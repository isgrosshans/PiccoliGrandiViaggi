package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StudentHomeController {


    public void LogoutButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void PersonalProfileButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentProfile");
    }

    public void FutureTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentFutureTrips");
    }

    public void PastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentPastTrips");
    }

    public void BookedTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentBookedTrips");

    }
}
