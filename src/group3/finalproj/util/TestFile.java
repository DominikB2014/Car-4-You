// TODO - This file will be deleted. It is a placeholder used to upload the project to git as well test certain functionalities

package group3.finalproj.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** 
 * @author Dominik Buszowiecki
 * 
 */
public class TestFile {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(new File("data/SalesData.csv")); //Read file
			
			//Column titles in the database
			String columnLine = scanner.nextLine();
			System.out.println(columnLine);
			String[] columns = columnLine.split(","); //Array of column titles
			columns[0] = columns[0].substring(3);
			
			//Single line in database
			String line = scanner.nextLine();
			System.out.println(line + "\n");
			
			//Single car in database
			String[] car = line.split(",");
			for(int i = 0; i < columns.length; i++) {
				System.out.println(columns[i] + ": " + car[i]);
			}	
			
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.out.println("File not Found");
		}
	}	
}
