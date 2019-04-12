package group3.finalproj.car;

public class Tuple {
	public final Property property;
	public final int weight;
	
	public Tuple(Property x, int y) {
		this.property = x;
		this.weight = y;
	}
	
	@Override
	public String toString () {
		return property.toString() + weight;
}
	public Property getProperty() {
		return property;
	}
	
	public int getRank() {
		return weight;
	}
}
