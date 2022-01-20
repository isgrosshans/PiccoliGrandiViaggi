package it.univr.studyholiday.model;

public class User {
    private static Object currentUser;
    private static User user = new User();

    public static void setCurrentUser(Object o){
        currentUser=o;
    }

    public static Object getCurrentUser() {
        return currentUser;
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
