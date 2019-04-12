package gui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import group3.finalproj.car.Car;
import group3.finalproj.car.Property;

public class Output extends JPanel {
	
	private JLabel lblSelectProperties;

	/**
	 * Create the panel.
	 */
	public Output(String car, String link) {
		
		setBounds(10, 11, 504, 276);
		setLayout(null);
		setVisible(false);
		
		lblSelectProperties = new JLabel("Here are the Perfect Cars for you!");
		lblSelectProperties.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectProperties.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectProperties.setBounds(10, 11, 468, 37);
		add(lblSelectProperties);
		
		JLabel lblNewLabel = new JLabel(car);
		lblNewLabel.setBounds(20, 81, 92, 26);
		add(lblNewLabel);
		
		JLabel lblLink = new JLabel(link);
		lblLink.setBounds(20, 128, 92, 26);
		add(lblLink);
		
	}
}
