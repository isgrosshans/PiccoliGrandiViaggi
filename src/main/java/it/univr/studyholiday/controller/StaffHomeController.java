package it.univr.studyholiday.controller;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.pgvApplication;
import javafx.event.ActionEvent;
import java.io.IOException;

public class StaffHomeController {

    public void LogoutButtonClick(ActionEvent actionEvent) throws IOException {
        User.setCurrentUser(null);
        pgvApplication.setRoot("Login");
    }

    public void SchoolsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffSchools");
    }

    public void FutureTripsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffFutureTrips");
    }

    public void PastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffPastTrips");
    }

    public void BookedTripsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffBookings");
    }
}
