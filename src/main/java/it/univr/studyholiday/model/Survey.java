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
        if(comment!=null)
            this.comment = comment;
        else

        this.answers = answers;
        if(answers.size()>0) hasQuestions=true;
        else hasQuestions=false;
    }

    public Survey(String holiday, String student, int score, String comment) {
        this.holiday = Fetch.holiday(holiday);
        this.student = Fetch.student(student);
        this.score = score;
        if(comment!=null)
            this.comment = comment;
        this.answers = Fetch.answersByStudent(holiday, student);
        if(answers.size()>0) hasQuestions=true;
        else hasQuestions=false;
    }

    public Holiday getHoliday() {
        return holiday;
    }
    public Student getStudent() {
        return student;
    }
    public int getScore() {
        return score;
    }
    public String getComment() {
        return comment;
    }
    public ArrayList<Answer> getAnswers() {
        return answers;
    }
    public boolean hasQuestions() {
        return hasQuestions;
    }
    public boolean hasComment(){
        if(comment==null) return false;
        if(comment.isBlank()) return false;
        if(comment.isEmpty()) return false;
        return true;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
    public void setHasQuestions(boolean hasQuestions) {
        this.hasQuestions = hasQuestions;
    }
}
