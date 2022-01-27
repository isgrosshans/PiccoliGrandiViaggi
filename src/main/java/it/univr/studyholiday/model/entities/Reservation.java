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
    private String friendName;
    private String friendEmail;
    private String languageLevel;

    public Reservation(int studentid, int holidayid, String paymentMethod, int bedid, String friendName, String friendEmail, String languageLevel) {
        this.studentid = studentid;
        this.holidayid = holidayid;
        this.paymentMethod = paymentMethod;
        this.bedid = bedid;
        this.friendName = friendName;
        this.friendEmail = friendEmail;
        this.languageLevel = languageLevel;
    }

    public Reservation(int id, int studentid, int holidayid, String paymentMethod, int bedid, String friendName, String friendEmail, String languageLevel) {
        this.id = id;
        this.studentid = studentid;
        this.holidayid = holidayid;
        this.paymentMethod = paymentMethod;
        this.bedid = bedid;
        this.friendName = friendName;
        this.friendEmail = friendEmail;
        this.languageLevel = languageLevel;
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

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
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
