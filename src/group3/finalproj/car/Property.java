/**
 * 
 */
package group3.finalproj.car;

/**
 * Enumerated type to represent the different properties of a car model
 * @author Dominik Buszowiecki
 */
enum Property {
	
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
	
	private String property;
	
	/**
	 * Retrieves the string value of a property
	 * @return string value
	 */
	@Override
	public String toString() {
		return this.property;
	}
	
	/**
	 * Determines if a property is associated with a number
	 * @param prop A property of a car
	 * @return true if the property is numeric, otherwise false
	 */
	public static boolean isNumericProperty(Property prop) {
		switch(prop) {
			case Price: return true;
			case Year: return true;
			case CityMPG: return true;
			case HighwayMPG: return true;
			case Mileage: return true;
			default: return false;
		}
	}
	
	/**
	 * Constructor for a property
	 * @param property String of the property name
	 */
	Property(String property) {
		this.property = property;
	}
	
	
}
