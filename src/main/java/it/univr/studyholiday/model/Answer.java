package it.univr.studyholiday.model;

import it.univr.studyholiday.util.Database.*;

import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

public class Answer {
    Survey survey;
    Question question;
    String answer;

    public Answer(Survey survey, Question question, String answer) {
        this.survey = survey;
        this.question = question;
        this.answer = answer;
    }

    public Answer(String holiday, String student, String question, String answer) {
        this.survey = Fetch.survey(holiday, student);
        //todo this.question
        this.answer = answer;
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
    public static ArrayList<Answer> fetchAllFor(Question question){
        Fetch.allAnswersFor(question.question);
    }
    public static ArrayList<Answer> fetchAllFor(Survey survey){
        Fetch.allAnswersFor(question.question);
    }


    public Survey getSurvey() {
        return survey;
    }
    public Question getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
