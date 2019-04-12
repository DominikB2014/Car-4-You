package group3.finalproj.car;

import java.util.ArrayList;
import java.util.TreeMap;

/*
 * Data type used to represent a car
 * @author Dominik Buszowiecki
 */
public class Car{
	
	//Maps a category to its value of this car
	private TreeMap<Property, Object> properties = new TreeMap<Property, Object>();

	/**
	 * Constructs a car based on its categories
	 * @param properties An array of categories
	 * @param values A array of values, each corresponding to a category
	 * in the categories array
	 */
	public Car(String[] properties, String[] values) {
		for (int i = 0; i < properties.length; i++) {
			
			// If the property is numeric, convert value to Integer and add it to the TreeMap
			if(Property.isNumericProperty(Property.valueOf(properties[i]))) {
				//If the value associated with a numeric property is missing in the dataset, treat it as 0
				if (values[i].equals(""))
					this.properties.put(Property.valueOf(properties[i]), 0);
				else this.properties.put(Property.valueOf(properties[i]), Integer.parseInt(values[i]));
			}
			
			//If the category is not numeric, add its string value			
			else this.properties.put(Property.valueOf(properties[i]), values[i]);
		}
	}
	
	/**
	 * Compares this Car to another based on a property
	 * @param property - The property to compare
	 * @param car - Another car to compare to
	 * @return 0 if the properties are equal, -1 if this property is less that the compared, otherwise 1
	 */
	public int compareTo(Property property, Car car) {
		Object a = properties.get(property);
		Object b = car.properties.get(property);
		if (Property.isNumericProperty(property)) {
			if ((int)a > (int)b) return 1;
			if ((int)a < (int)b) return -1;
			return 0;
		}
		else return ((String)a).compareTo((String)b);
	}
	
	/**
	 * Retrieves a particular property of a car
	 * @param property - A property of a car
	 * @return The value of that property
	 */
	public Object get(Property property) {
		return properties.get(property);
	}
	
	public boolean hasProperty(Property property) {
		return properties.containsKey(property);
	}
	
	public int scoreCalc(ArrayList<Tuple> a) {
		return 1;
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
