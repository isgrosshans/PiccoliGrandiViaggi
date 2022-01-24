package it.univr.studyholiday.model;


import it.univr.studyholiday.util.Database.*;

import java.lang.reflect.Field;
import java.time.LocalDate;

//     HOLIDAY(id,
//      startdate,weeks,school)
public class Holiday implements Entity{
    private int id = -1;
    private LocalDate start;
    private int weeks;
    private School school;

    public Holiday(LocalDate start, int weeks, School school) {
        this.start = start;
        this.weeks = weeks;
        this.school = school;
    }

    public Holiday(int id, LocalDate start, int weeks, School school) {
        this.id = id;
        this.start = start;
        this.weeks = weeks;
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public int getWeeks() {
        return weeks;
    }

    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);


    }
}
