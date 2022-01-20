package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.lang.reflect.Field;

//SCHOOL
//(id, name, address, postalCode, city, country, language)
public class School implements Entity {
//    private SimpleStringProperty id;
//    private SimpleStringProperty name;
//    private SimpleStringProperty address;
//    private SimpleStringProperty postalCode;
//    private SimpleStringProperty city;
//    private SimpleStringProperty country;
//    private SimpleStringProperty language;
//
//    public School(String name, String address, String postalCode, String city, String country, String language) {
//        this.id =           new SimpleStringProperty("");
//        this.name =         new SimpleStringProperty(name);
//        this.address =      new SimpleStringProperty(address);
//        this.postalCode =   new SimpleStringProperty(postalCode);
//        this.city =         new SimpleStringProperty(city);
//        this.country =      new SimpleStringProperty(country);
//        this.language =     new SimpleStringProperty(language);
//    }
//
//    public School(String id, String name, String address, String postalCode, String city, String country, String language) {
//        this.id =           new SimpleStringProperty(id);
//        this.name =         new SimpleStringProperty(name);
//        this.address =      new SimpleStringProperty(address);
//        this.postalCode =   new SimpleStringProperty(postalCode);
//        this.city =         new SimpleStringProperty(city);
//        this.country =      new SimpleStringProperty(country);
//        this.language =     new SimpleStringProperty(language);
//    }
//
//    public String getId() {
//        return id.get();
//    }
//
//    public SimpleStringProperty idProperty() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id.set(id);
//    }
//
//    public String getName() {
//        return name.get();
//    }
//
//    public SimpleStringProperty nameProperty() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name.set(name);
//    }
//
//    public String getAddress() {
//        return address.get();
//    }
//
//    public SimpleStringProperty addressProperty() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address.set(address);
//    }
//
//    public String getPostalCode() {
//        return postalCode.get();
//    }
//
//    public SimpleStringProperty postalCodeProperty() {
//        return postalCode;
//    }
//
//    public void setpostalCode(String postalCode) {
//        this.postalCode.set(postalCode);
//    }
//
//    public String getCity() {
//        return city.get();
//    }
//
//    public SimpleStringProperty cityProperty() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city.set(city);
//    }
//
//    public String getCountry() {
//        return country.get();
//    }
//
//    public SimpleStringProperty countryProperty() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country.set(country);
//    }
//
//    public String getLanguage() {
//        return language.get();
//    }
//
//    public SimpleStringProperty languageProperty() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language.set(language);
//    }

    private String id;
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String language;

    public School(String id, String name,
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
        this.id="";
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.language = language;
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
