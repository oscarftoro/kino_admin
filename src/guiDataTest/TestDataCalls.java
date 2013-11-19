package guiDataTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import guiDataTest.DbConnector;


public class TestDataCalls {

	public static void newMovie(String title, String year, String genre, String storyLine, String language, String country, String releaseDate,
			String version, String length, String ageLimit) throws SQLException {
		
		Connection SqlConnector = null;  
		Statement statement = null;
		//ResultSet rs = null;
		System.out.println(title);
		String q = "INSERT INTO movies (title, year, genre, storyLine, language, country, releaseDate, version, length, ageLimit) VALUES ('" + 
				title + "', '" + year + "', '" + genre + "', '" + storyLine + "', '" + language +"', '" + country + "', '"+ releaseDate +"', '" + version + 
				"', '" + length +"', '" + ageLimit +"');";
		
		SqlConnector = DbConnector.getSqlConnection();// connect to database
		statement = SqlConnector.createStatement();
		statement.executeUpdate(q);
		// Get the result of the SQL query      
		//rs = statement.getResultSet();
		
		//rs.close(); // close result set
		statement.close(); // close statement
		
		DbConnector.closeDatabaseConnection();//disconnect from database
		
	}

	public static void editMovie(String title, String year, String genre, String storyLine, String language, String country, String releaseDate,
			String version, String length, String ageLimit, int movieId) throws SQLException {
		
		Connection SqlConnector = null;  
		Statement statement = null;
		//ResultSet rs = null;

		String q = "UPDATE movies SET title='"+title+"' , year='"+year+"', genre='"+genre+"', storyLine='"+storyLine+"', language='"+language+"', country='"+
				country+"', releaseDate='"+releaseDate+"', version='"+version+"', length='"+length+"', ageLimit='"+ageLimit+"' WHERE id="+movieId+";";
				
		SqlConnector = DbConnector.getSqlConnection();// connect to database
		statement = SqlConnector.createStatement();
		statement.executeUpdate(q);
		// Get the result of the SQL query      
		//rs = statement.getResultSet();
		
		//rs.close(); // close result set
		statement.close(); // close statement
		
		DbConnector.closeDatabaseConnection();//disconnect from database
		
	}
	
	public static void insertMovieIntoSchedule(String startDate, int session, int TheaterNumber, int movieId, String endDate) throws SQLException {
		
		Connection SqlConnector = null;  
		Statement statement = null;
		//ResultSet rs = null;
		
		String q = "INSERT INTO schedule (startDate, movieId, session, endDate, theater) " +
				"VALUES ('" + startDate + "', " + movieId + ", " + session + ", '" + endDate +"'," + TheaterNumber +");";
		
		SqlConnector = DbConnector.getSqlConnection();// connect to database
		statement = SqlConnector.createStatement();
		statement.executeUpdate(q);
		// Get the result of the SQL query      
		//rs = statement.getResultSet();
		
		//rs.close(); // close result set
		statement.close(); // close statement
		
		DbConnector.closeDatabaseConnection();//disconnect from database
		
	}
	
	public static String[] getTextPaneMovieData(int theater, String date, int session) throws SQLException {

		Connection SqlConnector = null;  
		Statement statement = null;
		ResultSet rs = null;
		
		String q = "SELECT movies.id AS movieId, title, schedule.id AS scheduleId FROM movies, schedule WHERE schedule.theater="+ (theater+1) 
				+" AND schedule.session=" + (session+1) + " AND ('"+date+"' BETWEEN schedule.startDate AND schedule.endDate) AND movies.id = schedule.movieId";
		
		SqlConnector = DbConnector.getSqlConnection();// connect to database
		statement = SqlConnector.createStatement();
		statement.executeQuery(q);
		
		// Get the result of the SQL query      
		rs = statement.getResultSet();
		
		String[] results = new String[3];//array to store results from the database
		
		//int i =0;
		while (rs.next()) // loop through rows of result set
		{		
			results[0]=rs.getString("movieId");
			results[1]=rs.getString("title");
			results[2]=rs.getString("scheduleId");
			//i++;
		}
		
		rs.close(); // close result set
		statement.close(); // close statement
		DbConnector.closeDatabaseConnection();//disconnect from database
		
		return results;

	}
		

	public static void removeMovieFromSchedule(String date, String id) throws SQLException {
		
		Connection SqlConnector = null;  
		Statement statement = null;
		//ResultSet rs = null;
		
		String q = "UPDATE schedule SET endDate='"+date+"' WHERE id="+id+";";
		
		SqlConnector = DbConnector.getSqlConnection();// connect to database
		statement = SqlConnector.createStatement();
		statement.executeUpdate(q);
		// Get the result of the SQL query      
		//rs = statement.getResultSet();
		
		//rs.close(); // close result set
		statement.close(); // close statement
		
		DbConnector.closeDatabaseConnection();//disconnect from database
		
	}
	
	public static String[] getMovieData(int movieId) throws SQLException{
		
		Connection SqlConnector = null;  
		Statement statement = null;
		ResultSet rs = null;
		
		String q = "SELECT title, year, genre, storyLine, language, country, releaseDate, ageLimit, version, length  FROM movies WHERE id="+ movieId +";";
		
		SqlConnector = DbConnector.getSqlConnection();// connect to database
		statement = SqlConnector.createStatement();
		statement.executeQuery(q);
		
		// Get the result of the SQL query      
		rs = statement.getResultSet();
		
		String[] results = new String[10];//array to store results from the database
		
		while (rs.next()) // loop through rows of result set
		{		
			results[0]=rs.getString("title");
			results[1]=rs.getString("year");
			results[2]=rs.getString("genre");
			results[3]=rs.getString("storyLine");
			results[4]=rs.getString("language");
			results[5]=rs.getString("country");
			results[6]=rs.getString("releaseDate");
			results[7]=rs.getString("ageLimit");
			results[8]=rs.getString("version");
			results[9]=rs.getString("length");
			
		}
		
		rs.close(); // close result set
		statement.close(); // close statement
		DbConnector.closeDatabaseConnection();//disconnect from database
		
		return results;
		
	}
	
}
