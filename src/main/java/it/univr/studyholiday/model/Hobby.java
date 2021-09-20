package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

public class Hobby {
    private Student student;
    private String hobby;

    public Hobby(Student student, String hobby) {
        this.student = student;
        this.hobby = hobby;
    }

    public Hobby(String student, String hobby) {
        this.student = Fetch.student(student);
        this.hobby = hobby;
    }

    public void add() {
        Add.add(this);
    }
    public void update() {
        Update.update(this);
    }
    public void delete() {
        Delete.delete(this);
    }

    public Student getStudent() {
        return student;
    }
    public String getHobby() {
        return hobby;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
