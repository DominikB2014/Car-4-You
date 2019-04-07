package gui;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import group3.finalproj.io.ReadData;

public class InitData extends JPanel {

	protected JLabel lblInitalizing;
	protected JLabel lblDone;

	/**
	 * Create the panel.
	 */
	public InitData() {
		setBounds(10, 11, 504, 276);
		setLayout(null);
		setVisible(false);

		lblInitalizing = new JLabel("Loading Data: Please Wait");
		lblInitalizing.setHorizontalAlignment(SwingConstants.CENTER);
		lblInitalizing.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInitalizing.setBounds(10, 11, 468, 37);
		add(lblInitalizing);
		
		lblDone = new JLabel("Loading Data: Done!");
		lblDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDone.setBounds(10, 11, 468, 37);
		lblDone.setVisible(false);
		add(lblDone);
		
	}
	
	public boolean initData() {
		switch(Gui1.files) {
		case 0: return ReadData.readCars("data/newCars.csv", Gui1.types, Gui1.minPrice, Gui1.maxPrice);
		case 1: return ReadData.readCars("data/usedCars.csv", Gui1.types, Gui1.minPrice, Gui1.maxPrice);
		default: ReadData.readCars("data/newCars.csv", Gui1.types, Gui1.minPrice, Gui1.maxPrice);
				return ReadData.readCars("data/usedCars.csv", Gui1.types, Gui1.minPrice, Gui1.maxPrice);
		}
	}

}