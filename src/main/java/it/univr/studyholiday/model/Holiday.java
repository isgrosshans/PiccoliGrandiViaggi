package it.univr.studyholiday.model;


import it.univr.studyholiday.util.Database.*;

import java.lang.reflect.Field;
import java.time.LocalDate;

//     HOLIDAY(id,
//      startdate,weeks,school)
public class Holiday implements Entity{
    private int id = -1;
    private LocalDate departureDate;
    private int weeks;
    private int schoolid;

    public Holiday(LocalDate departureDate, int weeks, int schoolid) {
        this.departureDate = departureDate;
        this.weeks = weeks;
        this.schoolid = schoolid;
    }

    public Holiday(int id, LocalDate departureDate, int weeks, int schoolid) {
        this.id = id;
        this.departureDate = departureDate;
        this.weeks = weeks;
        this.schoolid = schoolid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public int getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(int schoolid) {
        this.schoolid = schoolid;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);


    }
}
