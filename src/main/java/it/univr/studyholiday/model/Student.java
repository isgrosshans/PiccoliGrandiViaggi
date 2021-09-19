package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
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
    private Address address;
    private ArrayList<Allergy> allergies;


    public Student(String email, String password,
                   String name, String surname,
                   LocalDate birthday, String birthplace,
                   String sex, String phonenumber,
                   Address address) {
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

    public static void singupStudent(Student st) {
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
    public Address getAddress() {
        return address;
    }

    public ArrayList<Allergy> getAllergies() {
        return allergies;
    }



}
