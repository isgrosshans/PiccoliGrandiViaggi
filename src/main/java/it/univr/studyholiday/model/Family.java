package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.Update;

public class Family {
    private String email;
    private String name;
    private String surname;
    private College college;
    private int members;
    private boolean havePets;
    private int bedrooms;
    private int bathrooms;
    private String cityDistance;

    public Family(String email, String name, String surname, College college,
                  int members, boolean havePets,
                  int bedrooms, int bathrooms,
                  String cityDistance) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.college = college;
        this.members = members;
        this.havePets = havePets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
    }

    public Family(String email, String name, String surname, String college,
                  int members, boolean havePets,
                  int bedrooms, int bathrooms,
                  String cityDistance) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.college = College.fetch(college);
        this.members = members;
        this.havePets = havePets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
    }

//    public String italianDescription(){
//        String result="";
//        result+=  "Famiglia           "+getFullName()+
//                "\nComponent:         "+members+
//                "\nCamere:            "+bedrooms+
//                "\nBagni:             "+bathrooms+
//                "\nAnimali domestici: ";
//        if(havePets) result+="sì";
//        else result+="no";
//        return result;
//    }

    public static Family fetch(String email){
        return Fetch.family(email);
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

    public void setName(String name) {
        this.name = name; update();
    }
    public void setSurname(String surname) {
        this.surname = surname; update();
    }
    public void setCollege(College college) {
        this.college = college; update();
    }
    public void setmembers(int members) {
        this.members = members; update();
    }
    public void setHavePets(boolean havePets) {
        this.havePets = havePets; update();
    }
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms; update();
    }
    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms; update();
    }
    public void setCityDistance(String cityDistance) {
        this.cityDistance = cityDistance; update();
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
    public College getCollege() {
        return college;
    }
    public int getmembers() {
        return members;
    }
    public boolean hasPets() {
        return havePets;
    }
    public int getBedrooms() {
        return bedrooms;
    }
    public int getBathrooms() {
        return bathrooms;
    }
    public String getCityDistance() {
        return cityDistance;
    }
    public String getFullName(){
        return name+" "+surname;
    }
}
