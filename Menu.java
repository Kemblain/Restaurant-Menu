import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/******************************************************************************
 *Class Name: 			Menu.java
 *Author:    			Rayan Vakil
 *Date:     			March 9th 2018
 *Course/Section:  		CSC 264-801
 *Class Description:  	Handles tasks related to manipulation of menu objects
 *						and the adjustment of the contained categories.
 *
 *Methods:
 *						Menu(String filename)
 *	String 				toString()
 *	ArrayList<Category> getCategories()
 *	String				getName()
 *	void 				addCategory(Category newC)
 *	void				deleteCategory(int i)
 *	void				editCategory(int i)
 *****************************************************************************/

public class Menu
{
	/*** Class Constants ***/
	
	/*** Class Variables ***/
	private String name;  //menu name
	private ArrayList <Category> categoryList; //categories

	/**************************************************************************
	 *Method Name: 			Menu(String filename)
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Handles creation of menu object from a supplied
	 *						filename.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	IF (File object exists)
	 *		Read First line (containing menu title)
	 *		Read Second line (containing number of categories)
	 *		Because nextInt doesn't consume the endline character, fire another nextLine
	 *		FOR (each integer up to the number of categories given)
	 *			Read Next Line (containing category title)
	 *			Create new category object with title
	 *			Read next line, and parse it for int (contains number of food items)
	 *			FOR (each integer up to the number of foodItems given)
	 *				Read next line for fooditem title
	 *				Read next line and parse it for a double for fooditem price
	 *				Read next line for fooditem description
	 *				Create new fooditem object with the parsed information
	 *				Add the fooditem object to the current category
	 *			END FOR (each integer up to the number of foodItems given)
	 *			Add the category object to the category arraylist
	 *		END FOR (each integer up to the number of categories given)
	 *	END IF (File object exists)
	 *	Close Scanner
	 *END Menu()
	 *************************************************************************/
	
	public Menu(String filename) throws FileNotFoundException
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		// Empty Category ArrayList
		categoryList = new ArrayList<Category>(); 
		
		// File object from filename supplied
		File inFile = new File(filename); 
		
		// Scanner object for user input
		Scanner scan = new Scanner(inFile);
		
		// Holder int for number of categories
		int numCategories = 0;
		
		// Holder int for number of food items
		int numFoodItems  = 0;
		
		// String for title of category
		String catTitle      = "";
		
		// String for title of food item
		String foodItemTitle = "";
		
		// Double for price of food item
		double foodItemPrice = 0;
		
		// String for Description of food item
		String foodItemDescription;
		
		/*********************************************************************/

		// IF (File object exists)
		if(inFile.exists())
		{
			
			// Read first line (containing menu title)
			name = scan.nextLine();

			// Read Second line (containing number of categories)
			numCategories = scan.nextInt();

			// Because nextInt doesn't consume the endline character, fire another nextLine
			scan.nextLine();

			// FOR (each integer up to the number of categories given)
			for(int i = 0; i < numCategories; i++)
			{
				// Read Next Line (containing category title)
				catTitle = scan.nextLine();
				
				// Create new category object with title
				Category cat = new Category(catTitle);
				
				// Read next line, and parse it for int (contains number of food items)
				numFoodItems = Integer.parseInt(scan.nextLine());
				
				// FOR (each integer up to the number of foodItems given)
				for(int j = 0; j < numFoodItems; j++)
				{
					// Read next line for fooditem title
					foodItemTitle = scan.nextLine();
					
					// Read next line and parse it for a double for fooditem price
					foodItemPrice = Double.parseDouble(scan.nextLine());
					
					// Read next line for fooditem description
					foodItemDescription = scan.nextLine();

					// Create new fooditem object with the parsed information
					FoodItem fdItm = new FoodItem(foodItemTitle, 
										foodItemDescription, foodItemPrice);
					
					// Add the fooditem object to the current category
					cat.addFoodItem(fdItm);

				}// END FOR (each integer up to the number of foodItems given)
				
				// Add the category object to the category arraylist
				categoryList.add(cat);
				
			}// END FOR (each integer up to the number of categories given)
			
		}// END IF (File object exists)
		
		// Close scanner
		scan.close();
		
	}// END Menu()

	/**************************************************************************
	 *Method Name: 			toString()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Overloads the toString method to allow for menu
	 *						objects to be converted to strings.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Add name and endline to string variable
	 *	FOR (each category in the category list)
	 *		Add the category and an endline to the string
	 *	END FOR (each category in the category list)
	 *	return the string
	 *END toString()
	 *************************************************************************/
	public String toString()
	{
		/*** Local Constants ***/
		final String newL = "\n";
		
		/*** Local Variables ***/
		String menu = "";
		
		/*********************************************************************/
		// BEGIN
		// Add name and endline to string variable
		menu = name + newL;
		
		// FOR (each category in the category list)
		for(int i = 0; i < categoryList.size(); i++)
		{
			// Add the category and an endline to the string
			menu += categoryList.get(i) + newL;
		}// END FOR (each category in the category list)
		
		// return the string
		return menu;
		
	}// END toString()

	/**************************************************************************
	 *Method Name: 			getCategories()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Allows the driver to access the categoryList
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Return categoryList
	 *END getCategories
	 *************************************************************************/
	public ArrayList<Category> getCategories()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		
		// Return categoryList
		return categoryList;
		
	}// END getCategories
	
	/**************************************************************************
	 *Method Name: 			getName()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Allows the driver to access the name value.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Return name
	 *END getName()
	 *************************************************************************/
	public String getName()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Return Name
		return name;
		
	}// END getName()

	/**************************************************************************
	 *Method Name: 			addCategory(Category newC)
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Adds a passed category to the categorylist
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Add passed category to categorylist
	 *END addCategory
	 *************************************************************************/
	public void addCategory(Category newC)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Add passed category to categorylist
		categoryList.add(newC);
		
	}//END addCategory()

	/**************************************************************************
	 *Method Name: 			deleteCategory()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Removes category at position passed to function.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Remove category at position passed
	 *END addCategory
	 *************************************************************************/
	public void deleteCategory(int i)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		
		//Remove category at position passed
		categoryList.remove(i);
		
	}// END addCategory()

	/**************************************************************************
	 *Method Name: 			editCategory()
	 *Author:    			Rayan Vakil
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Handles alterations to a category that already
	 *						exists.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	If (passed position is legal)
	 *		Get category at position
	 *		WHILE (User doesnt want to quit)
	 *			Ensure Counter is 0
	 *			FOR (each fooditem in the category)
	 *				Print counter + fooditem name
	 *				Increment counter
	 *			END FOR (each fooditem in the category)
	 *			Print prompt to get position of item to edit
	 *			Get user input
	 *			WHILE (input is outside range)
	 *				Repeat prompt
	 *				Get user input
	 *			END WHILE (input is outside range)
	 *			Consume newline char that was left after nextInt
	 *			IF (input is inside range of fooditems)
	 *				Call function to edit fooditem
	 *			END IF (input is inside range)
	 *			ELSE IF (input is change category name)
	 *				Print prompt for new category name
	 *				Get input
	 *				Save the category name
	 *			END ELSE IF (input is change category name)
	 *		END WHILE (User doesnt want to quit)
	 *	END If (passed position is legal)
	 *	ELSE category position was out of range
	 *		Print Error
	 *	END ELSE category position was out of range	
	 *	Close Scanner
	 *END addCategory
	 *************************************************************************/
	public void editCategory(int i)
	{
		/*** Local Constants ***/
		// Value that user will enter to quit back to main menu
		final int QUITTER = -1;
		
		// Value that user will enter to change the category name
		final int CHANGE_NAME = -2;
		
		/*** Local Variables ***/
		// Storage for user input of position of fooditem
		int index = 0;
		
		// Storage for new name of category
		String name;
		
		// Scanner object for user input
	    Scanner scan = new Scanner(System.in);
	    
	    // Category object for editing category information
	    Category cat;
	    
	    // Counter integer for printing list of fooditems
	    int j = 0;
	    
	    /*********************************************************************/
	    
		// If (passed position is legal)
		if(i >= 0 && i < categoryList.size())
		{
			// WHILE (User doesnt want to quit)
			while (index != QUITTER)
			{
				//Ensure Counter is 0
				j = 0;
				
				// Get category at position
				cat = categoryList.get(i);

				// FOR (each fooditem in the category)
				for(FoodItem f : cat.getFoodItems())
				{
					// Print counter + fooditem name
					System.out.println(j + ". " + f);
					
					// Increment counter
					j++;
					
				}// END FOR (each fooditem in the category)
				
				// Print prompt to get position of item to edit
				System.out.print("Position of food item to edit, -1 to exit, -2 to edit name of category: ");
				
				// Get user input
				index = scan.nextInt();

				// WHILE (input is outside range)
				while(index < CHANGE_NAME || index >= cat.getFoodItems().size())
				{
					// Repeat prompt
					System.out.print("Position of food item to edit, -1 to exit, -2 to edit name of category: ");
					
					// Get user input
					index = scan.nextInt();
				}// WHILE (input is outside range)

				// Consume newline char that was left after nextInt
				scan.nextLine();

				// IF (input is inside range of fooditems)
				if(index >= 0 && index < cat.getFoodItems().size())
				{
					// Call function to edit fooditem
					cat.editFoodItem(index);
					
				}// END IF (input is inside range of fooditems)
			
				// ELSE IF (input is change category name)
				else if (index == CHANGE_NAME)
				{
					// Print prompt for new category name
					System.out.println("Enter name of category: ");
					
					// Get input
					name = scan.nextLine();
					
					// Save the category name
					categoryList.get(i).setName(name);
					
				}// END ELSE IF (input is change category name)
	
			}// END WHILE (User doesn't want to quit)

	    }// END If (passed position is legal)
		
		// ELSE category position was out of range
		else
		{
			// Print Error
			System.out.print(i + " was not a valid category position.");
			
		}//END ELSE category position was out of range
		
		//Close Scanner
		scan.close();
		
	}// END addCategory
	
}//END Menu