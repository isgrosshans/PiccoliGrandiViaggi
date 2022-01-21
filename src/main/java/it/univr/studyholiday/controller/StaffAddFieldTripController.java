package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Holiday;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffAddFieldTripController {

    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffNewTrip2");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffNewTrip2");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffNewTrip2");
    }
}
