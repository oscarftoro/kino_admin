package gui;

import guiDataTest.TestDataCalls;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

import controller.ReservationController;

@SuppressWarnings("serial")
public class ReservationInfoPanel extends JPanel {
	private JTextField txtMovie;
	private JTextField txtName;
	private JTextField txtDate;
	private JTextField txtSurname;
	private JTextField txtSession;
	private JTextField txtPhone;
	private JTextField txtSeats;
	private JTextField txtEmail;
	private JPanel dataPanel;
	private JLabel lblMovie;
	private JLabel lblSurname;
	private JLabel lblDate;
	private JLabel lblName;
	private JLabel lblSession;
	private JLabel lblPhone;
	private JLabel lblSeats;
	private JLabel lblEmail;
	private JPanel buttonPanel;
	private JButton btnPrintTicket;
	private JButton btnAddExtras;
	private JButton btnCancelReservation;
	private StartKinoPanel startKino;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JLabel lblNewLabel_2;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JLabel lblReservationDetails;
	private final Action action = new AddExtrasAction();
	private int reservationId;


	/**
	 * Create the panel.
	 * 
	 * @param startKinoPanel
	 */
	public ReservationInfoPanel(final StartKinoPanel startKinoPanel) {
		setBackground(new Color(255, 255, 255));
		this.startKino = startKinoPanel;

		setMinimumSize(new Dimension(10, 5));
		setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		dataPanel = new JPanel();
		dataPanel.setBackground(new Color(255, 255, 255));
		panel_2.add(dataPanel);
		dataPanel.setLayout(new BorderLayout(0, 0));

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		dataPanel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));

		lblReservationDetails = new JLabel(" Reservation Details");
		lblReservationDetails.setForeground(new Color(0, 0, 128));
		lblReservationDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_3.add(lblReservationDetails);

		panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_4.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));

		panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_12.add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_11.add(panel_5);
		panel_5.setLayout(new BorderLayout(1, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel_5.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(4, 0, 0, 6));

		lblMovie = new JLabel("Movie: ");
		lblMovie.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblMovie);
		lblMovie.setFont(new Font("Arial", Font.BOLD, 12));

		lblDate = new JLabel("Date: ");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDate);
		lblDate.setFont(new Font("Arial", Font.BOLD, 12));

		lblSession = new JLabel("  Session: ");
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSession);
		lblSession.setFont(new Font("Arial", Font.BOLD, 12));

		lblSeats = new JLabel("Seats: ");
		lblSeats.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSeats);
		lblSeats.setFont(new Font("Arial", Font.BOLD, 12));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_5.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 0, 0, 6));

		txtMovie = new JTextField();
		formatTextFields(txtMovie);
		panel_1.add(txtMovie);
		txtMovie.setColumns(10);

		txtDate = new JTextField();
		formatTextFields(txtDate);
		panel_1.add(txtDate);
		txtDate.setColumns(10);

		txtSession = new JTextField();
		formatTextFields(txtSession);
		panel_1.add(txtSession);
		txtSession.setColumns(10);

		txtSeats = new JTextField();
		formatTextFields(txtSeats);
		panel_1.add(txtSeats);
		txtSeats.setColumns(10);

		panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_11.add(panel_6);
		panel_6.setLayout(new BorderLayout(1, 0));

		panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_7, BorderLayout.WEST);
		panel_7.setLayout(new GridLayout(4, 0, 0, 6));

		lblName = new JLabel(" Name: ");
		lblName.setFont(new Font("Arial", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblName);

		lblSurname = new JLabel(" Surname: ");
		lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblSurname);
		lblSurname.setFont(new Font("Arial", Font.BOLD, 12));

		lblPhone = new JLabel("   Phone: ");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblPhone);
		lblPhone.setFont(new Font("Arial", Font.BOLD, 12));

		lblEmail = new JLabel("   e-mail: ");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblEmail);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));

		panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_6.add(panel_8);
		panel_8.setLayout(new GridLayout(4, 0, 0, 6));

		txtName = new JTextField();
		formatTextFields(txtName);
		panel_8.add(txtName);
		txtName.setColumns(10);

		txtSurname = new JTextField();
		formatTextFields(txtSurname);
		panel_8.add(txtSurname);
		txtSurname.setColumns(10);

		txtPhone = new JTextField();
		formatTextFields(txtPhone);
		panel_8.add(txtPhone);
		txtPhone.setColumns(10);

		txtEmail = new JTextField();
		formatTextFields(txtEmail);
		panel_8.add(txtEmail);
		txtEmail.setColumns(10);

		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 255, 255));
		panel_2.add(buttonPanel, BorderLayout.EAST);
		buttonPanel.setLayout(new BorderLayout(0, 0));

		panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		buttonPanel.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

		lblNewLabel_2 = new JLabel("Options");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblNewLabel_2);

		panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		buttonPanel.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(0, 1, 0, 10));

		btnPrintTicket = new JButton("Print Ticket");
		panel_10.add(btnPrintTicket);
        btnPrintTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reservationId = startKino.getReservationManagerPanel().getSelectedReservationId();
                ReservationController.getInstance().changeReservation(reservationId, "finished");
                startKinoPanel.getReservationManagerPanel().updateTable(null,null);
            }
        });

		btnAddExtras = new JButton("Add Extras");
		btnAddExtras.setAction(action);
		panel_10.add(btnAddExtras);

		btnCancelReservation = new JButton("Cancel Reservation");
		panel_10.add(btnCancelReservation);
        btnCancelReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int reservationId = startKino.getReservationManagerPanel().getSelectedReservationId();
                ReservationController.getInstance().changeReservation(reservationId, "canceled");
                startKinoPanel.getReservationManagerPanel().updateTable(null,null);
            }
        });

		panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		buttonPanel.add(panel_13, BorderLayout.EAST);

		panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		buttonPanel.add(panel_14, BorderLayout.WEST);

	}

    public void setReservationDetails(int reservationId){

        ArrayList<Object> reservation = ReservationController.getInstance().getReservationData(reservationId);

        //ArrayList<Object> reservation2 = null;
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		txtMovie.setText((String) reservation.get(0));
		txtDate.setText((String) reservation.get(1));
		txtSession.setText(reservation.get(2)+"");
		txtSeats.setText(reservation.get(3)+"");
		txtName.setText((String) reservation.get(4));
		txtSurname.setText((String) reservation.get(5));
		txtPhone.setText((String) reservation.get(6));
		txtEmail.setText((String) reservation.get(7));
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
        setReservationDetails(reservationId);
	}

	private void formatTextFields(JTextField t){
		t.setFont(new Font("Tahoma", Font.BOLD, 11));
		t.setForeground(new Color(0, 0, 128));
	}

	private class AddExtrasAction extends AbstractAction {
		public AddExtrasAction() {
			putValue(NAME, "Add Extras");
			//putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			startKino.getReservationManagerPanel().getExtraServicesWrapperPanel().add(startKino.getExtraServicesPanel(), BorderLayout.CENTER);
			startKino.getReservationManagerPanel().getExtraServicesWrapperPanel().updateUI();
		}
	}


}
