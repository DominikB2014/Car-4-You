package group3.finalproj.car;

import java.util.TreeMap;

/*
 * Data type used to represent a car
 * @author Dominik Buszowiecki
 */
public class Car {
	
	//Maps a category to a particular value of a car
	public TreeMap<Category, Object> categories = new TreeMap<Category, Object>();

	/**
	 * Constructs a car based on its categories
	 * @param categories An array of categories
	 * @param values A array of values, each corresponding to a category
	 * in the categories array
	 */
	public Car(String[] categories, String[] values) {
		for (int i = 0; i < categories.length; i++) {
			if(Category.isNumericCategory(Category.valueOf(categories[i])))
				this.categories.put(Category.valueOf(categories[i]), Integer.parseInt(values[i]));
			else this.categories.put(Category.valueOf(categories[i]), values[i]);
		}
	}

	/**
	 * String representation of a Car
	 */
	@Override
	public String toString() {
		return categories.get(Category.Year) + " " + 
				categories.get(Category.Make) + " " 
					+ categories.get(Category.Model) + " for: $" 
						+ categories.get(Category.Price);
	}
}
