package it.univr.studyholiday.controller;
import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import java.io.IOException;

public class StaffHomeController {

    public void LogoutButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("login");
    }

    public void SchoolsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools");
    }

    public void FutureTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("staffFutureTrips");
    }

    public void PastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("staffPastTrips");
    }
}
