package gui;

import controller.MovieController;
import guiDataTest.TestDataCalls;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Action;

import sun.swing.DefaultLookup;

public class MovieDetailsPanel extends JPanel {

    private StartKinoPanel startKino;
    private JComboBox genreComboBox;
    private JTextField yearTextField;
	private JTextField languageTextField;
    private JTextField countryTextField;
    private JComboBox ageRestrictionComboBox;
	private JComboBox versionComboBox;
    private JTextField lengthTextField;
    private JTextField titleTextField;
    private JTextPane storyLineTextPane;
	private JDateChooser releaseDateTextField;
    private JLabel lblMovieTitle;
    private JButton btnSaveNewMovie;
	private JButton btnCancel;
    private JButton btnEdit;
    private final Action saveAction = new SaveNewMovieAction();
    private final Action cancelAction = new CancelEditAction();
    private final Action editAction = new EditAction();
    private int movieId;
    private JButton btnSaveEditedMovie;
    private final Action saveEditedMovieAction = new SaveEditedMovieAction();
    private final Action cancelNewMovieAction = new CancelNewMovieAction();
    private JButton btnCancelNew;
    private JFrame frame;
    

	public MovieDetailsPanel(StartKinoPanel startKino) {
		this.startKino = startKino;
		
		setBorder(null);
        setLayout(new BorderLayout(0, 0));
        
        JPanel movieTitlePanel = new JPanel();
        movieTitlePanel.setBackground(new Color(255, 255, 255));
        add(movieTitlePanel, BorderLayout.NORTH);
        movieTitlePanel.setLayout(new BorderLayout(0, 20));
        
        JPanel panel_18 = new JPanel();
        movieTitlePanel.add(panel_18, BorderLayout.NORTH);
        panel_18.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_11 = new JPanel();
        panel_18.add(panel_11, BorderLayout.NORTH);
        panel_11.setBackground(new Color(255, 255, 255));
        panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        lblMovieTitle = new JLabel("NEW MOVIE");
        panel_11.add(lblMovieTitle);
        lblMovieTitle.setForeground(new Color(25, 25, 112));
        lblMovieTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblMovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(100, 149, 237));
        panel_18.add(separator, BorderLayout.CENTER);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        movieTitlePanel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(5, 5));
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(255, 255, 255));
        panel_1.add(panel_4, BorderLayout.NORTH);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));
        
        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(255, 255, 255));
        panel_4.add(panel_5);
        panel_5.setLayout(new BorderLayout(2, 0));
        
        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(255, 255, 255));
        panel_5.add(panel_9, BorderLayout.WEST);
        panel_9.setLayout(new GridLayout(0, 1, 0, 5));
        
        JLabel lblNewLabel_9 = new JLabel("                       Title:");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel_9.add(lblNewLabel_9);
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
        
        JPanel panel_10 = new JPanel();
        panel_5.add(panel_10, BorderLayout.CENTER);
        panel_10.setLayout(new GridLayout(0, 1, 0, 5));
        
        titleTextField = new JTextField();
        titleTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        titleTextField.setForeground(new Color(0, 0, 128));
        panel_10.add(titleTextField);
        titleTextField.setHorizontalAlignment(SwingConstants.LEFT);
        titleTextField.setColumns(30);
        
        JPanel storyLine = new JPanel();
        storyLine.setBackground(new Color(255, 255, 255));
        add(storyLine, BorderLayout.CENTER);
        storyLine.setLayout(new BorderLayout(30, 30));
        
        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(255, 255, 255));
        storyLine.add(panel_7, BorderLayout.NORTH);
        panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(255, 255, 255));
        storyLine.add(panel_8, BorderLayout.CENTER);
        panel_8.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_15 = new JPanel();
        panel_15.setBackground(new Color(255, 255, 255));
        panel_8.add(panel_15, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Story Line");
        panel_15.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel panel_14 = new JPanel();
        panel_14.setBorder(new LineBorder(new Color(100, 149, 237), 2));
        panel_8.add(panel_14, BorderLayout.CENTER);
        panel_14.setLayout(new BorderLayout(0, 0));
        
        storyLineTextPane = new JTextPane();
        storyLineTextPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
        storyLineTextPane.setForeground(new Color(0, 0, 128));
        panel_14.add(storyLineTextPane, BorderLayout.CENTER);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(255, 255, 255));
        storyLine.add(panel_6, BorderLayout.SOUTH);
        
        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(255, 255, 255));
        storyLine.add(panel_12, BorderLayout.WEST);
        
        JPanel panel_13 = new JPanel();
        panel_13.setBackground(new Color(255, 255, 255));
        storyLine.add(panel_13, BorderLayout.EAST);
        
        JPanel movieDetailsPanel = new JPanel();
        movieDetailsPanel.setBackground(new Color(255, 255, 255));
        add(movieDetailsPanel, BorderLayout.WEST);
        movieDetailsPanel.setLayout(new BorderLayout(0, 20));
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 0, 139));
        panel.setBackground(new Color(255, 255, 255));
        movieDetailsPanel.add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(2, 0));
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel.add(panel_2, BorderLayout.WEST);
        panel_2.setLayout(new GridLayout(8, 1, 0, 5));
        
        JLabel lblNewLabel_1 = new JLabel("Genre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Year:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Language:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Country:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("Release Date:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("  Age Restriction:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Version:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_7);
        
        JLabel lblNewLabel_8 = new JLabel("Length:");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_8.setBackground(new Color(255, 255, 255));
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
        panel_2.add(lblNewLabel_8);
        
        JPanel panel_3 = new JPanel();
        panel_3.setForeground(new Color(0, 0, 139));
        panel_3.setBackground(new Color(255, 255, 255));
        panel.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new GridLayout(8, 1, 0, 5));
        
        genreComboBox = new JComboBox();
        genreComboBox.setBackground(new Color(255, 255, 255));
        genreComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary", "Drama", "Family", "Fantasy", "Film-Noir", "Game-Show", "History", "Horror", "Music", "Musical", "Mystery", "News", "Reality-TV", "Romance", "Sci-Fi", "Sport", "Talk-Show", "Thriller", "War", "Western"}));
        genreComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        genreComboBox.setForeground(new Color(0, 0, 128));
        panel_3.add(genreComboBox);
        
        yearTextField = new JTextField();
        yearTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        yearTextField.setForeground(new Color(0, 0, 128));
        panel_3.add(yearTextField);
        yearTextField.setColumns(10);
        
        languageTextField = new JTextField();
        languageTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        languageTextField.setForeground(new Color(0, 0, 128));
        panel_3.add(languageTextField);
        languageTextField.setColumns(10);
        
        countryTextField = new JTextField();
        countryTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        countryTextField.setForeground(new Color(0, 0, 128));
        panel_3.add(countryTextField);
        countryTextField.setColumns(10);
        
        releaseDateTextField = new JDateChooser();
        releaseDateTextField.setForeground(new Color(0, 0, 139));
        releaseDateTextField.setDateFormatString("dd/MM/yyyy");
        ((JTextFieldDateEditor)releaseDateTextField.getDateEditor()).setFont(new Font("Tahoma", Font.BOLD, 11));
        
        panel_3.add(releaseDateTextField);
        
        ageRestrictionComboBox = new JComboBox();
        ageRestrictionComboBox.setBackground(new Color(255, 255, 255));
        ageRestrictionComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "A", "7", "11", "15"}));
        ageRestrictionComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        ageRestrictionComboBox.setForeground(new Color(0, 0, 128));
        panel_3.add(ageRestrictionComboBox);
        
        versionComboBox = new JComboBox();
        versionComboBox.setBackground(new Color(255, 255, 255));
        versionComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "2D", "3D"}));
        versionComboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        versionComboBox.setForeground(new Color(0, 0, 128));
        panel_3.add(versionComboBox);
        
        lengthTextField = new JTextField();
        lengthTextField.setFont(new Font("Tahoma", Font.BOLD, 11));
        lengthTextField.setForeground(new Color(0, 0, 128));
        panel_3.add(lengthTextField);
        lengthTextField.setColumns(10);
        
        JPanel panel_19 = new JPanel();
        panel_19.setBackground(new Color(255, 255, 255));
        movieDetailsPanel.add(panel_19, BorderLayout.CENTER);
        panel_19.setLayout(new BorderLayout(0, 5));
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(100, 149, 237));
        panel_19.add(separator_1, BorderLayout.NORTH);
        
        JPanel panel_20 = new JPanel();
        panel_20.setBackground(new Color(255, 255, 255));
        FlowLayout flowLayout_2 = (FlowLayout) panel_20.getLayout();
        flowLayout_2.setHgap(0);
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        panel_19.add(panel_20);
        
        btnSaveEditedMovie = new JButton("New button");
        btnSaveEditedMovie.setAction(saveEditedMovieAction);
        panel_20.add(btnSaveEditedMovie);
        
        btnSaveNewMovie = new JButton("Save");
        btnSaveNewMovie.setAction(saveAction);
        panel_20.add(btnSaveNewMovie);
        
        btnEdit = new JButton("Edit");
        btnEdit.setAction(editAction);
        panel_20.add(btnEdit);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setAction(cancelAction);
        panel_20.add(btnCancel);
        
        btnCancelNew = new JButton("Cancel New");
        btnCancelNew.setAction(cancelNewMovieAction);
        panel_20.add(btnCancelNew);

    }

    public JButton getBtnCancelNew() {
		return btnCancelNew;
	}

	public JComboBox getGenreComboBox() {
		return genreComboBox;
	}
    
    public JComboBox getAgeRestrictionComboBox() {
		return ageRestrictionComboBox;
	}

	public JComboBox getVersionComboBox() {
		return versionComboBox;
	}

	public JTextField getYearTextField() {
		return yearTextField;
	}


	public JTextField getLanguageTextField() {
		return languageTextField;
	}


	public JTextField getCountryTextField() {
		return countryTextField;
	}


	public JTextField getLengthTextField() {
		return lengthTextField;
	}


	public JTextField getTitleTextField() {
		return titleTextField;
	}


	public JDateChooser getReleaseDateTextField() {
		return releaseDateTextField;
	}
	
	public JLabel getLblMovieTitle() {
		return lblMovieTitle;
	}
	
    public JTextPane getStoryLineTextPane() {
		return storyLineTextPane;
	}
    
    public JButton getBtnSaveNewMovie() {
		return btnSaveNewMovie;
	}

    public JButton getBtnSaveEditedMovie() {
		return btnSaveEditedMovie;
	}
    
	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}
    
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	//reset textFields
	public void resetTextFields(){
		getLblMovieTitle().setText("");
		getTitleTextField().setText("");
		getYearTextField().setText("");
		getStoryLineTextPane().setText("");
		getLanguageTextField().setText("");
		getCountryTextField().setText("");
		getLengthTextField().setText("");
		getGenreComboBox().setSelectedItem("");
		getAgeRestrictionComboBox().setSelectedItem("");
		getVersionComboBox().setSelectedItem("");
		getReleaseDateTextField().setDate(null);
		
	}
	
	//enable or disable textFields
	public void setEditableTextFields(boolean b){
		getTitleTextField().setEditable(b);
		getYearTextField().setEditable(b);
		getStoryLineTextPane().setEditable(b);
		getLanguageTextField().setEditable(b);
		getCountryTextField().setEditable(b);
		getLengthTextField().setEditable(b);
		getGenreComboBox().setEnabled(b);
		getAgeRestrictionComboBox().setEnabled(b);
		getVersionComboBox().setEnabled(b);
		UIManager.put("ComboBox.disabledForeground", new Color(0, 0, 128));
		getReleaseDateTextField().getCalendarButton().setEnabled(b);//disable calendar button
		getReleaseDateTextField().setEnabled(b);//disable calendar textField
		((JTextFieldDateEditor)releaseDateTextField.getDateEditor()).setDisabledTextColor(new Color(0, 0, 128));//set disable calendar textField color	
	}
	
	
	private class SaveNewMovieAction extends AbstractAction {
		public SaveNewMovieAction() {
			putValue(NAME, "Save");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/save_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
            
			//check if all the fields have data
			if(getReleaseDateTextField().getDate()!=null && getGenreComboBox().getSelectedItem()!=null && getVersionComboBox().getSelectedItem()!=null &&
					getAgeRestrictionComboBox().getSelectedItem()!=null && !getTitleTextField().getText().isEmpty() && !getYearTextField().getText().isEmpty() &&
					!getStoryLineTextPane().getText().isEmpty() && !getLanguageTextField().getText().isEmpty() && !getCountryTextField().getText().isEmpty() ){
				
				
				String genre = (String) getGenreComboBox().getSelectedItem();//parse Object to String
				String version = (String) getVersionComboBox().getSelectedItem();
				String ageLimit = (String) getAgeRestrictionComboBox().getSelectedItem();
		        String title  =  getTitleTextField().getText();
		        String year = getYearTextField().getText();
		        String storyLine = getStoryLineTextPane().getText();
		        String  language = getLanguageTextField().getText();
		        String country =  getCountryTextField().getText();
		        Date releaseDate = getReleaseDateTextField().getDate();
				MovieController.getInstance().addMovie(title,year,genre,storyLine,language,country,releaseDate,ageLimit,version);
				startKino.getMovieManagerPanel().setMovieTableData();//update table
				startKino.getMovieManagerPanel().getTabbedPane().removeAll();//clean panel
				startKino.getMovieManagerPanel().getTabbedPane().updateUI();

			} else { //error: verify data fields

				JOptionPane.showMessageDialog(frame, "Please make sure all fields are filled.","System Message",
				JOptionPane.ERROR_MESSAGE);
				
			}						
			
	    }
	}
	
	private class CancelEditAction extends AbstractAction {
		public CancelEditAction() {
			putValue(NAME, "Cancel");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/cancel_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setEditableTextFields(false);
			getBtnEdit().setVisible(true);
			getBtnCancel().setVisible(false);
			getBtnSaveNewMovie().setVisible(false);
			getBtnSaveEditedMovie().setVisible(false);
			getBtnCancelNew().setVisible(false);
			
		}
	}
	
	private class EditAction extends AbstractAction {
		public EditAction() {
			putValue(NAME, "Edit");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/edit.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			setEditableTextFields(true);
			getBtnEdit().setVisible(false);
			getBtnSaveNewMovie().setVisible(false);
			getBtnSaveEditedMovie().setVisible(true);
			getBtnCancel().setVisible(true);
			getBtnCancelNew().setVisible(false);
			
		}
	}

	private class SaveEditedMovieAction extends AbstractAction {
		public SaveEditedMovieAction() {
			putValue(NAME, "Save");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/save_16.png")));
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
				String genre = (String) getGenreComboBox().getSelectedItem();//parse Object to String
				String version = (String) getVersionComboBox().getSelectedItem();
				String ageLimit = (String) getAgeRestrictionComboBox().getSelectedItem();
		        String title  =  getTitleTextField().getText();
		        String year = getYearTextField().getText();
		        String storyLine = getStoryLineTextPane().getText();
		        String  language = getLanguageTextField().getText();
		        String country =  getCountryTextField().getText();
		        Date releaseDate = getReleaseDateTextField().getDate();
		        
				MovieController.getInstance().updateMovie(movieId, title,year,genre,storyLine,language,country,releaseDate,ageLimit,version);
				
				//update panels
				setEditableTextFields(false);
				getBtnEdit().setVisible(true);
				getBtnCancel().setVisible(false);
				getBtnSaveNewMovie().setVisible(false);
				getBtnSaveEditedMovie().setVisible(false);
				getBtnCancelNew().setVisible(false);
				startKino.getMovieManagerPanel().setMovieTableData();
		
			
		}
	}
	private class CancelNewMovieAction extends AbstractAction {
		public CancelNewMovieAction() {
			putValue(NAME, "Cancel");
			putValue(SMALL_ICON, new ImageIcon(MovieSchedulePlanPanel.class.getResource("/images/cancel_16.png")));
		}
		public void actionPerformed(ActionEvent e) {
			startKino.getMovieManagerPanel().getTabbedPane().removeAll();//clean panel
			startKino.getMovieManagerPanel().getTabbedPane().updateUI();
			
		}
	}
}
