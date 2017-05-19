package gui2;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Activate extends JPanel {

	JCheckBox checkBoxArray[];
	
	/**
	 * Create the panel.
	 */
	public Activate() {
		setLayout(null);
		
		JCheckBox n1checkbox = new JCheckBox("N1");
		n1checkbox.setBounds(40, 24, 50, 23);
		add(n1checkbox);
		
		JCheckBox n2checkbox = new JCheckBox("N2");
		n2checkbox.setBounds(40, 65, 50, 23);
		add(n2checkbox);
		
		JCheckBox n3checkbox = new JCheckBox("N3");
		n3checkbox.setBounds(40, 103, 50, 23);
		add(n3checkbox);
		
		JCheckBox e1checkbox = new JCheckBox("E1");
		e1checkbox.setBounds(362, 24, 50, 23);
		add(e1checkbox);
		
		JCheckBox e2checkbox = new JCheckBox("E2");
		e2checkbox.setBounds(362, 65, 50, 23);
		add(e2checkbox);
		
		JCheckBox e3checkbox = new JCheckBox("E3");
		e3checkbox.setBounds(362, 103, 50, 23);
		add(e3checkbox);
		
		JCheckBox w1checkbox = new JCheckBox("W1");
		w1checkbox.setBounds(40, 215, 56, 23);
		add(w1checkbox);
		
		JCheckBox w2checkbox = new JCheckBox("W2");
		w2checkbox.setBounds(40, 250, 56, 23);
		add(w2checkbox);
		
		JCheckBox w3checkbox = new JCheckBox("W3");
		w3checkbox.setBounds(40, 285, 56, 23);
		add(w3checkbox);
		
		JCheckBox s1checkbox = new JCheckBox("S1");
		s1checkbox.setBounds(362, 215, 50, 23);
		add(s1checkbox);
		
		JCheckBox s2checkbox = new JCheckBox("S2");
		s2checkbox.setBounds(362, 250, 50, 23);
		add(s2checkbox);
		
		JCheckBox s3checkbox = new JCheckBox("S3");
		s3checkbox.setBounds(362, 285, 50, 23);
		add(s3checkbox);
		
		checkBoxArray = new JCheckBox[]{n1checkbox,n2checkbox,n3checkbox,e1checkbox,e2checkbox,e3checkbox,w1checkbox,w2checkbox,w3checkbox,s1checkbox,s2checkbox,s3checkbox};
		
		JButton activateCheckedBox = new JButton("ACTIVATE");
		activateCheckedBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				for(int i=0; i<12; i++)
//				{
//					if(checkBoxArray[i].isSelected())
//					{
//						checkBoxResult[i] = true;
//					}
//				}
			}
		});
		activateCheckedBox.setBounds(107, 366, 117, 29);
		add(activateCheckedBox);
		
		
		JButton deactivateCheckedBox = new JButton("DEACTIVATE");
		deactivateCheckedBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				for(int i=0; i<12; i++)
//				{
//					if(checkBoxArray[i].isSelected())
//					{
//						checkBoxResult[i] = false;
//					}
//				}
				
			}
		});
		deactivateCheckedBox.setBounds(308, 366, 117, 29);
		add(deactivateCheckedBox);
		
		
		JButton checkAllNorth = new JButton("ALL NORTH");
		checkAllNorth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1checkbox.setSelected(true);
				n2checkbox.setSelected(true);
				n2checkbox.setSelected(true);
			}
		});
		checkAllNorth.setBounds(118, 64, 117, 29);
		add(checkAllNorth);
		
		
		JButton checkAllEast = new JButton("ALL EAST");
		checkAllEast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				e1checkbox.setSelected(true);
				e2checkbox.setSelected(true);
				e3checkbox.setSelected(true);
			}
		});
		checkAllEast.setBounds(431, 64, 117, 29);
		add(checkAllEast);
		
		
		JButton checkAllWest = new JButton("ALL WEST");
		checkAllWest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				w1checkbox.setSelected(true);
				w2checkbox.setSelected(true);
				w3checkbox.setSelected(true);
			}
		});
		checkAllWest.setBounds(118, 249, 117, 29);
		add(checkAllWest);
		
		
		JButton checkAllSouth = new JButton("ALL SOUTH");
		checkAllSouth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s1checkbox.setSelected(true);
				s2checkbox.setSelected(true);
				s3checkbox.setSelected(true);
			}
		});
		checkAllSouth.setBounds(431, 249, 117, 29);
		add(checkAllSouth);
		
		
	}
}
