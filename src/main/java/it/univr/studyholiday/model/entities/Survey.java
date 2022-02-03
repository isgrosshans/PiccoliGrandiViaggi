package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//(id, holidayid, studentid, overall, school, accomodation, activities, fieldtrips)
//SK: holidayid, studentid
public class Survey implements Entity {
    private int id = -1;
    private int holidayid = -1;
    private int studentid = -1;
    private String comment;
    private int overallScore;
    private int schoolScore;
    private int accommodationScore;
    private int activitiesScore;
    private int fieldtripsScore;

    public Survey(int holidayid, int studentid, String comment, int overallScore, int schoolScore, int accommodationScore, int activitiesScore, int fieldtripsScore) {
        this.id = -1;
        this.holidayid = holidayid;
        this.studentid = studentid;
        this.comment = comment;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accommodationScore = accommodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripsScore = fieldtripsScore;
    }

    public Survey(int id, int holidayid, int studentid, String comment, int overallScore, int schoolScore, int accommodationScore, int activitiesScore, int fieldtripsScore) {
        this.id = id;
        this.holidayid = holidayid;
        this.studentid = studentid;
        this.comment = comment;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accommodationScore = accommodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripsScore = fieldtripsScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(int holidayid) {
        this.holidayid = holidayid;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getSchoolScore() {
        return schoolScore;
    }

    public void setSchoolScore(int schoolScore) {
        this.schoolScore = schoolScore;
    }

    public int getAccommodationScore() {
        return accommodationScore;
    }

    public void setAccommodationScore(int accommodationScore) {
        this.accommodationScore = accommodationScore;
    }

    public int getActivitiesScore() {
        return activitiesScore;
    }

    public void setActivitiesScore(int activitiesScore) {
        this.activitiesScore = activitiesScore;
    }

    public int getFieldtripsScore() {
        return fieldtripsScore;
    }

    public void setFieldtripsScore(int fieldtripsScore) {
        this.fieldtripsScore = fieldtripsScore;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
