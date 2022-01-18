package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;
import it.univr.studyholiday.util.Database.LoginDB;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;

//     STUDENT(email, password, firstName, lastName,
//          birthday, birthplace, sex, address,
//          phonenumber* 	)

//STUDENT
//(id, email, password, firstname, lastname, birthday, gender, homeaddress, phone*, parent1id, parent2id*, hobby)
public class Student implements Entity {
    private String email;
    private String psw;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String sex;
    private String address;
    private String phone;
    private String hobby;
    private String idParent1;
    private String idParent2;

    public Student(String email, String firstName,
                   String lastName, LocalDate birthday,
                   String sex, String address,
                   String phone, String hobby,
                   String idParent1, String idParent2) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobby = hobby;
        this.idParent1 = idParent1;
        this.idParent2 = idParent2;
    }

    public Student(String email, String psw, String firstName, String lastName, LocalDate birthday, String sex, String address, String phone, String hobby, String idParent1, String idParent2) {
        this.email = email;
        this.psw = LoginDB.encrypy(psw);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobby = hobby;
        this.idParent1 = idParent1;
        this.idParent2 = idParent2;
    }

    //special getter
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

    //standard getters and setters
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getIdParent1() {
        return idParent1;
    }

    public void setIdParent1(String idParent1) {
        this.idParent1 = idParent1;
    }

    public String getIdParent2() {
        return idParent2;
    }

    public void setIdParent2(String idParent2) {
        this.idParent2 = idParent2;
    }

    //    public void singupStudent(Student student, Parent parent1, Parent parent2) {
//        student.add();
//        Add.add(student.getAllergies());
//        // Add.add(student.getHobby());
//
//        parent1.add();
//        parent2.add();
//    }
//
//    public void singupStudent(Student student, Parent parent1) {
//        student.add();
//        Add.add(student.getAllergies());
//        // Add.add(student.getHobby());
//
//        parent1.add();
//    }

}
