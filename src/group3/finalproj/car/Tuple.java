package group3.finalproj.car;

public class Tuple<X, Y> {
	public final X property;
	public final Y weight;
	
	public Tuple(X x, Y y) {
		this.property = x;
		this.weight = y;
	}
	
	@Override
	public String toString () {
		return property.toString() + " " + weight;
}
	public X getProperty() {
		return property;
	}
	
	public Y getRank() {
		return weight;
	}
}
