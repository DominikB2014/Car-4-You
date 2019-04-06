package group3.finalproj.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import group3.finalproj.car.Car;
import group3.finalproj.car.CarType;

/**
 * Reads and initializes car data into the program
 * 
 * @author Dominik Buszowiecki
 *
 */
public class ReadData {

	public static ArrayList<Car> cars = new ArrayList<Car>();

	public static void readCars(String file, CarType[] types) {
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
					cars.add(new Car(categories, car));
					System.out.println("	Adding: " + cars.get(cars.size()-1)); //Prints which car is being added
					car = scanner.nextLine().split(",");
				}
			}
			scanner.close();
			
		}catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	public static void main(String args[]) {
		CarType[] types = {CarType.CargoVan, CarType.Sedan}; //Must be in sorted order!
		readCars("data/newCars.csv", types);
		
	}
}
