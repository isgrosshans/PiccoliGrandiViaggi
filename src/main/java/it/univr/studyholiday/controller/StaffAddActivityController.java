package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffAddActivityController {
    public void ReturnActivityButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchoolActivities");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchoolActivities");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //todo save
        GlossaApplication.setRoot("StaffSchoolActivities");
    }
}
