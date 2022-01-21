package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.lang.reflect.Field;
import java.sql.SQLException;

//DORMROOM
//(id, roomnumber, dormitoryid beds)
public class DormRoom implements Entity{
    private String id;
    private String dormitoryid;
    private String roomNumber;
    private int beds;

    public DormRoom(String dormitoryid, String roomNumber, int beds) {
        this.id = "";
        this.dormitoryid = dormitoryid;
        this.roomNumber = roomNumber;
        this.beds = beds;
    }

    public DormRoom(String id, String dormitoryid, String roomNumber, int beds) {
        this.id = id;
        this.dormitoryid = dormitoryid;
        this.roomNumber = roomNumber;
        this.beds = beds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
