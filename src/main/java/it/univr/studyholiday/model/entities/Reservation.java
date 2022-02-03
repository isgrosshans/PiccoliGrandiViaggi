package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//RESERVATION
//(id, studentId, holidayId, paymentmethod, familyId*, dormroomId*, friendname*, friendemail*, languagelevel)
public class Reservation implements Entity {
    private int id=-1;
    private int studentId;
    private int holidayId;
    private String paymentMethod;
    private int bedId =-1;
    private String friendEmail;
    private String languageLevel;
    private Boolean familyStay;
    private Boolean requestedSingle;

    //costructor for when student makes reservation


    public Reservation(int studentId, int holidayId, Boolean familyStay, Boolean requestedSingle) {
        this.studentId = studentId;
        this.holidayId = holidayId;
        this.familyStay = familyStay;
        this.requestedSingle = requestedSingle;
    }

    //costructor that gets info from db
    public Reservation(int id, int studentId, int holidayId, String paymentMethod, int bedId, String friendEmail, String languageLevel, Boolean familyStay, Boolean requestedSingle) {
        this.id = id;
        this.studentId = studentId;
        this.holidayId = holidayId;
        this.paymentMethod = paymentMethod;
        this.bedId = bedId;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getBedId() {
        return bedId;
    }

    public String getBedIdString() {
        if(bedId>0) return String.valueOf(bedId); else return "";
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
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
                ", studentId=" + studentId +
                ", holidayId=" + holidayId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", bedId=" + bedId +
                ", friendEmail='" + friendEmail + '\'' +
                ", languageLevel='" + languageLevel + '\'' +
                ", familyStay=" + familyStay +
                ", requestedSingle=" + requestedSingle +
                '}';
    }
}
