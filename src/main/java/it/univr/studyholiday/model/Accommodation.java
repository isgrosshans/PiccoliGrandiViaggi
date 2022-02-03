package it.univr.studyholiday.model;

import it.univr.studyholiday.model.entities.*;

//wrapper class
public class Accommodation {
    private Bed bed=null;
    private Family family=null;
    private Dormitory dormitory=null;
    private DormRoom dormRoom=null;

    public Accommodation(Bed bed, Family family) {
        this.bed = bed;
        this.family = family;
    }

    public Accommodation(Bed bed, Dormitory dormitory, DormRoom dormRoom) {
        this.bed = bed;
        this.dormitory = dormitory;
        this.dormRoom = dormRoom;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public void setDormRoom(DormRoom dormRoom) {
        this.dormRoom = dormRoom;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String getName(){
        if(family!=null){
            return family.getFirstName()+" "+family.getLastName();
        }
        else
            return "("+dormitory.getSex()+") Camera #"+dormRoom.getRoomNumber()+" presso "+dormitory.getName();
    }

    public String getAddress(){
        if(family!=null)
            return family.getAddress();
        else return dormitory.getAddress();
    }

    public String getType(){
        if(family!=null) return "famiglia";
        String res="";
        if(dormRoom!=null) {
            if(dormRoom.getBeds()==1){
                res+="singola";
            }
            else if(dormRoom.getBeds()==2){
                res+="doppia";
            }
            else {
                res+="camera per"+dormRoom.getBeds();
            }

            if(dormitory.getSex().startsWith("F")
                ||dormitory.getSex().startsWith("f")){
                res+="Femminile";
            }
            else if(dormitory.getSex().startsWith("M")
                    ||dormitory.getSex().startsWith("m")){
                res+="Maschile";
            }
        }
        return res;}

    public String italianDescription(){
        if (family!=null) return family.italianDescription();
        String s="";
        s=dormitory.italianDescription()+"\n"+dormRoom.italianDescription();
        return s;
    }


    public int getBedId() {
        return this.bed.getId();
    }
}
