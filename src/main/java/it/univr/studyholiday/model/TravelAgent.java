package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Update;

// TRAVELAGENT(email,
//         password,name,surname,phonenumber)
public class TravelAgent {

    private String email;
    private String password;
    private String name;
    private String surname;
    private String phonenumber;

    public TravelAgent(String email, String password, String name, String surname, String phonenumber) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
    }

    public void update() {
        Update.update(this);
    }
    public void add() {
        Add.add(this);
    }
    public void delete() {
        Delete.delete(this);
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
