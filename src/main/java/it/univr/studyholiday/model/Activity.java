package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;

//ACTIVITY
//(id, schoolid, name, description)
public class Activity implements Entity {
    String id;
    String schoolid;
    String name;
    String description;

     public Activity(String name, String description) {
        this.id="";
        this.name = name;
        this.description = description;
    }

    public Activity(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

}
