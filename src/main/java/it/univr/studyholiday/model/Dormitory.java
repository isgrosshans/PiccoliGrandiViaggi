package it.univr.studyholiday.model;

//(id, name, address, schoolid, gender)
public class Dormitory {
    String name;
    String address;
    School school;
    String gender;

    public Dormitory(String name, String address, School school, String gender) {
        this.name = name;
        this.address = address;
        this.school = school;
        this.gender = gender;
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

    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
