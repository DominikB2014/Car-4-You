package group3.finalproj.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads and initializes car data into the program
 * 
 * @author Dominik Buszowiecki
 *
 */
public class ReadData {
	
	public Car cars[] = new Car[1000];
	
	public static void main(String args[]) {
		try {
			Scanner scanner = new Scanner(new File("data/SalesData.csv")); // Read file
			
			// Column titles in the database
			String columnLine = scanner.nextLine();
			System.out.println(columnLine);
			String[] columns = columnLine.split(","); // Array of column titles
			columns[0] = columns[0].substring(3);

			// Single car in database
			String[] car = scanner.nextLine().split(",");
			
			for (int i = 0; i < columns.length; i++) {
				System.out.println(columns[i] + ": " + car[i]);
			}


			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}
}
