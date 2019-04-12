package gui;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.text.NumberFormatter;

import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;


/**
 * GUI for property selection
 * @author Dominik Buszowiecki
 *
 */
public class Properties extends JPanel {
	
	private JLabel lblSelectProperties;
	private JCheckBox chckbxCrewCabPickup;
	private JFormattedTextField textField;
	private JFormattedTextField textField_1;

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
		
		chckbxCrewCabPickup = new JCheckBox("Fuel Economy");
		chckbxCrewCabPickup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxCrewCabPickup.setBounds(24, 55, 157, 23);
		add(chckbxCrewCabPickup);
		
		JCheckBox chckbxAffordability = new JCheckBox("Affordability");
		chckbxAffordability.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAffordability.setBounds(258, 55, 157, 23);
		add(chckbxAffordability);
		
		JCheckBox chckbxAllWheelDrive = new JCheckBox("All Wheel Drive");
		chckbxAllWheelDrive.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAllWheelDrive.setBounds(24, 112, 157, 23);
		add(chckbxAllWheelDrive);
		
		textField = new JFormattedTextField(intFormatter);
		textField.setBounds(154, 47, 87, 32);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JFormattedTextField(intFormatter);
		textField_1.setColumns(10);
		textField_1.setBounds(154, 104, 87, 32);
		add(textField_1);
			
	}
}
