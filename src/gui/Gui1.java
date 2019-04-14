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
import java.awt.Panel;

import javax.swing.JProgressBar;

import group3.finalproj.car.Car;
import group3.finalproj.car.CarType;
import group3.finalproj.car.Property;
import group3.finalproj.car.Tuple;
import group3.finalproj.io.ReadData;
import group3.finalproj.util.Graph;
import group3.finalproj.util.GraphGenerator;

/**
 * GUI (JFrame) for the entire program
 * @author Dominik Buszowiecki
 *
 */
public class Gui1 {

	private JFrame frame;
	private int i = 0;
	private Output[] carPanes = new Output[5];
	private Graph G;
	
	protected static ArrayList<CarType> types = new ArrayList<CarType>();
	protected static int minPrice;
	protected static int maxPrice;
	protected static int files; //0 = new Cars, 1 = used Cars, 2 = all
	protected static ArrayList<Tuple<Property, Integer>> properties = new ArrayList<Tuple<Property, Integer>>();
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
		
		JButton btnBack = new JButton("Back");
		JButton btnNext = new JButton("Next");
		
		btnBack.setVisible(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(i) {
				case 0:
					btnBack.setVisible(false);
					break;
				case 1:
					typesPanel.setVisible(true);
					conditionPricePanel.setVisible(false);
					i--;
					break;
				case 3:
					conditionPricePanel.setVisible(true);
					initDataPanel.setVisible(false);
					i=1;
					break;
				case 4:
					conditionPricePanel.setVisible(true);
					propertyPanel.setVisible(false);
					i=1;
					break;
				default:
					if (i <= 6) btnBack.setVisible(false);
					progressBar.setValue(i-5);
					carPanes[i-5].setVisible(false);
					carPanes[i-6].setVisible(true);
					i--;
					btnNext.setVisible(true);
				}
				progressBar.setValue(i);
			}
		});
		btnBack.setBounds(10, 298, 89, 23);
		frame.getContentPane().add(btnBack);
		
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
							btnBack.setVisible(true);
						}
						break;
					case 1:
						conditionPricePanel.setPriceCondition();
						conditionPricePanel.setVisible(false);
						initDataPanel.lblInitalizing.setVisible(true);
						initDataPanel.lblDone.setVisible(false);
						initDataPanel.setVisible(true);
						i++;
						progressBar.setValue(i);
						break;
					case 2:
						if(initDataPanel.initData()) i++;
						initDataPanel.lblInitalizing.setVisible(false);
						initDataPanel.lblDone.setVisible(true);
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
							JOptionPane.showMessageDialog(null, "Intializing Data: This may take some time");
							
							outputCars = GraphGenerator.findBestCars(properties, maxPrice, properties.size());
							
							i++;
							propertyPanel.setVisible(false);
							//Outputs Car JFrames
							for (int i = 0; i < outputCars.size(); i++) {
								carPanes[i] = new Output(outputCars.get(i).toString(), (String)outputCars.get(i).get(Property.Link));
								frame.getContentPane().add(carPanes[i]);
							}
							for(int i = 4; i > outputCars.size()-1; i--) {
								carPanes[i] = new Output("No Car Found", "");
							}
							btnBack.setVisible(false);
							carPanes[0].setVisible(true);
						}
						break;
					default:
						carPanes[i-5].setVisible(false);
						carPanes[i-4].setVisible(true);
						i++;
						if (i == 9) btnNext.setVisible(false);
						btnBack.setVisible(true);
						break;
						
				}
				progressBar.setValue(i);
			}
		});
		btnNext.setBounds(425, 298, 89, 23);
		frame.getContentPane().add(btnNext);	
		
	}
	
}
