package group3.finalproj.car;

/**
 * 
 * @author Pedram Yazdinia
 *
 * @param <X>
 * @param <Y>
 */
public class Tuple<X, Y> {
	private final X property;
	private final Y weight;
	
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
