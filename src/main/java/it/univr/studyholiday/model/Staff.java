package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;
import it.univr.studyholiday.util.Database.LoginDB;

import java.lang.reflect.Field;

//STAFF
//(id, email, psw, firstname, lastname, phone)
public class Staff implements Entity {

    private int id=-1;
    private String email;
    private String psw;
    private String firstname;
    private String lastname;
    private String phone;

    public Staff(String email, String psw, String firstname, String lastname, String phone) {
        this.email = email;
        this.psw = LoginDB.encrypy(psw);
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public Staff(int id, String email, String psw, String firstname, String lastname, String phone) {
        this.id = id;
        this.email = email;
        this.psw = psw;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
