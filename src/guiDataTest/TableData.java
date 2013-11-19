package guiDataTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class TableData {
	
	private static Connection SqlConnector = null;  
	private static Statement statement = null;
	private static ResultSet rs = null;
	private static int columnCount;
	
	public static DefaultTableModel buildTableModel(String query, String[] headerCols) throws SQLException {
		
		SqlConnector = DbConnector.getSqlConnection();// connect to database

		try {
			statement = SqlConnector.createStatement();
			// Get the result of the SQL query      
			rs = statement.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		//build table model
	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int numberOfheaderCols = headerCols.length;
	    for (int column = 0; column <= numberOfheaderCols-1; column++) {
	        //columnNames.add(metaData.getColumnName(column));
	    	columnNames.add(headerCols[column]);
	    }
	    
	    columnCount = metaData.getColumnCount();
	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        	
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    DbConnector.closeDatabaseConnection();//disconnect from database
	    
	    return new DefaultTableModel(data, columnNames);

	}
}
