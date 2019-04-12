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

import group3.finalproj.car.Car;
import group3.finalproj.car.CarType;
import group3.finalproj.car.Property;
import group3.finalproj.car.Tuple;
import group3.finalproj.io.ReadData;

/**
 * GUI (JFrame) for the entire program
 * @author Dominik Buszowiecki
 *
 */
public class Gui1 {

	private JFrame frame;
	private int i = 0;
	private Output[] carPanes = new Output[5];
	
	protected static ArrayList<CarType> types = new ArrayList<CarType>();
	protected static int minPrice;
	protected static int maxPrice;
	protected static int files; //0 = new Cars, 1 = used Cars, 2 = all
	protected static ArrayList<Tuple> properties = new ArrayList<Tuple>();
	protected static ArrayList<Car> outputCars = new ArrayList<Car>();

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
		Properties propertyPanel = new Properties();
		
		frame.getContentPane().add(typesPanel);
		frame.getContentPane().add(conditionPricePanel);
		frame.getContentPane().add(initDataPanel);
		frame.getContentPane().add(propertyPanel);
		
		
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
						propertyPanel.setVisible(true);
						i++;
						break;
					case 4:
						propertyPanel.getProperties();
						if(properties.isEmpty()) {JOptionPane.showMessageDialog(null, "Please Select 1 Property Property");}
						else {
							i++;
							propertyPanel.setVisible(false);
							//Outputs Car JFrames
							for (int i = 0; i < 5; i ++) {
								carPanes[i] = new Output(outputCars.get(i).toString(), (String)outputCars.get(i).get(Property.Link));
								frame.getContentPane().add(carPanes[i]);
							}
						}
						break;
					case 5:
						
				}
				progressBar.setValue(i);
			}
		});
		btnNext.setBounds(425, 298, 89, 23);
		frame.getContentPane().add(btnNext);	
	}
	
	private void testOutputGUI() {
		ReadData.cars.
	}
}
