package group3.finalproj.car;

/**
 * 
 * @author Pedram Yazdinia
 * A custom class to represent a tuple data structure.
 * @param <X> Type for the first value of the Tuple
 * @param <Y> Type for the second value of the Tuple
 */
public class Tuple<X, Y> {
	private final X property;
	private final Y weight;
	/**
	 * Constructor for Tuple ADT 
	 * @param x First value of the Tuple of type X
	 * @param y Second value of the Tuple of type Y
	 */
	public Tuple(X x, Y y) {
		this.property = x;
		this.weight = y;
	}
	
	@Override
	public String toString () {
		return property.toString() + " " + weight;
}
	/**
	 * Get the first value of the tuple
	 * @return property of Type X
	 */
	public X getProperty() {
		return property;
	}
	/**
	 * Get the second value of the tuple
	 * @return weight of type Y
	 */
	public Y getRank() {
		return weight;
	}
}
