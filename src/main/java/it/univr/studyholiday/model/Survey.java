package it.univr.studyholiday.model;

//(id, holidayid, studentid, overall, school, accomodation, activities, fieldtrips)
public class Survey {
private Holiday holiday;
private Student student;
private int overallScore;
private int schoolScore;
private int accomodationScore;
private int activitiesScore;
private int fieldtripsScore;

    public Survey(Holiday holiday, Student student, int overallScore,
                  int schoolScore, int accomodationScore, int activitiesScore,
                  int fieldtripsScore) {
        this.holiday = holiday;
        this.student = student;
        this.overallScore = overallScore;
        this.schoolScore = schoolScore;
        this.accomodationScore = accomodationScore;
        this.activitiesScore = activitiesScore;
        this.fieldtripsScore = fieldtripsScore;
    }

    public Holiday getHoliday() {
        return holiday;
    }
    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public int getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getSchoolScore() {
        return schoolScore;
    }
    public void setSchoolScore(int schoolScore) {
        this.schoolScore = schoolScore;
    }

    public int getAccomodationScore() {
        return accomodationScore;
    }
    public void setAccomodationScore(int accomodationScore) {
        this.accomodationScore = accomodationScore;
    }

    public int getActivitiesScore() {
        return activitiesScore;
    }
    public void setActivitiesScore(int activitiesScore) {
        this.activitiesScore = activitiesScore;
    }

    public int getFieldtripsScore() {
        return fieldtripsScore;
    }
    public void setFieldtripsScore(int fieldtripsScore) {
        this.fieldtripsScore = fieldtripsScore;
    }
}
