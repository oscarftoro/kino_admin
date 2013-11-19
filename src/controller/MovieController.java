package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import sql.DbConnector;

public class MovieController {

    private static MovieController instance = new MovieController();
    private static Connection connector = DbConnector.getSqlConnection();
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    int count = 1;
    // insert movie data to the database and returns feedback to UI

    public MovieController() {
    }

    public static MovieController getInstance() {
        return instance;
    }

    public void addMovie( String title, String year, String genre, String storyLine,String language, String country, Date releaseDate, String ageLimit, String version){
        //boolean message = false;//data was successfully inserted to DB
       // System.out.println("Inserting...");
        try {
            //returns 1 -  amount of rows inserted to DB                                                                                                                        //title, year, genre, storyLine, language, country, releaseDate, ageLimit, status, version
            connector.createStatement().executeUpdate("INSERT INTO movies (title, year, genre, storyLine, language, country, releaseDate, ageLimit, version) VALUES ('" + title + "','" + year + "','" + genre + "','" + storyLine.replaceAll("\\'", "\\\\'") + "','" + language + "','" + country + "','" + format.format(releaseDate) + "','" + ageLimit + "','" + version +"')");
        } catch (SQLException e) {
            e.printStackTrace();
            //message = true;//error occurred
        }
        //return message;
        System.out.println("Inserted successfully");
    }

    // update movie in the database and return feedback to UI
    public void updateMovie(int id,String title, String year, String genre, String storyLine,String language, String country, Date releaseDate, String ageLimit, String version){
        System.out.println("Updating ...");
       // boolean message = false;//data was successfully updated
        try {
            //returns 1 -  amount of rows updated
            int result =  connector.createStatement().executeUpdate("UPDATE movies SET title='"+ title +"',year = '"+year+"', genre='"+genre+"', storyLine='"+storyLine.replaceAll("\\'", "\\\\'") +"', language ='"+language+"', country = '"+country+"',releaseDate ='"+format.format(releaseDate)+"', ageLimit = '"+ageLimit+"', version='"+version+"' WHERE id = "+id);
        } catch (SQLException e) {
            e.printStackTrace();
            //message = true;//error occurred
            System.out.println("Update");
        }
        //return message;
    }

    // insert session data to the db schedule table  and returns feedback to UI
    public void addSessions(Date startDate, int session, int theater, int movieId, Date endDate){
      // boolean message = false;//data was successfully inserted to DB
        System.out.println("INSERT INTO schedule(startDate,movieId,session,endDate,theater) VALUES ('"+format.format(startDate)+"',"+movieId+","+(session)+",'"+format.format(endDate)+"',"+(theater)+")");
        try {
            //returns 1 -  amount of rows inserted to DB
            connector.createStatement().executeUpdate("INSERT INTO schedule(startDate,movieId,session,endDate,theater) VALUES ('"+format.format(startDate)+"',"+movieId+","+(session-1)+",'"+format.format(endDate)+"',"+(theater-1)+")");
        } catch (SQLException e) {
            e.printStackTrace();
            //message = true;//error occurred
        }
        //return message;
        System.out.println("new session Added");
    }
    //Used
    public Vector<Vector<Object>> getMoviesSortedByTitle(){
        Vector<Vector<Object>> tableVector = new Vector();
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT id, title, year, genre FROM movies ORDER BY title ASC");
            while (result.next()){
                Vector<Object> dataRow = new Vector();
                dataRow.add(result.getInt(1));
                dataRow.add(result.getString(2));
                dataRow.add(result.getString(3));
                dataRow.add(result.getString(4));
                tableVector.add(dataRow);
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return tableVector;
    }
    //Used
    public String[] getMovies(int theater, String date, int session){
        String[] movieInfo = new String[3];
        count++;
        try {
            ResultSet result = connector.createStatement().executeQuery("SELECT m.id, m.title, s.id FROM movies m,schedule s WHERE s.startDate <='"+date+"' AND s.endDate >= '"+date+"' AND s.session = "+session+" AND s.movieId = m.id AND s.theater = "+theater);
            while(result.next()){

                movieInfo[0] = result.getString(1)+"";
                movieInfo[1] = result.getString(2);
                movieInfo[2] = result.getString(3)+"";
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieInfo;
    }
    //Used
    public boolean updateSchedule(String endDate, String id){
        boolean message = false;//data was successfully inserted to DB
        try {
            int result =  connector.createStatement().executeUpdate("UPDATE schedule SET endDate='"+endDate+"'WHERE id="+id);
            //System.out.println("movie removed");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            message = true;
        }
        return message;
    }


}
