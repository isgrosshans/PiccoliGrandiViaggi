package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.util.ArrayList;

//(id, studentid, holidayid, paymentmethod, familyid*, dormroomid*, friendname*, friendemail*, leveltostudy
public class Reservation {
    private Student student;
    private Holiday holiday;
    private String preferedPayment;
    private Family family;
    private DormRoom dormRoom;
    private String friendName;
    private String friendEmail;
    private String languageLevel;

    public Reservation(Student student, Holiday holiday, String preferredPayment,
                       Family family, DormRoom dormRoom, String friendName,
                       String friendEmail, String languageLevel) {
        this.student = student;
        this.holiday = holiday;
        this.preferedPayment = preferredPayment;
        this.family = family;
        this.dormRoom = dormRoom;
        this.friendName = friendName;
        this.friendEmail = friendEmail;
        this.languageLevel = languageLevel;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Holiday getHoliday() {
        return holiday;
    }
    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public String getPreferedPayment() {
        return preferedPayment;
    }
    public void setPreferedPayment(String preferedPayment) {
        this.preferedPayment = preferedPayment;
    }

    public Family getFamily() {
        return family;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    public DormRoom getDormRoom() {
        return dormRoom;
    }
    public void setDormRoom(DormRoom dormRoom) {
        this.dormRoom = dormRoom;
    }

    public String getFriendName() {
        return friendName;
    }
    public void setFriendName(String friendName) {
        this.friendName = friendName;
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

    //    private Holiday holiday;
//    private Student student;
//    private boolean familystay;
//    private boolean single;
//    private Student friend;
//    private String paymentmethod;
//
//    public Reservation(Holiday holiday, Student student, boolean familystay, boolean single,Student friend, String paymentmethod) {
//        this.holiday = holiday;
//        this.student = student;
//        this.familystay = familystay;
//        this.single = single;
//        this.paymentmethod = paymentmethod;
//    }
//
//    public Reservation(String holiday, String student, boolean familystay, boolean single,String friend, String paymentmethod) {
//        this.holiday = Fetch.holiday(holiday);
//        this.student = Fetch.student(student);
//        this.familystay = familystay;
//        this.single = single;
//        this.friend=Fetch.student(friend);
//        this.paymentmethod = paymentmethod;
//    }
//
//    public void update() {
//        Update.update(this);
//    }
//    public void add() {
//        Add.add(this);
//    }
//    public void delete() {
//        Delete.delete(this);
//    }
//
//    public static ArrayList<Reservation> allReservationsFor(Student student){
//        return Fetch.allReservationsFor(student.getEmail());
//    }
//
//    public Holiday getHoliday() {
//        return holiday;
//    }
//    public Student getStudent() {
//        return student;
//    }
//    public boolean isFamilyStay() {
//        return familystay;
//    }
//    public boolean isSingle() {
//        return single;
//    }
//    public String getPaymentmethod() {
//        return paymentmethod;
//    }
//    public Student getFriend() {
//        return friend;
//    }
//
//    public void setHoliday(Holiday holiday) {
//        this.holiday = holiday;
//    }
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//    public void setFamilystay(boolean familystay) {
//        this.familystay = familystay;
//    }
//    public void setSingle(boolean single) {
//        this.single = single;
//    }
//    public void setFriend(Student friend) {
//        this.friend = friend;
//    }
//    public void setPaymentmethod(String paymentmethod) {
//        this.paymentmethod = paymentmethod;
//    }
}
