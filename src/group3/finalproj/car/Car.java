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
	 * @param properties An array of categories
	 * @param values A array of values, each corresponding to a category
	 * in the categories array
	 */
	public Car(String[] properties, String[] values) {
		for (int i = 0; i < properties.length; i++) {
			
			// If the category is numeric, convert value to Integer and add to TreeMap
			if(Property.isNumericProperty(Property.valueOf(properties[i]))) {
				if (values[i].equals(""))
					this.properties.put(Property.valueOf(properties[i]), 0);
				else this.properties.put(Property.valueOf(properties[i]), Integer.parseInt(values[i]));
			}
			
			//If the category is not numeric, add its string value			
			else this.properties.put(Property.valueOf(properties[i]), values[i]);
		}
	}
	
	public int compareTo(Property property, Car car) {
		Object a = properties.get(property);
		Object b = car.properties.get(property);
		if (Property.isNumericProperty(property)) {
			if ((int)a == (int)b) return 0;
			if ((int)a < (int)b) return -1;
			return 1;
		}
		else return ((String)a).compareTo((String)b);
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
