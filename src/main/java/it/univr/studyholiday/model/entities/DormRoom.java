package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

//DORMROOM
//(id, roomnumber, dormitoryid beds)
public class DormRoom implements Entity {
    private int id=-1;
    private int dormitoryid;
    private String roomNumber;
    private int beds;

    public DormRoom(int dormitoryid, String roomNumber, int beds) {
        this.dormitoryid = dormitoryid;
        this.roomNumber = roomNumber;
        this.beds = beds;
    }

    public DormRoom(int id, int dormitoryid, String roomNumber, int beds) {
        this.id = id;
        this.dormitoryid = dormitoryid;
        this.roomNumber = roomNumber;
        this.beds = beds;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

    public int getId() {
        return id;
    }


    public int getDormitoryid() {
        return dormitoryid;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getBeds() {
        return beds;
    }


    public String italianDescription(){
        String s="Camera numero "+roomNumber+"\n";
        if(beds==1) s+="Singola";
        else s+=beds+" posti letto";
        return s;
    }
}
