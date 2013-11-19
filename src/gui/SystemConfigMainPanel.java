package gui;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Color;


public class SystemConfigMainPanel extends JPanel {
	private StartKinoPanel startKinoPanel;

	
	
	public SystemConfigMainPanel(StartKinoPanel startKinoPanel) {
		setBackground(new Color(255, 255, 255));
		this.startKinoPanel = startKinoPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		panel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel sodaPanel = new JPanel();
		sodaPanel.setBackground(new Color(255, 255, 255));
		sodaPanel.setToolTipText("");
		tabbedPane.addTab("Soda", null, sodaPanel, null);
		sodaPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel popcornPanel = new JPanel();
		popcornPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Popcorn", null, popcornPanel, null);
		popcornPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel candyPanel = new JPanel();
		candyPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Candy", null, candyPanel, null);
		candyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel moviePanel = new JPanel();
		moviePanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Movie", null, moviePanel, null);
		moviePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 10));
		
		JLabel lblNewLabel = new JLabel("System Configuration");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		panel_7.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));

	}
	


	

}
