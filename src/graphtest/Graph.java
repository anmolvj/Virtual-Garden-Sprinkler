package graphtest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Graph extends JFrame {

     /**
      *
      */
     private static final long serialVersionUID = 1L;
     private JPanel contentPane;

     /**
      * Launch the application.
      */
     public static void main(String[] args) {



          EventQueue.invokeLater(new Runnable() {
               public void run() {
                    try {
                         Graph frame = new Graph();

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
     public Graph() {
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(100, 100, 731, 446);
          contentPane = new JPanel();
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(contentPane);
          contentPane.setLayout(null);

          JPanel panel = new JPanel();
          panel.setBackground(Color.ORANGE);
          panel.setForeground(Color.BLACK);
          panel.setBounds(6, 6, 719, 325);
          contentPane.add(panel);
          panel.setLayout(new BorderLayout(0, 0));

          JButton generateBtn = new JButton("GENERATE CHART");
          generateBtn.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                    int[] data={32,43,21,10,97,44,68};//int size = 7
                    
                    
                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    dataset.setValue(data[0], "", "monday");
                    dataset.setValue(data[1], "", "teusday");
                    dataset.setValue(data[2], "", "wednesday");
                    dataset.setValue(data[3], "", "thursday");
                    dataset.setValue(data[4], "", "friday");
                    dataset.setValue(data[5], "", "saturday");
                    dataset.setValue(data[6], "", "sunday");
                    
                    
                    JFreeChart chart = ChartFactory.createBarChart("WATER CONSUMPTION", "days", "Water Consumption", dataset);
                    CategoryPlot catPlot = chart.getCategoryPlot();
                    catPlot.setRangeGridlinePaint(Color.WHITE);
                    
                    ChartPanel chartPanel = new ChartPanel(chart);
                    panel.removeAll();
                    panel.add(chartPanel,BorderLayout.CENTER);
                    panel.validate();



               }
          });
          generateBtn.setBounds(273, 343, 177, 75);
          contentPane.add(generateBtn);
     }

}


