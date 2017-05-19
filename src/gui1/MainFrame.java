package gui1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.ImageIcon;
import java.awt.Color;

public class MainFrame extends JFrame implements Runnable{

	public  JPanel contentPane,schedulePanel, tempPanel, waterPanel, activePanel;
	static MainFrame frame;
	JButton btnDisable, btnEnable;
	JPanel mainPanel ;
	static Logger log;
	JLabel labelON[],labelOFF[];
	boolean isEnable=true;
	boolean[] checkBoxResult;
	JCheckBox checkBoxArray[];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setTitle("HummingBee Garden Sprinkler System");
					
					Thread t1 = new Thread(frame);
					t1.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				log = Logger.getLogger("SprinklerLog");  
			    FileHandler fh;  

			    try {  

			        // This block configure the logger with handler and formatter  
			        fh = new FileHandler("/Users/sindukandula/Documents/workspace/eclipsedirectory/OoadProject/src/gui1/SprinklerLog");  
			        log.addHandler(fh);
			        SimpleFormatter formatter = new SimpleFormatter();  
			        fh.setFormatter(formatter);  

			        // the following statement is used to log any messages  
			      

			    } catch (SecurityException e) {  
			        e.printStackTrace();  
			    } catch (IOException e) {  
			        e.printStackTrace();  
			    } 
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void setPanel(JPanel panel)
	{
		
		setContentPane(panel);
		
	}
	
	public MainFrame() throws MalformedURLException{
		URL url1,url2,url3;
		checkBoxResult = new boolean[]{false,false,false,false,false,false,false,false,false,false,false,false};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		createSchedulePanel();
		createTempPanel();
		createActivePanel();
		
		 mainPanel = new JPanel();
		 mainPanel.setBackground(Color.WHITE);
		 mainPanel.setForeground(Color.WHITE);
		 mainPanel.setBorder(new TitledBorder(null, "Garden Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		 mainPanel.setBounds(6, 6, 640, 380);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		
		//icon code
		url1 = new File("/Users/sindukandula/Desktop/sprinklerFinalGIF.gif").toURI().toURL();
        url2 = new File("/Users/sindukandula/Desktop/sprinklerOFF.jpg").toURI().toURL();
        url3 = new File("/Users/sindukandula/Desktop/grass.png").toURI().toURL();
        Icon iconON = new ImageIcon(url1);
        Icon iconOFF = new ImageIcon(url2);
        Icon grassIcon = new ImageIcon(url3);
		
		
		
		JLabel n1on = new JLabel("");
		n1on.setIcon(iconON);
		n1on.setBounds(213, 16, 50, 50);
		mainPanel.add(n1on);
		
		JLabel n1off = new JLabel("");
		n1off.setIcon(iconOFF);
		n1off.setBounds(234, 48, 10, 10);
		mainPanel.add(n1off);
		
		JLabel n2on = new JLabel("");
		n2on.setIcon(iconON);
		n2on.setBounds(290, 64, 50, 50);
		mainPanel.add(n2on);
		
		JLabel n2off = new JLabel("");
		n2off.setIcon(iconOFF);
		n2off.setBounds(310, 93, 10, 10);
		mainPanel.add(n2off);
		
		JLabel n3on = new JLabel("");
		n3on.setIcon(iconON);
		n3on.setBounds(363, 16, 50, 50);
		mainPanel.add(n3on);
		
		JLabel n3off = new JLabel("");
		n3off.setIcon(iconOFF);
		n3off.setBounds(384, 48, 10, 10);
		mainPanel.add(n3off);
		
		JLabel w1on = new JLabel("");
		w1on.setIcon(iconON);
		w1on.setBounds(6, 104, 50, 50);
		mainPanel.add(w1on);
		
		JLabel w1off = new JLabel("");
		w1off.setIcon(iconOFF);
		w1off.setBounds(27, 134, 10, 10);
		mainPanel.add(w1off);
		
		JLabel w2on = new JLabel("");
		w2on.setIcon(iconON);
		w2on.setBounds(79, 158, 50, 50);
		mainPanel.add(w2on);
		
		JLabel w2off = new JLabel("");
		w2off.setIcon(iconOFF);
		w2off.setBounds(100, 189, 10, 10);
		mainPanel.add(w2off);
		
		JLabel w3on = new JLabel("");
		w3on.setIcon(iconON);
		w3on.setBounds(6, 220, 50, 50);
		mainPanel.add(w3on);
		
		JLabel w3off = new JLabel("");
		w3off.setIcon(iconOFF);
		w3off.setBounds(27, 249, 10, 10);
		mainPanel.add(w3off);
		
		JLabel s1on = new JLabel("");
		s1on.setIcon(iconON);
		s1on.setBounds(213, 321, 50, 50);
		mainPanel.add(s1on);
		
		JLabel s1off = new JLabel("");
		s1off.setIcon(iconOFF);
		s1off.setBounds(234, 350, 10, 10);
		mainPanel.add(s1off);
		
		JLabel s2on = new JLabel("");
		s2on.setIcon(iconON);
		s2on.setBounds(290, 280, 50, 50);
		mainPanel.add(s2on);
		
		JLabel s2off = new JLabel("");
		s2off.setIcon(iconOFF);
		s2off.setBounds(310, 311, 10, 10);
		mainPanel.add(s2off);
		
		JLabel s3on = new JLabel("");
		s3on.setIcon(iconON);
		s3on.setBounds(363, 321, 50, 50);
		mainPanel.add(s3on);
		
		JLabel s3off = new JLabel("");
		s3off.setIcon(iconOFF);
		s3off.setBounds(384, 350, 10, 10);
		mainPanel.add(s3off);
		
		JLabel e1on = new JLabel("");
		e1on.setIcon(iconON);
		e1on.setBounds(573, 104, 50, 50);
		mainPanel.add(e1on);
		
		JLabel e1off = new JLabel("");
		e1off.setIcon(iconOFF);
		e1off.setBounds(594, 134, 10, 10);
		mainPanel.add(e1off);
		
		JLabel e2on = new JLabel("");
		e2on.setIcon(iconON);
		e2on.setBounds(500, 159, 50, 50);
		mainPanel.add(e2on);
		
		JLabel e2off = new JLabel("");
		e2off.setIcon(iconOFF);
		e2off.setBounds(521, 189, 10, 10);
		mainPanel.add(e2off);
		
		JLabel e3on = new JLabel("");
		e3on.setIcon(iconON);
		e3on.setBounds(573, 220, 50, 50);
		mainPanel.add(e3on);
		
		JLabel e3off = new JLabel("");
		e3off.setIcon(iconOFF);
		e3off.setBounds(594, 249, 10, 10);
		mainPanel.add(e3off);
		
		JLabel lblNorth = new JLabel("NORTH");
		lblNorth.setBounds(290, 16, 50, 16);
		mainPanel.add(lblNorth);
		
		JLabel lblWest = new JLabel("WEST");
		lblWest.setBounds(6, 183, 38, 16);
		mainPanel.add(lblWest);
		
		JLabel lblSouth = new JLabel("SOUTH");
		lblSouth.setBounds(290, 355, 50, 16);
		mainPanel.add(lblSouth);
		
		JLabel lblEast = new JLabel("EAST");
		lblEast.setBounds(596, 189, 38, 16);
		mainPanel.add(lblEast);
		
		JLabel label = new JLabel("1");
		label.setBounds(234, 75, 10, 16);
		mainPanel.add(label);
		
		JLabel label_1 = new JLabel("2");
		label_1.setBounds(310, 128, 10, 16);
		mainPanel.add(label_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setBounds(384, 78, 10, 16);
		mainPanel.add(label_2);
		
		JLabel label_3 = new JLabel("1");
		label_3.setBounds(68, 134, 10, 16);
		mainPanel.add(label_3);
		
		JLabel label_4 = new JLabel("2");
		label_4.setBounds(141, 189, 10, 16);
		mainPanel.add(label_4);
		
		JLabel label_5 = new JLabel("3");
		label_5.setBounds(68, 249, 10, 16);
		mainPanel.add(label_5);
		
		JLabel label_6 = new JLabel("1");
		label_6.setBounds(191, 355, 10, 16);
		mainPanel.add(label_6);
		
		JLabel label_7 = new JLabel("2");
		label_7.setBounds(310, 333, 10, 16);
		mainPanel.add(label_7);
		
		JLabel label_8 = new JLabel("3");
		label_8.setBounds(425, 355, 10, 16);
		mainPanel.add(label_8);
		
		JLabel label_9 = new JLabel("1");
		label_9.setBounds(540, 128, 10, 16);
		mainPanel.add(label_9);
		
		JLabel label_10 = new JLabel("2");
		label_10.setBounds(474, 189, 10, 16);
		mainPanel.add(label_10);
		
		JLabel label_11 = new JLabel("3");
		label_11.setBounds(540, 243, 10, 16);
		mainPanel.add(label_11);
		
		JLabel fountainlbl = new JLabel("");
		fountainlbl.setIcon(new ImageIcon("/Users/sindukandula/Desktop/fountain.png"));
		fountainlbl.setBounds(280, 192, 60, 50);
		mainPanel.add(fountainlbl);
		
		JLabel grass2 = new JLabel("");
		grass2.setBounds(79, 189, 52, 52);
		grass2.setIcon(grassIcon);
		mainPanel.add(grass2);
		
		JLabel grass3 = new JLabel("New label");
		grass3.setBounds(4, 249, 52, 52);
		grass3.setIcon(grassIcon);
		mainPanel.add(grass3);
		
		JLabel grass1 = new JLabel("New label");
		grass1.setBounds(147, 110, 52, 52);
		grass1.setIcon(grassIcon);
		mainPanel.add(grass1);
		
		JLabel grass13 = new JLabel("New label");
		grass13.setBounds(244, 62, 52, 52);
		grass13.setIcon(grassIcon);
		mainPanel.add(grass13);
		
		JLabel grass12 = new JLabel("New label");
		grass12.setBounds(352, 104, 52, 52);
		grass12.setIcon(grassIcon);
		mainPanel.add(grass12);
		
		JLabel grass11 = new JLabel("New label");
		grass11.setBounds(450, 87, 52, 52);
		grass11.setIcon(grassIcon);
		mainPanel.add(grass11);
		
		JLabel grass8 = new JLabel("New label");
		grass8.setBounds(338, 231, 52, 52);
		grass8.setIcon(grassIcon);
		mainPanel.add(grass8);
		
		JLabel grass10 = new JLabel("New label");
		grass10.setBounds(211, 125, 52, 52);
		grass10.setIcon(grassIcon);
		mainPanel.add(grass10);
		
		JLabel grass7 = new JLabel("New label");
		grass7.setBounds(479, 207, 52, 52);
		grass7.setIcon(grassIcon);
		mainPanel.add(grass7);
		
		JLabel grass9 = new JLabel("New label");
		grass9.setBounds(552, 249, 52, 52);
		grass9.setIcon(grassIcon);
		mainPanel.add(grass9);
		
		JLabel grass6 = new JLabel("New label");
		grass6.setBounds(425, 311, 52, 52);
		grass6.setIcon(grassIcon);
		mainPanel.add(grass6);
		
		JLabel grass5 = new JLabel("New label");
		grass5.setBounds(211, 231, 52, 52);
		grass5.setIcon(grassIcon);
		mainPanel.add(grass5);
		
		JLabel grass4 = new JLabel("New label");
		grass4.setBounds(118, 333, 52, 52);
		grass4.setIcon(grassIcon);
		mainPanel.add(grass4);
		
		JLabel grass24 = new JLabel("New label");
		grass24.setBounds(99, 249, 52, 52);
		grass24.setIcon(grassIcon);
		mainPanel.add(grass24);
		
		JLabel grass33 = new JLabel("New label");
		grass33.setBounds(58, 51, 52, 52);
		grass33.setIcon(grassIcon);
		mainPanel.add(grass33);
		
		JLabel grass29 = new JLabel("New label");
		grass29.setBounds(383, 183, 52, 52);
		grass29.setIcon(grassIcon);
		mainPanel.add(grass29);
		
		JLabel grass27 = new JLabel("New label");
		grass27.setBounds(474, 280, 52, 52);
		grass27.setIcon(grassIcon);
		mainPanel.add(grass27);
		
		JLabel grass25 = new JLabel("New label");
		grass25.setBounds(27, 319, 52, 52);
		grass25.setIcon(grassIcon);
		mainPanel.add(grass25);
		
		JLabel grass30 = new JLabel("New label");
		grass30.setBounds(521, 39, 52, 52);
		grass30.setIcon(grassIcon);
		mainPanel.add(grass30);
		
		JLabel grass31 = new JLabel("New label");
		grass31.setBounds(432, 39, 52, 52);
		grass31.setIcon(grassIcon);
		mainPanel.add(grass31);
		
		JLabel grass32 = new JLabel("New label");
		grass32.setBounds(149, 51, 52, 52);
		grass32.setIcon(grassIcon);
		mainPanel.add(grass32);
		
		JLabel grass20 = new JLabel("New label");
		grass20.setBounds(4, 16, 52, 52);
		grass20.setIcon(grassIcon);
		mainPanel.add(grass20);
		
		JLabel grass26 = new JLabel("New label");
		grass26.setBounds(136, 278, 52, 52);
		grass26.setIcon(grassIcon);
		mainPanel.add(grass26);
		
		JLabel grass28 = new JLabel("New label");
		grass28.setBounds(415, 231, 52, 52);
		grass28.setIcon(grassIcon);
		mainPanel.add(grass28);
		
		JLabel grass23 = new JLabel("New label");
		grass23.setBounds(173, 190, 52, 52);
		grass23.setIcon(grassIcon);
		mainPanel.add(grass23);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(6, 396, 640, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelON = new JLabel[]{n1on,n2on,n3on,e1on,e2on,e3on,w1on,w2on,w3on,s1on,s2on,s3on};
		labelOFF = new JLabel[]{n1off,n2off,n3off,e1off,e2off,e3off,w1off,w2off,w3off,s1off,s2off,s3off};
		
		for(int i=0;i<12;i++)
		{
			labelON[i].setVisible(false);
			labelOFF[i].setVisible(true);
		}
		
		JButton btnGoToSecod = new JButton("Schedule");
		btnGoToSecod.setBounds(6, 6, 111, 76);
		panel.add(btnGoToSecod);
		btnGoToSecod.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
			
				setContentPane(schedulePanel);
				schedulePanel.revalidate();
				
			}
		});
		
		JButton btnTempController = new JButton("Temperature Controller");
		btnTempController.setBounds(118, 6, 190, 76);
		panel.add(btnTempController);
		btnTempController.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setContentPane(tempPanel);
				tempPanel.revalidate();
				
				
			}
		});
		
		
		JButton btnNeButton = new JButton("Water Consumption");
		btnNeButton.setBounds(458, 6, 176, 76);
		panel.add(btnNeButton);
		btnNeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame graphFrame = new JFrame("Frame");
				graphFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				graphFrame.setSize(600, 600);
				graphFrame.setResizable(false);
				graphFrame.setVisible(true);
				
				waterPanel = new JPanel();
				waterPanel.setBackground(Color.ORANGE);
				waterPanel.setForeground(Color.BLACK);
				waterPanel.setLayout(null);
				graphFrame.setContentPane(waterPanel);
				
				int s = water[0] ;
				int m = water[1] ;
				int t = water[2] ;
				int w = water[3] ;
				int th = water[4] ;
				int f = water[5] ;
				int sa = water[6] ;
				
				 
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.setValue(s, "", "SUNDAY");
                dataset.setValue(m, "", "MONDAY");
                dataset.setValue(t, "", "TEUSDAY");
                dataset.setValue(w, "", "WEDNESDAY");
                dataset.setValue(th, "", "THURSDAY");
                dataset.setValue(f, "", "FRIDAY");
                dataset.setValue(sa, "", "SATURDAY");
                
                
                JFreeChart chart = ChartFactory.createBarChart("WATER CONSUMPTION", "DAYS", "WATER CONSUMPTION-gallons/sec", dataset);
                CategoryPlot catPlot = chart.getCategoryPlot();
                catPlot.setRangeGridlinePaint(Color.WHITE);
                
                ChartPanel chartPanel = new ChartPanel(chart);
                waterPanel.removeAll();
                getContentPane().add(chartPanel,BorderLayout.CENTER);

                graphFrame.setContentPane(chartPanel);
				chartPanel.revalidate();
				
			
			}
		});
		
		JButton btn = new JButton("Activate/Deactivate");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setContentPane(activePanel);
				activePanel.revalidate();
				
				
			}
		});
		btn.setBounds(310, 6, 144, 76);
		panel.add(btn);
		
		btnDisable = new JButton("Disable");
		btnDisable.setBounds(176, 94, 117, 47);
		panel.add(btnDisable);
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				isEnable=false;
				btnDisable.setEnabled(false);
				btnGoToSecod.setEnabled(false);
				btnTempController.setEnabled(false);
				btn.setEnabled(false);
				btnNeButton.setEnabled(false);
				btnEnable.setEnabled(true);
			}
		});
		
		btnEnable = new JButton("Enable");
		btnEnable.setBounds(338, 94, 117, 47);
		panel.add(btnEnable);
		btnEnable.setEnabled(false);
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				isEnable=true;
				btnEnable.setEnabled(false);
				btnDisable.setEnabled(true);
				btnGoToSecod.setEnabled(true);
				btnTempController.setEnabled(true);
				btn.setEnabled(true);
				btnNeButton.setEnabled(true);
			}
		});

		
		
	}
	
	
	
	//----------------------CODE FOR THE SCHEDULING PANEL STARTS HERE------------------//
	private JComboBox groupIdBox;
	private JComboBox sprinklerIdBox;
	private JComboBox weekDayBox;
	private JComboBox startHourBox;
	private JComboBox startMinBox;
	private JComboBox stopHourBox;
	private JComboBox stopMinBox;
	private int g=0;
	private int weekIndex=0;
	private int spArrayIndex=0;
	public JPanel controllerPanel;
	public Container container;
	int b=0;
	int a=0;
	Sprinkler[] sprinkler = new Sprinkler[12];
	int water[]= new int[7];
	
	boolean tempSprinkler = false;

	
	public void createSchedulePanel()
	{
		schedulePanel= new JPanel();
		schedulePanel.setBackground(new Color(0, 191, 255));
		schedulePanel.setLayout(null);
		
		groupIdBox = new JComboBox();
		groupIdBox.setModel(new DefaultComboBoxModel(new String[] {"N", "E", "W", "S"}));
		groupIdBox.setBounds(301, 17, 67, 27);
		groupIdBox.setToolTipText("Enter Group Sprinkler ID:");
		schedulePanel.add(groupIdBox);
		
		sprinklerIdBox = new JComboBox();
		sprinklerIdBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		sprinklerIdBox.setBounds(301, 45, 71, 27);
		sprinklerIdBox.setToolTipText("Enter Sprinkler ID:");
		schedulePanel.add(sprinklerIdBox);
		
		weekDayBox = new JComboBox();
		weekDayBox.setModel(new DefaultComboBoxModel(new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}));
		weekDayBox.setToolTipText("Enter Day of the week:");
		weekDayBox.setBounds(301, 73, 83, 27);
		schedulePanel.add(weekDayBox);
		
		startHourBox = new JComboBox();
		startHourBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		startHourBox.setToolTipText("Enter the start time:");
		startHourBox.setBounds(301, 101, 71, 27);
		schedulePanel.add(startHourBox);
		
		startMinBox = new JComboBox();
		startMinBox.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "56", "57", "58", "59"}));
		startMinBox.setToolTipText("Enter the stop time:");
		startMinBox.setBounds(301, 129, 71, 27);
		schedulePanel.add(startMinBox);
		
		stopHourBox = new JComboBox();
		stopHourBox.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		stopHourBox.setBounds(301, 157, 71, 27);
		schedulePanel.add(stopHourBox);
		
		stopMinBox = new JComboBox();
		stopMinBox.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		stopMinBox.setBounds(301, 185, 71, 27);
		schedulePanel.add(stopMinBox);
		
		JLabel groupIdLabel = new JLabel("Enter the Group ID:");
		groupIdLabel.setBounds(93, 21, 128, 16);
		schedulePanel.add(groupIdLabel);
		
		JLabel sprinklerIdLabel = new JLabel("Enter the Sprinkler ID:");
		sprinklerIdLabel.setBounds(93, 49, 145, 16);
		schedulePanel.add(sprinklerIdLabel);
		
		JLabel weekDayLabel = new JLabel("Enter the WeekDay:");
		weekDayLabel.setBounds(93, 77, 149, 16);
		schedulePanel.add(weekDayLabel);
		
		JLabel startHourLabel = new JLabel("Enter the Start time(hours):");
		startHourLabel.setBounds(93, 105, 179, 16);
		schedulePanel.add(startHourLabel);
		
		JLabel startMinLabel = new JLabel("Enter the Start Time(Min):");
		startMinLabel.setBounds(93, 133, 166, 16);
		schedulePanel.add(startMinLabel);
		
		JLabel stopHourLabel = new JLabel("Enter the Stop Time(Hours):");
		stopHourLabel.setBounds(93, 161, 175, 16);
		schedulePanel.add(stopHourLabel);
		
		JLabel stopMinLabel = new JLabel("Enter the Stop Time(Min):");
		stopMinLabel.setBounds(93, 189, 179, 16);
		schedulePanel.add(stopMinLabel);
		
		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(new Font("Menlo", Font.PLAIN, 25));
		saveButton.setForeground(new Color(0, 191, 255));
		saveButton.setBackground(new Color(127, 255, 212));
		saveButton.setBounds(178, 270, 166, 50);
		schedulePanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setSprinklerTimeData();
		
					repaint();
					revalidate();
				
				
			}
			
		});
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(new Color(0, 191, 255));
		btnBack.setFont(new Font("Menlo", Font.PLAIN, 25));
		btnBack.setBackground(new Color(127, 255, 212));
		btnBack.setBounds(178, 334, 166, 50);
		schedulePanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				contentPane.remove(schedulePanel);
				contentPane.add(mainPanel, BorderLayout.CENTER);
				setContentPane(contentPane);
				
				
			}
			
		});
	}
	
	public void setSprinklerTimeData()
	{
		String direction = groupIdBox.getSelectedItem().toString();
		a = getGroup(direction);
		b = Integer.parseInt(sprinklerIdBox.getSelectedItem().toString());
		
		spArrayIndex = getSprinklerIndex(a*10+b);
		weekIndex = getWeekIndex();
		
		System.out.println(weekIndex);

		sprinkler[spArrayIndex].setStart_time_hours(weekIndex,Integer.parseInt(startHourBox.getSelectedItem().toString()));
		sprinkler[spArrayIndex].setStart_time_min(weekIndex, Integer.parseInt(startMinBox.getSelectedItem().toString()));
			
		//SETS STOP TIME
		sprinkler[spArrayIndex].setStop_time_hours(weekIndex,Integer.parseInt(stopHourBox.getSelectedItem().toString()));
		sprinkler[spArrayIndex].setStop_time_min(weekIndex,Integer.parseInt(stopMinBox.getSelectedItem().toString()));
	}
	
	
	public int getGroup(String direction)
	{
		
		switch(direction){
		case "N": return 1;
		case "E": return 2;
		case "W": return 3;
		case "S": return 4;
		default: return 0;
		}
	}
	
	
	public int getSprinklerIndex(int n)
	{
		switch(n){
		
		case 11: 
			return 0; 
		case 12: 
			return 1;
		case 13: 
			return 2; 
		case 21: 
			return 3;
		case 22: 
			return 4;
		case 23: 
			return 5; 
		case 31:
			return 6;
		case 32:
			return 7; 
		case 33:
			return 8;
		case 41:
			return 9; 
		case 42: 
			return 10; 
		case 43: 
			return 11;
		default: 
			return 12;
		}
			
	}
	
	public int getWeekIndex()
	{
		switch(weekDayBox.getSelectedItem().toString())
			{
				case "Sun":
					return 0;		
				case "Mon":
					return 1;
				case "Tue":
					return 2;
				case "Wed":
					return 3;
				case "Thu":
					return 4;
				case "Fri":
					return 5;
				case "Sat":
					return 6;
				default:
					return 10;
						
			}
	}

	public int getWaterUsage(int startHR, int stopHR, int startMIN, int stopMIN)
	{	
		int minuteDIFF=0;
		if(startHR==stopHR){
			
			minuteDIFF= stopMIN-startMIN;
		}
		else{
			minuteDIFF = stopMIN + (60-startMIN);
		}
		
		return (((stopHR-startHR)+minuteDIFF)*2);	
	}
	
	@Override
	public void run() {
		
		
		for(int i=0; i<12; i++)
		{
			sprinkler[i] = new Sprinkler();
		}
		
		GregorianCalendar gCalendar = new GregorianCalendar();
		System.out.println("Thread started");
		int day = gCalendar.get(Calendar.DAY_OF_WEEK) -1;
		//System.out.println("DAY of week is "+ day);
	
			while(true)
			{
				if(isEnable)
					
				{
				
				gCalendar = new GregorianCalendar();
				 day = gCalendar.get(Calendar.DAY_OF_WEEK) -1;
				 
				 for(int k=0; k<=11; k++)
				 {
					 if(sprinkler[k].statusOn)
						 water[day]=water[day]+2;
					 
			      }
				 
				 //CODE FOR MINIMUM TEMPERATURE FUNCTIONING
				 if( Integer.parseInt(currentTempText.getText()) < Integer.parseInt(minTempText.getText()) ) 
				 {
					 tempSprinkler = true;
					 for(int j=0; j<12 ; j++)
					 {
						 if(sprinkler[j].statusOn)
						 {
							 sprinkler[j].setStatusOn(false);
							 labelOFF[j].setVisible(true);
							 labelON[j].setVisible(false);
							 System.out.println("Sprinkler "+j+"is turned off.");
							  log.info("Sprinkler "+j+"is turned off.");  
						 }
						 
					 }
					 
				 }
				 
				 //CODE FOR MAXIMUM TEMPERATURE FUNCTIONING
				 else if(Integer.parseInt(currentTempText.getText()) > Integer.parseInt(maxTempText.getText()))
				 {
					 tempSprinkler = true;
					 for(int j=0; j<12 ; j++)
					 {
						 if(!sprinkler[j].statusOn)
						 {
							 sprinkler[j].setStatusOn(true);
							 labelOFF[j].setVisible(false);
							 labelON[j].setVisible(true);
							 System.out.println("Sprinkler "+(j+1)+"is turned on.");
							 log.info("Sprinkler "+(j+1)+"is turned on.");  
						 }
						 
					 }
					 
				 }
				 
				 //	 //CODE TO SEE IF CURRENT TEMPERATURE IS IDEAL
				 else
				 {
					 	//SECTION TO STOP ALL SPRINKLERS FIRST
					 	if(tempSprinkler)
					 	{
					 		tempSprinkler = false;
					 		for(int j=0; j<12 ; j++)
							 {
								 if(sprinkler[j].statusOn)
								 {
									 sprinkler[j].setStatusOn(false);
									 labelOFF[j].setVisible(true);
									 labelON[j].setVisible(false);
									 System.out.println("Sprinkler "+(j+1)+"is turned off.");
									 log.info("Sprinkler "+(j+1)+"is turned off.");  
								 }
								 
							 }
					 	}
					 	
					 		//CHECKS AND STARTS SCHEDULED SPRINKLERS - BY "START" TIME
						 for(int i =0; i<=11; i++)
						 {
							if(!sprinkler[i].checkStatus())
							{
								
								if((sprinkler[i].getStart_time_hours(day) == gCalendar.get(Calendar.HOUR_OF_DAY)) && (sprinkler[i].getStart_time_min(day) == gCalendar.get(Calendar.MINUTE)) )
								{
									System.out.println("\nSprinkler "+(i+1)+ " is turned on");
									sprinkler[i].setStatusOn(true);
									 labelOFF[i].setVisible(false);
									 labelON[i].setVisible(true);
									log.info("Sprinkler "+(i+1)+"is turned on.");
								}
								
							}
							
							//CHECKS AND STOPS SCHEDULED SPRINKLERS - BY "STOP" TIME
							else if(sprinkler[i].checkStatus())
							{
								if(!checkBoxResult[i]){
									
								if((sprinkler[i].getStop_time_hours(day) == gCalendar.get(Calendar.HOUR_OF_DAY)) && (sprinkler[i].getStop_time_min(day) == gCalendar.get(Calendar.MINUTE)) )
								{
									//STOP SPRINKLER HERE
									System.out.println("\nSprinkler "+(i+1)+ " is turned off");
									sprinkler[i].setStatusOn(false);
									 labelOFF[i].setVisible(true);
									 labelON[i].setVisible(false);
									log.info("Sprinkler "+(i+1)+"is turned off.");
									

									}
								}
									
							}
						 }
				 	}	
					try {
						System.out.print("time is "+gCalendar.get(Calendar.HOUR_OF_DAY)+":"+gCalendar.get(Calendar.MINUTE)); //+ " required is : "+sprinkler[i].getStart_time_hours(day) +":"+sprinkler[i].getStart_time_min(day));
						
						Thread.sleep(10000);
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
			}
				else
				{
					for(int i=0;i<=11;i++)
					{
						sprinkler[i].setStatusOn(false);
						labelON[i].setVisible(false);
						labelOFF[i].setVisible(true);
					}
					
					
				}
		}
			
			
	}	

	
	private JTextField maxTempText;
	private JTextField minTempText;
	private JTextField currentTempText;
	
	public void createTempPanel()
	{
		
		tempPanel = new JPanel();
		
		tempPanel.setLayout(null);
		
		maxTempText = new JTextField();
		maxTempText.setText("85");
		maxTempText.setBounds(276, 42, 130, 26);
		tempPanel.add(maxTempText);
		maxTempText.setColumns(10);
		
		minTempText = new JTextField();
		minTempText.setText("60");
		minTempText.setBounds(276, 122, 130, 26);
		tempPanel.add(minTempText);
		minTempText.setColumns(10);
		
		currentTempText = new JTextField();
		currentTempText.setText("73");
		currentTempText.setBounds(276, 211, 130, 26);
		tempPanel.add(currentTempText);
		currentTempText.setColumns(10);
		
		JLabel maxTemp = new JLabel("Enter the Maximum Temperature:");
		maxTemp.setBounds(23, 47, 220, 16);
		tempPanel.add(maxTemp);
		
		JLabel minTemp = new JLabel("Enter the Minimum Temperature:");
		minTemp.setBounds(23, 127, 220, 16);
		tempPanel.add(minTemp);
		
		JLabel currentTemp = new JLabel("Enter the Current Temperature:");
		currentTemp.setBounds(23, 216, 220, 16);
		tempPanel.add(currentTemp);
		
		JButton btnSaveTemp = new JButton("SAVE TEMPERATURE");
		btnSaveTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				contentPane.remove(tempPanel);
				contentPane.add(mainPanel, BorderLayout.CENTER);
				setContentPane(contentPane);
				
				
				
			}
		});
		btnSaveTemp.setBounds(140, 252, 173, 29);
		tempPanel.add(btnSaveTemp);
		
		
		
		
		
		
	}
	
	
	
	
	
	
	public void createActivePanel()
	{
		
		activePanel = new JPanel();
		activePanel.setLayout(null);
		
		JCheckBox n1checkbox = new JCheckBox("N1");
		n1checkbox.setBounds(40, 24, 50, 23);
		activePanel.add(n1checkbox);
		
		JCheckBox n2checkbox = new JCheckBox("N2");
		n2checkbox.setBounds(40, 65, 50, 23);
		activePanel.add(n2checkbox);
		
		JCheckBox n3checkbox = new JCheckBox("N3");
		n3checkbox.setBounds(40, 103, 50, 23);
		activePanel.add(n3checkbox);
		
		JCheckBox e1checkbox = new JCheckBox("E1");
		e1checkbox.setBounds(362, 24, 50, 23);
		activePanel.add(e1checkbox);
		
		JCheckBox e2checkbox = new JCheckBox("E2");
		e2checkbox.setBounds(362, 65, 50, 23);
		activePanel.add(e2checkbox);
		
		JCheckBox e3checkbox = new JCheckBox("E3");
		e3checkbox.setBounds(362, 103, 50, 23);
		activePanel.add(e3checkbox);
		
		JCheckBox w1checkbox = new JCheckBox("W1");
		w1checkbox.setBounds(40, 215, 56, 23);
		activePanel.add(w1checkbox);
		
		JCheckBox w2checkbox = new JCheckBox("W2");
		w2checkbox.setBounds(40, 250, 56, 23);
		activePanel.add(w2checkbox);
		
		JCheckBox w3checkbox = new JCheckBox("W3");
		w3checkbox.setBounds(40, 285, 56, 23);
		activePanel.add(w3checkbox);
		
		JCheckBox s1checkbox = new JCheckBox("S1");
		s1checkbox.setBounds(362, 215, 50, 23);
		activePanel.add(s1checkbox);
		
		JCheckBox s2checkbox = new JCheckBox("S2");
		s2checkbox.setBounds(362, 250, 50, 23);
		activePanel.add(s2checkbox);
		
		JCheckBox s3checkbox = new JCheckBox("S3");
		s3checkbox.setBounds(362, 285, 50, 23);
		activePanel.add(s3checkbox);
		
		checkBoxArray = new JCheckBox[]{n1checkbox,n2checkbox,n3checkbox,e1checkbox,e2checkbox,e3checkbox,w1checkbox,w2checkbox,w3checkbox,s1checkbox,s2checkbox,s3checkbox};
		
		JButton activateCheckedBox = new JButton("ACTIVATE");
		activateCheckedBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<12; i++)
				{
					if(checkBoxArray[i].isSelected())
					{
						checkBoxResult[i] = true;
						labelON[i].setVisible(true);
						labelOFF[i].setVisible(false);
						
					}
					
				}
				
				contentPane.remove(activePanel);
				contentPane.add(mainPanel, BorderLayout.CENTER);
				setContentPane(contentPane);
			}
		});
		activateCheckedBox.setBounds(107, 366, 117, 29);
		activePanel.add(activateCheckedBox);
		
		
		JButton deactivateCheckedBox = new JButton("DEACTIVATE");
		deactivateCheckedBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<12; i++)
				{
					if(checkBoxArray[i].isSelected())
					{
						checkBoxResult[i] = false;
						labelON[i].setVisible(false);
						labelOFF[i].setVisible(true);
						checkBoxArray[i].setSelected(false);
					}
					
				}
				
				
				contentPane.remove(activePanel);
				contentPane.add(mainPanel, BorderLayout.CENTER);
				setContentPane(contentPane);
				
			}
		});
		deactivateCheckedBox.setBounds(308, 366, 117, 29);
		activePanel.add(deactivateCheckedBox);
		
		
		JButton checkAllNorth = new JButton("ALL NORTH");
		checkAllNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1checkbox.setSelected(true);
				n2checkbox.setSelected(true);
				n2checkbox.setSelected(true);
			}
		});
		checkAllNorth.setBounds(118, 64, 117, 29);
		activePanel.add(checkAllNorth);
		
		
		JButton checkAllEast = new JButton("ALL EAST");
		checkAllEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				e1checkbox.setSelected(true);
				e2checkbox.setSelected(true);
				e3checkbox.setSelected(true);
			}
		});
		checkAllEast.setBounds(431, 64, 117, 29);
		activePanel.add(checkAllEast);
		
		
		JButton checkAllWest = new JButton("ALL WEST");
		checkAllWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w1checkbox.setSelected(true);
				w2checkbox.setSelected(true);
				w3checkbox.setSelected(true);
			}
		});
		checkAllWest.setBounds(118, 249, 117, 29);
		activePanel.add(checkAllWest);
		
		
		JButton checkAllSouth = new JButton("ALL SOUTH");
		checkAllSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s1checkbox.setSelected(true);
				s2checkbox.setSelected(true);
				s3checkbox.setSelected(true);
			}
		});
		checkAllSouth.setBounds(431, 249, 117, 29);
		activePanel.add(checkAllSouth);
		
		
	}

}
