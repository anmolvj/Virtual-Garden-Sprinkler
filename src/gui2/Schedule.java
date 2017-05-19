package gui2;

import javax.swing.JPanel;

import gui1.Sprinkler;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class Schedule extends JPanel {

	
	
	private JComboBox groupIdBox;
	private JComboBox sprinklerIdBox;
	private JComboBox weekDayBox;
	private JComboBox startHourBox;
	private JComboBox startMinBox;
	private JComboBox stopHourBox;
	private JComboBox stopMinBox;
	private int weekIndex=0;
	private int spArrayIndex=0;
	public JPanel controllerPanel;
	public Container container;
	int b=0;
	int a=0;
	Sprinkler[] sprinkler = new Sprinkler[12];
	int water[]= new int[7];
	
	boolean tempSprinkler = false;
	/**
	 * Create the panel.
	 * 
	 * 
	 */
	
	
	public Schedule() {
		
		
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		groupIdBox = new JComboBox();
		groupIdBox.setModel(new DefaultComboBoxModel(new String[] {"N", "E", "W", "S"}));
		groupIdBox.setBounds(301, 17, 67, 27);
		groupIdBox.setToolTipText("Enter Group Sprinkler ID:");
		add(groupIdBox);
		
		sprinklerIdBox = new JComboBox();
		sprinklerIdBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		sprinklerIdBox.setBounds(301, 45, 71, 27);
		sprinklerIdBox.setToolTipText("Enter Sprinkler ID:");
		add(sprinklerIdBox);
		
		weekDayBox = new JComboBox();
		weekDayBox.setModel(new DefaultComboBoxModel(new String[] {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}));
		weekDayBox.setToolTipText("Enter Day of the week:");
		weekDayBox.setBounds(301, 73, 83, 27);
		add(weekDayBox);
		
		startHourBox = new JComboBox();
		startHourBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		startHourBox.setToolTipText("Enter the start time:");
		startHourBox.setBounds(301, 101, 71, 27);
		add(startHourBox);
		
		startMinBox = new JComboBox();
		startMinBox.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "56", "57", "58", "59"}));
		startMinBox.setToolTipText("Enter the stop time:");
		startMinBox.setBounds(301, 129, 71, 27);
		add(startMinBox);
		
		stopHourBox = new JComboBox();
		stopHourBox.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		stopHourBox.setBounds(301, 157, 71, 27);
		add(stopHourBox);
		
		stopMinBox = new JComboBox();
		stopMinBox.setModel(new DefaultComboBoxModel(new String[] {"00","01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		stopMinBox.setBounds(301, 185, 71, 27);
		add(stopMinBox);
		
		JLabel groupIdLabel = new JLabel("Enter the Group ID:");
		groupIdLabel.setBounds(93, 21, 128, 16);
		add(groupIdLabel);
		
		JLabel sprinklerIdLabel = new JLabel("Enter the Sprinkler ID:");
		sprinklerIdLabel.setBounds(93, 49, 145, 16);
		add(sprinklerIdLabel);
		
		JLabel weekDayLabel = new JLabel("Enter the WeekDay:");
		weekDayLabel.setBounds(93, 77, 149, 16);
		add(weekDayLabel);
		
		JLabel startHourLabel = new JLabel("Enter the Start time(hours):");
		startHourLabel.setBounds(93, 105, 179, 16);
		add(startHourLabel);
		
		JLabel startMinLabel = new JLabel("Enter the Start Time(Min):");
		startMinLabel.setBounds(93, 133, 166, 16);
		add(startMinLabel);
		
		JLabel stopHourLabel = new JLabel("Enter the Stop Time(Hours):");
		stopHourLabel.setBounds(93, 161, 175, 16);
		add(stopHourLabel);
		
		JLabel stopMinLabel = new JLabel("Enter the Stop Time(Min):");
		stopMinLabel.setBounds(93, 189, 179, 16);
		add(stopMinLabel);
		
		JButton saveButton = new JButton("SAVE");
		saveButton.setFont(new Font("Menlo", Font.PLAIN, 25));
		saveButton.setForeground(new Color(0, 191, 255));
		saveButton.setBackground(new Color(127, 255, 212));
		saveButton.setBounds(178, 270, 166, 50);
		add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setSprinklerTimeData();
		
					repaint();
					revalidate();
				
				
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
		
		
		
		
				
				
			
		
		
		
		

		
	
}
