package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PriceCondition extends JFrame {

	private JPanel contentPane;
	private JTextField txtPriceCondition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PriceCondition frame = new PriceCondition();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PriceCondition() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPriceCondition = new JTextField();
		txtPriceCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceCondition.setText("Select the Price and Condition");
		txtPriceCondition.setFont(new Font("Arial", Font.BOLD, 18));
		txtPriceCondition.setBounds(0, 0, 434, 39);
		getContentPane().add(txtPriceCondition);
		txtPriceCondition.setColumns(10);
		
		JRadioButton rdbtnNew = new JRadioButton("New");
		rdbtnNew.setBounds(22, 69, 109, 23);
		
		JRadioButton rdbtnUsed = new JRadioButton("Used");
		rdbtnUsed.setBounds(22, 113, 109, 23);
		
		JRadioButton rdbtnIDontKnow = new JRadioButton("I Don't Know");
		rdbtnIDontKnow.setSelected(true);
		rdbtnIDontKnow.setBounds(22, 164, 109, 23);	
		
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
	}

}
