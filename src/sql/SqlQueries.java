package sql;

import java.sql.*;
import java.util.Vector;



public class SqlQueries {
	
	private Statement statement; 
	private Connection conn; 
	private ResultSet resultSet;
	private Vector data;
	static Connection connector = DbConnector.getSqlConnection();
	
	public SqlQueries(){
		try {
			statement = connector.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.connector = connector;
	}
	
//	public SqlQueryes(Connection con) {
//		try {
//			statement = con.createStatement();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		this.conn = conn;
//	}
	
	public Vector getInfo(ResultSet resultSet){
		try {
		
		ResultSetMetaData md = resultSet.getMetaData();
		int columnCount = md.getColumnCount();
		data = new Vector();
		Vector row;
		
		while(resultSet.next()) 
		{
			row = new Vector(columnCount);
			for(int i=1; i<=columnCount; i++)
			{
				row.add(resultSet.next());
			}
			data.add(row);
		}
		

	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return data;
}
	
	
	public Vector getMovieData() {		
		try {
			resultSet = statement.executeQuery("SELECT title, year, country, language, genre , storyLine FROM movies ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getInfo(resultSet);
	}
	
	public Vector getSeats(int sessionNumber, int theaterNumber, String date){
		try {
			resultSet = statement.executeQuery( "SELECT seat, row FROM seats WHERE session=" +sessionNumber+ " AND theater=" +theaterNumber+ " AND date='" +date+ "'");
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return getInfo(resultSet);
	}
	
	public Vector getSchedule(int theater, String date, int session){
		try {
			resultSet = statement.executeQuery("SELECT m.id, m.title FROM movies m, schedule s WHERE s.theater="+ (theater+1) +" AND s.session=" + (session+1) + " AND ('"+date+"' BETWEEN s.startDate AND s.endDate) AND m.id = s.movieId");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getInfo(resultSet);		
	}
	
	
	// ********INSERTS**********
	
	public void insertIntoDB(String insert) {
		try {
			statement = conn.createStatement();
			statement.execute(insert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertMovie(int id, String title, int year, String genre, String storyLine, String language, String country, String releaseDate, int ageLimit, String status, String version){
		insertIntoDB("INSERT INTO `kino_test`.`movies` ('id', 'title', 'year', 'genre', 'storyLine', 'language', 'country', 'releaseDate', 'ageLimit', 'status', 'version') VALUES ('"+id+"', '"+title+"', '"+year+"', '"+genre+"', '"+storyLine+"', '"+language+"', '"+country+"', '"+releaseDate+"', '"+ageLimit+"', '"+status+"', '"+version+"')");
	}
	
	public void insertSchedule(int id, String startDate, int movieId, int session, String endDate, int theater){
		insertIntoDB("INSERT INTO `kino_test`.`schedule`(`id`,`startDate`,`movieId`,`session`,`endDate`,`theater`) VALUES ('"+id+"','"+startDate+"','"+movieId+"','"+session+"','"+endDate+"','"+theater+"')");
	}
	
	public void insertPrices(int id, int amount){
		insertIntoDB("INSERT INTO `kino_test`.`pricelist`(`id`,`amount`) VALUES ('"+id+"','"+amount+"')");
	}
	
	public void insertSeats(int id, String session, String date, int seat, int row, int res_id, int theater){
		insertIntoDB("INSERT INTO `kino_test`.`seats`(`id`,`session`,`date`,`seat`,`row`,`reservation_id`,`theater`) VALUES ('"+id+"','"+session+"','"+date+"','"+seat+"','"+row+"','"+res_id+"','"+theater+"')");
	}

	
	// ********UPDATES**********
	
	public void updateDB(String update) {
		try {
			statement.executeUpdate(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateMovie(int id, String title, int year, String genre, String storyLine, String language, String country, String releaseDate, int ageLimit, String status, String version) throws SQLException{
		updateDB("UPDATE `kino_test`.`movies` SET `title`='"+title+"',`year`='"+year+"',`genre`='"+genre+"',`storyLine`='"+storyLine+"',`language`='"+language+"',`country`='"+country+"',`releaseDate`='"+releaseDate+"',`ageLimit`='"+ageLimit+"',`status`='"+status+"',`version`='"+version+"'");
	}
	public void updateTest(int session, String date, int theater){
		updateDB("UPDATE `kino_test`.`schedule` SET `endDate`='"+date+"'WHERE `session`='"+session+"'AND `theater`='"+theater+"'");
	}
}
