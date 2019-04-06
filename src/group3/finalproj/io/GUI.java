package group3.finalproj.io;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUI {

	private JFrame frame;
	private JTextField txtChooseCategories;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtChooseCategories = new JTextField();
		txtChooseCategories.setHorizontalAlignment(SwingConstants.CENTER);
		txtChooseCategories.setText("Choose Categories");
		txtChooseCategories.setFont(new Font("Arial", Font.BOLD, 18));
		txtChooseCategories.setBounds(0, 0, 434, 39);
		frame.getContentPane().add(txtChooseCategories);
		txtChooseCategories.setColumns(10);
		
		JCheckBox chckbxSedan = new JCheckBox("Sedan");
		chckbxSedan.setBounds(326, 68, 98, 23);
		frame.getContentPane().add(chckbxSedan);
		
		JCheckBox chckbxCoupe = new JCheckBox("Coupe");
		chckbxCoupe.setBounds(326, 94, 98, 23);
		frame.getContentPane().add(chckbxCoupe);
		
		JCheckBox chckbxConvertible = new JCheckBox("Convertible");
		chckbxConvertible.setBounds(326, 120, 98, 23);
		frame.getContentPane().add(chckbxConvertible);
		
		JCheckBox chckbxHatchback = new JCheckBox("Hatchback");
		chckbxHatchback.setBounds(326, 146, 98, 23);
		frame.getContentPane().add(chckbxHatchback);
		
		JCheckBox chckbxExtendedCabPickup = new JCheckBox("Extended Cab Pickup");
		chckbxExtendedCabPickup.setBounds(18, 94, 129, 23);
		frame.getContentPane().add(chckbxExtendedCabPickup);
		
		JCheckBox chckbxCrewCabPickup = new JCheckBox("Crew Cab Pickup");
		chckbxCrewCabPickup.setBounds(18, 68, 129, 23);
		frame.getContentPane().add(chckbxCrewCabPickup);
		
		JCheckBox chckbxRegularCabPickup = new JCheckBox("Regular Cab Pickup");
		chckbxRegularCabPickup.setBounds(18, 120, 129, 23);
		frame.getContentPane().add(chckbxRegularCabPickup);
		
		JCheckBox chckbxCargoVan = new JCheckBox("Cargo Van");
		chckbxCargoVan.setBounds(18, 146, 129, 23);
		frame.getContentPane().add(chckbxCargoVan);
		
		JCheckBox chckbxSUV = new JCheckBox("SUV");
		chckbxSUV.setBounds(183, 68, 129, 23);
		frame.getContentPane().add(chckbxSUV);
		
		JCheckBox chckbxMinivan = new JCheckBox("Minivan");
		chckbxMinivan.setBounds(183, 94, 129, 23);
		frame.getContentPane().add(chckbxMinivan);
		
		JCheckBox chckbxPassengerVan = new JCheckBox("Passenger Van");
		chckbxPassengerVan.setBounds(183, 146, 129, 23);
		frame.getContentPane().add(chckbxPassengerVan);
		
		JCheckBox chckbxWagon = new JCheckBox("Wagon");
		chckbxWagon.setBounds(183, 120, 129, 23);
		frame.getContentPane().add(chckbxWagon);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbx) 
			}
		});
		btnNext.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNext);
	}
}
