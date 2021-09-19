package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.util.ArrayList;

//RESERVATION(holiday,student,
// 			familystay*,single*,friend*,paymentmethod)
public class Reservation {
    private Holiday holiday;
    private Student student;
    private boolean familystay;
    private boolean single;
    private String paymentmethod;

    public Reservation(Holiday holiday, Student student, boolean familystay, boolean single, String paymentmethod) {
        this.holiday = holiday;
        this.student = student;
        this.familystay = familystay;
        this.single = single;
        this.paymentmethod = paymentmethod;
    }

    public Reservation(String holiday, String student, boolean familystay, boolean single, String paymentmethod) {
        this.holiday = Fetch.holiday(holiday);
        this.student = Fetch.student(student);
        this.familystay = familystay;
        this.single = single;
        this.paymentmethod = paymentmethod;
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

    public static Reservation fetch(Student student, Holiday holiday){
        return Fetch.reservation(student.getEmail(), holiday.getId());
    }
    public static ArrayList<Reservation> allReservationsFor(Student student){
        return Fetch.allReservationsFor(student.getEmail());
    }

    public Holiday getHoliday() {
        return holiday;
    }
    public Student getStudent() {
        return student;
    }
    public boolean isFamilyStay() {
        return familystay;
    }
    public boolean isSingle() {
        return single;
    }
    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setFamilystay(boolean familystay) {
        this.familystay = familystay;
    }
    public void setSingle(boolean single) {
        this.single = single;
    }
    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }
}
