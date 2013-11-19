package gui;

import controller.MovieController;
import guiDataTest.TestDataCalls;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.border.LineBorder;

import sql.DbConnector;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class SchedulePanel extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private StartKinoPanel startKinoPanel;
	private JTextPane[] weekDaysTextPane = new JTextPane[7];
	private JPanel[][] panels = new JPanel[5][7];
	private JPanel[][] subPanels = new JPanel[2][1];
	private JLabel[] labels = new JLabel[1];
	private JTextPane[] textPane = new JTextPane[1];
	private Calendar c = Calendar.getInstance();
	private Date date = new Date();
	private Date staticDate = new Date();
	private SimpleDateFormat dbDateFormat;
	private SimpleDateFormat textpaneDateFormat = new SimpleDateFormat("EEEE \n dd/MM/yyyy");
	private JLabel[] sessionLabels = new JLabel[5];
	private JPanel centerPanel;
	private JPanel weekDaysPanel;
	private int scheduleType;
	private JButton btnArrowRight;
	private JButton btnArrowLeft;
	private final Action arrowLeftAction = new ArrowLeftAction();
	private final Action arrowRightAction = new ArrowRightAction();
	private JPanel westPanel;
	private String movieId;
	private JFrame frame;
	
	public SchedulePanel(StartKinoPanel startKinoPanel, int scheduleType) {
		this.startKinoPanel = startKinoPanel;
		this.scheduleType = scheduleType;
		
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBackground(new Color(255, 255, 255));
		add(gridPanel, BorderLayout.CENTER);
		gridPanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		gridPanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(5, 7, 3, 3));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		gridPanel.add(panel_4, BorderLayout.EAST);
		
		JLabel lblSpacer = new JLabel("");
		lblSpacer.setVerifyInputWhenFocusTarget(false);
		lblSpacer.setFocusTraversalKeysEnabled(false);
		lblSpacer.setInheritsPopupMenu(false);
		lblSpacer.setRequestFocusEnabled(false);
		lblSpacer.setVisible(false);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		lblSpacer.setEnabled(false);
		lblSpacer.setFocusable(false);
		lblSpacer.setIcon(new ImageIcon(SchedulePanel.class.getResource("/images/navigate-right-icon-32.png")));
		panel_4.add(lblSpacer);
		
		JPanel northPanel = new JPanel();
		northPanel.setBackground(new Color(255, 255, 255));
		gridPanel.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BorderLayout(0, 0));
		
		weekDaysPanel = new JPanel();
		weekDaysPanel.setBackground(new Color(255, 255, 255));
		northPanel.add(weekDaysPanel);
		weekDaysPanel.setLayout(new GridLayout(0, 7, 0, 0));
			
		JPanel spacerPanel = new JPanel();
		spacerPanel.setBackground(new Color(255, 255, 255));
		northPanel.add(spacerPanel, BorderLayout.WEST);
		spacerPanel.setLayout(new BorderLayout(0, 0));
		
		btnArrowLeft = new JButton("...");
		btnArrowLeft.setAction(arrowLeftAction);
		btnArrowLeft.setFocusPainted(false);
		btnArrowLeft.setForeground(new Color(255, 255, 255));
		btnArrowLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		btnArrowLeft.setHorizontalTextPosition(SwingConstants.LEADING);
		btnArrowLeft.setContentAreaFilled(false);
		btnArrowLeft.setBorderPainted(false);
		btnArrowLeft.setBorder(null);
		btnArrowLeft.setBackground(new Color(255, 255, 255));
		btnArrowLeft.setIcon(new ImageIcon(SchedulePanel.class.getResource("/images/navigate-left-icon_32.png")));
		spacerPanel.add(btnArrowLeft);
		
		JPanel rightArrowpanel = new JPanel();
		rightArrowpanel.setBackground(new Color(255, 255, 255));
		northPanel.add(rightArrowpanel, BorderLayout.EAST);
		rightArrowpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnArrowRight = new JButton("");
		btnArrowRight.setAction(arrowRightAction);
		btnArrowRight.setFocusPainted(false);
		btnArrowRight.setBackground(new Color(255, 255, 255));
		btnArrowRight.setContentAreaFilled(false);
		btnArrowRight.setBorderPainted(false);
		btnArrowRight.setBorder(null);
		btnArrowRight.setIcon(new ImageIcon(SchedulePanel.class.getResource("/images/navigate-right-icon-32.png")));
		rightArrowpanel.add(btnArrowRight);
		
		westPanel = new JPanel();
		westPanel.setBackground(new Color(255, 255, 255));
		gridPanel.add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new GridLayout(5, 0, 0, 0));
		
		//set session labels
		setSessionLabelsText();
			
		JPanel southPanel = new JPanel();
		southPanel.setBackground(new Color(255, 255, 255));
		gridPanel.add(southPanel, BorderLayout.SOUTH);
	
		if(scheduleType==2){ //if the movie manager is selected update schedule
			updateSchedule();
		}
		
	}
	
	private void setSessionLabelsText(){
		//session labels
		String[] times = {"  11:30  ", "  14:00  ", "  16:20  ", "  19:00  ", "  21:30  "};
		for (int i = 0; i <= times.length-1; i++) {
			sessionLabels[i] = new JLabel();
			sessionLabels[i].setFont(new Font("Tahoma", Font.BOLD, 11));
			sessionLabels[i].setText(times[i]);
			westPanel.add(sessionLabels[i]);	
		}	
	}
	
	public void updateSchedule(){
		buildDateLabels();
		buildSchedule();
	}
	
	
	private void buildDateLabels(){
		//create and set the date for the weekDaysTextPanes
		weekDaysPanel.removeAll();
		for (int i = 0; i < 7; i++) {
			c.setTime(date);//set calendar time
			c.add(Calendar.DAY_OF_YEAR,i );//add 1 day
			weekDaysTextPane[i] = new JTextPane();
			alignTextCenter(weekDaysTextPane[i]);//set alignment
			weekDaysTextPane[i].setFont(new Font("Arial", Font.PLAIN, 12));
			if (i==0){
				weekDaysTextPane[i].setFont(new Font("Arial", Font.BOLD, 12));
			}
			weekDaysTextPane[i].setText(textpaneDateFormat.format(c.getTime()));
			weekDaysPanel.add(weekDaysTextPane[i]);	
		}
		weekDaysPanel.updateUI();
	}
	
	
	private void buildSchedule(){
		centerPanel.removeAll();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				panels[i][j] = new JPanel();
				panels[i][j].setLayout(new BorderLayout(0, 0));
				panels[i][j].setBorder(new LineBorder(new Color(100, 149, 237)));
				panels[i][j].setBackground(new Color(255, 255, 255));
				panels[i][j].setLayout(new GridLayout(2, 1, 0, 0));
				
				dbDateFormat = new SimpleDateFormat("yyyy-MM-dd");//date format
				c.setTime(date);//set calendar time
				c.add(Calendar.DAY_OF_YEAR,j );//add 1 day


				for (int a = 0; a < 2; a++) {
					for (int b = 0; b < 1; b++) {
						subPanels[a][b] = new JPanel();
						subPanels[a][b].setBackground(new Color(100, 149, 237));
						subPanels[a][b].setLayout(new BorderLayout(0, 0));

							labels[0] = new JLabel("Theater"+ (a+1));
							labels[0].setForeground(new Color(255, 255, 255));
							labels[0].setFont(new Font("Tahoma", Font.BOLD, 10));
							labels[0].setHorizontalAlignment(SwingConstants.CENTER);
							subPanels[a][b].add(labels[0], BorderLayout.NORTH);
									
							textPane[0] = new JTextPane();
							textPane[0].setFont(new Font("Tahoma", Font.BOLD, 10));
							textPane[0].putClientProperty("theater", (a+1));
							textPane[0].putClientProperty("date", dbDateFormat.format(c.getTime()));
							textPane[0].putClientProperty("session", (i+1));
							
							//change text pane color in today column
							if ( dbDateFormat.format(staticDate).equals(dbDateFormat.format(date)) && ((i==0 && j ==0)||(i==1 && j ==0)||(i==2 && j ==0)||(i==3 && j ==0)||(i==4 && j ==0))){
								textPane[0].setBackground(new Color(240, 230, 140));
							}
							
							//set text and property movie id
							try {
								getTextPaneMovieData(a, dbDateFormat.format(c.getTime()), i, textPane[0]);//get references from all textPanes
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							textPane[0].setFocusable(false);
							textPane[0].setEditable(false);
							textPane[0].addMouseListener(this);//mouse listener
							
							subPanels[a][b].add(textPane[0], BorderLayout.CENTER);
						
						panels[i][j].add(subPanels[a][b]);
						
					}
				}
								
				centerPanel.add(panels[i][j]);

			}
		}
		centerPanel.updateUI();
	}
	
	public void resetDate(){
		date = new Date();
	}
	
	 //DOVILES CONTROLLER populate schedule with sessions data
	//call the controller to get the data from the database to populate the schedule
	    private void getTextPaneMovieData(int theater, String date, int session, JTextPane textPane) throws Exception {
        MovieController movieController = MovieController.getInstance();
		// Get the result of the SQL query
		//String[] rs = TestDataCalls.getTextPaneMovieData(theater, date, session);
        String[] rs = movieController.getMovies(theater, date, session);

		textPane.putClientProperty("movieId", rs[0]);
		textPane.setText(rs[1]);
		textPane.putClientProperty("scheduleId", rs[2]);


	}
	
	

	private void alignTextCenter(JTextPane dateTextField){ //set text and attributes on the date JTextpanels 
		StyledDocument text = dateTextField.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		text.setParagraphAttributes(0, text.getLength(), center, false);
		dateTextField.setFocusable(false);
		dateTextField.setEditable(false);
	}
	
	private String selectedMovieInfo(int sessionNumber, String movieName, String date){
		
		String session = null;
		switch (sessionNumber) {
			case 1 : session = "11:30";
			break;
			case 2 : session = "14:00";
			break;
			case 3 : session = "16:20";
			break;
			case 4 : session = "19:00";
			break;
			case 5 : session = "21:30";
			break;
		
		}
		if(movieName==null && date==null){ //return only the session String
			return session;
		} else {
			startKinoPanel.getTheaterPanel().setMovieId(movieId);
			return "\rTitle: "+ movieName + "\rDate: "+ date + "\rTime: " + session+"\r\n";
		}
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		
		JTextPane source = (JTextPane) e.getSource();
		int theater = (Integer) source.getClientProperty("theater");
		String date = (String) source.getClientProperty("date");
		int session = (Integer) source.getClientProperty("session");
		movieId = (String) source.getClientProperty("movieId");
		String scheduleId =  (String) source.getClientProperty("scheduleId");
		
		//TODO: delete output test
		System.out.println("ScheduleId: "+ scheduleId + " theater: "+ theater + " -- date: " + date + " -- session: " + session + " -- movie ID: " + movieId);
		
		
		if(scheduleType==1){ //actions for reservations
				
			//set theater seats
			if(theater==1){
				startKinoPanel.getTheaterPanel().setSeats(12);
				startKinoPanel.getTheaterPanel().setRows(20);
				startKinoPanel.getTheaterPanel().setButtons(new JButton[20][12]);
				startKinoPanel.getTheaterPanel().rebuildSeats(theater);
			} else {
				startKinoPanel.getTheaterPanel().setSeats(16);
				startKinoPanel.getTheaterPanel().setRows(25);
				startKinoPanel.getTheaterPanel().setButtons(new JButton[25][16]);
				startKinoPanel.getTheaterPanel().rebuildSeats(theater);
			}
			
			//set the theater number, session, and date
			startKinoPanel.getTheaterPanel().setTheaterNumber(theater);
			startKinoPanel.getTheaterPanel().setSessionNumber(session);
			startKinoPanel.getTheaterPanel().setDate(date);
			startKinoPanel.getTheaterPanel().setOcupiedSeats();
			startKinoPanel.getTheaterPanel().getInfoTextPane().setText(selectedMovieInfo(session, source.getText(), date));//pass the session, movie title and reservation date to next window

			startKinoPanel.getNewReservationPanel().getMainPanel().removeAll();
			startKinoPanel.getNewReservationPanel().setIconsImageForward();
			startKinoPanel.getNewReservationPanel().getMainPanel().add(startKinoPanel.getTheaterPanel(), BorderLayout.CENTER);
			startKinoPanel.getNewReservationPanel().getMainPanel().updateUI();

		} else if(scheduleType==2){ //actions for movie manager
		
			
			if(movieId==null){ //add movie to schedule
				
				//split selected date string
				String[] s = date.split("-");
				Calendar x = Calendar.getInstance();
				//set selected date into a calendar object
				x.set(Integer.parseInt(s[0]), Integer.parseInt(s[1])-1, Integer.parseInt(s[2]));
				
				if(startKinoPanel.getMovieSchedulePlan().getTextFieldStartDate().requestFocus(isCursorSet())){
					
					startKinoPanel.getMovieSchedulePlan().getTextFieldStartDate().setDate(x.getTime());
					startKinoPanel.getMovieSchedulePlan().setTheaterNumber(theater);//pass theater number
					startKinoPanel.getMovieSchedulePlan().setSession(session);//pass session number
					//note: we don't need to pass the movie Id because when we selected the movie from the list the value is passed directly
					//into the MovieSchedulePlan panel, who calls these one. 
					startKinoPanel.getMovieSchedulePlan().getLblSession().setText(selectedMovieInfo(session, null, null));//set label
					startKinoPanel.getMovieSchedulePlan().getLblTheaterNumber().setText(""+theater);//set label
							
				} else if(startKinoPanel.getMovieSchedulePlan().getTextFieldEndDate().requestFocus(isCursorSet())){
					
					startKinoPanel.getMovieSchedulePlan().getTextFieldEndDate().setDate(x.getTime());	
				}

			} else {
				//remove movie from schedule
				
				//reset add movie fields
				startKinoPanel.getMovieSchedulePlan().getTextFieldStartDate().setDate(null);
				startKinoPanel.getMovieSchedulePlan().getTextFieldEndDate().setDate(null);
				startKinoPanel.getMovieSchedulePlan().getLblSession().setText("\"Not Selected\"");//set label
				startKinoPanel.getMovieSchedulePlan().getLblTheaterNumber().setText("\"Not Selected\"");//set label
				
				
				//date, theaterNumber, session, movieId
				System.out.println("remove movie");
				System.out.println(scheduleId);
				
				int option = JOptionPane.showConfirmDialog(frame, "Remove movie?", "System Message", JOptionPane.YES_NO_OPTION);
				
				if (option == JOptionPane.YES_OPTION) {
				    System.out.println("yes");


                    //***************************************DOVILE****************************
//                    try {
//                        TestDataCalls.removeMovieFromSchedule(date, scheduleId);
//                    } catch (SQLException e1) {
//                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//                    }
                    MovieController.getInstance().updateSchedule(date,scheduleId);
                    updateSchedule(); //update Schedule
                }
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

	private class ArrowLeftAction extends AbstractAction {
		public ArrowLeftAction() {
			putValue(NAME, "...");
			putValue(SHORT_DESCRIPTION, "Previous 7 days.");
		}
		public void actionPerformed(ActionEvent e) {
			c.setTime(date);//reset date
			c.add(Calendar.DAY_OF_YEAR, -7);//subtract 7 days
			date = c.getTime();//set new date
			updateSchedule();//update Schedule
		}
	}
	
	private class ArrowRightAction extends AbstractAction {
		public ArrowRightAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Next 7 days.");
		}
		public void actionPerformed(ActionEvent e) {
			c.setTime(date);//reset date
			c.add(Calendar.DAY_OF_YEAR, 7);//add 7 days
			date = c.getTime(); //set new date
			updateSchedule(); //update Schedule
			System.out.println(date + "--"+ staticDate);
		}
	}
}
