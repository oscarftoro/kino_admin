package gui;

import controller.MovieController;
import guiDataTest.TableData;
import guiDataTest.TestDataCalls;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JTabbedPane;
import java.awt.Color;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JDateChooser;

public class MovieManagerPanel extends JPanel {

	private JTable movieListTable;
	private final Action newMovieAction = new NewMovieAction();
	private JPanel formsPanel;
	private StartKinoPanel startKinoPanel;
	private JPanel headerPanel;
	private JPanel moviesListPanel;
	private JPanel mainContainer;
	private JPanel wrapperPanel;
	private JButton btnNewMovie;
	private JTabbedPane tabbedPane;
	private JPanel centerPanel;
	private JPanel newMoviePanel;

	
	public MovieManagerPanel(StartKinoPanel startKinoPanel) {
		this.startKinoPanel = startKinoPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		mainContainer = new JPanel();
		add(mainContainer, BorderLayout.CENTER);
		mainContainer.setLayout(new BorderLayout(0, 0));
		
		wrapperPanel = new JPanel();
		wrapperPanel.setBackground(new Color(255, 255, 255));
		mainContainer.add(wrapperPanel);
		wrapperPanel.setLayout(new BorderLayout(1, 0));
		
		moviesListPanel = new JPanel();
		wrapperPanel.add(moviesListPanel, BorderLayout.WEST);
		moviesListPanel.setLayout(new BorderLayout(0, 10));
		
		JPanel tablePanel = new JPanel();
		moviesListPanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		centerPanel = new JPanel();
		centerPanel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(100, 149, 237)));
		centerPanel.setBackground(new Color(255, 255, 255));
		tablePanel.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 5));
		
		movieListTable = new JTable();
		centerPanel.add(movieListTable);
		centerPanel.add(movieListTable.getTableHeader(), BorderLayout.NORTH);
		
		newMoviePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) newMoviePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		newMoviePanel.setBackground(new Color(255, 255, 255));
		centerPanel.add(newMoviePanel, BorderLayout.SOUTH);
		
		btnNewMovie = new JButton("New Movie");
		newMoviePanel.add(btnNewMovie);
		btnNewMovie.setAction(newMovieAction);
		
		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(255, 255, 255));
		wrapperPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 15));
		
		JLabel lblTitle = new JLabel("Movie Manager");
		lblTitle.setForeground(new Color(0, 0, 128));
		headerPanel.add(lblTitle);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 21));
		
		formsPanel = new JPanel();
		formsPanel.setBorder(null);
		formsPanel.setBackground(new Color(255, 255, 255));
		wrapperPanel.add(formsPanel, BorderLayout.CENTER);
		formsPanel.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBackground(new Color(255, 255, 255));
		formsPanel.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.setComponentOrientation(getComponentOrientation().RIGHT_TO_LEFT);
		
		
		
	}

	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}


	public JPanel getFormsPanel() {
		return formsPanel;
	}


	//***************test method to populate the movies table---> to be replaced with a controller call****************
	private DefaultTableModel getMovieList() {
//		try {
			//String q = "SELECT DISTINCT movies.id, title, year, genre FROM movies, schedule WHERE movies.id=schedule.id ORDER BY title ASC";
			//String q = "SELECT DISTINCT movies.id, title, year, genre FROM movies ORDER BY title ASC";
			//String [] tableHeaders = {"Id", "Title", "Year", "Genre"};
            Vector<String> tableHeaders = new Vector<>(Arrays.asList(new String[]{"Id", "Title", "Year", "Genre"}));
			//return TableData.buildTableModel(q, tableHeaders);//-->> TODO: connect to controller after testing
            Vector<Vector<Object>> values = MovieController.getInstance().getMoviesSortedByTitle();
            return new DefaultTableModel(values,tableHeaders);
			
//		} catch (SQLException e) {
//            e.printStackTrace();
//        }
//		return null;
	}
	

	
	private void movieTableSetup(){

		movieListTable.addMouseListener(new MouseAdapter() { //table listener
			@Override
			public void mouseClicked(MouseEvent e) {
				//get movie Id
				int row=movieListTable.rowAtPoint(e.getPoint());
				startKinoPanel.getMovieSchedulePlan().setMovieId((int) movieListTable.getValueAt(row,0));//pass the movie Id to the schedule panel
				startKinoPanel.getMovieSchedulePlan().getLblMovieTitle().setText((String) movieListTable.getValueAt(row,1));//set label in schedule panel
				
				try {
					setMovieDataDetails((int) movieListTable.getValueAt(row,0));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				startKinoPanel.getMovieDetailsPanel().getBtnEdit().setVisible(true);
				startKinoPanel.getMovieDetailsPanel().getBtnCancel().setVisible(false);
				startKinoPanel.getMovieDetailsPanel().getBtnSaveNewMovie().setVisible(false);
				startKinoPanel.getMovieDetailsPanel().getBtnSaveEditedMovie().setVisible(false);
				startKinoPanel.getMovieDetailsPanel().setEditableTextFields(false);
				startKinoPanel.getMovieDetailsPanel().getBtnCancelNew().setVisible(false);
				//the tabbedPanes need the selected movie id
				tabbedPane.addTab("Movie Details", null, startKinoPanel.getMovieDetailsPanel(), null);
				tabbedPane.addTab("Schedule Plan", null, startKinoPanel.getMovieSchedulePlan(), null);
				startKinoPanel.getMovieDetailsPanel().setMovieId((int) movieListTable.getValueAt(row,0));//pass the movie Id to movieDetailsPanel
			}
		});
			
        //set table columns width
		int[] columnsWidth = { 0, 190, 50, 100 };//columns size
		TableFormat.formatTable(columnsWidth, movieListTable);//format table look
		boolean[] columnEditables = new boolean[] {
				false, false, false
		};
		
			
	}
	
	
	
	
	public JPanel getMainContainer() {
		return mainContainer;
	}
	
	public JPanel getWrapperPanel() {
		return wrapperPanel;
	}
	
	public void setMovieTableData(){
		//update movies table
		movieListTable.setModel(getMovieList());
		movieTableSetup();//setup table configuration
	}

	public void setMovieDataDetails(int movieId) throws SQLException{

		String[] rs = TestDataCalls.getMovieData(movieId);
		
		startKinoPanel.getMovieDetailsPanel().getLblMovieTitle().setText(rs[0]);
		startKinoPanel.getMovieDetailsPanel().getTitleTextField().setText(rs[0]);
		startKinoPanel.getMovieDetailsPanel().getYearTextField().setText(rs[1]);
		startKinoPanel.getMovieDetailsPanel().getStoryLineTextPane().setText(rs[3]);
		startKinoPanel.getMovieDetailsPanel().getLanguageTextField().setText(rs[4]);
		startKinoPanel.getMovieDetailsPanel().getCountryTextField().setText(rs[5]);
		startKinoPanel.getMovieDetailsPanel().getLengthTextField().setText(rs[9]);
		startKinoPanel.getMovieDetailsPanel().getGenreComboBox().setSelectedItem(rs[2]);
		startKinoPanel.getMovieDetailsPanel().getAgeRestrictionComboBox().setSelectedItem(rs[7]);
		startKinoPanel.getMovieDetailsPanel().getVersionComboBox().setSelectedItem(rs[8]);
		
		//parse the date from string to date Object to use in the JDateChooser
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		Date date = null;
		try {
			date = (java.util.Date)formatter.parse(rs[6]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startKinoPanel.getMovieDetailsPanel().getReleaseDateTextField().setDate(date);

	}
	
	
	
	private class NewMovieAction extends AbstractAction {
		public NewMovieAction() {
			putValue(NAME, "New Movie");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/add_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
	
			tabbedPane.removeAll();
			startKinoPanel.getMovieDetailsPanel().setEditableTextFields(true);
			startKinoPanel.getMovieDetailsPanel().resetTextFields();
			startKinoPanel.getMovieDetailsPanel().getLblMovieTitle().setText("NEW MOVIE");
			startKinoPanel.getMovieDetailsPanel().getBtnEdit().setVisible(false);
			startKinoPanel.getMovieDetailsPanel().getBtnCancel().setVisible(false);
			startKinoPanel.getMovieDetailsPanel().getBtnSaveNewMovie().setVisible(true);
			startKinoPanel.getMovieDetailsPanel().getBtnCancelNew().setVisible(true);
			startKinoPanel.getMovieDetailsPanel().getBtnSaveEditedMovie().setVisible(false);
			tabbedPane.addTab("New Movie", null, startKinoPanel.getMovieDetailsPanel(), null);
			tabbedPane.updateUI();
			

		}
	}

	
}
