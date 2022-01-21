package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffFutureTripsController {
    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffHome");
    }

    public void AddTripButtonAction(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffNewTrip1");
    }
}
