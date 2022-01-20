package it.univr.studyholiday.model;

import java.util.ArrayList;

public class Allergy {
    private Student student;
    private String allergen;
    private String precautions;

    public Allergy(Student student, String allergen, String precautions) {
        this.student = student;
        this.allergen = allergen;
        this.precautions = precautions;
    }

    public Student getStudent() {
        return student;
    }
    public String getAllergen() {
        return allergen;
    }
    public String getPrecautions() {
        return precautions;
    }

    //TODO
//     public static ArrayList<Allergy> getAll(Student student){
//        return  Fetch.allAllergiesFor(student.getEmail());
//    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public void setAllergen(String allergen) {
        this.allergen = allergen;
    }
    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
}
