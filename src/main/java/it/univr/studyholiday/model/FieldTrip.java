package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.lang.reflect.Field;

//FIELDTRIP
//(id, holidayid, destination, hours, price, description)
public class FieldTrip implements Entity{
    private String id;
    private String destination;
    private String description;
    private int price;
    private int hours;

    public FieldTrip(String destination, String description, int price, int hours) {
        this.id="";
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public FieldTrip(String id, String destination, String description, int price, int hours) {
        this.id = id;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
