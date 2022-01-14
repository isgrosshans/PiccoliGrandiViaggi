package it.univr.studyholiday.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//SCHOOL
//(id, name, address, postalcode, city, country, language)
public class School {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty address;
    private SimpleStringProperty postalcode;
    private SimpleStringProperty city;
    private SimpleStringProperty country;
    private SimpleStringProperty language;

    public School(int id, String name, String address, String postalcode, String city, String country, String language) {
        this.id =           new SimpleIntegerProperty(id);
        this.name =         new SimpleStringProperty(name);
        this.address =      new SimpleStringProperty(address);
        this.postalcode =   new SimpleStringProperty(postalcode);
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

    public String getPostalcode() {
        return postalcode.get();
    }

    public SimpleStringProperty postalcodeProperty() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode.set(postalcode);
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
}
