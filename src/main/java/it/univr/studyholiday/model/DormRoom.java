package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.sql.SQLException;

//DORMROOM(-college,	number-, 	beds 		)
public class DormRoom {
    private Dormitory dormitory;
    private String roomNumber;
    private int beds;

    public DormRoom(Dormitory dormitory, String roomNumber, int beds) {
        this.dormitory = dormitory;
        this.roomNumber = roomNumber;
        this.beds = beds;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
    public int getBeds() {
        return beds;
    }

    public void setCollege(Dormitory dormitory) {
        this.dormitory = dormitory;
    }
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    public void setBeds(int beds) {
        this.beds = beds;
    }
}
