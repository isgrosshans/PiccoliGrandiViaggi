package it.univr.studyholiday.model;


import it.univr.studyholiday.util.Database.*;

import java.time.LocalDate;
import java.util.ArrayList;

//     HOLIDAY(id,
//      startdate,weeks,school)
public class Holiday {
    private LocalDate startDate;
    private int weeks;
    private School school;
    //destination and language come from the school

    public Holiday(LocalDate startDate, int weeks, School school) {
        this.startDate = startDate;
        this.weeks = weeks;
        this.school = school;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return startDate.plusWeeks(weeks).minusDays(1);
    }
    public int getWeeks() {
        return weeks;
    }
    public School getSchool() {
        return school;
    }
    public String getDestination(){
        return school.getCity()+", "+school.getCountry();
    }
    public String getLanguage(){
        return school.getLanguage();
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }
    public void setSchool(School school) {
        this.school = school;
    }
}
