package group3.finalproj.util;

import java.util.ArrayList;

import group3.finalproj.car.*;
import group3.finalproj.io.ReadData;

/**
 * Graphing Algorithm required to recommend the user a compatible car
 * @author Pedram Yazdinia
 *
 */
public class GraphGenerator {
	
	public static ArrayList<Car> cars = ReadData.cars;
	
	/**
	 * Main function that employs all of the helper functions 
	 * to find and output the best five cars with the highest score.
	 * @param property_rank An ArrayList of Tuples with the first value of type Property
	 * and second value of type Integer
	 * @param maxPrice The maxPrice that user chooses in the GUI
	 * @param n The number of properties that our graph is going to connect the edges based on
	 * @return carTuples An ArrayList of car with a maximum size of five.
	 */
	public static ArrayList<Car> findBestCars(ArrayList<Tuple<Property, Integer>> property_rank, int maxPrice, int n){
		int source = findSource(property_rank, maxPrice);
		try {
			System.out.println("\nSource Node: " + cars.get(source) + " " + source);
			Graph G = graphMake(n);
			System.out.println("Graph created");
			System.out.println();
			ArrayList<Tuple<Car, Integer>> carTuples = runDFS(G, source, maxPrice, property_rank);
			ArrayList<Car> theBest = theBestFive(carTuples);
			return theBest;
		}catch(IndexOutOfBoundsException e){
			ArrayList<Car> carTuples = new ArrayList<Car>();
			return carTuples;
		}

	}
	   /***************************************************************************
	    * Helper functions
	    ***************************************************************************/
	/**
	 * Graph generator function that goes through every Car in the initially filtered 
	 * data set by the user specified conditions, to connect the cars that share the 
	 * given number of properties or more than that.
	 * @param n
	 * @return
	 */
	private static Graph graphMake(int n) {
		Graph G = new Graph(cars.size());
		for (int i = 0; i < cars.size(); i++) {
			for (int j = i + 1; j < cars.size(); j++) {
				int count = 0;
				for (Property p: Property.values()) {
					if (cars.get(i).hasProperty(p) && cars.get(j).hasProperty(p) 
							&& cars.get(i).scoreCalc(p) > 3
							&& cars.get(j).scoreCalc(p) > 3
							&& calcableProperty(p)) {
						count++;
					}	
				}
				if (count >= n) {
					G.addEdge(i, j);
				}
			}
		}
		return G;
	}
	/**
	 * This method will run Depth First Search algorithm on a gien source to find all of the cars in the 
	 * same connected component as the given source. 
	 * @param G The graph in which the different connected components from our car dataset each share 
	 * a certain number of properties.
	 * @param source An integer that represents the source node which our DFS algorithm uses.
	 * @param maxPrice An integer that specifies the max price given by the user.
	 * @param property_Rank An ArrayList that contains custom Tuples of the type Property and Integer.
	 * @return carTuples which represents all of the found cars in the same connected component by the DFS alg.
	 */
	private static ArrayList<Tuple<Car, Integer>> runDFS(Graph G, int source, int maxPrice, ArrayList<Tuple<Property, Integer>> property_Rank){
		ArrayList<Tuple<Car, Integer>> carTuples = new ArrayList<Tuple<Car, Integer>>(); 
		DepthFirstPaths dfs = new DepthFirstPaths(G, source);
		boolean[] listCar = dfs.getMarked();
		for (int i = 0; i < listCar.length; i++) {
			if (listCar[i]) {
				int score = cars.get(i).scoreCalc(property_Rank, maxPrice);
				Tuple<Car, Integer> tempTup = new Tuple<Car, Integer>(cars.get(i), score);
				carTuples.add(tempTup);
			}
		}
		return carTuples;
	}
	/**
	 * This method returns the best five cars that have the highest score using the properties 
	 * selected by the user. The program uses HeapSort to sort the given list of cars using their
	 * score.
	 * @param carTuples An ArrayList of Tuples that includes that properties associated with the 
	 * attribute selected by the user in the program.
	 * @return the cars with the 5 highest score. 
	 */
	private static ArrayList<Car> theBestFive(ArrayList<Tuple<Car, Integer>> carTuples){
		System.out.println("Potential Cars: " + carTuples.size());
		ArrayList<Car> bestCar = new ArrayList<Car>();
		for (Tuple<Car, Integer> tuple: carTuples) {
			tuple.getProperty().addProperty(Property.Score, tuple.getRank());
			bestCar.add(tuple.getProperty());
		}
		Heap.sort(bestCar, Property.Score);
		ArrayList<Car> fiveBest = new ArrayList<Car>();
		for (int i = bestCar.size() - 1; i >= 0 && i > bestCar.size()-6; i--) {
			if (i < bestCar.size()) fiveBest.add(bestCar.get(i));
		}
		return fiveBest;
	}
	/**
	 * Used to crossout properties that cannot be used to calculate a score. 
	 * @param p Property to check.
	 * @return True if the given property is not any of the following, BodyStyle, HighwayMPG, Link,
	 * Transmission, Trim, Year, Model and FuelType.
	 */
	private static  boolean calcableProperty(Property p) {
		return !(p.equals(Property.BodyStyle) || p.equals(Property.HighwayMPG) || p.equals(Property.Link) 
				|| p.equals(Property.Transmission) || p.equals(Property.Trim) || p.equals(Property.Year)
				|| p.equals(Property.Model) || p.equals(Property.FuelType));
	}
	/**
	 * This function will find a compatible source node in our data set by iterating through the 
	 * cars dataset and checking if score of each car given a property_rank is bigger than the 
	 * current score which is initialized to be 0. 
	 * @param property_rank An ArrayList that contains custom Tuples of the type Property and Integer.
	 * @param maxPrice An integer that specifies the max price given by the user.
	 * @return An integer that represents the index of our source in our data set.
	 */
	private static int findSource(ArrayList<Tuple<Property, Integer>> property_rank, int maxPrice) {
		int source = 0;
		int total = totalRank(property_rank);
		System.out.println("TOTAL: " + total);
		ArrayList<Car> tempCars = new ArrayList<Car>();
		
		ReadData.setValues();
		
		System.out.println(property_rank.size());
		
		double factor = ((double)property_rank.size()*((double)total/(double)(property_rank.size()*10.0)));
		
		for (Car car: cars) {
			//System.out.println(car.scoreCalc(property_rank, maxPrice) + " > " + factor*5);
			if (car.scoreCalc(property_rank, maxPrice) > factor*5) {
				tempCars.add(car);
				if(cars.get(source).scoreCalc(property_rank, maxPrice) < car.scoreCalc(property_rank, maxPrice)) {
					source = tempCars.indexOf(car);
				}
			}
		}
		System.out.println("DONE: " + tempCars.size() + " meet the properties");
		cars = tempCars;
		return source;
	}
	/**
	 * This method returns the sum of the weight that the user is given to each of their 
	 * desired attributes.
	 * @param property_rank An ArrayList that contains custom Tuples of the type Property and Integer.
	 * @return An integer representing the total weight of the given attributes, selected by the user.
	 */
	private static int totalRank(ArrayList<Tuple<Property, Integer>> property_rank) {
		int sum = 0;
		for(Tuple<Property, Integer> tup: property_rank) {
			sum += (int)tup.getRank();
		}
		return sum;
	}
	
	   /***************************************************************************
	    * Main method for testing
	    ***************************************************************************/
	
	/**
	 * Main method for testing purposes 
	 * @param args the command-line arguments
	 */
	public static void main(String args[]) {
		
		ArrayList<CarType> types = new ArrayList<CarType>(); //Must be in sorted order!	
		types.add(CarType.Coupe);
		ReadData.readCars("data/newCars.csv", types, 10000, 30000);
		ReadData.readCars("data/usedCars.csv", types, 10000, 30000);
		
		ArrayList<Tuple<Property, Integer>> properties = new ArrayList<Tuple<Property, Integer>>();
		properties.add(new Tuple<Property, Integer>(Property.Engine, 5));
		
		System.out.print("Properties Selected: ");
		for(Tuple<Property, Integer> tuple: properties) System.out.print(tuple + " ");
		
		ArrayList<Car> best = new ArrayList<Car>();
		System.out.println("Recommended Cars");
		best = GraphGenerator.findBestCars(properties, 30000, properties.size());
		for (Car car: best) {
			System.out.println(car + " " + car.get(Property.Engine));
		}
	}
}
