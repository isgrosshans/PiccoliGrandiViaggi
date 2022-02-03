package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//DORMITORY
//(id, name, address, schoolid, sex)
public class Dormitory implements Entity {
    private int id=-1;
    private int schoolid;
    private String name;
    private String address;
    private String sex;

    public Dormitory(int schoolid, String name, String address, String sex) {
        this.schoolid = schoolid;
        this.name = name;
        this.address = address;
        this.sex = sex;
    }
    public Dormitory(int id, int schoolid, String name, String address, String sex) {
        this.id = id;
        this.schoolid = schoolid;
        this.name = name;
        this.address = address;
        this.sex = sex;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String italianDescription(){
        String s="Dormitorio '"+name+"'\n";
        if(sex.startsWith("F")||sex.startsWith("f")) s+="Femminile";
        else if(sex.startsWith("M")||sex.startsWith("m")) s+="Maschile";
        s+="\n"+address;
        return s;
    }
}
