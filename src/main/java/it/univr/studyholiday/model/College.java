package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.Update;

import java.util.ArrayList;

//COLLEGE(id, name, address, language)
public class College {
    String id="";
    String name;
    String language;
    Address address;
    private ArrayList<Activity> activities;


    public College(String name, String language, Address address) {
        this.name = name;
        this.language = language;
        this.address = address;
        this.id=getId();
        this.activities = Fetch.collegeActivities(getId());
    }

    public College(String id, String name, String language, Address address) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.address = address;
        this.activities = Fetch.collegeActivities(getId());
    }

    public static College fetch(String college) {
        return Fetch.college(college);
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

    public String getId() {
        if(id.isEmpty() || id.isBlank())
            return (name+language+getAddress().getFullAddress()).replaceAll("[ ,]","");

        else
            return id;
    }
    public String getName() {
        return name;
    }
    public String getLanguage() {
        return language;
    }
    public Address getAddress() {
        return address;
    }
    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }
}
