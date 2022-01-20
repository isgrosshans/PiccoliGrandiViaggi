package it.univr.studyholiday.model;

import java.util.ArrayList;

//ACTIVITY
//(id, schoolid, name, description)
public class Activity {
    School school;
    String name;
    String description;

    public Activity(School school, String name, String description) {
        this.school = school;
        this.name = name;
        this.description = description;
    }
    

    public School getSchool() {
        return school;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //TODO
//    public static ArrayList<Activity> getAllFor(School school){
//        Fetch.schoolActivities(school.getId());
//        return null;
//    }
}
