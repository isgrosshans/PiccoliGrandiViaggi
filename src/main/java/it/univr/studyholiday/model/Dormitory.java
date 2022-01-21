package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;

import java.lang.reflect.Field;

//DORMITORY
//(id, name, address, schoolid, sex)
public class Dormitory implements Entity {
    private String id;
    private String name;
    private String address;
    private String sex;

    public Dormitory(String name, String address, String sex) {
        this.id = "";
        this.name = name;
        this.address = address;
        this.sex = sex;
    }

    public Dormitory(String id, String name, String address, String sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
