package gui;

import controller.ReservationController;
import guiDataTest.TableData;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ReservationManagerPanel extends JPanel {
	private JTable table;
	private JTextField searchTextField;
	private JButton btnNewReservation;
	private final Action newReservationAction = new NewReservation();
	private JPanel formsPanel;
	private StartKinoPanel startKinoPanel;
	private JPanel headerPanel;
	private JPanel newReservationPanel;
	private JPanel reservationListPanel;
	private JPanel mainContainer;
	private JPanel wrapperPanel;
	private JPanel extraServicesWrapperPanel;
	private JPanel reservationsInfoPanel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnSearch;
	private JComboBox searchComboBox;
	private final Action searchAction = new SearchAction();
	private JPanel panel_5;
	private JButton btnNewButton;
	private final Action refreshAction = new RefreshAction();

	/**
	 * Create the panel.
	 * @param startKinoPanel 
	 */
	public ReservationManagerPanel(StartKinoPanel startKinoPanel) {
		this.startKinoPanel = startKinoPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		mainContainer = new JPanel();
		add(mainContainer, BorderLayout.CENTER);
		mainContainer.setLayout(new BorderLayout(0, 0));
		
		wrapperPanel = new JPanel();
		mainContainer.add(wrapperPanel);
		wrapperPanel.setLayout(new BorderLayout(0, 0));
		
		reservationListPanel = new JPanel();
		reservationListPanel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(100, 149, 237)));
		reservationListPanel.setBackground(new Color(255, 255, 255));
		wrapperPanel.add(reservationListPanel, BorderLayout.WEST);
		reservationListPanel.setLayout(new BorderLayout(0, 10));
		
		JPanel labelPanel = new JPanel();
		labelPanel.setBorder(null);
		reservationListPanel.add(labelPanel, BorderLayout.NORTH);
		labelPanel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) labelPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		JLabel lblReservations = new JLabel("Reservations ");
		lblReservations.setForeground(new Color(0, 0, 128));
		lblReservations.setFont(new Font("Arial", Font.BOLD, 18));
		labelPanel.add(lblReservations);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(255, 255, 255));
		tablePanel.setBorder(null);
		reservationListPanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 10));
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(255, 255, 255));
		tablePanel.add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		searchPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(3, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel_2.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(5, 0));
		
		searchComboBox = new JComboBox();
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Surname", "Phone", "Email", "Movie"}));
		panel.add(searchComboBox, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		searchTextField = new JTextField();
		panel_1.add(searchTextField, BorderLayout.CENTER);
		searchTextField.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_5, BorderLayout.EAST);
		panel_5.setLayout(new BorderLayout(3, 0));
		
		btnSearch = new JButton("");
		panel_5.add(btnSearch, BorderLayout.CENTER);
		btnSearch.setAction(searchAction);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setAction(refreshAction);
		panel_5.add(btnNewButton, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		searchPanel.add(panel_3, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		searchPanel.add(panel_4, BorderLayout.EAST);
		
		JPanel centerPanel = new JPanel();
		tablePanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		centerPanel.add(table);
		centerPanel.add(table.getTableHeader(), BorderLayout.NORTH);
		updateTable(null, null);
		
		newReservationPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) newReservationPanel.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		newReservationPanel.setBackground(new Color(255, 255, 255));
		reservationListPanel.add(newReservationPanel, BorderLayout.SOUTH);
		
		btnNewReservation = new JButton("New Reservation");
		btnNewReservation.setAction(newReservationAction);
		newReservationPanel.add(btnNewReservation);
		
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 255, 255));
		wrapperPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 7));
		
		JLabel lblTitle = new JLabel("Reservation Manager");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setFont(new Font("Arial", Font.BOLD, 21));
		headerPanel.add(lblTitle);
		
		formsPanel = new JPanel();
		formsPanel.setBackground(new Color(255, 255, 255));
		wrapperPanel.add(formsPanel, BorderLayout.CENTER);
		formsPanel.setLayout(new BorderLayout(0, 20));
		
		reservationsInfoPanel = new JPanel();
		formsPanel.add(reservationsInfoPanel, BorderLayout.NORTH);
		
		reservationsInfoPanel.setLayout(new BorderLayout(0, 0));
		//reservationsInfoPanel.add(startKinoPanel.getReservationInfoPanel(), BorderLayout.NORTH);
		
		extraServicesWrapperPanel = new JPanel();
		extraServicesWrapperPanel.setBackground(new Color(255, 255, 255));
		formsPanel.add(extraServicesWrapperPanel, BorderLayout.CENTER);
		
		extraServicesWrapperPanel.setLayout(new BorderLayout(0, 0));
		//extraServicesWrapperPanel.add(startKinoPanel.getServicesPanel(), BorderLayout.CENTER);
	
	}

	//**************************************************************************************************************************
	public void updateTable(String selectedChoice, String typeField){
		table.setModel(getMovieList(selectedChoice, typeField));
		table.addMouseListener(new MouseAdapter() { //table listener
			@Override
			public void mouseClicked(MouseEvent e) {
				reservationsInfoPanel.add(startKinoPanel.getReservationInfoPanel(), BorderLayout.NORTH);
				startKinoPanel.getReservationInfoPanel().setReservationId((int) table.getValueAt(table.rowAtPoint(e.getPoint()),0));//pass the movie Id to the schedule panel
				reservationsInfoPanel.updateUI();
                startKinoPanel.getExtraServicesPanel().setReservationId(getSelectedReservationId());
                startKinoPanel.getExtraServicesPanel().updateTable();
                startKinoPanel.getExtraServicesPanel().calculateTotal();
			}
		});
		//set table columns width
		int[] columnsWidth = { 0, 95, 95, 150, 90, 140 };//columns size
		TableFormat.formatTable(columnsWidth, table);
	}
	
	//***************test method to populate the movies table---> to be replaced with a controller call****************
	private static DefaultTableModel getMovieList(String selectedChoice, String typeField) {
        Vector<String> tableHeaders = new Vector<>(Arrays.asList(new String[]{"Id", "Name","Surname", "Movie","Phone", "Email"}));
        Vector<Vector<Object>> data = ReservationController.getInstance().getReservations(selectedChoice, typeField);
        return new DefaultTableModel(data,tableHeaders);
		//return TableData.buildTableModel(q, tableHeaders);//-->> TODO: connect to controller after testing		

	}
    public int getSelectedReservationId(){
        return (int) table.getValueAt(table.getSelectedRow(),0);
    }
		
	public JPanel getReservationsInfoPanel() {
		return reservationsInfoPanel;
	}
	
	public JPanel getMainContainer() {
		return mainContainer;
	}
	
	public JPanel getWrapperPanel() {
		return wrapperPanel;
	}

	public JPanel getExtraServicesWrapperPanel() {
		return extraServicesWrapperPanel;
	}
    public String getReservationsTable(){
        return (String) table.getValueAt(table.getSelectedRow(),3);
    }

	private class NewReservation extends AbstractAction {
		public NewReservation() {
			putValue(NAME, "New Reservation");
			putValue(SMALL_ICON, new ImageIcon(TheaterSeatsPanel.class.getResource("/images/add_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			mainContainer.removeAll();
			mainContainer.add(startKinoPanel.getNewReservationPanel(), BorderLayout.CENTER);
			startKinoPanel.getNewReservationPanel().getMainPanel().removeAll();
			startKinoPanel.getNewReservationPanel().setStepNumber(1); //reset stepNumber
			//startKinoPanel.getNewReservationPanel().resetIcons();//reset icons
			startKinoPanel.getNewReservationPanel().getMainPanel().add(startKinoPanel.getSchedule(), BorderLayout.CENTER);
			startKinoPanel.getSchedule().resetDate();
 			startKinoPanel.getSchedule().updateSchedule();
			mainContainer.updateUI();
		}
	}
	private class SearchAction extends AbstractAction {
		public SearchAction() {
			putValue(NAME, "");
			putValue(SMALL_ICON, new ImageIcon(ReservationManagerPanel.class.getResource("/images/49.png")));
			putValue(SHORT_DESCRIPTION, "Search");
		}
		public void actionPerformed(ActionEvent e) {
			updateTable((String)searchComboBox.getSelectedItem(), searchTextField.getText());
			
		}
	}
	private class RefreshAction extends AbstractAction {
		public RefreshAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Refresh Table");
			putValue(SMALL_ICON, new ImageIcon(ReservationManagerPanel.class.getResource("/images/refresh_16.png")));
		}
		public void actionPerformed(ActionEvent e) {
			updateTable(null,null);
			
		}
	}
}

