package it.univr.studyholiday.model;

import it.univr.studyholiday.model.entities.Staff;
import it.univr.studyholiday.model.entities.Student;

public class User {
    private static Object currentUser;
    private static User user;

    private User() {
    }

    public static void setCurrentUser(Object o){
        currentUser=o;
    }

    public static Object getCurrentUser() {
        return currentUser;
    }

    public static Student getCurrentStudent(){
        if(isStaff())return null;
        return (Student) currentUser;
    }

    public static boolean isStaff(){
        if (currentUser instanceof Staff) return true;
        else return false;
    }

    public static boolean isNull(){
        if (currentUser instanceof Boolean) return true;
        else return false;
    }
}
