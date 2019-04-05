package group3.finalproj.data;

import java.util.TreeMap;

import restaurants.Menu;

/*
 * 
 */
class Car {
	
	public TreeMap<Category, Object> categories = new TreeMap<Category, Object>();

	protected Car(String[] categories, String[] values) {
		/*Category order: Make, Model, Year, Price, BodyStyle, Trim, Fuel Type, CityMPG, HwMPG, Drivetrain, Trans, engine, mileage*, link
		   *mileage only in used car database  */
		for (int i = 0; i < categories.length; i++) {
			this.categories.put(Category(categories[i]), values[i]);
		}
		
		for (String category: categories) {
			
		}

	}

	@Override
	public String toString() {
		return year + " " + make + " " + model + " for: $" + price;
	}

}
