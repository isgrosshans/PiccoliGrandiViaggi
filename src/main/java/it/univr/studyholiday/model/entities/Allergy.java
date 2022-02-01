package it.univr.studyholiday.model.entities;

import java.lang.reflect.Field;

public class Allergy implements Entity {
    private int id=-1;
    private int studentid;
    private String allergen;
    private String precautions;

    public Allergy(String allergen, String precautions) {
        this.allergen = allergen;
        this.precautions = precautions;
    }

    public Allergy(int studentid, String allergen, String precautions) {
        this.studentid = studentid;
        this.allergen = allergen;
        this.precautions = precautions;
    }

    public Allergy(int id, int studentid, String allergen, String precautions) {
        this.id = id;
        this.studentid = studentid;
        this.allergen = allergen;
        this.precautions = precautions;
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

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
}
