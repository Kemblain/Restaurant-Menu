import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/******************************************************************************
 *Class Name: 			RestaurantDriver.java
 *Author:    			Rayan Vakil
 *Date:     			March 9th 2018
 *Course/Section:  		CSC 264-801
 *Class Description:  	Driver for a console menu driven application for
 *						loading, displaying, and editing restaurant menus.
 *						Menus should be stored in a text file and are loaded
 *						by the user during runtime.
 *
 *Methods:
 *	void main()
 *	void printUserMenu()
 *	void printMenuNames()
 *****************************************************************************/

public class RestaurantDriver
{
	/*** Class Constants ***/
	
	/*** Class Variables ***/
	static ArrayList <Menu> menus;  // ArrayList object to handle menu storage
	
	/**************************************************************************
	 *Method Name: 			main()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Handles all user interaction with the menu
	 *						database.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	WHILE (the user doesn't want to quit)
	 *		Print the menu
	 *		Print an entry prompt
	 *		Get input from user
	 *
	 *		IF (the user wants to exit)
	 *			Change boolean so that loop will exit
	 *		END IF (the user wants to exit)
	 *
	 *		First ELSE IF (the user wishes to load a menu from file)
	 *			Prompt user for filename
	 *			Store filename
	 *			Print filename back to user
	 *			IF (user doesn't want to exit this menu)
	 *				Check if the file exists
	 *				IF (the file exists)
	 *					Create a new menu object
	 *					Add the menu object to the arraylist
	 *				END IF (the file exists)
	 *				ELSE (the file doesn't exist)
	 *					Print an error message
	 *				END ELSE (the file doesn't exist)
	 *			END IF (user doesn't want to exit this menu)
	 *		END First ELSE IF (the user wishes to load a menu from file)
	 *
	 *		Second ELSE IF (the user wants a list of the menus)
	 *			Print a list of menu titles
	 *		END Second ELSE IF
	 *
	 *		Third ELSE IF (the user wants to see a loaded menu)
	 *			Print a list of menus
	 *			Ask user for which menu they want to see
	 *			Get user input
	 *			WHILE (the input is out of range)
	 *				Repeat prompt
	 *				Get user input
	 *			END WHILE
	 *			Print the object at the location given
	 *		END Third ELSE IF
	 *
	 *		Fourth ELSE IF (the user wants to edit a menu)
	 *			Print the list of menus loaded
	 *			Prompt user for which menu they want to edit
	 *			Get user input
	 *			WHILE (the input is out of range)
	 *				Repeat prompt
	 *				Get user input
	 *			Instantiate menu object from requested location in arraylist
	 *			Instantiate an arraylist of the categories for this menu
	 *			Ensure counter variable is equal to zero
	 *			FOR (each category in the category arraylist)
	 *				Print the counter and category name
	 *				Increment counter
	 *			END FOR
	 *			Print prompt to get category to edit
	 *			Get user input
	 *			WHILE (the input is out of range)
	 *				Repeat prompt
	 *				Get user input
	 *			END WHILE
	 *			Call function to edit category
	 *			Save edited menu to menu arraylist
	 *		END Fourth ELSE IF
	 *
	 *		ELSE (the users input wasn't an option)
	 *			Print an error message
	 *			Print the users entry
	 *		END ELSE
	 *	END WHILE
	 *	Close Scanner
	 *END main()
	 *************************************************************************/

	public static void main(String[] args) throws FileNotFoundException
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		// ArrayList object of menus
		menus = new ArrayList<Menu>();
		
		// Driver User Menu Quitter
		boolean quit = false;
		
		// Scanner object for user input
		Scanner input = new Scanner(System.in);
		
		// Used for listing categories while editing a menu
		int i = 0;
		
		
		/*********************************************************************/
		//BEGIN
		
		//WHILE (the user doesn't want to quit)
		while(quit != true)
		{
			// Print the menu
			printUserMenu();
			
			// Print an entry prompt
			System.out.print("Input choice: ");
			
			// Get input from user
			int choice = input.nextInt();

			// IF (the user wants to exit)
			if(choice == 1)
			{
				// Change boolean so that loop will exit
				quit = true;
				
			}// END IF (the user wants to exit)

			// First ELSE IF (the user wishes to load a menu from file)
			else if(choice == 2)
			{
				// Prompt user for filename
				System.out.print("Enter filename of menu or type exit: ");
				
				// Store filename
				String fileName = input.next();
				
				// Print filename back to user
				System.out.println("[" + fileName + "]");

				// IF (user doesn't want to exit this menu)
				if(!fileName.equals("exit"))
				{
					// Check if the file exists
					File file = new File(fileName);

					// IF (the file exists)
					if(file.exists())
					{
						
						// Create a new menu object
						Menu menu = new Menu(fileName);
						
						// Add the menu object to the arraylist
						menus.add(menu);
						
					}// END IF (the file exists)
					
					// ELSE (the file doesn't exist)
					else
					{
						//Print an error message
						System.out.println("File \"" + fileName + "\" not found");
						
					} // END ELSE (the file doesn't exist)
					
				}// END IF (user doesn't want to exit this menu)
						 		
			}// END First ELSE IF (the user wishes to load a menu from file)
			
			// Second ELSE IF (the user wants a list of the menus)
			else if(choice == 3)
			{
				// Print a list of menu titles
				printMenuNames();
				
			}// END Second ELSE IF (the user wants a list of the menus)
			
			// Third ELSE IF (the user wants to see a loaded menu)
			else if(choice == 4)
			{
				// Print a list of menus
				printMenuNames();

				// Ask user for which menu they want to see
				System.out.println("Enter number of menu to be displayed: ");
				
				// Get user input
				int index = input.nextInt();

				// WHILE (the input is out of range)
				while(index < 0 || index >= menus.size())
				{
					// Repeat prompt
					System.out.println("Enter number of menu to be displayed: ");
					
					// Get user input
					index = input.nextInt();
					
				}// END WHILE (the input is out of range)
				
				// Print the object at the location given
				System.out.println(menus.get(index));
				
			}// END Third ELSE IF (the user wants to see a loaded menu)
			
			// Fourth ELSE IF (the user wants to edit a menu)
			else if(choice == 5)
			{
				// Print the list of menus loaded
				printMenuNames();
				
				// Prompt user for which menu they want to edit
				System.out.print("Select menu to edit: ");
						 
				// Get user input
				int sel = input.nextInt();

				// WHILE (the input is out of range)
				while(sel < 0 || sel >= menus.size())
				{
					// Repeat prompt
					System.out.print("Select menu to edit: ");
					
					// Get user input
					sel = input.nextInt();
					
				} // END WHILE (the input is out of range)

				// Instantiate menu object from requested location in arraylist
				Menu menuHolder = menus.get(sel);
				
				// Instantiate an arraylist of the categories for this menu
				ArrayList <Category> catList = menuHolder.getCategories();
				
				//Ensure counter variable is equal to zero
				i = 0;

				// FOR (each category in the category arraylist)
				for(Category c : catList)
				{
					// Print the counter and category name
					System.out.println(i + ". " + c.getName());
					
					// Increment counter
					i++;
					
				}// END FOR (each category in the category arraylist)

				// Print prompt to get category to edit
				System.out.print("Input category # to edit category: ");
				
				// Get user input
				int catNum = input.nextInt();

				// WHILE (the input is out of range)
				while(catNum < 0 || catNum >= catList.size())
				{
					// Repeat prompt
						System.out.print("Select category to edit: ");
						
						// Get user input
						catNum = input.nextInt();
						
				}// END WHILE (the input is out of range)
				
				// Call function to edit category
				menuHolder.editCategory(catNum);
				
				// Save edited menu to menu arraylist
				menus.set(sel, menuHolder);
				
			}// END Fourth ELSE IF (the user wants to edit a menu)
			
			// ELSE (the users input wasn't an option)
			else
			{
				// Print an error message
				System.out.println("Your entry could not be resolved.");
				
				// Print the users entry
				System.out.println(choice + " is not a valid entry.");
				
			}// END ELSE (the users input wasn't an option)
			
		}// END WHILE (the user doesn't want to quit)
		
		// Close scanner
		input.close();
		
	} // END main()

	/**************************************************************************
	 *Method Name: 			printUserMenu()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Prints the user interaction menu.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Print exit line
	 *	Print add menu line
	 *	Print list menus line
	 *	Print print entire menu line
	 *	Print edit menu line
	 *END
	 *************************************************************************/
	public static void printUserMenu()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		// BEGIN
		// Print exit line
		System.out.println("1. Quit");
		
		// Print add menu line
		System.out.println("2. Add a menu");
		
		// Print list menus line
		System.out.println("3. Print menu list");
		
		// Print print entire menu line
		System.out.println("4. Print menu");
		
		// Print edit menu line
		System.out.println("5. Edit menu");
		
	}// End printUserMenu()

	/**************************************************************************
	 *Method Name: 			printMenuNames()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Prints a list of all of the loaded menus.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	FOR (each menu in the menulist object
	 *		Store menu at current position in temporary variable
	 *		Print counter variable and temporary menu name
	 *	END FOR (each menu in the menulist object
	 *END printMenuNames()
	 *************************************************************************/
	public static void printMenuNames()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		Menu tempMenu;
		
		/*********************************************************************/
		
		// FOR (each menu in the menulist object
		for(int i = 0; i < menus.size(); i++)
		{
			// Store menu at current position in temporary variable
			tempMenu = menus.get(i);
			
			// Print counter variable and temporary menu name
			System.out.println(i + ". " + tempMenu.getName());
			
		}// END FOR (each menu in the menulist object
		
	}// END printMenuNames()
	
}// END RestaurantDriver