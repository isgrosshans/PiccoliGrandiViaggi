package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffFamilyAddController {

    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    public void ReturnFamilyButtonClick(ActionEvent actionEvent) throws IOException {
        StaffFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffFamilies");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //todo save
        StaffFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffFamilies");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        StaffFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffFamilies");
    }
}
