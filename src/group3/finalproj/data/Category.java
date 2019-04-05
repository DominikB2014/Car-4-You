/**
 * 
 */
package group3.finalproj.data;

/**
 * @author Dominik Buszowiecki
 *
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
	DriveTrain("Drivetrain"),
	Transmission("Transmission"),
	Engine("Engine"),
	Mileage("Mileage"),
	Link("Link");
	
	private String category;
	
	public String getCategory() {
		return this.category;
	}
	
	Category(String category) {
		this.category = category;
	}
	
	
}
