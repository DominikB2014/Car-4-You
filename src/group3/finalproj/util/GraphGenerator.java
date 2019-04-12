package group3.finalproj.util;

import java.util.ArrayList;

import group3.finalproj.car.*;
import group3.finalproj.io.ReadData;

public class GraphGenerator {
	
	public static Graph graphMake(int n) {
		Graph G = new Graph(ReadData.cars.size());
		for (int i = 0; i < ReadData.cars.size(); i++) {
			for (int j = i + 1; j < ReadData.cars.size(); j++) {
				int count = 0;
				System.out.print("Hello");
				for (Property p: Property.values()) {
					if (ReadData.cars.get(i).hasProperty(p) && ReadData.cars.get(j).hasProperty(p) 
							&& ReadData.cars.get(i).scoreCalc(p) < 11 && ReadData.cars.get(i).scoreCalc(p) > 5
							&& ReadData.cars.get(j).scoreCalc(p) < 11 && ReadData.cars.get(j).scoreCalc(p) > 5
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
	
	public static ArrayList<Tuple<Car, Integer>> runDFS(Graph G, int source, int maxPrice, ArrayList<Tuple<Property, Integer>> property_Rank){
		ArrayList<Tuple<Car, Integer>> carTuples = new ArrayList<Tuple<Car, Integer>>(); 
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, source);
		boolean[] listCar = bfs.getMarked();
		for (int i = 0; i < listCar.length; i++) {
			if (listCar[i]) {
				int score = ReadData.cars.get(i).scoreCalc(property_Rank, maxPrice);
				Tuple<Car, Integer> tempTup = new Tuple<Car, Integer>(ReadData.cars.get(i), score);
				carTuples.add(tempTup);
			}
		}
		return carTuples;
	}
	
	public static ArrayList<Car> theBestFive(ArrayList<Tuple<Car, Integer>> carTuples){
		ArrayList<Car> bestCar = new ArrayList<Car>();
		for (int i = 0 ; i < carTuples.size(); i++) {
			carTuples.get(i).getProperty().addProperty(Property.Score, carTuples.get(i).getRank());
			bestCar.add(carTuples.get(i).getProperty());
		}
		Heap.sort(bestCar, Property.Score);
		ArrayList<Car> fiveBest = new ArrayList<Car>();
		for (int i = bestCar.size(); i > bestCar.size() - 5 ; i++) {
			fiveBest.add(bestCar.get(i));
		}
		return fiveBest;
	}
	
	private static  boolean calcableProperty(Property p) {
		return !(p.equals(Property.BodyStyle) || p.equals(Property.HighwayMPG) || p.equals(Property.Link) 
				|| p.equals(Property.Transmission) || p.equals(Property.Trim) || p.equals(Property.Year)
				|| p.equals(Property.Model) || p.equals(Property.FuelType));
	}
	private static int carIndex(Car c) {
		for (int i = 0 ; i < ReadData.cars.size(); i++) {
			if (ReadData.cars.get(i) == c) {
				return i;
			}
		}
		return -1;
	}
}
