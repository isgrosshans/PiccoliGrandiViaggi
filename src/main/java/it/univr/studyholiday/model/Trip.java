package it.univr.studyholiday.model;

import it.univr.studyholiday.model.entities.Holiday;
import it.univr.studyholiday.model.entities.School;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trip {
    private Holiday holiday;
    private School school;

    public Trip(Holiday h, School s) {
        holiday =h;
        school=s;
    }

    public Trip(int holidayid, LocalDate holidaystart, int holidayweeks,
                int schoolid, String schoolname,
                String schooladdress, String schoolpostalCode,
                String schoolcity, String schoolcountry,
                String schoollanguage) {
        holiday=new Holiday(holidayid,holidaystart,holidayweeks,schoolid);
        school=new School(schoolid,schoolname,schooladdress,schoolpostalCode,schoolcity,schoolcountry,schoollanguage);
    }

    public Holiday getHoliday() {
        return this.holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public School getSchool() {
        return this.school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getDestination(){
        return this.school.getCity()+", "+this.school.getCountry();
    }

    public LocalDate getDepartureDate(){
        return this.holiday.getDepartureDate();
    }

    public int getWeeks(){
        return this.holiday.getWeeks();
    }
}
