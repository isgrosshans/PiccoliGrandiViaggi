package it.univr.studyholiday.model;

//import it.univr.studyholiday.util.Database.Add;
//import it.univr.studyholiday.util.Database.Delete;
//import it.univr.studyholiday.util.Database.Fetch;
//import it.univr.studyholiday.util.Database.Update;

import it.univr.studyholiday.util.Database.Entity;

import java.lang.reflect.Field;

//FAMILY
//(id, hhfirstname, hhlastname, hhemail, hhphone, address, members, pets, baths, beds, citydistance , schoolid)
public class Family implements Entity {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private int members;
    private boolean havePets;
    private int bedrooms;
    private int bathrooms;
    private String cityDistance;
    private String address;

    public Family(String email, String firstName, String lastName,
                  int members, boolean havePets, int bedrooms,
                  int bathrooms, String cityDistance, String address) {
        this.id="";
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.members = members;
        this.havePets = havePets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
        this.address = address;
    }

    public Family(String id, String email, String firstName,
                  String lastName, int members, boolean havePets,
                  int bedrooms, int bathrooms, String cityDistance,
                  String address) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.members = members;
        this.havePets = havePets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
        this.address = address;
    }

    public String italianDescription(){
        String result="";
        result+=  "Famiglia di             "+getFullName()+
                "\nComponent:              "+members+
                "\nCamere per gli ospiti:  "+bedrooms+
                "\nBagni per gli ospiti:   "+bathrooms+
                "\nAnimali domestici:      ";
        if(havePets) result+="sì";
        else result+="no";
        result+="\nDistanza dal centro:    "+cityDistance;
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public boolean isHavePets() {
        return havePets;
    }

    public void setHavePets(boolean havePets) {
        this.havePets = havePets;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getCityDistance() {
        return cityDistance;
    }

    public void setCityDistance(String cityDistance) {
        this.cityDistance = cityDistance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
