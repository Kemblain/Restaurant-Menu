/******************************************************************************
 *Class Name: 			Category.java
 *Author:    			Anthony Nann II
 *Date:     			March 9th 2018
 *Course/Section:  		CSC 264-801
 *Class Description:  	Handles tasks related to manipulation of menu objects
 *						and the adjustment of the contained categories.
 *
 *Methods:
 *FoodItem(String name, String desc, double pr)
 *String getName()
 *String getDesc()
 *double getPrice()
 *void setName(String n)
 *void setDescription(String desc)
 *void setPrice(double n)
 *String toString()
 *****************************************************************************/

public class FoodItem
{
	/*** Class Constants ***/
	
	/*** Class Variables ***/
	// Food Item Name
	private String name; 
	
	// Food Item Description
	private String description;
	
	// Food Item Cost
	private double price;
	
	/**************************************************************************
	 *Method Name: 			FoodItem(String name, String desc, double pr)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Handles creation of fooditem object from data
	 *						passed.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Set Name
	 *	Set Description
	 *	Set Price
	 *END FoodItem(String name, String desc, double pr)
	 *************************************************************************/
	public FoodItem(String name, String desc, double pr)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Set Name
		this.name = name;
		
		// Set Description
		description = desc;
		
		// Set Price
		price = pr;
		
	}// END FoodItem(String name, String desc, double pr)

	/**************************************************************************
	 *Method Name: 			getName()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Returns name value.
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
		return this.name;
		
	}// END getName()

	/**************************************************************************
	 *Method Name: 			getDesc()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Returns description value.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Return name
	 *END getDesc()
	 *************************************************************************/
	public String getDesc()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Return description
		return description;
		
	}// getDesc()

	/**************************************************************************
	 *Method Name: 			getPrice()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Returns price value.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Return price
	 *END getPrice()
	 *************************************************************************/
	public double getPrice()
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Return price
		return price;
		
	}// END getPrice()

	/**************************************************************************
	 *Method Name: 			setName(String n)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Sets name to passed value.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Set name.
	 *END setName(String n)
	 *************************************************************************/
	public void setName(String n)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Set name
		name = n;
		
	}// END setName(String n)

	/**************************************************************************
	 *Method Name: 			setDescription(String desc)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Sets description to passed value.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Set description.
	 *END setDescription(String desc)
	 *************************************************************************/
	public void setDescription(String desc)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Set description
		description = desc;
	}// END setDescription(String desc)

	/**************************************************************************
	 *Method Name: 			setPrice(double n)
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Sets price to passed value.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Set price
	 *END setPrice(double n)
	 *************************************************************************/
	public void setPrice(double n)
	{
		/*** Local Constants ***/
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Set price
		price = n;
		
	}// END setPrice(double n)

	/**************************************************************************
	 *Method Name: 			String toString()
	 *Author:    			Anthony Nann II
	 *Date:     			March 9th 2018
	 *Course/Section:  		CSC 264-801
	 *Method Description:  	Overloads toString function to allow for 
	 *						conversion from FoodItem to String.
	 *
	 *Pseudocode:
	 *BEGIN
	 *	Add name, price, description to string
	 *	Return string
	 *END toString()
	 *************************************************************************/
	public String toString()
	{
		/*** Local Constants ***/
		// String to hold fooditem information
		String foodItem = "";
		
		/*** Local Variables ***/
		
		/*********************************************************************/
		//BEGIN
		// Add name, price, description to string
		foodItem = name + ", " + price + ", " + description;
		
		// Return string
		return foodItem;
		
	}// END toString()
	
}// End FoodItem.java