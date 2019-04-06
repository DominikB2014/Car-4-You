/**
 * 
 */
package group3.finalproj.car;

/**
 * Enumerated type to represent the different categories of a car model
 * @author Dominik Buszowiecki
 */
enum Category {
	
	Make("Make"),
	Model("Model"),
	Year("Year"),
	Price("Price"),
	BodyStyle("Body Style"),
	Trim("Trim"),
	FuelType("Fuel Type"),
	CityMPG("City MPG"),
	HighwayMPG("Highway MPG"), 
	Drivetrain("Drivetrain"),
	Transmission("Transmission"),
	Engine("Engine"),
	Mileage("Mileage"),
	Link("Link");
	
	private String category;
	
	/**
	 * Retrieves the string value of a category
	 * @return string value
	 */
	@Override
	public String toString() {
		return this.category;
	}
	
	/**
	 * Determines if a category is associated with a number
	 * @param cat A category of a car
	 * @return true if the category is numeric, otherwise false
	 */
	public static boolean isNumericCategory(Category cat) {
		switch(cat) {
			case Price: return true;
			case Year: return true;
			case CityMPG: return true;
			case HighwayMPG: return true;
			case Mileage: return true;
			default: return false;
		}
	}
	
	/**
	 * Constructor for a category
	 * @param category String of the category name
	 */
	Category(String category) {
		this.category = category;
	}
	
	
}
