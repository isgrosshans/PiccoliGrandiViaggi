package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//ACTIVITY
//(id, schoolid, name, description)
public class Activity implements Entity {
    int id=-1;
    int schoolid;
    String name;
    String description;

    public Activity(int schoolid, String name, String description) {
        this.schoolid = schoolid;
        this.name = name;
        this.description = description;
    }

    public Activity(int id, int schoolid, String name, String description) {
        this.id = id;
        this.schoolid = schoolid;
        this.name = name;
        this.description = description;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
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
}
