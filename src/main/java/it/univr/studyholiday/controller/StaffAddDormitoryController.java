package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffAddDormitoryController {

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

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //todo save
        StaffSchoolDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDormitories");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDormitories");
    }
}
