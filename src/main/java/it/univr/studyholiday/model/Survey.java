package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.Fetch;

import java.util.ArrayList;

//SURVEY(holiday,student,
//        score,comment*)
public class Survey {
    private Holiday holiday;
    private Student student;
    private int score;
    private String comment;
    private ArrayList<Answer> answers;
    private boolean hasQuestions;

    public Survey(Holiday holiday, Student student, int score, String comment, ArrayList<Answer> answers) {
        this.holiday = holiday;
        this.student = student;
        this.score = score;
        this.comment = comment;
        this.answers = answers;
        if(answers.size()>0) hasQuestions=true;
        else hasQuestions=false;
    }

    public Survey(String holiday, String student, int score, String comment) {
        this.holiday = Fetch.holiday(holiday);
        this.student = Fetch.student(student);
        this.score = score;
        this.comment = comment;
    }

}
