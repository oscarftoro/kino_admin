package gui;

import guiDataTest.ReservationSeats;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;

public class StartKinoPanel { 
	
	private JFrame frameKino;
	private SodaPanel sodaPanel = new SodaPanel(this);
	private PopcornPanel popcornPanel = new PopcornPanel(this);
	private CandyPanel candyPanel = new CandyPanel(this);
	private MoviePricesPanel moviePricesPanel = new MoviePricesPanel(this);
	private JTabbedPane tabbedPane;
	private ReservationInfoPanel reservationInfoPanel = new ReservationInfoPanel(this);
	private ExtraServicesPanel extraServicesPanel = new ExtraServicesPanel(this);
	private SchedulePanel reservationSchedule = new SchedulePanel(this,1); //reservation manager schedule
	private NewReservationPanel nrp = new NewReservationPanel(this);
	private ReservationManagerPanel rmp = new ReservationManagerPanel(this);
	private TheaterSeatsPanel theaterSeatsPanel = new TheaterSeatsPanel(this);
	private SchedulePanel movieManagerSchedule = new SchedulePanel(this,2);//movie manager schedule
	private MovieDetailsPanel movieDetailsPanel = new MovieDetailsPanel(this);
	private MovieSchedulePlanPanel movieSchedulePlanPanel = new MovieSchedulePlanPanel(this);
	private MovieManagerPanel movieManagerPanel = new MovieManagerPanel(this);
	private ReservationSeats reservationSeats = new ReservationSeats();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartKinoPanel window = new StartKinoPanel();
					window.frameKino.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartKinoPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameKino = new JFrame();
		frameKino.getContentPane().setBackground(new Color(255, 255, 255));
		frameKino.setTitle("Kino");
		frameKino.setBounds(100, 100, 1126, 702);
		frameKino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameKino.getContentPane().setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		frameKino.getContentPane().add(tabbedPane, BorderLayout.CENTER);		

		tabbedPane.addTab("Reservation Manager", null, rmp, null);

		tabbedPane.addTab("Movie Manager", null, movieManagerPanel, null);
		
		JPanel systemPanel = new JPanel();//to be removed
		tabbedPane.addTab("System Configuration", null, systemPanel, null);	
		
		UIManager.getDefaults().put("TableHeader.cellBorder",new MatteBorder(0, 0, 2, 0, (Color) new Color(100, 149, 237)));//changes all tables in the application
		tabListener();

	}
	
	private void tabListener(){
		//get the clicked tab index
		tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	            
	        	//Reservation Manager --> update reservations table data
	            if(tabbedPane.getSelectedIndex()==0){
	            	//getMovieManagerPanel().setMovieTableData();
	            	getReservationManagerPanel().updateTable(null, null);
	            	getReservationManagerPanel().getExtraServicesWrapperPanel().removeAll();
	            	getReservationManagerPanel().getReservationsInfoPanel().removeAll();
	            	getReservationManagerPanel().updateUI();
	            	
	            }
	            //Movie Manager --> update movie table data
	            if(tabbedPane.getSelectedIndex()==1){
	            	getMovieManagerPanel().setMovieTableData(); 
	            	getMovieManagerPanel().getTabbedPane().removeAll();
	            	getMovieManagerPanel().getTabbedPane().updateUI();
	            }
	          
	            
	        }
	    });
	}

	public SchedulePanel getSchedule() {
		return reservationSchedule;
	}
	
	public NewReservationPanel getNewReservationPanel() {
		return nrp;
	}
	
	public ReservationManagerPanel getReservationManagerPanel() {
		return rmp;
	}

	public TheaterSeatsPanel getTheaterPanel() {
		return theaterSeatsPanel;
	}	
	
	public SchedulePanel getMovieManagerSchedule() {
		return movieManagerSchedule;
	}
	
	public MovieSchedulePlanPanel getMovieSchedulePlan() {
		return movieSchedulePlanPanel;
	}
	
	public MovieDetailsPanel getMovieDetailsPanel() {
		return movieDetailsPanel;
	}
	
	public MovieManagerPanel getMovieManagerPanel() {
		return movieManagerPanel;
	}

	public ReservationSeats getReservationSeats() {
		return reservationSeats;
	}
	
	public ExtraServicesPanel getExtraServicesPanel() {
		return extraServicesPanel;
	}
	public ReservationInfoPanel getReservationInfoPanel() {
		return reservationInfoPanel;
	}
}
