package it.univr.studyholiday.model;

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
