package model;

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 4/15/13
 * Time: 4:20 AM
 */
public class Movie {

    String title = "title";
    String genre = "genre";
    int year = 2013;
    String country = "Danmark";
    String language ="language";

    String summary = "summary";
    int AgeRestriction;

    public Movie() {


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getAgeRestriction() {
        return AgeRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        AgeRestriction = ageRestriction;
    }
}
