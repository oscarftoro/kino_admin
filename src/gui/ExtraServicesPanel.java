package gui;

import controller.ExtraServiceController;
import controller.MovieController;
import controller.ReservationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

public class ExtraServicesPanel extends JPanel {
    ExtraServiceController extraServiceController = ExtraServiceController.getInstance();
	private JTable table;
	private StartKinoPanel startKinoPanel;
    private JTextField quantityField;
    private JComboBox comboBoxItem;
    private JComboBox comboBox_subItem;
    private JButton btnAdd;
    private JButton btnDelete;
    private JPanel panel_south;
    private JPanel panel_east;
    private Vector<Vector<Object>> dataVector = new Vector<>();
    private ArrayList<Object[]> extras;
    private String[] extraItems;
    private int extraServiceID = 0;
    private int reservationId = 0;
    JPanel tablePanel;
    JLabel lblTotalInt;

    public ExtraServicesPanel(StartKinoPanel stp) {
		this.startKinoPanel = stp;
		setLayout(new BorderLayout(0, 0));
		JPanel panel_north = new JPanel();
		add(panel_north, BorderLayout.NORTH);

         //Dovile has added a textField for quantity
        quantityField = new JTextField();
        quantityField.setPreferredSize(new Dimension(35, 27));
        panel_north.add(quantityField);

		comboBoxItem = new JComboBox();
		comboBoxItem.setModel(new DefaultComboBoxModel(new String[] {"...", "Drinks", "Candy", "Popcorn"}));
        comboBoxItem.setPreferredSize(new Dimension(100,27));
        comboBoxItem.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!comboBoxItem.getSelectedItem().equals("...")){
                    extras = extraServiceController.getExtraServices( comboBoxItem.getSelectedIndex());
                    extraItems = new String[extras.size()];
                    int i=0;
                    for (Object[] s: extras){
                        extraItems[i] = (String) s[1];
                        i++;
                    }

                    comboBox_subItem.setModel(new DefaultComboBoxModel(extraItems));
                }
            }
        });
		panel_north.add(comboBoxItem);

		comboBox_subItem = new JComboBox();
        comboBox_subItem.setModel(new DefaultComboBoxModel());
        comboBox_subItem.setPreferredSize(new Dimension(100,27));
		//comboBox_subItem.setModel(new DefaultComboBoxModel(new String[] {"SubItem1", "SubItem2", "SubItem3"}));
		panel_north.add(comboBox_subItem);

		btnAdd = new JButton("Add");
		panel_north.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //int extraServiceID = 0;
                for (Object[] o: extras){
                    if (o[1]== comboBox_subItem.getSelectedItem()){
                        extraServiceID = (int)o[0];
                    }
                }
                extraServiceController.makeOrder(extraServiceID,Integer.parseInt(quantityField.getText()),startKinoPanel.getReservationManagerPanel().getSelectedReservationId());
                updateTable();
                quantityField.setText("");
                comboBoxItem.setSelectedIndex(0);
                comboBox_subItem.removeAllItems();
                calculateTotal();
                calculateTotal();
            }
        });

        btnDelete = new JButton("Delete");
        panel_north.add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int orderId = (int)table.getValueAt(table.getSelectedRow(),0);
                ExtraServiceController.getInstance().deleteOrder(orderId);
                updateTable();
                calculateTotal();
            }
        });

		panel_south = new JPanel();
		add(panel_south, BorderLayout.SOUTH);
		panel_south.setLayout(new BorderLayout(0, 0));

		panel_east = new JPanel();
		panel_south.add(panel_east, BorderLayout.EAST);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_east.add(lblTotal);

		lblTotalInt = new JLabel("......");
		lblTotalInt.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_east.add(lblTotalInt);

		JPanel panel_center = new JPanel();
		panel_south.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

//		JButton button = new JButton("+");
//		panel_center.add(button);
//
//		JButton button_1 = new JButton("-");
//		panel_center.add(button_1);
//
//		JButton btnX = new JButton("X");
//		panel_center.add(btnX);
//
//		JButton btnConfirm = new JButton("Confirm");
//		panel_center.add(btnConfirm);
//
//		JButton btnCancel = new JButton("Cancel");
//		panel_center.add(btnCancel);

		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));
		add(tablePanel, BorderLayout.CENTER);

		table = new JTable();
		tablePanel.add(table , BorderLayout.CENTER);
		tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
		//updateTable();
		//this.setVisible(false);
	}
    public void setReservationId(int reservationId){
        this.reservationId = reservationId;
    }

	public void updateTable(){
       // extraServiceID = reservationId;
        Vector<String> columnNames = new Vector(Arrays.asList(new String[]{"","Quantity", "Description", "Price", "Subtotal"}));
        dataVector = ExtraServiceController.getInstance().getOrders(reservationId);
        table.setModel(new DefaultTableModel(dataVector,columnNames));
		table.getColumnModel().getColumn(2).setPreferredWidth(495);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
	}
    public void calculateTotal(){
        String movieTitle = startKinoPanel.getReservationManagerPanel().getReservationsTable();
        int reservationId = startKinoPanel.getReservationManagerPanel().getSelectedReservationId();
        //System.out.println("MOVIE TITLE SELECTED: "+movieTitle);
        double moviePrice = ReservationController.getInstance().getTotalPrice(movieTitle, reservationId);
        lblTotalInt.setText(String.valueOf(moviePrice));
    }

}
