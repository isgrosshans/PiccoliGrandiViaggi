package it.univr.studyholiday.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//SCHOOL
//(id, name, address, postalCode, city, country, language)
public class School {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty address;
    private SimpleStringProperty postalCode;
    private SimpleStringProperty city;
    private SimpleStringProperty country;
    private SimpleStringProperty language;

    public School(int id, String name, String address, String postalCode, String city, String country, String language) {
        this.id =           new SimpleIntegerProperty(id);
        this.name =         new SimpleStringProperty(name);
        this.address =      new SimpleStringProperty(address);
        this.postalCode =   new SimpleStringProperty(postalCode);
        this.city =         new SimpleStringProperty(city);
        this.country =      new SimpleStringProperty(country);
        this.language =     new SimpleStringProperty(language);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPostalCode() {
        return postalCode.get();
    }

    public SimpleStringProperty postalCodeProperty() {
        return postalCode;
    }

    public void setpostalCode(String postalCode) {
        this.postalCode.set(postalCode);
    }

    public String getCity() {
        return city.get();
    }

    public SimpleStringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getLanguage() {
        return language.get();
    }

    public SimpleStringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    @Override
    public String toString() {
        return getName()+getAddress()+getCity()+getLanguage()+getCountry()+getPostalCode()+getId();    }
}
