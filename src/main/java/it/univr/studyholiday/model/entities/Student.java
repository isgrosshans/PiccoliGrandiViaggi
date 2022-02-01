package it.univr.studyholiday.model.entities;

import it.univr.studyholiday.util.Database.LoginDB;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//     STUDENT(email, password, firstName, lastName,
//          birthday, birthplace, sex, address,
//          phonenumber* 	)

//STUDENT
//(id, email, password, firstname, lastname, birthday, gender, address, phone*, parent1id, parent2id*, hobbies)
public class Student implements Entity {
    private int id=-1;
    private String email;
    private String psw="";
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String sex;
    private String address;
    private String phone;
    private String hobbies;
    private int parent1id;
    private int parent2id=-1;

    public Student(int id, String email, String psw, String firstName, String lastName, LocalDate birthday, String sex, String address, String phone, String hobbies, int parent1id, int parent2id) {
        this.id = id;
        this.email = email;
        this.psw = psw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
        this.parent1id = parent1id;
        this.parent2id = parent2id;
    }

    public Student(String email, String psw, String firstName, String lastName, LocalDate birthday, String sex, String address, String phone, String hobbies, int parent1id, int parent2id) {
        this.email = email;
        this.psw = LoginDB.encrypy(psw);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
        this.parent1id = parent1id;
        this.parent2id = parent2id;
    }
    public Student(String email, String psw, String firstName, String lastName, LocalDate birthday, String sex, String address, String phone, String hobbies, int parent1id) {
        this.email = email;
        this.psw = LoginDB.encrypy(psw);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
        this.parent1id = parent1id;
    }

    public Student(int id, String email, /*String psw,*/ String firstName, String lastName, LocalDate birthday, String sex, String address, String phone, String hobbies, int parent1id, int parent2id) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
        this.parent1id = parent1id;
        this.parent2id = parent2id;
    }

    public Student(String email, String psw, String firstName, String lastName, LocalDate birthday, String sex, String address, String phone, String hobbies) {
        this.email = email;
        this.psw = LoginDB.encrypy(psw);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.hobbies = hobbies;
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
        if(phone==null)return""; else return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getParent1id() {
        return parent1id;
    }

    public void setParent1id(int parent1id) {
        this.parent1id = parent1id;
    }

    public int getParent2id() {
        return parent2id;
    }

    public void setParent2id(int parent2id) {
        this.parent2id = parent2id;
    }

    public String getBirthdayString() {
        return birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public int getId() {
        return id;
    }

    public String getFullName(){
        return firstName+" "+lastName;
    }
}
