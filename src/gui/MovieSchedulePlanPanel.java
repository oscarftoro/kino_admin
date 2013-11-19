package gui;

import controller.MovieController;

import guiDataTest.TestDataCalls;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Action;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

public class MovieSchedulePlanPanel extends JPanel {
	private JDateChooser textFieldStartDate;
	private JDateChooser textFieldEndDate;
	private StartKinoPanel startKinoPanel;
	private JLabel lblMovieTitle;
	private int session;
	private int theaterNumber;
	private int movieId;
	private JButton btnSchedule;
	private final Action addToScheduleAction = new AddToScheduleAction();
	private JLabel lblTheaterNumber;
	private JLabel lblSession;
	private JFrame frame;

	/**
	 * Create the panel.
	 * @param startKinoPanel 
	 */
	public MovieSchedulePlanPanel(StartKinoPanel startKinoPanel) {
		this.startKinoPanel = startKinoPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 255, 255));
		add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 20));
		
		mainPanel.add(startKinoPanel.getMovieManagerSchedule(), BorderLayout.CENTER);
		
		JPanel wrapperOptionsPanel = new JPanel();
		wrapperOptionsPanel.setBackground(new Color(255, 255, 255));
		mainPanel.add(wrapperOptionsPanel, BorderLayout.NORTH);
		wrapperOptionsPanel.setLayout(new BorderLayout(0, 15));
		
		JPanel optionsPanel = new JPanel();
		wrapperOptionsPanel.add(optionsPanel, BorderLayout.CENTER);
		optionsPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel movieTitlePanel = new JPanel();
		movieTitlePanel.setBackground(new Color(255, 255, 255));
		optionsPanel.add(movieTitlePanel);
		
		lblMovieTitle = new JLabel("Movie Title...");
		lblMovieTitle.setFont(new Font("Arial", Font.BOLD, 20));
		movieTitlePanel.add(lblMovieTitle);
		
		JPanel sheduleDetailsPanel = new JPanel();
		sheduleDetailsPanel.setBackground(new Color(255, 255, 255));
		optionsPanel.add(sheduleDetailsPanel);
		sheduleDetailsPanel.setLayout(new GridLayout(0, 5, 0, 0));
		
		JPanel startDatePanel = new JPanel();
		startDatePanel.setBackground(new Color(255, 255, 255));
		sheduleDetailsPanel.add(startDatePanel);
		
		JLabel lblStart = new JLabel("Start Date: ");
		startDatePanel.add(lblStart);
		textFieldStartDate = new JDateChooser();
		textFieldStartDate.setPreferredSize(new Dimension(110, 20));
		textFieldStartDate.setDateFormatString("dd/MM/yyyy");
		startDatePanel.add(textFieldStartDate);
		
		JPanel theaterNumberPanel = new JPanel();
		theaterNumberPanel.setBackground(new Color(255, 255, 255));
		sheduleDetailsPanel.add(theaterNumberPanel);
		
		JLabel lblNewLabel = new JLabel("Theater: ");
		theaterNumberPanel.add(lblNewLabel);
		
		lblTheaterNumber = new JLabel("\"Not Selected\"");
		theaterNumberPanel.add(lblTheaterNumber);
		
		JPanel sessionPanel = new JPanel();
		sessionPanel.setBackground(new Color(255, 255, 255));
		sheduleDetailsPanel.add(sessionPanel);
		
		JLabel lblNewLabel_3 = new JLabel("Session: ");
		sessionPanel.add(lblNewLabel_3);
		
		lblSession = new JLabel("\"Not Selected\"");
		sessionPanel.add(lblSession);
		
		JPanel endDatePanel = new JPanel();
		endDatePanel.setBackground(new Color(255, 255, 255));
		sheduleDetailsPanel.add(endDatePanel);
		
		JLabel lblEndDate = new JLabel("End Date: ");
		endDatePanel.add(lblEndDate);
		textFieldEndDate = new JDateChooser();
		textFieldEndDate.setPreferredSize(new Dimension(110, 20));
		textFieldEndDate.setDateFormatString("dd/MM/yyyy");
		endDatePanel.add(textFieldEndDate);
		
		JPanel addButtonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) addButtonPanel.getLayout();
		flowLayout.setVgap(0);
		addButtonPanel.setBackground(new Color(255, 255, 255));
		sheduleDetailsPanel.add(addButtonPanel);
		
		btnSchedule = new JButton("");
		btnSchedule.setAction(addToScheduleAction);
		addButtonPanel.add(btnSchedule);
		
		JSeparator separator = new JSeparator();
		wrapperOptionsPanel.add(separator, BorderLayout.SOUTH);
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(25, 25, 112));

	}

	public JDateChooser getTextFieldEndDate() {
		return textFieldEndDate;
	}

	public JDateChooser getTextFieldStartDate() {
		return textFieldStartDate;
	}

	public void setSession(int session) {
		this.session = session;
	}

	public void setTheaterNumber(int theater) {
		this.theaterNumber = theater;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public JLabel getLblMovieTitle() {
		return lblMovieTitle;
	}
	
	public JLabel getLblTheaterNumber() {
		return lblTheaterNumber;
	}

	public JLabel getLblSession() {
		return lblSession;
	}
		
		
	private class AddToScheduleAction extends AbstractAction {
        private MovieController movieController=MovieController.getInstance();//move

		public AddToScheduleAction() {
			putValue(NAME, "Add Movie to Schedule");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/add_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
			
		}

		public void actionPerformed(ActionEvent e) {
			
			//verify if the fields are empty and if the startDate is less than endDate
			if(textFieldStartDate.getDate()!=null && textFieldEndDate.getDate()!=null && session>0 && theaterNumber>0 && textFieldStartDate.getDate().compareTo(textFieldEndDate.getDate())<0){
				
				//convert from date object to String
				SimpleDateFormat textpaneDateFormat = new SimpleDateFormat("yyyy-MM-dd");//database date format
				Calendar c = Calendar.getInstance();
				c.setTime(textFieldStartDate.getDate());
				String startDate = textpaneDateFormat.format(c.getTime());
                Date startD = textFieldStartDate.getDate();
				c.setTime(textFieldEndDate.getDate());
				String endDate = textpaneDateFormat.format(c.getTime());
                Date endD = textFieldEndDate.getDate();
                
                //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                //System.out.println(format.format(startD));
                
                
                //DOVILES CONNECTOR - adds sessions to the database
//				try {
                    System.out.println(startD+", "+ session+", "+ theaterNumber+", "+ movieId+", "+ endD);
                    movieController.addSessions(startD, session, theaterNumber, movieId, endD);
					//TestDataCalls.insertMovieIntoSchedule(startDate, session, theaterNumber, movieId, endDate);//call class to add movie to schedule in db
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				startKinoPanel.getMovieManagerSchedule().updateSchedule();
				
			} else { //error verify fields data

				JOptionPane.showMessageDialog(frame, "Please verify the fields:\n" + "- Start Date\n" + "- End Date\n","System Message",
				JOptionPane.ERROR_MESSAGE);
				
			}
		}
	}
}
