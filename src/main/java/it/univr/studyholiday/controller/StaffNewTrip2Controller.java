package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffNewTrip2Controller {
    public void ReturnSelectTripButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffNewTrip1");
    }

    public void NextButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffFieldTripAdd");
    }

    public void DatePickerClick(ActionEvent actionEvent) {
        //todo remove method
    }
}
