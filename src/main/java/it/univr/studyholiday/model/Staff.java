package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;
import it.univr.studyholiday.util.Database.LoginDB;

import java.lang.reflect.Field;

//STAFF
//(id, email, psw, firstname, lastname, phone)
public class Staff implements Entity {

    private String id;
    private String email;
    private String psw;
    private String firstname;
    private String lastname;
    private String phone;

//    public Staff(String id, String email,
//                 String firstname, String lastname,
//                 String phone) {
//        this.id = id;
//        this.email = email;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.phone = phone;
//    }

    public Staff(String email, String psw, String firstname, String lastname, String phone) {
        this.id="";
        this.email = email;
        this.psw = LoginDB.encrypy(psw);
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
