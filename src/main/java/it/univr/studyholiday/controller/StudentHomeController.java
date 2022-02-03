package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class StudentHomeController {


    public void LogoutButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("Login");
    }

    public void PersonalProfileButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void FutureTripsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentFutureTrips");
    }

    public void PastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentPastTrips");
    }

    public void BookedTripsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentBookedTrips");

    }
}
