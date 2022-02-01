package it.univr.studyholiday.model.entities;

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
            return family.getLastName();
        }
        else
            return "("+dormitory.getSex()+") Camera "+dormRoom.getRoomNumber()+" presso "+dormitory.getName();
    }

    public String getAddress(){
        if(family!=null)
            return family.getAddress();
        else return dormitory.getAddress();
    }

    public String getType(){return "";}


}
