package group3.finalproj.car;

import java.util.ArrayList;
import java.util.TreeMap;

import group3.finalproj.io.ReadData;

/**
 * Data type used to represent a car
 * @author Dominik Buszowiecki
 * @author Zayed Sheet
 */
public class Car {

	ArrayList<Car> carList = ReadData.cars;

	// Maps a property to its value of this car
	private TreeMap<Property, Object> properties = new TreeMap<Property, Object>();

	/**
	 * Constructs a car based on its properties
	 * 
	 * @param properties An array of properties
	 * @param values     A array of values, each corresponding to a category in the
	 *                   categories array
	 */
	public Car(String[] properties, String[] values) {
		for (int i = 0; i < properties.length; i++) {

			// If the property is numeric, convert value to Integer and add it to the
			// TreeMap
			if (Property.isNumericProperty(Property.valueOf(properties[i]))) {
				// If the value associated with a numeric property is missing in the dataset,
				// treat it as 0
				if (values[i].equals(""))
					this.properties.put(Property.valueOf(properties[i]), 0);
				else
					this.properties.put(Property.valueOf(properties[i]), Integer.parseInt(values[i]));
			}

			// If the category is not numeric, add its string value
			else
				this.properties.put(Property.valueOf(properties[i]), values[i]);
		}
	}

	/**
	 * Compares this Car to another based on a property
	 * 
	 * @param property - The property to compare
	 * @param car      - Another car to compare to
	 * @return 0 if the properties are equal, -1 if this property is less that the
	 *         compared, otherwise 1
	 */
	public int compareTo(Property property, Car car) {
		Object a = properties.get(property);
		Object b = car.properties.get(property);
		if (Property.isNumericProperty(property)) {
			if ((int) a > (int) b)
				return 1;
			if ((int) a < (int) b)
				return -1;
			return 0;
		} else
			return ((String) a).compareTo((String) b);
	}

	/**
	 * Retrieves a particular property of a car
	 * 
	 * @param property - A property of a car
	 * @return The value of that property
	 */
	public Object get(Property property) {
		return properties.get(property);
	}

	/**
	 * Determines if a property has been set in a car
	 * 
	 * @param property A property of a car
	 * @return true if the property has been set
	 */
	public boolean hasProperty(Property property) {
		return properties.containsKey(property);
	}

	/**
	 * String representation of a Car
	 */
	@Override
	public String toString() {
		return properties.get(Property.Year) + " " + properties.get(Property.Make) + " " + properties.get(Property.Model) + " "
				+ properties.get(Property.Trim) + " for: $" + properties.get(Property.Price);
	}

	/**
	 * Adds a new property or updates a properties value
	 * 
	 * @param property - a property of a car
	 * @param value    - the value corresponding to that property
	 */
	public void addProperty(Property property, Object value) {
		if (Property.isNumericProperty(property))
			properties.put(property, (int) value);
		else
			properties.put(property, value);
	}

	/**
	 * Returns how "good" a certain property is of a car
	 * 
	 * @param property - the Car property of interest
	 * @return the score of the property (higher is better)
	 */
	public int scoreCalc(Property property) {
		return scoreProperty(property, 10, Integer.MAX_VALUE);
	}

	/**
	 * Returns how "good" a set of properties are in a car based on the user's
	 * preferences
	 * 
	 * @param property_Rank - a list of the properties and how highly the user ranks
	 *                      the propery
	 * @param maxPrice      - The maximum price a user is willing to spend on a car
	 * @return the score of a set of properties (higher is betters)
	 */
	public int scoreCalc(ArrayList<Tuple<Property, Integer>> property_Rank, int maxPrice) {
		if ((int)properties.get(Property.Price) == 0) return 0;
		int score = 0;
		for (Tuple<Property, Integer> tup : property_Rank) {
			score += scoreProperty(tup.getProperty(), tup.getRank(), maxPrice);
		}
		return score;
	}

	/***************************************************************************
	 * Helper functions to calculate the score.
	 ***************************************************************************/

	/**
	 * Returns the number of cylinders a car has
	 * 
	 * @return the number of cylinder a car has, if not known -1
	 */
	public int numCyl() {
		String cylinders[] = { "4 ", "6 ", "8 ", "10 ", "12 ", "14 ", "16 ", "18 " }; // Possible number of cylinders
		for (String cyl : cylinders) {
			if (((String) this.get(Property.Engine)).contains(cyl))
				return Integer.parseInt(cyl.substring(0, cyl.length() - 1)); // Strips the space, converts to integers
		}
		return -1;
	}
	
	/**
	 * Scores a property based on how the user ranks it
	 * @param property - the property to be scored
	 * @param rank - how highly the user ranks this property
	 * @param maxPrice - the max price the user is willing to spend on a car
	 * @return The score of the property, the higher the better
	 */
	private int scoreProperty(Property property, int rank, int maxPrice) {
		switch (property) {

		// Custom algorithm to rank properties created below
		
		case CityMPG:
			if ((int) this.get(Property.CityMPG) > 50) {
				return 50 / 45 * rank;
			} else {
				return (int) this.get(Property.CityMPG) / 45 * rank;
			}

		case Price:
			double z = (1 - ((int) this.get(Property.Price) / (double)ReadData.maxPrice)) * rank;
			if (z < 0) return 0;
			return (int)z;

		case Engine:
			double engine = ((double)this.numCyl() / (double)ReadData.maxCylinders)*(double)rank;
			return (int)engine;

		case Make:
			String[] names = { "Aston Martin", "Audi", "Bently", "BMW", "Ferrari", "Genesis", "Infiniti", "Jaguar",
					"Land Rover", "Lexus", "Maybach", "Maserati", "Lincoln", "McLaren", "Mercedes-Benz", "Porsche",
					"Rolls-Royce", "Tesla" };
			for (int i = 0; i < names.length; i++) {
				if (((String) this.get(Property.Make)).equals(names[i])) {
					return 1 * rank;
				}
			}
			return 0;

		case Mileage:
			if (this.hasProperty(Property.Mileage)) {
				if (!((int) this.get(Property.Mileage) == 0)) {
					int x = ReadData.maxMileage;
					double y = (1 - ((int)this.get(Property.Mileage)/(double)x)) * rank;
					if (y < 0) return 0;
					return (int)y;
				}
			}
			return rank;

		case Drivetrain:
			if (((String) this.get(Property.Drivetrain)).equals("AWD")) {
				return 1 * rank;
			}
			return 0;
		default:
			return 0;
		}
	}

}
