package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Holiday;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StaffPastTripDetailsController {

    private static Holiday holiday;
    public static Holiday getHoliday() {
        return holiday;
    }
    public static void setHoliday(Holiday h) {
        holiday = h;
    }

    public void ReturnPastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffPastTrips");
    }
}
