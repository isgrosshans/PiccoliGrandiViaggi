package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Family;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffDetailsFamilyController {

    private static Family family;
    public static Family getFamily() {
        return family;
    }
    public static void setFamily(Family f) {
        family = f;
    }

    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }
    
    public void ReturnFamiliesButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolFamilies");
    }
}
