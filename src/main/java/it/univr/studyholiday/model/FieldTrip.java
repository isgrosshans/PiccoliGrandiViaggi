package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

public class FieldTrip {

    private Holiday holiday;
    private String destination;
    private String description;
    private int price;
    private int hours;

    public FieldTrip(Holiday holiday, String destination,
                     String description, int price,
                     int hours) {
        this.holiday = holiday;
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
    }

    public FieldTrip(String holiday, String destination,
                     String description, int price,
                     int hours) {
        this.holiday = Fetch.holiday(holiday);
        this.destination = destination;
        this.description = description;
        this.price = price;
        this.hours = hours;
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

    public Holiday getHoliday() {
        return holiday;
    }
    public String getDestination() {
        return destination;
    }
    public String getDescription() {
        return description;
    }
    public int getPrice() {
        return price;
    }
    public int getHours() {
        return hours;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
}
