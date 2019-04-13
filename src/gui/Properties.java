package gui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import group3.finalproj.car.Property;
import group3.finalproj.car.Tuple;


/**
 * JFrame for property selection
 * @author Dominik Buszowiecki
 *
 */
public class Properties extends JPanel {
	
	private JLabel lblSelectProperties;
	private JCheckBox chckbxEcon;
	private JCheckBox chckbxAffordability;
	private JCheckBox chckbxAllWheelDrive;
	private JCheckBox chckbxPerformance;
	private JCheckBox chckbxLuxury;
	private JCheckBox chckbxMileage;
	
	private JFormattedTextField mileageText;
	private JFormattedTextField econText;
	private JFormattedTextField awdText;
	private JFormattedTextField affordText;
	private JFormattedTextField performText;
	private JFormattedTextField luxuryText;

	/**
	 * Create the panel.
	 */
	public Properties() {
		
		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		intFormat.setGroupingUsed(false);
		NumberFormatter intFormatter = new NumberFormatter(intFormat);
		intFormatter.setValueClass(Integer.class);
		intFormatter.setAllowsInvalid(false);
		intFormatter.setMinimum(0);
		
		setBounds(10, 11, 504, 276);
		setLayout(null);
		setVisible(false);
		
		lblSelectProperties = new JLabel("Select Car Properties and Rank from 1-10");
		lblSelectProperties.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectProperties.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectProperties.setBounds(10, 11, 468, 37);
		add(lblSelectProperties);
		
		chckbxEcon = new JCheckBox("Fuel Economy");
		chckbxEcon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxEcon.setBounds(24, 55, 126, 23);
		add(chckbxEcon);
		
		chckbxAffordability = new JCheckBox("Affordability");
		chckbxAffordability.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAffordability.setBounds(258, 55, 116, 23);
		add(chckbxAffordability);
		
		chckbxAllWheelDrive = new JCheckBox("All Wheel Drive");
		chckbxAllWheelDrive.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAllWheelDrive.setBounds(24, 112, 126, 23);
		add(chckbxAllWheelDrive);
		
		econText = new JFormattedTextField(intFormatter);
		econText.setBounds(154, 47, 87, 32);
		add(econText);
		econText.setColumns(10);
		
		awdText = new JFormattedTextField(intFormatter);
		awdText.setColumns(10);
		awdText.setBounds(154, 104, 87, 32);
		add(awdText);
		
		affordText = new JFormattedTextField(intFormatter);
		affordText.setColumns(10);
		affordText.setBounds(391, 47, 87, 32);
		add(affordText);
		
		chckbxPerformance = new JCheckBox("Performance");
		chckbxPerformance.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxPerformance.setBounds(258, 112, 119, 23);
		add(chckbxPerformance);
		
		performText = new JFormattedTextField((Object) null);
		performText.setColumns(10);
		performText.setBounds(391, 104, 87, 32);
		add(performText);
		
		luxuryText = new JFormattedTextField((Object) null);
		luxuryText.setColumns(10);
		luxuryText.setBounds(154, 167, 87, 32);
		add(luxuryText);
		
		chckbxLuxury = new JCheckBox("Luxury");
		chckbxLuxury.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxLuxury.setBounds(24, 176, 132, 23);
		add(chckbxLuxury);
		
		chckbxMileage = new JCheckBox("Low Mileage");
		chckbxMileage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxMileage.setBounds(258, 175, 119, 23);
		add(chckbxMileage);
		
		mileageText = new JFormattedTextField(intFormatter);
		mileageText.setColumns(10);
		mileageText.setBounds(391, 167, 87, 32);
		add(mileageText);	
	}
	
	public void getProperties() {
		Gui1.properties.clear();
		if(chckbxEcon.isSelected()) Gui1.properties.add(new Tuple<Property, Integer>(Property.CityMPG, normalize(econText.getText())));
		if(chckbxAffordability.isSelected()) Gui1.properties.add(new Tuple<Property, Integer>(Property.Price, normalize(affordText.getText())));
		if(chckbxAllWheelDrive.isSelected()) Gui1.properties.add(new Tuple<Property, Integer>(Property.Drivetrain, normalize(awdText.getText())));
		if(chckbxPerformance.isSelected()) Gui1.properties.add(new Tuple<Property, Integer>(Property.Engine, normalize(performText.getText())));
		if(chckbxLuxury.isSelected()) Gui1.properties.add(new Tuple<Property, Integer>(Property.Make, normalize(luxuryText.getText())));
		if(chckbxMileage.isSelected()) Gui1.properties.add(new Tuple<Property, Integer>(Property.Mileage, normalize(mileageText.getText())));
		printConsole();
	}
	
	private int normalize(String string) {
		if (string.equalsIgnoreCase("")) return 5;
		if (Integer.parseInt(string) > 10) return 10;
		return Integer.parseInt(string);
	}
	
	private void printConsole() {
		System.out.print("Properties Selected: ");
		for (Tuple<Property, Integer> tuple: Gui1.properties) {
			System.out.println(tuple);
		}
	}
}
