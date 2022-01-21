package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffSchoolDormitoriesController {

    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDetailsController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDetails");
    }

    public void AddDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffAddDormitoryController.setSchool(school);
        GlossaApplication.setRoot("StaffAddDormitory");
    }
}
