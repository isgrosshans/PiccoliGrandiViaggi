package it.univr.studyholiday.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Trip {
    private static Holiday holiday;
    private static School school;

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

    public static Holiday getHoliday() {
        return holiday;
    }

    public static void setHoliday(Holiday holiday) {
        Trip.holiday = holiday;
    }

    public static School getSchool() {
        return school;
    }

    public static void setSchool(School school) {
        Trip.school = school;
    }

    public static String getDestination(){
        return school.getCity()+", "+school.getCountry();
    }

    public static String getDepartureDate(){
        return holiday.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public static int getWeeks(){
        return holiday.getWeeks();
    }
}
