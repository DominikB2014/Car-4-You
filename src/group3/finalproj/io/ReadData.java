package group3.finalproj.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import group3.finalproj.car.Car;

/**
 * Reads and initializes car data into the program
 * 
 * @author Dominik Buszowiecki
 *
 */
public class ReadData {

	public static ArrayList<Car> cars = new ArrayList<Car>();

	public static void readCars(String file) {
		try {
			Scanner scanner = new Scanner(new File(file));
			
			//Column titles in the database
			String columnLine = scanner.nextLine();
			String[] categories = columnLine.split(",");
//			while(scanner.hasNextLine()) {
//				car = scanner.nextLine().split(",");
//				
//			}
			
			cars.add(new Car(categories, scanner.nextLine().split(",")));
			cars.add(new Car(categories, scanner.nextLine().split(",")));
			
			for (Car carr: cars) {
				System.out.println(carr);
			}
			
			
			
			scanner.close();
		}catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	public static void main(String args[]) {
		readCars("data/usedCars.csv");
		
	}
}
