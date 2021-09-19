package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Add;
import it.univr.studyholiday.util.Database.Delete;
import it.univr.studyholiday.util.Database.Fetch;
import it.univr.studyholiday.util.Database.Update;

public class Allergy {
    private Student student;
    private String allergen;
    private String precautions;

    public Allergy(Student student, String allergen, String precautions) {
        this.student = Fetch.student(student);
        this.allergen = allergen;
        this.precautions = precautions;
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

    public Student getStudent() {
        return student;
    }
    public String getAllergen() {
        return allergen;
    }
    public String getPrecautions() {
        return precautions;
    }

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
