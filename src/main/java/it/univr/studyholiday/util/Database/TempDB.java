package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.School;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class TempDB {
    //private static TempDB single_instante = null;

    private static ArrayList<School> schools;
    public static ArrayList<School> getSchools() {return schools;}
    public static void addSchool(School s){schools.add(s);}



    private TempDB(){   //Dummy Values
        schools.add(new School(1,"Carl Duisberg Berlin","Jaegerstrasse 64, Toreinfahrt 63 a","10117","Berlino","Germania","Tedesco"));
    }
}
