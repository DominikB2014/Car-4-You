package group3.finalproj.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads and initializes car data into the program
 * 
 * @author Dominik Buszowiecki
 *
 */
public class ReadData {

	public ArrayList<Car> cars = new ArrayList<Car>();

	public static void readCars(String file, String[] categories) {
		try {
			Scanner scanner = new Scanner(new File(file));
			
			//Column titles in the database
			String columnLine = scanner.nextLine();
			String[] columns = columnLine.split(",");
//			while(scanner.hasNextLine()) {
//				car = scanner.nextLine().split(",");
//				
//			}
			String[] car = scanner.nextLine().split(",");
			for (int i = 0; i < columns.length; i++) {
				System.out.println(columns[i] + ": " + car[i]);
			}
			scanner.close();
		}catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	public static void main(String args[]) {
		String[] cat = {"SUV"};
		readCars("data/usedCars.csv", cat);
		
	}
}
