package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Update;

import java.time.LocalDate;

//ACCOMODATION(student,holiday,
//             dormroom,family,startdate,enddate)
public class Accomodation {
    private Student student;
    private Holiday holiady;
    private DormRoom dormRoom;
    private Family family;
    private LocalDate startDate;
    private LocalDate endDate;

    public Accomodation(Student student, Holiday holiady,
                        DormRoom dormRoom, Family family,
                        LocalDate startDate, LocalDate endDate) {
        this.student = student;
        this.holiady = holiady;
        this.dormRoom = dormRoom;
        this.family = family;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static void assignAccomodation(){}

    public void update() {
        Update.update(this);
    }
    public void add() {
        Add.add(this);
    }
    public void delete() {
        Delete.delete(this);
    }

    public Student getStudent() {
        return student;
    }
    public Holiday getHoliady() {
        return holiady;
    }
    public DormRoom getDormRoom() {
        return dormRoom;
    }
    public Family getFamily() {
        return family;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public void setHoliady(Holiday holiady) {
        this.holiady = holiady;
    }
    public void setDormRoom(DormRoom dormRoom) {
        this.dormRoom = dormRoom;
    }
    public void setFamily(Family family) {
        this.family = family;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
