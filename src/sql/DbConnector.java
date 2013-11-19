package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	  
	private static Connection Sqlconnection=null;
	
	public static Connection getSqlConnection(){ //Connect to the database


        //new version

        //localhost
        String databaseName="kino_test"; //database name
        String userName="root"; //database user
        String userPassword="12345"; //database Password   babayaga
        String dbServer="jdbc:mysql://localhost/";
		/*
			String databaseName="tecknika_kino"; //database name
			String userName="tecknika_kino"; //database user
			String userPassword="KinoGroup"; //database Password
			String dbServer="jdbc:mysql://66.7.221.199:3306/";*/

			try {
				Sqlconnection = DriverManager.getConnection(dbServer + databaseName, userName, userPassword); //connect to database
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Sqlconnection;
		}
		
	
	
	//Disconnect from the database
	public static void closeDatabaseConnection() {
		try {
			if (Sqlconnection != null) {
				Sqlconnection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
}

/*__________________________________
< How do we connect to the database?! >
  ----------------------------------
           \   ^__^
           \  (oo)\_______
             (__)\       )\/\
                 ||--WWW |
                 ||     ||     */

