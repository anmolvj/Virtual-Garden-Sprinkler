package gui2;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Temperature extends JPanel {
	private JTextField maxTempText;
	private JTextField minTempText;
	private JTextField currentTempText;

	/**
	 * Create the panel.
	 */
	public Temperature() {
		setLayout(null);
		
		maxTempText = new JTextField();
		maxTempText.setText("Enter");
		maxTempText.setBounds(276, 42, 130, 26);
		add(maxTempText);
		maxTempText.setColumns(10);
		
		minTempText = new JTextField();
		minTempText.setText("Enter");
		minTempText.setBounds(276, 122, 130, 26);
		add(minTempText);
		minTempText.setColumns(10);
		
		currentTempText = new JTextField();
		currentTempText.setText("Enter");
		currentTempText.setBounds(276, 211, 130, 26);
		add(currentTempText);
		currentTempText.setColumns(10);
		
		JLabel maxTemp = new JLabel("Enter the Maximum Temperature:");
		maxTemp.setBounds(23, 47, 220, 16);
		add(maxTemp);
		
		JLabel minTemp = new JLabel("Enter the Minimum Temperature:");
		minTemp.setBounds(23, 127, 220, 16);
		add(minTemp);
		
		JLabel currentTemp = new JLabel("Enter the Current Temperature:");
		currentTemp.setBounds(23, 216, 220, 16);
		add(currentTemp);
		
		JButton btnSaveTemp = new JButton("SAVE TEMPERATURE");
		btnSaveTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveTemp.setBounds(140, 252, 173, 29);
		add(btnSaveTemp);
		
		
		
		

	}
}
