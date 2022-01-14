package it.univr.studyholiday.model;

//SCHOOL
//(id, name, address, country, language)
public class School {

    //private int id;
    private String name;
    //private String address;
    //private String postalcode;
    private String city;
    //private String country;
    private String language;

    public School(String name, String city, String language) {
        this.name = name;
        this.city = city;
        this.language = language;
    }

    //    public School(int id, String name, String address, String postalcode, String city, String country, String language) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.postalcode = postalcode;
//        this.city = city;
//        this.country = country;
//        this.language = language;
//    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLanguage() {
        return language;
    }
}
