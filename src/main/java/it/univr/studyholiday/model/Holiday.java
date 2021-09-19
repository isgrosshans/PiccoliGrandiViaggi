package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Fetch;

import java.time.LocalDate;
import java.util.ArrayList;

//     HOLIDAY(id,
//             startdate,weeks,college)
public class Holiday {
    private String id;
    private LocalDate startDate;
    private int weeks;
    private College college;
    private ArrayList<FieldTrip> fieldTrips;

    public Holiday(String id, LocalDate startDate, int weeks, College college) {
        this.id = id;
        this.startDate = startDate;
        this.weeks = weeks;
        this.college = college;
        this.fieldTrips = Fetch.fieldTripsFor(id);
    }

    public Holiday(String id, LocalDate startDate, int weeks, String college) {
        this.id = id;
        this.startDate = startDate;
        this.weeks = weeks;
        this.college = Fetch.college(college);
        this.fieldTrips = Fetch.fieldTripsFor(id);
    }


    public String getId() {
        return id;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {return startDate.plusWeeks(weeks).minusDays(1)}
    public int getWeeks() {
        return weeks;
    }
    public College getCollege() {
        return college;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setWeeks(int weeks) {
        this.weeks = weeks;
    }
    public void setCollege(College college) {
        this.college = college;
    }
}
