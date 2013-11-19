package tests;

import controller.MovieController;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class MovieControllerTest {
    private static MovieController movieController = MovieController.getInstance();
    private static int id = 1;
    private static String title = "Sin City";
    private static String title2 = "City of God";
    private static int year = 2005;
    private static String genre = "Thriller";
    private static String storyLine = "A film that explores the dark and miserable town, Basin City, and tells the story of three different people, all caught up in violent corruption.";
    private static String language = "English";
    private static String country = "USA";
    private static Date releaseDate = new Date();
    private static int ageLimit = 18;
    private static String status = "status";
    private static String version = "version";
    private static Date startDate = new Date();
    private static Date endDate = new Date();
    private static int movieId = 6;
    private static int session = 3;
    private static int theater =1;
    private static int sessionNumber = 2;
    private static Calendar myCal = Calendar.getInstance();
    private static Calendar myCal2 = Calendar.getInstance();
    private static int theaterNumber = 2;

    public static void main(String[] args) {
       //HashMap<Integer,ArrayList> test4 = movieController.getMovies();
//        HashMap<Integer,ArrayList> test5 = movieController.getMoviesData();
//        for (ArrayList a: test5.values()){
//            for (Object o: a){
//                System.out.print(o.toString());
//                System.out.print(", ");
//            }
//            System.out.println();
//        }
//        boolean test3 = movieController.addSessions(startDate, movieId, session, endDate, theater);
//        boolean test1 = movieController.addMovie(title, year, genre, storyLine, language, country,releaseDate, ageLimit, status, version);
//        boolean test2 = movieController.updateMovie(id,title2, year, genre, storyLine, language, country,releaseDate, ageLimit, status, version);
//        System.out.println(test1);
////        System.out.println(test2);
        myCal.set(Calendar.YEAR, 2013);
        myCal.set(Calendar.MONTH, 5);
        myCal.set(Calendar.DAY_OF_MONTH, 7); //29
        myCal2.set(Calendar.YEAR, 2013);
        myCal2.set(Calendar.MONTH, 4);
        myCal2.set(Calendar.DAY_OF_MONTH, 1); //29
        Date theDate = myCal.getTime();
        Date end = myCal2.getTime();

        //boolean a  = movieController.addSessions(theDate,session,theater,id,end);

        //11	2013-05-06	1	3	2013-05-08	1
       // boolean b = movieController.updateSchedule(sessionNumber, theDate, theaterNumber);
        //System.out.println(b);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String[] arrayTest = movieController.getMovies(theater,sf.format(theDate), session);
        for(String s: arrayTest){
            System.out.println(s);
        }
    }
}
