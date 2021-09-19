package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.Update;

//PARENT(email,child,
//      name,surname,telephone)
public class Parent {
    private String email;
    private String name;
    private String surname;
    private String phonenumber;
    private Student child;

    public Parent(String email, String name, String surname, String phoneumber, String child) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phoneumber;
        this.child = Fetch.student(child);
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
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public Student getChild() {
        return child;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public void setChild(Student child) {
        this.child = child;
    }
}
