import java.util.Scanner;
import java.util.ArrayList;

/******************************************************************************
 *Class Name: 			Category.java
 *Author:    			Anthony Nann II
 *Date:     			March 9th 2018
 *Course/Section:  		CSC 264-801
 *Class Description:  	Handles tasks related to manipulation of menu objects
 *						and the adjustment of the contained categories.
 *
 *Methods:
 *						Category(String name)
 *	String				toString()
 *	ArrayList<FoodItem>	getFoodItems()
 *	void				addFoodItem(String name, String description, double cost)
 *	void				addFoodItem(FoodItem fdItm)
 *	void				deleteFoodItem(int i)
 *	void 				editFoodItem(int i)
 *	String 				getName()
 *	void 				setName(String n)
 *****************************************************************************/

public class Category
{
	/*** Class Constants ***/
	
	/*** Class Variables ***/
	// Category Name
	private String name; 
	// Arraylist object of food items
	private ArrayList <FoodItem> foodItemList;

	/**************************************************************************
	 *Method Name: 			Category(String name)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Handles creation of category object with a 
	 *						supplied category name.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Set Category name as passed name
	 *	Create new empty fooditem arraylist
	 *END Category()
	 *************************************************************************/
	public Category(String name)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Set Category name as passed name
		this.name = name;
		
		// Create new empty fooditem arraylist
		foodItemList = new ArrayList <FoodItem>();
	}

	/**************************************************************************
	 *Method Name: 			toString()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Overloads toString function to allow conversion
	 *						from Category to String.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Add category name and endline to string
	 *	FOR (each fooditem in the fooditemlist)
	 *		Add fooditem info and endline to string
	 *	END FOR (each fooditem in the fooditemlist)
	 *	Return string
	 *END Category()
	 *************************************************************************/
	public String toString()
	{
		/*** Local Constants ***/
		final String endL = "\n";
		
		/*** Local Variables ***/
		String s = "";
		
		/*********************************************************************/
		//BEGIN
		// Add category name and endline to string
		s = name + endL;

		// FOR (each fooditem in the fooditemlist)
		for(int i = 0; i < foodItemList.size(); i++)
		{
			// Add fooditem info and endline to string
			s += foodItemList.get(i) + endL;
			
		}// END FOR (each fooditem in the fooditemlist)
		
		// Return string
		return s;

	}// END Category()

	/**************************************************************************
	 *Method Name: 			getFoodItems()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Returns the foodItemList.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Return fooditemlist
	 *END getFoodItems()
	 *************************************************************************/
	public ArrayList <FoodItem> getFoodItems()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		// BEGIN
		// Return fooditemlist
		return foodItemList;
		
	} //END getFoodItems()

	/**************************************************************************
	 *Method Name: 			addFoodItem(String name, String description, double cost)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Creates a food item object from passed information
	 *						and adds it to the fooditemlist
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Create fooditem by passing information to constructor
	 *	Add fooditem to fooditemlist
	 *END addFoodItem(String name, String description, double cost)
	 *************************************************************************/
	public void addFoodItem(String name, String description, double cost)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		// FoodItem object for adding to the list
		FoodItem fdItm;
		
		/*********************************************************************/
		// BEGIN
		// Create fooditem by passing information to constructor
		fdItm = new FoodItem(name, description, cost);
		
		// Add fooditem to fooditemlist
		foodItemList.add(fdItm);
		
	}// END addFoodItem(String name, String description, double cost)

	/**************************************************************************
	 *Method Name: 			addFoodItem(FoodItem fdItm)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Creates a food item object from passed FoodItem
	 *						object.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Add foodItem object to list
	 *END addFoodItem(FoodItem fdItm)
	 *************************************************************************/
	public void addFoodItem(FoodItem fdItm)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Add foodItem object to list
		foodItemList.add(fdItm);
		
	}// END addFoodItem(FoodItem fdItm)

	/**************************************************************************
	 *Method Name: 			deleteFoodItem(int i)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Deletes the fooditem object at the passed position.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	IF (Position is in range)
	 *		Remove Food item at position
	 *	END IF (Position is in range)
	 *	ELSE (position out of range)
	 *		Output error
	 *	END ELSE (position out of range)
	 *END addFoodItem(FoodItem fdItm)
	 *************************************************************************/
	public void deleteFoodItem(int i)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		
		// IF (Position is in range)
		if(i >= 0 && i < foodItemList.size())
		{
			// Remove Food item at position
			foodItemList.remove(i);
			
		}// END IF (Position is in range)
		
		// ELSE (position out of range)
		else
		{
			// Output error
			System.out.println(i + " is not a valid position.");
			
		}// END ELSE (position out of range)
		
	}// END addFoodItem(FoodItem fdItm)

	/**************************************************************************
	 *Method Name: 			editFoodItem(int i)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Allows for modification of the food item at
	 *						the passed position.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	IF (position is in range)
	 *		Prompt for new item name
	 *		Get new name
	 *		Prompt for new item price
	 *		Get new price
	 *		Prompt for new item description
	 *		Get new description
	 *		Create a foodItem object from this information
	 *		Replace the old information in the list
	 *	END IF (position is in range)
	 *	ELSE (position out of range)
	 *		Output error
	 *	END ELSE (position out of range)
	 *	Close Scanner
	 *END editFoodItem()
	 *************************************************************************/
	public void editFoodItem(int i)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		// Storage for new name
		String name;
		
		// Storage for new price
		double price;
		
		// Storage for new description
		String description;
		
		// Scanner object for user input
        Scanner scan = new Scanner(System.in);
		
        /*********************************************************************/
        // BEGIN
        
        // IF (position is in range)
		if(i >= 0 && i < foodItemList.size())
		{
			// Prompt for new item name
			System.out.println("Name of food item: ");
			
			// Get new name
			name  = scan.nextLine();
			
			// Prompt for new item price
			System.out.println("Set price of item: ");
			
			// Get new price
			price = Double.parseDouble(scan.nextLine());

			// Prompt for new item description
			System.out.println("Enter description of item: ");
			
			// Get new description
			description = scan.nextLine();

			// Create a foodItem object from this information
			FoodItem fdItm = new FoodItem(name, description, price);

			// Replace the old information in the list
			foodItemList.set(i, fdItm);
			
	    }// END IF (position is in range)
		
		// ELSE (position out of range)
		else
		{
			//Output error
			System.out.println(i + " is not a valid position.");
			
		}// END ELSE (position out of range)
		
		//Close Scanner
		scan.close();
		
	}// END editFoodItem(int i)

	/**************************************************************************
	 *Method Name: 			getName()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Returns name of the food item.
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
		//Return name
		return this.name;
		
	}// END getName()

	/**************************************************************************
	 *Method Name: 			setName()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:   Returns name of the food item.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Update name with passed value
	 *END setName()
	 *************************************************************************/
	public void setName(String n)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		// BEGIN
		// Update name with passed value
		name = n;
		
	}// END setName()

}// End Category.java