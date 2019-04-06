package group3.finalproj.car;

import java.util.TreeMap;

/*
 * Data type used to represent a car
 * @author Dominik Buszowiecki
 */
public class Car {
	
	//Maps a category to a particular value of a car
	public TreeMap<Property, Object> categories = new TreeMap<Property, Object>();

	/**
	 * Constructs a car based on its categories
	 * @param categories An array of categories
	 * @param values A array of values, each corresponding to a category
	 * in the categories array
	 */
	public Car(String[] categories, String[] values) {
		for (int i = 0; i < categories.length; i++) {
			
			// If the category is numeric, convert value to Integer and add to TreeMap
			if(Property.isNumericProperty(Property.valueOf(categories[i]))) {
				if (values[i].equals(""))
					this.categories.put(Property.valueOf(categories[i]), 0);
				else this.categories.put(Property.valueOf(categories[i]), Integer.parseInt(values[i]));
			}
			
			//If the category is not numeric, add its string value			
			else this.categories.put(Property.valueOf(categories[i]), values[i]);
		}
	}

	/**
	 * String representation of a Car
	 */
	@Override
	public String toString() {
		return categories.get(Property.Year) + " " + 
				categories.get(Property.Make) + " " 
					+ categories.get(Property.Model) + " for: $" 
						+ categories.get(Property.Price);
	}
}
