package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
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

    public static ArrayList<Activity> getall(){
        return null;
    }
}
