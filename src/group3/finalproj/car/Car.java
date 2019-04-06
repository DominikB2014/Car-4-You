package group3.finalproj.car;

import java.util.TreeMap;

/*
 * Data type used to represent a car
 * @author Dominik Buszowiecki
 */
public class Car {
	
	//Maps a category to a particular value of a car
	private TreeMap<Property, Object> properties = new TreeMap<Property, Object>();

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
					this.properties.put(Property.valueOf(categories[i]), 0);
				else this.properties.put(Property.valueOf(categories[i]), Integer.parseInt(values[i]));
			}
			
			//If the category is not numeric, add its string value			
			else this.properties.put(Property.valueOf(categories[i]), values[i]);
		}
	}
	
	public Object get(Property property) {
		return properties.get(property);
	}

	/**
	 * String representation of a Car
	 */
	@Override
	public String toString() {
		return properties.get(Property.Year) + " " + 
				properties.get(Property.Make) + " " 
					+ properties.get(Property.Model) + " for: $" 
						+ properties.get(Property.Price);
	}
}
