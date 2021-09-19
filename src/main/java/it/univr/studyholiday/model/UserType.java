package it.univr.studyholiday.model;

//SINGLETON
public class UserType {
    private static Student student;
    private static TravelAgent travelAgent;
    private Boolean admin;

    private static UserType instance = new UserType();

    //USE AT LOGIN
    public static void setMode(Student student) {
        instance.setStudent(student);
        instance.setAdmin(false);
    }
    public static void setMode(TravelAgent travelAgent) {
        instance.setTravelAgent(travelAgent);
        instance.setAdmin(true);
    }

    public static Boolean isAdmin(){
        return instance.admin;
    }
    public static Student getStudent() {
        return student;
    }
    public static TravelAgent getTravelAgent() {
        return travelAgent;
    }
    public static UserType getInstance(){
        return instance;
    }

    private void setStudent(Student student) {
        this.student = student;
    }
    private void setTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }
    private void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
