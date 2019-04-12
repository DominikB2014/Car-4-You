package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JProgressBar;

import group3.finalproj.car.CarType;

/**
 * GUI (JFrame) for the entire program
 * @author Dominik Buszowiecki
 *
 */
public class Gui1 {

	private JFrame frame;
	private int i = 0;
	
	protected static ArrayList<CarType> types = new ArrayList<CarType>();
	protected static int minPrice;
	protected static int maxPrice;
	protected static int files; //0 = new Cars, 1 = used Cars, 2 = all

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui1 window = new Gui1();
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
	public Gui1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Categories typesPanel = new Categories();
		Condition conditionPricePanel = new Condition();
		InitData initDataPanel = new InitData();
		Properties properties = new Properties();
		
		frame.getContentPane().add(typesPanel);
		frame.getContentPane().add(conditionPricePanel);
		frame.getContentPane().add(initDataPanel);
		frame.getContentPane().add(properties);
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(5);
		progressBar.setBounds(150, 298, 233, 23);
		frame.getContentPane().add(progressBar);
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(i){
					case 0:
						typesPanel.getTypes();
						if(types.isEmpty()) JOptionPane.showMessageDialog(null, "Please Select at Least 1 Car Type");
						else {
							i++;
							typesPanel.setVisible(false);
							conditionPricePanel.setVisible(true);
						}
						break;
					case 1:
						conditionPricePanel.setPriceCondition();
						conditionPricePanel.setVisible(false);
						initDataPanel.setVisible(true);
						i++;
						progressBar.setValue(i);
						if(initDataPanel.initData()) {
							initDataPanel.lblInitalizing.setVisible(false);
							initDataPanel.lblDone.setVisible(true);
							i++;
						}
						break;
					case 2:
						if(initDataPanel.initData()) i++;
						break;
					case 3:
						initDataPanel.setVisible(false);
						properties.setVisible(true);
				}
				progressBar.setValue(i);
			}
		});
		btnNext.setBounds(425, 298, 89, 23);
		frame.getContentPane().add(btnNext);	
	}
}
