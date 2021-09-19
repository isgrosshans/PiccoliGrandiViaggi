package it.univr.studyholiday.model;

public class Address {
    private String address;
    private String postalCode;
    private String city;
    private String provinceorstate;
    private String country;

    public Address(String address, String postalCode, String city, String provinceorstate, String country) {
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.provinceorstate = provinceorstate;
        this.country = country;
    }

    public String getFullAddress(){
        return address+", "+postalCode+" "+city+" "+provinceorstate+", "+country;
    }
    public String getAddress() {
        return address;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getCity() {
        return city;
    }
    public String getProvinceorstate() {
        return provinceorstate;
    }
    public String getCountry() {
        return country;
    }
}
