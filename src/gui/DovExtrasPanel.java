package gui;

import controller.ExtraServiceController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Do
 * Date: 08/05/13
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
//public class DovExtrasPanel {
//
//        ExtraServiceController extraServiceController = ExtraServiceController.getInstance();
//        private JTable table;
//        private StartKinoPanel startKinoPanel;
//        private JTextField quantityField;
//        private JComboBox comboBoxItem;
//        private JComboBox comboBox_subItem;
//        private JButton btnAdd;
//        private JPanel panel_south;
//        private JPanel panel_east;
//        private Vector<Vector<Object>> dataVector = new Vector<>();
//        private double price = 25.20;
//        private ArrayList<Object[]> extras;
//        private String[] extraItems;
//        private int extraServiceID = 0;
//
//        public ExtraServicesPanel(StartKinoPanel stp) {
//            this.startKinoPanel = stp;
//            setLayout(new BorderLayout(0, 0));
//            JPanel panel_north = new JPanel();
//            add(panel_north, BorderLayout.NORTH);
//
//            //Dovile has added a textField for quantity
//            quantityField = new JTextField();
//            quantityField.setPreferredSize(new Dimension(35, 27));
//            panel_north.add(quantityField);
//
//            comboBoxItem = new JComboBox();
//            comboBoxItem.setModel(new DefaultComboBoxModel(new String[] {"...", "Drinks", "Candy", "Popcorn"}));
//            comboBoxItem.setPreferredSize(new Dimension(100,27));
//            comboBoxItem.addItemListener(new ItemListener() {
//                @Override
//                public void itemStateChanged(ItemEvent e) {
//                    if (!comboBoxItem.getSelectedItem().equals("...")){
//                        extras = extraServiceController.getExtraServices( comboBoxItem.getSelectedIndex());
//                        extraItems = new String[extras.size()];
//                        int i=0;
//                        for (Object[] s: extras){
//                            extraItems[i] = (String) s[1];
//                            i++;
//                        }
//
//                        comboBox_subItem.setModel(new DefaultComboBoxModel(extraItems));
//                    }
//                }
//            });
//            panel_north.add(comboBoxItem);
//
//            comboBox_subItem = new JComboBox();
//            comboBox_subItem.setModel(new DefaultComboBoxModel());
//            comboBox_subItem.setPreferredSize(new Dimension(100,27));
//            //comboBox_subItem.setModel(new DefaultComboBoxModel(new String[] {"SubItem1", "SubItem2", "SubItem3"}));
//            panel_north.add(comboBox_subItem);
//
//            btnAdd = new JButton("Add");
//            panel_north.add(btnAdd);
//            btnAdd.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//
//                    //int extraServiceID = 0;
//                    for (Object[] o: extras){
//                        if (o[1]== comboBox_subItem.getSelectedItem()){
//                            extraServiceID = (int)o[0];
//                        }
//                    }
//                    extraServiceController.makeOrder(extraServiceID,Integer.parseInt(quantityField.getText()),startKinoPanel.getReservationManagerPanel().getSelectedReservationId());
//
//                }
//            });
//
//            panel_south = new JPanel();
//            add(panel_south, BorderLayout.SOUTH);
//            panel_south.setLayout(new BorderLayout(0, 0));
//
//            panel_east = new JPanel();
//            panel_south.add(panel_east, BorderLayout.EAST);
//
//            JLabel lblTotal = new JLabel("Total:");
//            lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
//            panel_east.add(lblTotal);
//
//            JLabel lblTotalInt = new JLabel("......");
//            lblTotalInt.setVerticalAlignment(SwingConstants.BOTTOM);
//            panel_east.add(lblTotalInt);
//
//            JPanel panel_center = new JPanel();
//            panel_south.add(panel_center, BorderLayout.CENTER);
//            panel_center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//
//            JButton button = new JButton("+");
//            panel_center.add(button);
//
//            JButton button_1 = new JButton("-");
//            panel_center.add(button_1);
//
//            JButton btnX = new JButton("X");
//            panel_center.add(btnX);
//
//            JButton btnConfirm = new JButton("Confirm");
//            panel_center.add(btnConfirm);
//
//            JButton btnCancel = new JButton("Cancel");
//            panel_center.add(btnCancel);
//
//            JPanel tablePanel = new JPanel();
//            tablePanel.setLayout(new BorderLayout(0, 0));
//            add(tablePanel, BorderLayout.CENTER);
//
//            table = new JTable();
//            tablePanel.add(table , BorderLayout.CENTER);
//            tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
//            servicesTable();
//            this.setVisible(false);
//        }
//
//        private void getReservationId(){
//
//        }
//
//
//        private void servicesTable(){
//            Vector<String> columnNames = new Vector(Arrays.asList(new String[]{"Quantity", "Description", "Price", "Total"}));
//
//            table.setModel(new DefaultTableModel(dataVector,columnNames));
//
////		table.setModel(new DefaultTableModel( ()
////				new String[][] {
////						{"2", "candy","200"},
////						{"2", "popcorn", "150"},
////						{"2", "soda", "50"},
////						{null, null, null},
////						{null, null, null},
////						{null, null, null},
////				},
////				new String[] {
////						"Quantity", "Description", "Total"
////				}
////				) {
////
////			private static final long serialVersionUID = 1L;
////			Class[] columnTypes = new Class[] {
////					String.class, Object.class, String.class
////			};
////			public Class getColumnClass(int columnIndex) {
////				return columnTypes[columnIndex];
////			}
////			boolean[] columnEditables = new boolean[] {
////					false, false, false, false
////			};
////			public boolean isCellEditable(int row, int column) {
////				return columnEditables[column];
////			}
////		});
//            table.getColumnModel().getColumn(1).setPreferredWidth(495);
//
//        }
//}





//private JTextField txtTitle;
//private JTextField txtName;
//private JTextField txtDate;
//private JTextField txtSurname;
//private JTextField txtTime;
//private JTextField txtPhone;
//private JTextField txtSeats;
//private JTextField txtEmail;
//private JPanel dataPanel;
//private JLabel lblTitle;
//private JLabel lblName;
//private JButton btnEditReservation;
//private JLabel lblDate;
//private JLabel lblSurname;
//private JLabel lblTime;
//private JLabel lblPhone;
//private JLabel lblSeats;
//private JLabel lblEmail;
//private JPanel buttonPanel;
//private JButton btnPrintTicket;
//private JButton btnAddExtras;
//private JButton btnCancelReservation;
//private StartKinoPanel startKino;
//private JPanel panel;
//private JPanel panel_1;
//private JPanel panel_2;
//private JPanel panel_3;
//private JLabel lblNewLabel;
//private JLabel lblNewLabel_1;
//private JPanel panel_4;
//private JPanel panel_5;
//private JPanel panel_6;
//private JPanel panel_7;
//private JPanel panel_8;
//private JPanel panel_9;
//private JPanel panel_10;
//private JLabel lblNewLabel_2;
//private JPanel panel_11;
//private JPanel panel_12;
//
///**
// * Create the panel.
// *
// * @param startKinoPanel
// */
//public ReservationInfoPanel(final StartKinoPanel startKinoPanel) {
//        this.startKino = startKinoPanel;
//
//setMinimumSize(new Dimension(10, 5));
//setLayout(new BorderLayout(0, 0));
//
//panel_2 = new JPanel();
//add(panel_2, BorderLayout.NORTH);
//panel_2.setLayout(new BorderLayout(0, 0));
//
//dataPanel = new JPanel();
//panel_2.add(dataPanel);
//dataPanel.setLayout(new BorderLayout(0, 0));
//
//panel_4 = new JPanel();
//dataPanel.add(panel_4, BorderLayout.CENTER);
//panel_4.setLayout(new BorderLayout(0, 0));
//
//panel_3 = new JPanel();
//panel_4.add(panel_3, BorderLayout.NORTH);
//panel_3.setLayout(new GridLayout(1, 0, 0, 0));
//
//lblNewLabel = new JLabel("Movie");
//lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//panel_3.add(lblNewLabel);
//
//lblNewLabel_1 = new JLabel("Customer");
//lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//panel_3.add(lblNewLabel_1);
//
//panel_12 = new JPanel();
//panel_4.add(panel_12, BorderLayout.CENTER);
//panel_12.setLayout(new BorderLayout(0, 0));
//
//panel_11 = new JPanel();
//panel_12.add(panel_11, BorderLayout.NORTH);
//panel_11.setLayout(new GridLayout(0, 2, 0, 0));
//
//panel_5 = new JPanel();
//panel_11.add(panel_5);
//panel_5.setLayout(new BorderLayout(0, 0));
//
//panel = new JPanel();
//panel_5.add(panel, BorderLayout.WEST);
//panel.setLayout(new GridLayout(4, 0, 0, 6));
//
//lblTitle = new JLabel("   Title: ");
//lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
//panel.add(lblTitle);
//lblTitle.setFont(new Font("Arial", Font.BOLD, 12));
//
//lblDate = new JLabel("   Date: ");
//lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
//panel.add(lblDate);
//lblDate.setFont(new Font("Arial", Font.BOLD, 12));
//
//lblTime = new JLabel("   Time: ");
//lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
//panel.add(lblTime);
//lblTime.setFont(new Font("Arial", Font.BOLD, 12));
//
//lblSeats = new JLabel("    Seats: ");
//lblSeats.setHorizontalAlignment(SwingConstants.RIGHT);
//panel.add(lblSeats);
//lblSeats.setFont(new Font("Arial", Font.BOLD, 12));
//
//panel_1 = new JPanel();
//panel_5.add(panel_1);
//panel_1.setLayout(new GridLayout(4, 0, 0, 6));
//
//txtTitle = new JTextField();
//txtTitle.setPreferredSize(new Dimension(6, 25));
//panel_1.add(txtTitle);
//txtTitle.setColumns(10);
//
//txtDate = new JTextField();
//panel_1.add(txtDate);
//txtDate.setColumns(10);
//
//txtTime = new JTextField();
//panel_1.add(txtTime);
//txtTime.setColumns(10);
//
//txtSeats = new JTextField();
//panel_1.add(txtSeats);
//txtSeats.setColumns(10);
//
//panel_6 = new JPanel();
//panel_11.add(panel_6);
//panel_6.setLayout(new BorderLayout(0, 0));
//
//panel_7 = new JPanel();
//panel_6.add(panel_7, BorderLayout.WEST);
//panel_7.setLayout(new GridLayout(4, 0, 0, 6));
//
//lblSurname = new JLabel("  Surname: ");
//lblSurname.setFont(new Font("Arial", Font.BOLD, 12));
//lblSurname.setHorizontalAlignment(SwingConstants.RIGHT);
//panel_7.add(lblSurname);
//
//lblPhone = new JLabel("   Phone: ");
//lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
//panel_7.add(lblPhone);
//lblPhone.setFont(new Font("Arial", Font.BOLD, 12));
//
//lblEmail = new JLabel("   e-mail: ");
//lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
//panel_7.add(lblEmail);
//lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
//
//lblName = new JLabel("   Name: ");
//lblName.setHorizontalAlignment(SwingConstants.RIGHT);
//panel_7.add(lblName);
//lblName.setFont(new Font("Arial", Font.BOLD, 12));
//
//panel_8 = new JPanel();
//panel_6.add(panel_8);
//panel_8.setLayout(new GridLayout(4, 0, 0, 6));
//
//txtName = new JTextField();
//panel_8.add(txtName);
//txtName.setColumns(10);
//
//txtSurname = new JTextField();
//panel_8.add(txtSurname);
//txtSurname.setColumns(10);
//
//txtPhone = new JTextField();
//panel_8.add(txtPhone);
//txtPhone.setColumns(10);
//
//txtEmail = new JTextField();
//panel_8.add(txtEmail);
//txtEmail.setColumns(10);
//
//buttonPanel = new JPanel();
//panel_2.add(buttonPanel, BorderLayout.EAST);
//buttonPanel.setLayout(new BorderLayout(0, 0));
//
//panel_9 = new JPanel();
//buttonPanel.add(panel_9, BorderLayout.NORTH);
//panel_9.setLayout(new GridLayout(0, 1, 0, 0));
//
//lblNewLabel_2 = new JLabel("Options");
//lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
//panel_9.add(lblNewLabel_2);
//
//panel_10 = new JPanel();
//buttonPanel.add(panel_10, BorderLayout.CENTER);
//panel_10.setLayout(new GridLayout(0, 1, 0, 2));
//
//btnPrintTicket = new JButton("Print Ticket");
//panel_10.add(btnPrintTicket);
//
//btnAddExtras = new JButton("Add Extras");
//btnAddExtras.addActionListener(new ActionListener() {
//
//public void actionPerformed(ActionEvent e) {
//        if(e.getSource().equals(btnAddExtras)){
//        startKinoPanel.getServicesPanel().setVisible(true);
//}
//        }
//        });
//panel_10.add(btnAddExtras);
//
//btnEditReservation = new JButton("Edit Reservation");
//panel_10.add(btnEditReservation);
//
//btnCancelReservation = new JButton("Cancel Reservation");
//panel_10.add(btnCancelReservation);
//
//}