package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public final class SqlConnection {
	
		//Common connection variable
/*		private Connection conn = null;
		private volatile static SqlConnection singleton = null;  //why are we using volatile here?*/
		
		//MySQL
/*		private static final String mySqlUrl = "tecknika.com:3306"; //e.g. jdbc:mysql://localhost/kinoxp?
		private static final String mySQLDriver = "com.mysql.jdbc.Driver";
		
		private SqlConnection(){
			//Database login variables
			private String dbName="KinoXP";
			private String dpUser="tecknika_kino
			private String dpPassword="KinoGroup";
			
/*
			try {
				Class.forName(mySQLDriver).newInstance();
				//this.conn = DriverManager.getConnection(mySqlUrl, dbName, dbUser, dbPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}*/
/*
		*//*

		public static SqlConnection getInstance(){
			if(singleton == null){
				singleton = new SqlConnection();
			}
			return singleton;
		}
		
   */
}

