package group3.finalproj.util;

import java.util.ArrayList;

import group3.finalproj.car.*;
import group3.finalproj.io.ReadData;

/**
 * 
 * @author Pedram Yazdinia
 *
 */
public class GraphGenerator {
	
	public static ArrayList<Car> cars = ReadData.cars;
	
	private static Graph graphMake(int n) {
		Graph G = new Graph(cars.size());
		for (int i = 0; i < cars.size(); i++) {
			for (int j = i + 1; j < cars.size(); j++) {
				int count = 0;
				for (Property p: Property.values()) {
					if (cars.get(i).hasProperty(p) && cars.get(j).hasProperty(p) 
							&& cars.get(i).scoreCalc(p) < 11 && cars.get(i).scoreCalc(p) > 5
							&& cars.get(j).scoreCalc(p) < 11 && cars.get(j).scoreCalc(p) > 5
							&& calcableProperty(p)) {
						count++;
					}	
				}
				if (count == n) {
					G.addEdge(i, j);
				}
			}
		}
		return G;
	}
	
	private static ArrayList<Tuple<Car, Integer>> runDFS(Graph G, int source, int maxPrice, ArrayList<Tuple<Property, Integer>> property_Rank){
		ArrayList<Tuple<Car, Integer>> carTuples = new ArrayList<Tuple<Car, Integer>>(); 
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, source);
		boolean[] listCar = bfs.getMarked();
		for (int i = 0; i < listCar.length; i++) {
			if (listCar[i]) {
				int score = cars.get(i).scoreCalc(property_Rank, maxPrice);
				Tuple<Car, Integer> tempTup = new Tuple<Car, Integer>(cars.get(i), score);
				carTuples.add(tempTup);
			}
		}
		return carTuples;
	}
	
	private static ArrayList<Car> theBestFive(ArrayList<Tuple<Car, Integer>> carTuples){
		System.out.println("Potential Cars: " + carTuples.size());
		ArrayList<Car> bestCar = new ArrayList<Car>();
		for (Tuple<Car, Integer> tuple: carTuples) {
			tuple.getProperty().addProperty(Property.Score, tuple.getRank());
			bestCar.add(tuple.getProperty());
		}
		Heap.sort(bestCar, Property.Score);
		ArrayList<Car> fiveBest = new ArrayList<Car>();
		for (int i = bestCar.size() - 1; i < bestCar.size() && i > bestCar.size()-6; i--) {
			if (i < bestCar.size()) fiveBest.add(bestCar.get(i));
		}
		return fiveBest;
	}
	
	private static int findSource(ArrayList<Tuple<Property, Integer>> property_rank, int maxPrice) {
		int source = 0;
		ArrayList<Car> tempCars = new ArrayList<Car>();
		for (Car c: cars) {
			if (c.scoreCalc(property_rank, maxPrice) > (property_rank.size() * 4)) {
				tempCars.add(c);
			}
			else if (c.scoreCalc(property_rank, maxPrice) > (property_rank.size() * 8)) {
				source = cars.indexOf(c);
			}
		}
		cars = tempCars;
		return source;
	}
	
	public static ArrayList<Car> masterScrum(ArrayList<Tuple<Property, Integer>> property_rank, int maxPrice, int n){
		int source = findSource(property_rank, maxPrice);
		System.out.println("\nSource Node: " + cars.get(source));
		Graph G = graphMake(n);
		ArrayList<Tuple<Car, Integer>> carTuples = runDFS(G, source, maxPrice, property_rank);
		ArrayList<Car> theBest = theBestFive(carTuples);
		return theBest;
	}
	   /***************************************************************************
	    * Helper functions
	    ***************************************************************************/
	
	private static  boolean calcableProperty(Property p) {
		return !(p.equals(Property.BodyStyle) || p.equals(Property.HighwayMPG) || p.equals(Property.Link) 
				|| p.equals(Property.Transmission) || p.equals(Property.Trim) || p.equals(Property.Year)
				|| p.equals(Property.Model) || p.equals(Property.FuelType));
	}
	
	
	   /***************************************************************************
	    * Main method for testing
	    ***************************************************************************/
	
	public static void main(String args[]) {
		
		ArrayList<CarType> types = new ArrayList<CarType>(); //Must be in sorted order!	
		types.add(CarType.Coupe);
		types.add(CarType.Sedan);
		ReadData.readCars("data/newCars.csv", types, 0, 40000);
		
		ArrayList<Tuple<Property, Integer>> properties = new ArrayList<Tuple<Property, Integer>>();
		properties.add(new Tuple<Property, Integer>(Property.Make, 9));
		
		System.out.print("Properties Selected: ");
		for(Tuple<Property, Integer> tuple: properties) System.out.print(tuple + " ");
		
		ArrayList<Car> best = new ArrayList<Car>();
		
		System.out.println("Recommended Cars");
		best = GraphGenerator.masterScrum(properties, 40000, 3);
		for (Car car: best) {
			System.out.println(car);
		}
	}
}
