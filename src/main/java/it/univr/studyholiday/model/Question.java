package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

// QUESTION(holiday,question)
public class Question {
    Holiday holiday;
    String question;

    public Question(Holiday holiday, String question) {
        this.holiday = holiday;
        this.question = question;
    }

    public Question(String holiday, String question) {
        this.holiday = Fetch.holiday(holiday);
        this.question = question;
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
    public String getQuestion() {
        return question;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
}
