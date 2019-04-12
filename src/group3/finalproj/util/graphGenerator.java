package group3.finalproj.util;

import java.util.ArrayList;
import java.util.EnumSet;

import group3.finalproj.car.*;
import group3.finalproj.io.ReadData;

public class graphGenerator {
	
	public static ArrayList<Car> cars = ReadData.cars;
	
	public static Graph graphMake(int n) {
		Graph G = new Graph(ReadData.cars.size());
		for (int i = 0; i < ReadData.cars.size(); i++) {
			for (int j = i + 1; j < ReadData.cars.size(); j++) {
				int count = 0;
				for (Property p: Property.values()) {
					if (ReadData.cars.get(i).hasProperty(p) && ReadData.cars.get(j).hasProperty(p) && ReadData.cars.get(i).compareTo(p, ReadData.cars.get(j)) == 0) {
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
	
	
	public static int carIndex(Car c) {
		for (int i = 0 ; i < ReadData.cars.size(); i++) {
			if (ReadData.cars.get(i) == c) {
				return i;
			}
		}
		return -1;
	}
}
