package it.univr.studyholiday.model;

import it.univr.studyholiday.model.entities.Student;

import java.util.HashMap;
import java.util.List;

public class SurveyResults {
    private int holidayid=-1;
    private int overallScore=-1;
    private int schoolScore=-1;
    private int accomodationScore=-1;
    private int activitiesScore=-1;
    private int fieldtripScore=-1;
    private List<String> comments;


    public SurveyResults(int holidayid, int overallScore, int schoolScore, int accomodationScore, int activitiesScore, int fieldtripScore,List<String> comments) {
        this.holidayid = holidayid;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accomodationScore = accomodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripScore = fieldtripScore;
        this.comments = comments;
    }

    public String getHolidayidText() {
        if(holidayid==-1) return "-";
        return String.valueOf(holidayid);
    }

    public String getOverallScoreText() {
        if(overallScore==-1) return "-";
        return String.valueOf(overallScore);
    }

    public String getSchoolScoreText() {
        if(schoolScore==-1) return "-";
        return String.valueOf(schoolScore);
    }

    public String getAccomodationScoreText() {
        if(accomodationScore==-1) return "-";
        return String.valueOf(accomodationScore);
    }

    public String getActivitiesScoreText() {
        if(activitiesScore==-1) return "-";
        return String.valueOf(activitiesScore);
    }

    public String getFieldtripScoreText() {
        if(fieldtripScore==-1) return "-";
        return String.valueOf(fieldtripScore);
    }

    public String getCommentsText() {
        String rs="";
        if(comments==null) return "NON CI SONO COMMENTI";

        for (String c:comments) {
            while(c.contains("\n\n"))
                c.replaceAll("\n\n","\n");
            if(!c.isBlank())
                rs+=c+"\n\n";
        }

        return rs;
    }

}
