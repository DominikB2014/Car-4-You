package group3.finalproj.car;

public enum CarType {
	CargoVan("Cargo Van"),
	Convertible("Convertible"),
	CrewCabPickup("Crew Cab Pickup"),
	ExtendedCabPickup("Extended Cab Pickup"),
	RegularCabPickup("Regular Cab Pickup"),
	Hatchback("Hatchback"),
	Minivan("Minivan"),
	PassengerVan("Passenger Van"),
	Sedan("Sedan"),
	SUV("SUV"),
	Wagon("Wagon"),
	Coupe("Coupe");
	

	private String carType;
	
	/**
	 * Retrieves the string value of a category
	 * @return string value
	 */
	@Override
	public String toString() {
		return this.carType;
	}
	
	/**
	 * Constructor for a carType
	 * @param category String of the category name
	 */
	CarType(String carType) {
		this.carType = carType;
	}
	
}
