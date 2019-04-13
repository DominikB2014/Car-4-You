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
	public static int maxMileage = 50000;
	public static int maxPrice = 200000;
	
	/**
	 * Reads cars with specific types into the cars array
	 * @param file - the name of the database file 
	 * @param types - array of cartypes that shall be read
	 */
	public static void readCars(String file, ArrayList<CarType> types) {
		readCars(file, types, 0, Integer.MAX_VALUE);
	}

	/**
	 * Reads cars with specifc types and in a price range into the cars array
	 * @param file - the name of the database file 
	 * @param types - array of cartypes that shall be read
	 * @param minPrice - minimum price of car to be read
	 * @param maxPrice - maximum price of a car to be read
	 */
	public static boolean readCars(String file, ArrayList<CarType> types, int minPrice, int maxPrice) {
		try {
			Scanner scanner = new Scanner(new File(file));
			
			//Column titles in the database
			String[] categories = scanner.nextLine().split(",");
			String[] car = scanner.nextLine().split(",");
			
			//Adds all cars of a the given types to the file
			for(CarType type: types) {
				if (!scanner.hasNext()) {scanner.close(); return false;}
				
				//Linear Search for first occurence of cartype
				while (!(CarType.valueOf(car[4]) == type) && scanner.hasNextLine()) car = scanner.nextLine().split(",");
				
				//When first occurence of car type is found, add all cars of that type
				System.out.println("Found First: " + type + "\n");
				while(CarType.valueOf(car[4]) == type && scanner.hasNextLine()) {
					Car newCar = new Car(categories, car);
					
					//Checks if the car is in the price range specified, if it is adds it
					if (minPrice <= (int)newCar.get(Property.Price) && (int)newCar.get(Property.Price) <= maxPrice) {
						cars.add(new Car(categories, car));
						System.out.println("	Adding: " + cars.get(cars.size()-1)); //Prints which car is being added
					}
					car = scanner.nextLine().split(",");
				}
			}
			System.out.println("DONE READ: Found " + cars.size() + " cars!");
			scanner.close();
			return true;
		}catch (FileNotFoundException e) {System.out.println("File not Found");}
		return false;
	}
	
	   /***************************************************************************
	    * Functions retrieve information about the read data
	    ***************************************************************************/
	
	/**
	 * Returns the price of the most expensive car in the data
	 * @return a integer of the highest price
	 */
	public static void setMaxPrice() {
		int max = 0;
		for (int i = 0; i < cars.size(); i++) {
			if ((int) cars.get(i).get(Property.Price) > max) {
				max = (int) cars.get(i).get(Property.Price);
			}
		}
		if (max > 50000) maxPrice = 50000;
		else maxPrice = max;
	}
	
	/**
	 * Returns the mileage of the car with the most mileage in the data
	 * @return a integer of the highest mileage
	 */
	public static void setMaxMileage() {
		int max = 0;
		for (int i = 0; i < cars.size(); i++) {
			if ((int) cars.get(i).get(Property.Mileage) > max) {
				max = (int) cars.get(i).get(Property.Mileage);
			}
		}
		if (max > 200000) maxMileage = 200000;
		else maxMileage = max;
	}
	
	   /***************************************************************************
	    * Main method for testing
	    ***************************************************************************/
	
	/**
	 * Testing for read
	 * @param args - command line argument
	 */
	public static void main(String args[]) {
		ArrayList<CarType> types = new ArrayList<CarType>(); //Must be in sorted order!
		types.add(CarType.Coupe);
		types.add(CarType.Sedan);
		readCars("data/newCars.csv", types, 0, 40000);
		
	}
}
