package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Entity;

import java.lang.reflect.Field;

public class Allergy implements Entity {
    private String id;
    private String studentid;
    private String allergen;
    private String precautions;

    public Allergy(String studentid, String allergen, String precautions) {
        this.id="";
        this.studentid = studentid;
        this.allergen = allergen;
        this.precautions = precautions;
    }

    public Allergy(String id, String studentid, String allergen, String precautions) {
        this.id = id;
        this.studentid = studentid;
        this.allergen = allergen;
        this.precautions = precautions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
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

    @Override
    public Object getValue(Field field) throws IllegalAccessException {
        return field.get(this);
    }
}
