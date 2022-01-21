package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Dormitory;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffDetailsDormitoryController {

    private static Dormitory dormitory;
    public static void setDormitory(Dormitory d) {
        dormitory=d;
    }
    public static Dormitory getDormitory(){
        return dormitory;
    }

    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    public void ReturnDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDormitories");
    }
}
