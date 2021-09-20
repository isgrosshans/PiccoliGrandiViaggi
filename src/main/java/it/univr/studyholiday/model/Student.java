package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.Update;

import java.time.LocalDate;
import java.util.ArrayList;

//     STUDENT(email, password, name, surname,
//          birthday, birthplace, sex, address,
//          phonenumber* 	)
public class Student {
    private String email;
    private String password;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String birthplace;
    private String sex;
    private String phonenumber;
    private String address;
    private ArrayList<Allergy> allergies;


    public Student(String email, String password,
                   String name, String surname,
                   LocalDate birthday, String birthplace,
                   String sex, String phonenumber,
                   String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.birthplace = birthplace;
        this.sex = sex;
        this.phonenumber = phonenumber;
        this.address = address;
    }

    public static void fetch(String email){
        Fetch.student(email);
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

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
    public String getBirthplace() {
        return birthplace;
    }
    public String getSex() {
        return sex;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public String getAddress() {
        return address;
    }

    public ArrayList<Allergy> getAllergies() {
        return allergies;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAllergies(ArrayList<Allergy> allergies) {
        this.allergies = allergies;
    }
}
