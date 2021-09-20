package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.sql.SQLException;

//DORMROOM(-college,	number-, 	beds 		)
public class DormRoom {
    private College college;
    private String roomNumber;
    private int beds;

    public DormRoom(College college, String roomNumber, int beds) {
        this.college = college;
        this.roomNumber = roomNumber;
        this.beds = beds;
    }

    public DormRoom(String college, String roomNumber, int beds) {
        this.college = Fetch.college(college);
        this.roomNumber = roomNumber;
        this.beds = beds;
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

    public College getCollege() {
        return college;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public int getBeds() {
        return beds;
    }

    public void setCollege(College college) {
        this.college = college;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setBeds(int beds) {
        this.beds = beds;
    }
}
