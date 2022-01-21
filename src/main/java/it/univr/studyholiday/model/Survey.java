package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;

import java.lang.reflect.Field;

//(id, holidayid, studentid, overall, school, accomodation, activities, fieldtrips)
public class Survey implements Entity {
    private String id;
    private String holidayid;
    private String studentid;
    private int overallScore;
    private int schoolScore;
    private int accomodationScore;
    private int activitiesScore;
    private int fieldtripScore;

    public Survey(String holidayid, String studentid, int overallScore, int schoolScore, int accomodationScore, int activitiesScore, int fieldtripScore) {
        this.id = "";
        this.holidayid = holidayid;
        this.studentid = studentid;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accomodationScore = accomodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripScore = fieldtripScore;
    }

    public Survey(String id, String holidayid, String studentid, int overallScore, int schoolScore, int accomodationScore, int activitiesScore, int fieldtripScore) {
        this.id = id;
        this.holidayid = holidayid;
        this.studentid = studentid;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accomodationScore = accomodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripScore = fieldtripScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(String holidayid) {
        this.holidayid = holidayid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
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

    public int getAvgOverallScore(String holidayid) {
        //todo
        return 0;
    }

    public int getAvgSchoolScore(String holidayid) {
        //todo
        return 0;
    }

    public int getAvgAccomodationScore(String holidayid) {
        //todo
        return 0;
    }

    public int getAvgActivitiesScore(String holidayid) {
        //todo
        return 0;
    }

    public int getAvgFieldtripScore(String holidayid) {
        //todo
        return 0;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
