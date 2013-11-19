package controller;

import guiDataTest.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ExtraServiceController {
    private static final ExtraServiceController instance = new ExtraServiceController();
    Connection connector = DbConnector.getSqlConnection();

    public ExtraServiceController() {
    }

    public static ExtraServiceController getInstance() {
        return instance;
    }
    public ArrayList<Object[]> getExtraServices(int category){
        //HashMap<Integer,String> extraServices = new HashMap<>();
        ArrayList<Object[]> extraServiceData = new ArrayList<>();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT e.id, e.name, p.amount FROM extras e, pricelist p WHERE category = "+ (category-1) +" AND e.pricelist_id = p.id");
            while (result.next()){
                Object[] row = new Object[3];
                row[0] = result.getInt(1);
                row[1] = result.getString(2);
                row[2] = result.getDouble(3);
                extraServiceData.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extraServiceData;
    }
    public void makeOrder(int extrasId, int quantity, int reservationId){
        System.out.println("New Order: "+extrasId+", "+quantity+", "+reservationId);
        try {
            int orderInsert = connector.createStatement().executeUpdate("INSERT INTO orders(quantity, extras_id,reservation_id) VALUES ("+quantity+", "+extrasId+", "+reservationId+")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vector<Vector<Object>> getOrders(int reservationID){

        Vector<Vector<Object>> data = new Vector<>();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT o.id, o.quantity, e.name, p.amount FROM orders o, extras e, pricelist p WHERE o.extras_id = e.id AND e.pricelist_id = p.id AND o.reservation_id = "+reservationID);
            while (result.next()){
                Vector<Object> row = new Vector<>();
                row.add(result.getInt(1));
                int quantity = result.getInt(2);
                row.add(quantity);
                row.add(result.getString(3));
                double price = result.getDouble(4);
                row.add(price);
                double total = price * quantity;
                row.add(total);
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return  data;
    }
    public void deleteOrder(int id){
        try {
            int deleteResult = connector.createStatement().executeUpdate("DELETE FROM orders WHERE orders.id = "+ id);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
