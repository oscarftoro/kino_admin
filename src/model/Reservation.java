package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oscar
 * Date: 4/15/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */

public class Reservation {

    String name;
    String phone;
    String email;
    List<ExtraService> extraservices = new ArrayList<>();

    public Reservation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ExtraService> getExtraservices() {
        return extraservices;
    }

    public void setExtraservices(List<ExtraService> extraservices) {
        this.extraservices = extraservices;
    }
}
