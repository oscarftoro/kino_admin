package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.*;
import sql.DbConnector;


public class ReservationController {
    private static final ReservationController instance = new ReservationController();
    static Connection connector = DbConnector.getSqlConnection();
    HashMap<Integer,ArrayList> reservations = new HashMap<>();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public ReservationController() {
    }

    public static ReservationController getInstance() {
        return instance;
    }

    // tested and working
    public Vector<Vector<Object>> getReservations(String selectedChoice, String typeField){

        ResultSet result;
        Vector<Vector<Object>> data = new Vector();

        //************************************
        try {
               // "Name","Surname","Phone","Email","Movie"
        //"r.customerName","r.surname","r.phone","r.email","m.title"
            System.out.println("RESERVATION: "+selectedChoice+", "+typeField);
        String[] selectedChoices = new String[]{"Name","Surname","Phone","Email","Movie"};
        String[] columnNames = new String[]{"r.customerName","r.surname","r.phone","r.email","m.title"};
        String query = null;
        if(selectedChoice != null && typeField != null){
            int i = 0;
            for (String s: selectedChoices){
                if (s == selectedChoice){
                    query = "SELECT r.id, r.CustomerName, r.surname, m.title,  r.phone, r.email FROM movies m, reservations r WHERE "+columnNames[i]+" ='"+typeField+"' AND m.id = r.movies_id AND m.status = 'pending' ORDER BY CustomerName ASC";
                }
                i++;
            }
        }else{
            query = "SELECT r.id, r.CustomerName, r.surname, m.title,  r.phone, r.email FROM movies m, reservations r WHERE m.id = r.movies_id AND m.status = 'pending' ORDER BY CustomerName ASC";

        }
        result =  connector.createStatement().executeQuery(query);
        while (result.next()){
            Vector<Object> dataRow = new Vector();
            dataRow.add(result.getInt(1));
            dataRow.add(result.getString(2));
            dataRow.add(result.getString(3));
            dataRow.add(result.getString(4));
            dataRow.add(result.getString(5));
            dataRow.add(result.getString(6));
            System.out.println(result.getInt(1)+","+result.getString(2)+","+result.getString(3)+","+result.getString(4)+","+result.getString(5)+","+result.getString(6));
            data.add(dataRow);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

        return data;
    }

    //tested and working
    public  Vector<Vector<Integer>>  getReservedSeats(int sessionNumber, int theaterNumber, String date){
        Vector<Vector<Integer>> data = new Vector<>();
        try {
            ResultSet result =  connector.createStatement().executeQuery("SELECT seat, row FROM reservedseats WHERE session=" +sessionNumber+ " AND theater=" +theaterNumber+ " AND date='" +date+ "'");
            while (result.next()){

                Vector<Integer> row = new Vector<>();
                row.add(result.getInt(2)-1);
                row.add(result.getInt(1)-1);
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }


    public boolean makeReservation(String name, String surname, String phone, String email, String movie, String date, int session, int theater, ArrayList<int[]> seats){
        boolean message = false;
        try {
            int customerInsert =  connector.createStatement().executeUpdate("INSERT INTO reservations(numberOfSeats,customerName,phone,movies_id,surname,email, status)VALUES ("+seats.size()+",'"+name+"','"+phone+"','"+movie+"','"+surname+"','"+email+"', 'pending')");
            if (customerInsert != 0) {
                ResultSet lastInsertResult = connector.createStatement().executeQuery("SELECT LAST_INSERT_ID()");
                int lastInsertID = 0;

                while (lastInsertResult.next()){
                    lastInsertID = lastInsertResult.getInt(1);
                }
                lastInsertResult.close();
                for (int[]a: seats){
                    int reservationInsert = connector.createStatement().executeUpdate("INSERT INTO reservedseats(session,date,seat,row,theater,Reservations_id)VALUES ("+session+",'"+date+"','"+a[1]+"','"+a[0]+"','"+theater+"','"+lastInsertID+"')");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            message = true;
        }
        return message;
    }


    public void deleteReservedSeat(){}

    public double getTotalPrice(String title, int reservationId){
        double price = 0;
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT p.amount FROM pricelist p, movies m WHERE m.pricelist_id = p.id AND m.title = '"+title+"'");
            while (result.next()){
                price = result.getDouble(1);
                //System.out.println("PRICE: "+price);
            }
            result.close();
            ResultSet orderResult = connector.createStatement().executeQuery("SELECT p.amount, o.quantity FROM orders o, extras e, pricelist p WHERE o.extras_id = e.id AND e.pricelist_id = p.id AND o.reservation_id = "+reservationId);
            while (orderResult.next()){
                price += orderResult.getDouble(1) * orderResult.getInt(2);
            }
            orderResult.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    public void changeReservation(int reservationId, String change){
        try {
            connector.createStatement().executeUpdate("UPDATE reservations SET status = '"+change+"' WHERE id = "+reservationId);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public ArrayList<Object> getReservationData(int reservationId){
        //title,date,session,seats,name,surname,phone,email
        ArrayList<Object> data = new ArrayList<>();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT m.title, s.date, s.session, r.numberOfSeats, r.customerName, r.surname, r.phone, r.email FROM movies m, reservedseats s, reservations r WHERE r.id = "+reservationId+" AND r.movies_id = m.id AND s.Reservations_id = r.id GROUP BY r.id");

            while (result.next()){
                data.add(result.getString(1));
                System.out.println(result.getString(1));
                data.add(format.format(result.getDate(2)));
                System.out.println(result.getDate(2));
                data.add(result.getInt(3));
                System.out.println(result.getInt(3));
                data.add(result.getInt(4));
                System.out.println(result.getInt(4));
                data.add(result.getString(5));
                System.out.println(result.getString(5));
                data.add(result.getString(6));
                System.out.println(result.getString(6));
                data.add(result.getString(7));
                System.out.println(result.getString(7));
                data.add(result.getString(8));
                System.out.println(result.getString(8));
            }
            result.close();
            //connector.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return data;
    }

}
