/**
 * 
 */
package group3.finalproj.car;

/**
 * Enumerated type to represent the different properties of a car model
 * @author Dominik Buszowiecki 
 */
public enum Property {
	
	//String
	Make("Make"),
	Model("Model"),
	BodyStyle("Body Style"),
	Trim("Trim"),
	FuelType("Fuel Type"),
	Link("Link"),
	Drivetrain("Drivetrain"),
	Transmission("Transmission"),
	Engine("Engine"),
	
	//Integer
	Year("Year"),
	Price("Price"),
	CityMPG("City MPG"),
	HighwayMPG("Highway MPG"), 
	Mileage("Mileage"),
	Score("Score");
	
	
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
			case Score: return true;
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
