package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class NewReservationPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StartKinoPanel startKinoPanel;
	private final Action goBackAction = new GoBackAction();
	private JPanel mainPanel;
	private JLabel icon1;
	private JLabel icon2;
	private JLabel icon3;
	private int stepNumber=1;
	
	
	public NewReservationPanel(StartKinoPanel startKinoPanel) {
		setBackground(new Color(255, 255, 255));
		this.startKinoPanel = startKinoPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(255, 255, 255));
		add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 7));
		
		JLabel lblTitle = new JLabel("New Reservation");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 21));
		titlePanel.add(lblTitle);
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		add(mainPanel, BorderLayout.CENTER);
		
		mainPanel.add(startKinoPanel.getSchedule(), BorderLayout.CENTER);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(25, 25, 112));
		panel.add(separator, BorderLayout.NORTH);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(25, 25, 112));
		panel.add(separator_1, BorderLayout.SOUTH);
		
		JPanel stepPanel = new JPanel();
		stepPanel.setBackground(new Color(255, 255, 255));
		panel.add(stepPanel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		stepPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		icon1 = new JLabel("");
		icon1.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number1b_35x35.png")));
		panel_1.add(icon1, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Movie Selection");
		panel_1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		stepPanel.add(panel_5);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_5.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/3dots.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		stepPanel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		icon2 = new JLabel("");
		icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2w_35x35.png")));
		panel_2.add(icon2, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel("  Seat Selection");
		panel_2.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		stepPanel.add(panel_6);
		
		JLabel lblNewLabel_9 = new JLabel("");
		panel_6.add(lblNewLabel_9);
		lblNewLabel_9.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/3dots.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		stepPanel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		icon3 = new JLabel("");
		icon3.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number3w_35x35.png")));
		panel_3.add(icon3, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel("Customer Details");
		panel_3.add(lblNewLabel_5, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 255, 255));
		panel.add(buttonPanel, BorderLayout.EAST);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 12));
		
		JButton btnBack = new JButton("Go Back");
		btnBack.setAction(goBackAction);
		buttonPanel.add(btnBack);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 9));
		
		
	}
	
	public JPanel getMainPanel() {
		return mainPanel;
	}
	

	public int getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}
	
	//update step numbers.
	public void setIconsImageForward(){
		
		stepNumber++;
		
		if (stepNumber==2){
			
			icon1.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number1w_35x35.png")));
			icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2b_35x35.png")));
			
		} else if (stepNumber==3){
			
			icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2w_35x35.png")));
			icon3.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number3b_35x35.png")));
			
		}
			
	}
	
	public void setIconsImageBackward(){
		
		stepNumber--;
		
		if(stepNumber==2){
			icon3.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number3w_35x35.png")));
			icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2b_35x35.png")));

		}
			
	}
	
	public void resetIcons(){
		icon1.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number1b_35x35.png")));
		icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2w_35x35.png")));
		icon3.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number3w_35x35.png")));
	}
	
	private class GoBackAction extends AbstractAction {

		private static final long serialVersionUID = 1L;
		public GoBackAction() {
			putValue(NAME, "Go Back");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(stepNumber==1){
				startKinoPanel.getReservationManagerPanel().getMainContainer().removeAll();
				icon1.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number1b_35x35.png")));
				icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2w_35x35.png")));
				startKinoPanel.getReservationManagerPanel().getMainContainer().add(startKinoPanel.getReservationManagerPanel().getWrapperPanel(), BorderLayout.CENTER);
				startKinoPanel.getReservationManagerPanel().getMainContainer().updateUI();
			}
			
			if(stepNumber==2){
				startKinoPanel.getNewReservationPanel().getMainPanel().removeAll();
				icon1.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number1b_35x35.png")));
				icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2w_35x35.png")));
				startKinoPanel.getNewReservationPanel().getMainPanel().add(startKinoPanel.getSchedule(), BorderLayout.CENTER);
				startKinoPanel.getNewReservationPanel().getMainPanel().updateUI();
	
			}
			
			if(stepNumber==3){
				startKinoPanel.getNewReservationPanel().getMainPanel().removeAll();
				icon3.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number3w_35x35.png")));
				icon2.setIcon(new ImageIcon(NewReservationPanel.class.getResource("/images/number2b_35x35.png")));
				startKinoPanel.getNewReservationPanel().getMainPanel().add(startKinoPanel.getTheaterPanel(), BorderLayout.CENTER);
				startKinoPanel.getNewReservationPanel().getMainPanel().updateUI();
	
			}
			
			
			if(stepNumber>1){
				stepNumber--;
			}
			
		}
	}
}
