package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

public class Allergy implements Entity {
    private int id=-1;
    private int studentid;
    private String allergen;
    private String precaution;

    public Allergy(String allergen, String precaution) {
        this.allergen = allergen;
        this.precaution = precaution;
    }

    public Allergy(int studentid, String allergen, String precaution) {
        this.studentid = studentid;
        this.allergen = allergen;
        this.precaution = precaution;
    }

    public Allergy(int id, int studentid, String allergen, String precaution) {
        this.id = id;
        this.studentid = studentid;
        this.allergen = allergen;
        this.precaution = precaution;
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

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }

    public String getPrecaution() {
        return precaution;
    }

    public void setPrecaution(String precaution) {
        this.precaution = precaution;
    }

    @Override
    public String toString() {
        return allergen + " (" + precaution + ")";
    }
}
