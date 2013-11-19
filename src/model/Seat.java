package model;

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 4/15/13
 * Time: 5:47 PM
 */
public class Seat {
    int row;
    int seat;
    Boolean avaialble;

    public Seat() {

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Boolean getAvaialble() {
        return avaialble;
    }

    public void setAvaialble(Boolean avaialble) {
        this.avaialble = avaialble;
    }
}
