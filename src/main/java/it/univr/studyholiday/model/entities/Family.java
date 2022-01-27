package it.univr.studyholiday.model.entities;

//import it.univr.studyholiday.util.Database.Add;
//import it.univr.studyholiday.util.Database.Delete;
//import it.univr.studyholiday.util.Database.Fetch;
//import it.univr.studyholiday.util.Database.Update;

import java.lang.reflect.Field;

//FAMILY
//(id, schoolid, email, firstname, lastname, members, phone,
// address, pets, bathrooms, bedrooms, citydistance)
public class Family implements Entity {
    private int id=-1;
    private int schoolid;
    private String email;
    private String firstName;
    private String lastName;
    private int members;
    private boolean pets;
    private int bedrooms;
    private int bathrooms;
    private String cityDistance;
    private String address;
    private String phone;

    public Family(int schoolid, String email, String firstName,
                  String lastName, int members, boolean pets,
                  int bedrooms, int bathrooms, String cityDistance,
                  String address, String phone) {
        this.schoolid = schoolid;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.members = members;
        this.pets = pets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
        this.address = address;
        this.phone=phone;
    }

    public Family(int id, int schoolid, String email,
                  String firstName, String lastName, int members,
                  boolean pets, int bedrooms, int bathrooms,
                  String cityDistance, String address, String phone) {
        this.id = id;
        this.schoolid = schoolid;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.members = members;
        this.pets = pets;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.cityDistance = cityDistance;
        this.address = address;
        this.phone=phone;
    }

    public String italianDescription(){
        String result="";
        result+=  "Famiglia di             "+firstName+" "+lastName+
                "\nComponent:              "+members+
                "\nCamere per gli ospiti:  "+bedrooms+
                "\nBagni per gli ospiti:   "+bathrooms+
                "\nAnimali domestici:      ";
        if(pets) result+="sì";
        else result+="no";
        result+="\nDistanza dal centro:    "+cityDistance;
        return result;
    }


    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

    public String getHouseholderName() {
        return firstName+" "+lastName;
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

    public boolean isPets() {
        return pets;
    }

    public String hasPets() {
        if(pets) return "sì";
        else return "no";
    }

    public void setPets(boolean pets) {
        this.pets = pets;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
