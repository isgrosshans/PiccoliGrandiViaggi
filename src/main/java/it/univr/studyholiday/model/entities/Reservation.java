package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//RESERVATION
//(id, studentid, holidayid, paymentmethod, familyid*, dormroomid*, friendname*, friendemail*, languagelevel)
public class Reservation implements Entity {
    private int id=-1;
    private int studentid;
    private int holidayid;
    private String paymentMethod;
    private int bedid =-1;
    private String friendEmail;
    private String languageLevel;
    private Boolean familyStay;
    private Boolean requestedSingle;

    //costructor for when student makes reservation


    public Reservation(int studentid, int holidayid, Boolean familyStay, Boolean requestedSingle) {
        this.studentid = studentid;
        this.holidayid = holidayid;
        this.familyStay = familyStay;
        this.requestedSingle = requestedSingle;
    }

    //costructor that gets info from db
    public Reservation(int id, int studentid, int holidayid, String paymentMethod, int bedid, String friendEmail, String languageLevel, Boolean familyStay, Boolean requestedSingle) {
        this.id = id;
        this.studentid = studentid;
        this.holidayid = holidayid;
        this.paymentMethod = paymentMethod;
        this.bedid = bedid;
        this.friendEmail = friendEmail;
        this.languageLevel = languageLevel;
        this.familyStay = familyStay;
        this.requestedSingle = requestedSingle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(int holidayid) {
        this.holidayid = holidayid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getBedid() {
        return bedid;
    }

    public void setBedid(int bedid) {
        this.bedid = bedid;
    }

    public String getFriendEmail() {
        return friendEmail;
    }

    public void setFriendEmail(String friendEmail) {
        this.friendEmail = friendEmail;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }

    public Boolean getFamilyStay() {
        return familyStay;
    }

    public void setFamilyStay(Boolean familyStay) {
        this.familyStay = familyStay;
    }

    public Boolean getRequestedSingle() {
        return requestedSingle;
    }

    public void setRequestedSingle(Boolean requestedSingle) {
        this.requestedSingle = requestedSingle;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", studentid=" + studentid +
                ", holidayid=" + holidayid +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", bedid=" + bedid +
                ", friendEmail='" + friendEmail + '\'' +
                ", languageLevel='" + languageLevel + '\'' +
                ", familyStay=" + familyStay +
                ", requestedSingle=" + requestedSingle +
                '}';
    }
}
