package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.lang.reflect.Field;
import java.util.Objects;

//FIELDTRIP
//(id, holidayid, destination, hours, price, description)
public class FieldTrip implements Entity{
    private int id = -1;
    private int holidayid=-1;
    private String destination;
    private String description;
    private int price;
    private int hours;

    public FieldTrip(int holidayid, String destination, String description, int price, int hours) {
        this.holidayid = holidayid;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public FieldTrip(int id, int holidayid, String destination, String description, int price, int hours) {
        this.id = id;
        this.holidayid = holidayid;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public FieldTrip(String destination, String description, int price, int hours) {
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(int holidayid) {
        this.holidayid = holidayid;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public boolean sameAs(FieldTrip f){
        return
                this.destination.equals(f.getDestination())
            &&  this.description.equals(f.getDescription())
            &&  this.price==f.getPrice()
            &&  this.hours==f.getHours()
                ;
    }

    @Override
    public String toString() {
        return "FieldTrip{" +
                "id=" + id +
                ", holidayid=" + holidayid +
                ", destination='" + destination + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", hours=" + hours +
                '}';
    }
}
