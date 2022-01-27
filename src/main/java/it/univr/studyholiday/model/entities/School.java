package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//SCHOOL
//(id, name, address, postalCode, city, country, language)
//SK name, full address
public class School implements Entity {
    private int id=-1;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String language;

    public School(int id, String name,
                  String address, String postalCode,
                  String city, String country,
                  String language) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.language = language;
    }

    public School(String name, String address,
                  String postalCode, String city,
                  String country, String language) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return getName()+getAddress()+getCity()+getLanguage()+getCountry()+getPostalCode()+getId();    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
