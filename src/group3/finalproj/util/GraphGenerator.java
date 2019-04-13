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
	
	public static ArrayList<Car> masterScrum(ArrayList<Tuple<Property, Integer>> property_rank, int maxPrice, int n){
		int source = findSource(property_rank, maxPrice);
		try {
			System.out.println("\nSource Node: " + cars.get(source) + " " + source);
			Graph G = graphMake(n);
			System.out.println("Graph created");
//			for(Integer i: G.adj(source)) System.out.print(cars.get(i) + " ");
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
		for (int i = bestCar.size() - 1; i >= 0 && i > bestCar.size()-6; i--) {
			if (i < bestCar.size()) fiveBest.add(bestCar.get(i));
		}
		return fiveBest;
	}
	
	private static  boolean calcableProperty(Property p) {
		return !(p.equals(Property.BodyStyle) || p.equals(Property.HighwayMPG) || p.equals(Property.Link) 
				|| p.equals(Property.Transmission) || p.equals(Property.Trim) || p.equals(Property.Year)
				|| p.equals(Property.Model) || p.equals(Property.FuelType));
	}
	
	private static int findSource(ArrayList<Tuple<Property, Integer>> property_rank, int maxPrice) {
		int source = 0;
		int total = totalRank(property_rank);
		System.out.println("TOTAL: " + total);
		ArrayList<Car> tempCars = new ArrayList<Car>();
		
		ReadData.setValues();
		
		System.out.println(property_rank.size());
		
		double factor = ((double)property_rank.size()*((double)total/(double)(property_rank.size()*10.0)));
		
		for (Car car: cars) {
			System.out.println(car.scoreCalc(property_rank, maxPrice) + " > " + factor*5);
			if (car.scoreCalc(property_rank, maxPrice) > factor*5) {
//				System.out.println(car);
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
	
	private static int totalRank(ArrayList<Tuple<Property, Integer>> property_rank) {
		int sum = 0;
		for(Tuple<Property, Integer> tup: property_rank) {
			sum += (int)tup.weight;
		}
		return sum;
	}
	
	   /***************************************************************************
	    * Main method for testing
	    ***************************************************************************/
	
	public static void main(String args[]) {
		
		ArrayList<CarType> types = new ArrayList<CarType>(); //Must be in sorted order!	
//		types.add(CarType.Coupe);
//		types.add(CarType.Sedan);
		types.add(CarType.Coupe);
		ReadData.readCars("data/newCars.csv", types, 10000, 30000);
		ReadData.readCars("data/usedCars.csv", types, 10000, 30000);
		
		ArrayList<Tuple<Property, Integer>> properties = new ArrayList<Tuple<Property, Integer>>();
		properties.add(new Tuple<Property, Integer>(Property.Engine, 5));
//		properties.add(new Tuple<Property, Integer>(Property.Make, 7));
		
		System.out.print("Properties Selected: ");
		for(Tuple<Property, Integer> tuple: properties) System.out.print(tuple + " ");
		
		ArrayList<Car> best = new ArrayList<Car>();
		System.out.println("Recommended Cars");
		best = GraphGenerator.masterScrum(properties, 30000, properties.size());
		for (Car car: best) {
			System.out.println(car + " " + car.get(Property.Engine));
		}
	}
}
