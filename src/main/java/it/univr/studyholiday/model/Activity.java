package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.Update;

import java.util.ArrayList;

public class Activity {
    College college;
    String name;
    String description;

    public Activity(College college, String name, String description) {
        this.college = college;
        this.name = name;
        this.description = description;
    }

    public Activity(String college, String name, String description) {
        this.college = Fetch.college(college);
        this.name = name;
        this.description = description;
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

    public College getCollege() {
        return college;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setCollege(College college) {
        this.college = college;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Activity> getAllFor(College college){
        Fetch.collegeActivities(college.getId());

        return null;
    }
}
