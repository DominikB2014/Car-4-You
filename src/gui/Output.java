package gui;

import java.util.ArrayList;

import javax.swing.JPanel;

import group3.finalproj.car.Car;
import group3.finalproj.car.Property;

public class Output extends JPanel {

	/**
	 * Create the panel.
	 */
	public Output(ArrayList<Car> cars) {
		int numCars = 5;
		
		setBounds(10, 11, 504, 276);
		setLayout(null);
		setVisible(false);
		String[] carText = new String[numCars];
		String[] links = new String[numCars];
		
		//Adds string representation of each car
		for (int j = 0; j < numCars && j < cars.size(); j++) {
			carText[j] = j + ": " + cars.get(j).toString();
			links[j] = (String)cars.get(j).get(Property.Link);
		}
		//If less than 5 cars returned, create empty car string representations
		for(int i = 5; i > numCars - cars.size(); i++) {
			carText[i] = i + ": ";
			links[i] = "";
		}
		
		
		
		
	}

}
