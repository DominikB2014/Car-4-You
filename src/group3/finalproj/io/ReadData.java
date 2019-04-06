package group3.finalproj.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import group3.finalproj.car.*;

/**
 * Reads and initializes car data into the program
 * @author Dominik Buszowiecki
 *
 */
public class ReadData {

	public static ArrayList<Car> cars = new ArrayList<Car>();
	
	/**
	 * Reads cars with specific types into the cars array
	 * @param file - the name of the database file 
	 * @param types - array of cartypes that shall be read
	 */
	public static void readCars(String file, CarType[] types) {
		readCars(file, types, 0, Integer.MAX_VALUE);
	}

	/**
	/**
	 * Reads cars with specifc types and in a price range into the cars array
	 * @param file - the name of the database file 
	 * @param types - array of cartypes that shall be read
	 * @param minPrice - minimum price of car to be read
	 * @param maxPrice - maximum price of a car to be read
	 */
	public static void readCars(String file, CarType[] types, int minPrice, int maxPrice) {
		try {
			Scanner scanner = new Scanner(new File(file));
			
			//Column titles in the database
			String[] categories = scanner.nextLine().split(",");
			String[] car = scanner.nextLine().split(",");
			
			//Adds all cars of a the given types to the file
			for(CarType type: types) {
				if (!scanner.hasNext()) return;
				
				//Linear Search for first occurence of cartype
				while (!(CarType.valueOf(car[4]) == type)) car = scanner.nextLine().split(",");
				
				//When first occurence of car type is found, add all cars of that type
				System.out.println("Found First: " + type + "\n");
				while(CarType.valueOf(car[4]) == type) {
					Car newCar = new Car(categories, car);
					
					//Checks if the car is in the price range specified
					if (minPrice <= (int)newCar.properties.get(Property.Price) && (int)newCar.properties.get(Property.Price) <= maxPrice) {
						cars.add(new Car(categories, car));
						System.out.println("	Adding: " + cars.get(cars.size()-1)); //Prints which car is being added
					}
					car = scanner.nextLine().split(",");
				}
				scanner.close();
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	/**
	 * Testing for read
	 * @param args - command line argument
	 */
	public static void main(String args[]) {
		CarType[] types = {CarType.CargoVan, CarType.Sedan}; //Must be in sorted order!
		readCars("data/newCars.csv", types, 0, 40000);
		
	}
}
