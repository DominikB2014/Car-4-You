package group3.finalproj.data;

import java.util.TreeMap;

/*
 * 
 */
class Car {
	
	public TreeMap<Category, Object> categories = new TreeMap<Category, Object>();

	protected Car(String[] categories, String[] values) {
		for (int i = 0; i < categories.length; i++) {
			this.categories.put(Category.valueOf(categories[i]), values[i]);
		}
	}

	@Override
	public String toString() {
		return categories.get(Category.Year) + " " + 
				categories.get(Category.Make) + " " 
					+ categories.get(Category.Model) + " for: $" 
						+ categories.get(Category.Price);
	}

}
