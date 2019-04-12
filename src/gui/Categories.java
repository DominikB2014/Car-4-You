package gui;

import javax.swing.JPanel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JButton;

import static group3.finalproj.car.CarType.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * JPanel for Category Selection
 * @author Dominik Buszowiecki
 *
 */
public class Categories extends JPanel {
	
	private JCheckBox chckbxCrewCabPickup;
	private JCheckBox chckbxExtendedCabPickup;
	private JCheckBox chckbxRegularCabPickup;
	private JCheckBox chckbxCargoVan;
	private JCheckBox chckbxSuv;
	private JCheckBox chckbxMinivan;
	private JCheckBox chckbxWagon;
	private JCheckBox chckbxPassengerVan;
	private JCheckBox chckbxSedan;
	private JCheckBox chckbxCoupe;
	private JCheckBox chckbxConvertible;
	private JCheckBox chckbxHatchback;
	private JLabel lblSelectCarTypes;
	
	/**
	 * Create the panel.
	 */
	public Categories() {
		
		setBounds(10, 11, 504, 276);
		setLayout(null);
		
		chckbxCrewCabPickup = new JCheckBox("Crew Cab Pickup");
		chckbxCrewCabPickup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxCrewCabPickup.setBounds(24, 55, 125, 23);
		add(chckbxCrewCabPickup);
		
		chckbxExtendedCabPickup = new JCheckBox("Extended Cab Pickup");
		chckbxExtendedCabPickup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxExtendedCabPickup.setBounds(24, 81, 143, 23);
		add(chckbxExtendedCabPickup);
		
		chckbxRegularCabPickup = new JCheckBox("Regular Cab Pickup");
		chckbxRegularCabPickup.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxRegularCabPickup.setBounds(24, 107, 143, 23);
		add(chckbxRegularCabPickup);
		
		chckbxCargoVan = new JCheckBox("Cargo Van");
		chckbxCargoVan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxCargoVan.setBounds(24, 133, 143, 23);
		add(chckbxCargoVan);
		
		chckbxSuv = new JCheckBox("SUV");
		chckbxSuv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxSuv.setBounds(200, 55, 108, 23);
		add(chckbxSuv);
		
		chckbxMinivan = new JCheckBox("Minivan");
		chckbxMinivan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxMinivan.setBounds(200, 82, 108, 23);
		add(chckbxMinivan);
		
		chckbxWagon = new JCheckBox("Wagon");
		chckbxWagon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxWagon.setBounds(200, 108, 108, 23);
		add(chckbxWagon);
		
		chckbxPassengerVan = new JCheckBox("Passenger Van");
		chckbxPassengerVan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxPassengerVan.setBounds(200, 134, 125, 23);
		add(chckbxPassengerVan);
		
		chckbxSedan = new JCheckBox("Sedan");
		chckbxSedan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxSedan.setBounds(353, 56, 125, 23);
		add(chckbxSedan);
		
		chckbxCoupe = new JCheckBox("Coupe");
		chckbxCoupe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxCoupe.setBounds(353, 82, 125, 23);
		add(chckbxCoupe);
		
		chckbxConvertible = new JCheckBox("Convertible");
		chckbxConvertible.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxConvertible.setBounds(353, 108, 125, 23);
		add(chckbxConvertible);
		
		chckbxHatchback = new JCheckBox("Hatchback");
		chckbxHatchback.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxHatchback.setBounds(353, 134, 125, 23);
		add(chckbxHatchback);
		
		lblSelectCarTypes = new JLabel("Select Car Types");
		lblSelectCarTypes.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectCarTypes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSelectCarTypes.setBounds(10, 11, 468, 37);
		add(lblSelectCarTypes);
	}
	
	/**
	 * Initalizes the types to be read from the file
	 */
	public void getTypes(){
		Gui1.types.clear();
		
		//Intializes array list of car types, in alphabetical order
		if(chckbxCargoVan.isSelected()) Gui1.types.add(CargoVan);
		if(chckbxConvertible.isSelected()) Gui1.types.add(Convertible);
		if(chckbxCoupe.isSelected()) Gui1.types.add(Coupe);
		if(chckbxCrewCabPickup.isSelected()) Gui1.types.add(CrewCabPickup);
		if(chckbxExtendedCabPickup.isSelected()) Gui1.types.add(ExtendedCabPickup);
		if(chckbxHatchback.isSelected()) Gui1.types.add(Hatchback);
		if(chckbxMinivan.isSelected()) Gui1.types.add(Minivan);
		if(chckbxPassengerVan.isSelected()) Gui1.types.add(PassengerVan);
		if(chckbxRegularCabPickup.isSelected()) Gui1.types.add(RegularCabPickup);
		if(chckbxSedan.isSelected()) Gui1.types.add(Sedan);
		if(chckbxSuv.isSelected()) Gui1.types.add(SUV);
		if(chckbxWagon.isSelected()) Gui1.types.add(Wagon);
		
	}
}
