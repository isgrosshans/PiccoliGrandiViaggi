package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffNewTrip1Controller {
    public void ReturnTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffFutureTrips");
    }

    public void NextButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffNewTrip2");
    }
}
