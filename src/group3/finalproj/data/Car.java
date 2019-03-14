package group3.finalproj.data;

/*
 * 
 */
class Car {
	public final String make;
	public final String model;
	public final String category;
	public final int year;
	public int count = 0; //number of times car has been purchased
	public double avgPrice, avgKm;
	
	
	protected Car(String make, String model, int year, String category) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.category = category;
	}
	
	protected void insertCar(int price, int kilometers, boolean auto) {
		avgKm = count * avgKm;
		avgPrice = count * avgKm;
		count ++;
		avgKm = (avgKm + kilometers)/count;
		avgPrice = (avgPrice + price)/count;
	}
	
	public String toString() {
		return year + " " + make + " " + model + " " 
				+ count + " " + "avgPrice" + " " + avgKm;
	}
}
