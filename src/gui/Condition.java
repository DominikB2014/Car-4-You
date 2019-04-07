package gui;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JPanel for for Condition and Price selection
 * @author Dominik Buszowiecki
 *
 */
public class Condition extends JPanel {
	private JFormattedTextField minPrice;
	private JFormattedTextField maxPrice;
	private JLabel lblConditionPrice;
	
	private JCheckBox rdbtnNew;
	private JCheckBox rdbtnUsed;
	private JCheckBox rdbtnIDontKnow;
	private JCheckBox chckbxMinprice;
	private JCheckBox chckbxMaxPrice;

	/**
	 * Create the panel.
	 */
	public Condition() {
		NumberFormat intFormat = NumberFormat.getIntegerInstance();
		intFormat.setGroupingUsed(false);
		NumberFormatter intFormatter = new NumberFormatter(intFormat);
		intFormatter.setValueClass(Integer.class);
		intFormatter.setAllowsInvalid(false);
		intFormatter.setMinimum(0);
		
		setBounds(10, 11, 504, 276);
		setLayout(null);
		setVisible(false);
		
		rdbtnNew = new JCheckBox("New");
		rdbtnNew.setBounds(43, 69, 109, 23);
		
		rdbtnUsed = new JCheckBox("Used");
		rdbtnUsed.setBounds(43, 116, 109, 23);
		
		rdbtnIDontKnow = new JCheckBox("I Don't Know");
		rdbtnIDontKnow.setSelected(true);
		rdbtnIDontKnow.setBounds(43, 164, 109, 23);	
		
		rdbtnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnIDontKnow.setSelected(false);
				rdbtnUsed.setSelected(false);
				rdbtnNew.setSelected(true);
			}
		});
		rdbtnUsed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnIDontKnow.setSelected(false);
				rdbtnUsed.setSelected(true);
				rdbtnNew.setSelected(false);
			}
		});
		rdbtnIDontKnow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnIDontKnow.setSelected(true);
				rdbtnUsed.setSelected(false);
				rdbtnNew.setSelected(false);
			}
		});
		add(rdbtnUsed);
		add(rdbtnIDontKnow);
		add(rdbtnNew);
		
		chckbxMinprice = new JCheckBox("Min Price:   $");
		chckbxMinprice.setBounds(196, 69, 97, 23);
		add(chckbxMinprice);
		
		chckbxMaxPrice = new JCheckBox("Max Price: $");
		chckbxMaxPrice.setBounds(196, 116, 97, 23);
		add(chckbxMaxPrice);
		
		maxPrice = new JFormattedTextField(intFormatter);
		maxPrice.setBounds(299, 117, 84, 20);
		add(maxPrice);
		maxPrice.setColumns(10);
		
		minPrice = new JFormattedTextField(intFormatter);
		minPrice.setBounds(299, 70, 84, 20);
		add(minPrice);
		minPrice.setColumns(10);
		
		lblConditionPrice = new JLabel("Choose Condition and Specify Price Range(Optional)");
		lblConditionPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblConditionPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConditionPrice.setBounds(10, 11, 468, 37);
		add(lblConditionPrice);
	}
	
	/**
	 * Sets the Price and Condition of cars to be read
	 */
	public void setPriceCondition() {
		if (!chckbxMinprice.isSelected()) Gui1.minPrice = 0;
		else Gui1.minPrice = Integer.parseInt(minPrice.getText());
		if (!chckbxMaxPrice.isSelected()) Gui1.maxPrice = Integer.MAX_VALUE;
		else Gui1.maxPrice = Integer.parseInt(maxPrice.getText());
		
		if (rdbtnNew.isSelected()) Gui1.files = 0;
		else if (rdbtnUsed.isSelected()) Gui1.files = 1;
		else Gui1.files = 2;
	}
	
}
