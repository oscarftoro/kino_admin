package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 4/15/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class Theater {

    List<Session> sessions = new LinkedList<>();
    List<Seat> seats = new LinkedList<>();

    public Theater() {
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
