package model;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 4/15/13
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Session {

    Date dateTime;

    List<Reservation> reservations;

    Session(){


    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
