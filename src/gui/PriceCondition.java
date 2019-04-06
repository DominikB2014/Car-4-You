package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import group3.finalproj.car.CarType;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.util.ArrayList;

public class PriceCondition extends JFrame {

	private JPanel contentPane;
	private JTextField txtPriceCondition;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public PriceCondition(ArrayList<CarType> types) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(281, 117, 102, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(281, 70, 102, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtPriceCondition = new JTextField();
		txtPriceCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceCondition.setText("Select the Price and Condition");
		txtPriceCondition.setFont(new Font("Arial", Font.BOLD, 18));
		txtPriceCondition.setBounds(0, 0, 434, 39);
		getContentPane().add(txtPriceCondition);
		txtPriceCondition.setColumns(10);
		
		JCheckBox rdbtnNew = new JCheckBox("New");
		rdbtnNew.setBounds(43, 69, 109, 23);
		
		JCheckBox rdbtnUsed = new JCheckBox("Used");
		rdbtnUsed.setBounds(43, 116, 109, 23);
		
		JCheckBox rdbtnIDontKnow = new JCheckBox("I Don't Know");
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
		contentPane.add(rdbtnUsed);
		contentPane.add(rdbtnIDontKnow);
		contentPane.add(rdbtnNew);
		
		JCheckBox chckbxMinprice = new JCheckBox("Min Price:   $");
		chckbxMinprice.setBounds(196, 69, 97, 23);
		contentPane.add(chckbxMinprice);
		
		JCheckBox chckbxMaxPrice = new JCheckBox("Max Price: $");
		chckbxMaxPrice.setBounds(196, 116, 97, 23);
		contentPane.add(chckbxMaxPrice);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(335, 227, 89, 23);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(btnNext);
	}
}
