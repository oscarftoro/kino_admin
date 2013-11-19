package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import guiDataTest.DbConnector;

public class SystemConfigController {
	
	
	private static SystemConfigController instance = new SystemConfigController();
	private static Connection connector = DbConnector.getSqlConnection();
	
	
	public SystemConfigController() {
	}
	
	public static SystemConfigController getInstance(){
		return instance;
	}
	
	public void addSoda(String name, Double price){
		try {
			String selectCategory = "INSERT INTO extras(name, price, category)";
			
			connector.createStatement().executeUpdate("INSERT INTO extras(name, price, category)" + "VALUES('"+name+"','"+price+"','soda')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSoda(int id, String name, Double price){
		try {
			
			int result =  connector.createStatement().executeUpdate("UPDATE extras SET name='"+name+", price ='"+price+"' 'WHERE id="+id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void addPopcorn(String name, Double price){
		try {
			connector.createStatement().executeUpdate("INSERT INTO extras(name, price, category)" + "VALUES('"+name+"','"+price+"','popcorn')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePopcorn(int id, String name, Double price){
		try {
			
			int result =  connector.createStatement().executeUpdate("UPDATE extras SET name='"+name+", price ='"+price+"' 'WHERE id="+id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addCandy(String name, Double price){
		try {
			connector.createStatement().executeUpdate("INSERT INTO extras(name, price, category)" + "VALUES('"+name+"','"+price+"','candy')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCandy(int id, String name, Double price){
		try {
			
			int result =  connector.createStatement().executeUpdate("UPDATE extras SET name='"+name+", price ='"+price+"' 'WHERE id="+id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Vector<Object>> getSoda(){
        Vector<Vector<Object>> tableVector = new Vector();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT name, price FROM extras WHERE category = 'soda' ORDER BY title ASC");
            while (result.next()){
                Vector<Object> dataRow = new Vector();
                dataRow.add(result.getString(1));
                dataRow.add(result.getDouble(2));
                tableVector.add(dataRow);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return tableVector;
    }
	
	public Vector<Vector<Object>> getPopcorn(){
        Vector<Vector<Object>> tableVector = new Vector();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT name, price FROM extras WHERE category = 'popcorn' ORDER BY title ASC");
            while (result.next()){
                Vector<Object> dataRow = new Vector();
                dataRow.add(result.getString(1));
                dataRow.add(result.getDouble(2));
                tableVector.add(dataRow);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return tableVector;
    }
	
	public Vector<Vector<Object>> getCandy(){
        Vector<Vector<Object>> tableVector = new Vector();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT name, price FROM extras WHERE category = 'candy' ORDER BY title ASC");
            while (result.next()){
                Vector<Object> dataRow = new Vector();
                dataRow.add(result.getString(1));
                dataRow.add(result.getDouble(2));
                tableVector.add(dataRow);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return tableVector;
    }

}
