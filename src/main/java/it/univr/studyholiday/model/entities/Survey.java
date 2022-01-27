package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//(id, holidayid, studentid, overall, school, accomodation, activities, fieldtrips)
//SK: holidayid, studentid
public class Survey implements Entity {
    private int id = -1;
    private int holidayid;
    private int studentid;
    private String comment;
    private int overallScore;
    private int schoolScore;
    private int accomodationScore;
    private int activitiesScore;
    private int fieldtripScore;

    public Survey(int holidayid, int studentid, String comment, int overallScore, int schoolScore, int accomodationScore, int activitiesScore, int fieldtripScore) {
        this.id = -1;
        this.holidayid = holidayid;
        this.studentid = studentid;
        this.comment = comment;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accomodationScore = accomodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripScore = fieldtripScore;
    }

    public Survey(int id, int holidayid, int studentid, String comment, int overallScore, int schoolScore, int accomodationScore, int activitiesScore, int fieldtripScore) {
        this.id = id;
        this.holidayid = holidayid;
        this.studentid = studentid;
        this.comment = comment;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accomodationScore = accomodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripScore = fieldtripScore;
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

    public int getAccomodationScore() {
        return accomodationScore;
    }

    public void setAccomodationScore(int accomodationScore) {
        this.accomodationScore = accomodationScore;
    }

    public int getActivitiesScore() {
        return activitiesScore;
    }

    public void setActivitiesScore(int activitiesScore) {
        this.activitiesScore = activitiesScore;
    }

    public int getFieldtripScore() {
        return fieldtripScore;
    }

    public void setFieldtripScore(int fieldtripScore) {
        this.fieldtripScore = fieldtripScore;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
