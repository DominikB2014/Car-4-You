package group3.finalproj.car;

import java.util.ArrayList;
import java.util.TreeMap;

import group3.finalproj.io.ReadData;

/*
 * Data type used to represent a car
 * @author Dominik Buszowiecki
 */
public class Car{
	
	ArrayList<Car> carList= ReadData.cars;
	
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
	
	/**
	 * Determines if a property has been set in a car
	 * @param property A property of a car
	 * @return true if the property has been set
	 */
	public boolean hasProperty(Property property) {
		return properties.containsKey(property);
	}
	
	public int scoreCalc(Property property) {
		ArrayList<Tuple<Property, Integer>> prop = new ArrayList<Tuple<Property, Integer>>();
		prop.add(new Tuple<Property, Integer>(property, 10));
		return scoreCalc(prop, Integer.MAX_VALUE);
	}
	
	public int scoreCalc(ArrayList<Tuple<Property, Integer>> property_Rank, int maxPrice) {
		int score = 0;
		for (Tuple<Property, Integer> tup: property_Rank) {
			if (tup.getProperty().equals(Property.CityMPG)) {
				if ((int)this.get(Property.CityMPG) > 50) {
					score += 50 / 45 * tup.getRank();
				} else {
					score += (int)this.get(Property.CityMPG) / 45 * tup.getRank();
				}
			}
			if (tup.getProperty().equals(Property.Price)) {
				if (maxPrice != Integer.MAX_VALUE) {
					score += (1 - ((int)this.get(Property.Price)/maxPrice)) * tup.getRank();
				} else {
					score += (1 - ((int)this.get(Property.Price)/ReadData.getMaxPrice())) * tup.getRank();
				}
			}
			if (tup.getProperty().equals(Property.Engine)) {
				score += (this.numCyl() / 12) * tup.getRank();  
			}
			if (tup.getProperty().equals(Property.Make)) {
				String[] names = {"Aston Martin", "Audi", "Bently", "BMW", "Ferrari", "Genesis", "Infiniti", "Jaguar", "Land Rover", "Lexus", "Maybach", "Maserati", "Lincoln", "McLaren", "Mercedes-Benz", "Porsche", "Rolls-Royce", "Tesla"};
				for(int i = 0; i < names.length; i++){
				    if (((String)this.get(Property.Make)).equals(names[i])) {
				    score += 1 * tup.getRank();
				    }
				}
			}
			if (tup.getProperty().equals(Property.Mileage)) {
				if (this.hasProperty(Property.Mileage)){
			        if (!((int)this.get(Property.Mileage) == 0)){
			            int x = ReadData.getMaxMileage();
			            score += (1-(x/(int)this.get(Property.Mileage))) * tup.getRank();
			        }
				}
			}
			if (tup.getProperty().equals(Property.Drivetrain)) {
				if (((String)this.get(Property.Drivetrain)).equals("AWD")) {
					score += 1 * tup.getRank();
				}
			}
		}
		return score;
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
	
	public void addProperty(Property property, Object value) {
		if(Property.isNumericProperty(property)) properties.put(property, (int)value);
		else properties.put(property, value);
	}
	
	
	/**
	 * Returns the number of cylinders a car has
	 * @return the number of cylinder a car has, if not known -1
	 */
	private int numCyl() {
		String cylinders[] = {"4 ", "6 ", "8 ", "10 ", "12 ", "14 ", "16 ", "18 "}; //Possible number of cylinders
		for (String cyl: cylinders) {
			if (((String)this.get(Property.Engine)).contains("4 ")) return Integer.parseInt(cyl.substring(0, cyl.length()-1));
		}
		return -1;
		
	}

}
