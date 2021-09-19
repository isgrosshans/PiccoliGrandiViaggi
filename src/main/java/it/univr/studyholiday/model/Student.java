package it.univr.studyholiday.model;

import java.time.LocalDate;

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

    public static void singupStudent(){}
}
