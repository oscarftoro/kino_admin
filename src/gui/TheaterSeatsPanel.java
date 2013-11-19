package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controller.ReservationController;
import guiDataTest.DbConnector;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class TheaterSeatsPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private StartKinoPanel startKinoPanel;
	private JPanel mainPanel;
	private JPanel seatsPanel;
	private JPanel rowNumbersPanel;
	private int seats;
	private int rows;
	private JButton[][] buttons;
	private int numberOfSelectedSeats = 0;
	private int maxNumberOfSeats = 0;
	private int individualPrice = 130;//fake price get the value from the db
	private JComboBox comboBox;
	private JLabel totalPriceLabel;
	private JLabel lblTheaterTitle;
	private int sessionNumber;
	private int theaterNumber;
	private String date;
	private JTextPane infoTextPane;
	private final Action confirmAction = new ConfirmAction();
	private JFrame frame;
	private JPanel customerDetailsPanel;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JTextField phoneTextField;
	private JTextField emailTextField;
	private JLabel lblName;
	private JLabel lblSurname;
	private JLabel lblPhone;
	private JLabel lblEmail;
	private String originalText = "";
	private JButton btnConfirm;
	private String movieId;

	

	public TheaterSeatsPanel(StartKinoPanel startKinoPanel) {
		this.startKinoPanel = startKinoPanel;

		setLayout(new BorderLayout(0, 0));

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		add(mainPanel);
		mainPanel.setLayout(new BorderLayout(10, 0));

		JPanel seatsWrapperPanel = new JPanel();
		seatsWrapperPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(seatsWrapperPanel, BorderLayout.CENTER);
		seatsWrapperPanel.setLayout(new BorderLayout(0, 0));

		JPanel screenPanel = new JPanel();
		screenPanel.setBackground(new Color(255, 255, 255));
		seatsWrapperPanel.add(screenPanel, BorderLayout.NORTH);
		screenPanel.setLayout(new BorderLayout(0, 0));

		JPanel spacerPanel = new JPanel();
		spacerPanel.setBackground(new Color(255, 255, 255));
		screenPanel.add(spacerPanel, BorderLayout.WEST);
		spacerPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_20 = new JLabel("Rows");
		lblNewLabel_20.setBackground(new Color(255, 255, 255));
		lblNewLabel_20.setForeground(new Color(255, 255, 255));
		spacerPanel.add(lblNewLabel_20);

		JPanel screenPicPanel = new JPanel();
		screenPicPanel.setBackground(new Color(255, 255, 255));
		screenPanel.add(screenPicPanel, BorderLayout.CENTER);
		screenPicPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(139, 0, 0), 2));
		screenPicPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblTheaterTitle = new JLabel();
		lblTheaterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblTheaterTitle);
		
		JLabel lblNewLabel = new JLabel("..............................................................");
		lblNewLabel.setVerifyInputWhenFocusTarget(false);
		lblNewLabel.setRequestFocusEnabled(false);
		lblNewLabel.setFocusTraversalKeysEnabled(false);
		lblNewLabel.setFocusable(false);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		screenPicPanel.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("..............................................................");
		lblNewLabel_1.setVerifyInputWhenFocusTarget(false);
		lblNewLabel_1.setRequestFocusEnabled(false);
		lblNewLabel_1.setFocusTraversalKeysEnabled(false);
		lblNewLabel_1.setFocusable(false);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		screenPicPanel.add(lblNewLabel_1, BorderLayout.EAST);

		seatsPanel = new JPanel();
		seatsPanel.setBackground(new Color(255, 255, 255));
		seatsWrapperPanel.add(seatsPanel, BorderLayout.CENTER);

		rowNumbersPanel = new JPanel();
		rowNumbersPanel.setBackground(new Color(255, 255, 255));
		seatsWrapperPanel.add(rowNumbersPanel, BorderLayout.WEST);

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(infoPanel, BorderLayout.WEST);
		infoPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		infoPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.addActionListener(this);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel(" Number of Seats: ");
		panel.add(lblNewLabel_2, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		infoPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 15));

		JLabel lblNewLabel_3 = new JLabel("Price: ");
		panel_1.add(lblNewLabel_3);
		
		totalPriceLabel = new JLabel(" - ");
		panel_1.add(totalPriceLabel);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_5.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Reservation Details");
		panel_12.add(lblNewLabel_4, BorderLayout.NORTH);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(25, 25, 112));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(100, 149, 237));
		panel_12.add(separator, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_5.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		infoTextPane = new JTextPane();
		panel_13.add(infoTextPane);
		
		customerDetailsPanel = new JPanel();
		customerDetailsPanel.setBackground(new Color(255, 255, 255));
		panel_4.add(customerDetailsPanel, BorderLayout.CENTER);
		customerDetailsPanel.setLayout(new BorderLayout(0, 15));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		customerDetailsPanel.add(panel_6, BorderLayout.NORTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCustomerDetails = new JLabel("Customer Details");
		lblCustomerDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCustomerDetails.setForeground(new Color(25, 25, 112));
		panel_6.add(lblCustomerDetails, BorderLayout.NORTH);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(100, 149, 237));
		panel_6.add(separator_1, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		customerDetailsPanel.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new BorderLayout(0, 15));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_9, BorderLayout.WEST);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		lblName = new JLabel("Name: ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblName);
		
		lblSurname = new JLabel("Surname: ");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblSurname);
		
		lblPhone = new JLabel("Phone: ");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblPhone);
		
		lblEmail = new JLabel("e-mail: ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_9.add(lblEmail);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(0, 1, 0, 0));
		
		nameTextField = new JTextField();
		panel_10.add(nameTextField);
		nameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		panel_10.add(surnameTextField);
		surnameTextField.setColumns(10);
		
		phoneTextField = new JTextField();
		panel_10.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		emailTextField = new JTextField();
		panel_10.add(emailTextField);
		emailTextField.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(100, 149, 237));
		panel_11.add(separator_2, BorderLayout.NORTH);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_14.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(0);
		panel_14.setBackground(new Color(255, 255, 255));
		panel_11.add(panel_14, BorderLayout.CENTER);
		
		btnConfirm = new JButton("Confirm");
		panel_14.add(btnConfirm);
		btnConfirm.setAction(confirmAction);
		
		enableCustomerfields(false);
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
	
	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}

	public void setTheaterNumber(int theaterNumber) {
		this.theaterNumber = theaterNumber;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public JTextPane getInfoTextPane() {
		return infoTextPane;
	}
	
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	//check how many seats are selected
	private void blockSeats(){
		if(numberOfSelectedSeats == maxNumberOfSeats){
			alterState(false);
		} else {
			alterState(true);
		}
	}

	//loop to enable or disable the seat buttons
	private void alterState(boolean x){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < seats; j++) {
				if( (int)buttons[i][j].getClientProperty("status")!=1){
					buttons[i][j].setEnabled(x);
				}
			}
		}
	}

	private void updateTextFieldWithSeats(){//update the information about the reservation with the selected seats
		if(originalText.equals("")){
			originalText = infoTextPane.getText();
		}
		
		String text="";
		text = originalText + "\n"+ startKinoPanel.getReservationSeats().getSeats();
		infoTextPane.setText(text);
	}
	
	public void setOcupiedSeats(){
		setReservedSeats();
		resetComboBox();
	}
	
	private void resetComboBox(){
		comboBox.setSelectedIndex(0);
	}
	
	//To re-factor, get the data from the controller
	private void setReservedSeats(){
		/* DOV */
//		String query = "SELECT seat, row FROM seats WHERE session=" +sessionNumber+ " AND theater=" +theaterNumber+ " AND date='" +date+ "'";
//
//		try {
//			Connection SqlConnector = DbConnector.getSqlConnection();// connect to database
//			Statement statement = SqlConnector.createStatement();
//			statement.executeQuery(query);
//			// Get the result of the SQL query
//			ResultSet rs = statement.getResultSet();
//
//
//
//			while (rs.next()) // loop through rows of result set
//			{
//				buttons[Integer.parseInt(rs.getString("row"))-1][Integer.parseInt(rs.getString("seat"))-1].putClientProperty("status", 2);
//			}
//
//			rs.close(); // close result set
//			statement.close(); // close statement
//			DbConnector.closeDatabaseConnection();//disconnect from database
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        Vector<Vector<Integer>>  reservedSeats = ReservationController.getInstance().getReservedSeats(sessionNumber,theaterNumber,date);
        for (Vector<Integer> reservedSeat : reservedSeats) {
            buttons[reservedSeat.get(0)][reservedSeat.get(1)].putClientProperty("status", 2);
        }
		setButtonStates();
	}
	

	
	
	//set the seats button states with information from the database
	private void setButtonStates(){
		//set occupied seats to red 
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < seats; j++) {
				
				if( (int)buttons[i][j].getClientProperty("status")==2){
					buttons[i][j].setBackground(Color.RED);
					buttons[i][j].setEnabled(false);
				}
				//set button states to false if the value of tickets selected is 0.
				if(maxNumberOfSeats==0){
					alterState(false);
				}
			}
		}
	}
	
	private void resetButtonStates(){
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < seats; j++) {
				buttons[i][j].putClientProperty("status", 0);
				buttons[i][j].setBackground(Color.WHITE);
				setButtonStates();//set occupied seats 
			}
		}
		setReservedSeats();
	}
	
	public void rebuildSeats(int theater){ //execute encapsulated buildSeats() method
		lblTheaterTitle.setText("Theater " + theater);
		buildSeats();	
	}
	
	private void buildSeats(){
		
		seatsPanel.removeAll();//remove all panels
		
		seatsPanel.setLayout(new GridLayout(rows, seats, 0, 0));//set layout
		for (int i = 0; i < rows; i++) { //build seats
			for (int j = 0; j < seats; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setText(""+(j+1)); 
				buttons[i][j].putClientProperty("row", (i+1));
				buttons[i][j].putClientProperty("seat", (j+1));
				buttons[i][j].putClientProperty("status", 0);
				buttons[i][j].addActionListener(this);
				buttons[i][j].setBackground(Color.WHITE);
				seatsPanel.add(buttons[i][j]);
			}
		}
		
		//build row numbers
		rowNumbersPanel.setLayout(new GridLayout(rows, 0, 0, 0));//set layout
		rowNumbersPanel.removeAll();
		for(int i=1; i<=rows; i++){ //build labels
			JLabel lblRowNumber = new JLabel("      "+i);
			lblRowNumber.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblRowNumber.setHorizontalAlignment(SwingConstants.RIGHT);
			lblRowNumber.setForeground(new Color(0, 0, 128));
			rowNumbersPanel.add(lblRowNumber);
		}
		
		seatsPanel.updateUI();
		setButtonStates();

	}
	
	public void resetSeats(){
		numberOfSelectedSeats = 0;
		resetButtonStates();
		blockSeats();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==comboBox){ //number of tickets combobox
			maxNumberOfSeats = (int) comboBox.getSelectedIndex();
			numberOfSelectedSeats = 0;
			resetButtonStates();
			blockSeats();
			int total = maxNumberOfSeats * individualPrice;
			totalPriceLabel.setText(""+total);
			startKinoPanel.getReservationSeats().removeAllSeats();
			enableCustomerfields(false);
			updateTextFieldWithSeats();
			if(startKinoPanel.getNewReservationPanel().getStepNumber()==3){
				startKinoPanel.getNewReservationPanel().setIconsImageBackward();
			}
			

			
			
		} else { //seat buttons
		
			JButton source = (JButton) e.getSource();
			int status = (Integer) source.getClientProperty("status");
			
			//***************test
			int row = (Integer) source.getClientProperty("row");
			int seat = (Integer) source.getClientProperty("seat");
			System.out.println("Row: " + row + " - Seat: " + seat+" - Status: "+ status +" - Tickets: " + numberOfSelectedSeats +" ");
			//**************end test
			
			if(status==0){
				source.putClientProperty("status", 1);
				status = (Integer) source.getClientProperty("status");
				source.setBackground(Color.GREEN);
				
				startKinoPanel.getReservationSeats().addSeat((Integer) source.getClientProperty("row"), (Integer) source.getClientProperty("seat"));
				
				numberOfSelectedSeats++;
				
				if(numberOfSelectedSeats == maxNumberOfSeats){ //enable Next button
					//enable customer fields
					enableCustomerfields(true);
					updateTextFieldWithSeats();
					startKinoPanel.getNewReservationPanel().setIconsImageForward();
				}
					
				blockSeats();
				
	
			} else if(status==1){
				source.putClientProperty("status", 0);
				status = (Integer) source.getClientProperty("status");
				source.setBackground(Color.LIGHT_GRAY);
				
				startKinoPanel.getReservationSeats().removeSeat((Integer) source.getClientProperty("row"), (Integer) source.getClientProperty("seat"));
				numberOfSelectedSeats--;
				
				//disable customer fields
				enableCustomerfields(false);
				startKinoPanel.getNewReservationPanel().setIconsImageBackward();
				updateTextFieldWithSeats();
				blockSeats();
				if(maxNumberOfSeats==0){
					alterState(false);
				}
			}
		}
	}

	private void enableCustomerfields(boolean set){ //enable / disable fields
		customerDetailsPanel.setEnabled(set);
		nameTextField.setEnabled(set);
		surnameTextField.setEnabled(set);
		phoneTextField.setEnabled(set);
		emailTextField.setEnabled(set);
		lblName.setEnabled(set);
		lblSurname.setEnabled(set);
		lblPhone.setEnabled(set);
		lblEmail.setEnabled(set);
		btnConfirm.setEnabled(set);
	}
	
	
	private class ConfirmAction extends AbstractAction {
		public ConfirmAction() {
			putValue(NAME, "Confirm");
			putValue(SMALL_ICON, new ImageIcon(TheaterSeatsPanel.class.getResource("/images/save_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			//check if all the customer fields have data
			if (!nameTextField.getText().isEmpty()&&!surnameTextField.getText().isEmpty()
					&&!phoneTextField.getText().isEmpty()&&!emailTextField.getText().isEmpty()){//fields have data, run new reservation method
				
				//************************************DOV****************************************************
	            String name = nameTextField.getText();
	            String surname = surnameTextField.getText();
	            String phone = phoneTextField.getText();
	            String email = emailTextField.getText();
	            //String movie = movieId;
	            //String dat = date;
	            //int session = sessionNumber;
	            //int theater = theaterNumber;
	            ArrayList<int[]> customerSeats = startKinoPanel.getReservationSeats().getCustomerSeats();
	            ReservationController.getInstance().makeReservation(name,surname,phone,email,movieId,date,sessionNumber,theaterNumber,customerSeats);
				//********************************************************************************************
				System.out.println(startKinoPanel.getReservationSeats().getCustomerSeats().toString());
				System.out.println(theaterNumber);
				System.out.println(movieId);
				System.out.println(date);
				System.out.println(sessionNumber);
				System.out.println(nameTextField.getText());
				System.out.println(surnameTextField.getText());
				System.out.println(phoneTextField.getText());
				System.out.println(emailTextField.getText());
				
				//reset fields
				nameTextField.setText("");
				surnameTextField.setText("");
				phoneTextField.setText("");
				emailTextField.setText("");
				
				//go back to main and update table
				startKinoPanel.getReservationManagerPanel().getMainContainer().removeAll();
				startKinoPanel.getReservationManagerPanel().getMainContainer().add(startKinoPanel.getReservationManagerPanel().getWrapperPanel(), BorderLayout.CENTER);
				startKinoPanel.getReservationManagerPanel().updateTable(null, null);
				startKinoPanel.getReservationManagerPanel().getMainContainer().updateUI();
				
			} else { //no data in all fields
				
				JOptionPane.showMessageDialog(frame, "Please verify Customer fields\n","System Message",
					    JOptionPane.ERROR_MESSAGE);
			}
			
			
				
		}
	}
}
