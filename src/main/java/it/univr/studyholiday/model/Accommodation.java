package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;
import java.time.LocalDate;

//ACCOMODATION(student,holiday,
//             dormroom,family,startdate,enddate)
public class Accommodation {

    private Reservation reservation;
    private DormRoom dormRoom;
    private Family family;
    private LocalDate startDate;
    private LocalDate endDate;

    public Accommodation(Reservation reservation,
                        DormRoom dormRoom, Family family,
                        LocalDate startDate, LocalDate endDate) {
        this.reservation = reservation;
        this.dormRoom = dormRoom;
        this.family = family;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public Accommodation(Reservation reservation,
                         String dormRoomnum, String family,
                         LocalDate startDate, LocalDate endDate) {
        this.reservation = reservation;
        this.dormRoom = Fetch.dormRoom(reservation.getHoliday().getCollege().getId(),dormRoomnum);
        this.family = Fetch.family(family);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Accommodation(String student, String holidayid,
                         String dormRoomnum, String family,
                         LocalDate startDate, LocalDate endDate) {
        this.reservation = Fetch.reservation(student, holidayid);
        this.dormRoom = Fetch.dormRoom(reservation.getHoliday().getCollege().getId(),dormRoomnum);
        this.family = Fetch.family(family);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void update() {
        Update.update(this);
    }
    public void add() {
        Add.add(this);
    }
    public void delete() {
        Delete.delete(this);
    }

    public Reservation getReservation() {
        return reservation;
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



    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
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


    public Student getStudent() {
        return reservation.getStudent();
    }
    public Holiday getHoliday() {
        return reservation.getHoliday();
    }
}
