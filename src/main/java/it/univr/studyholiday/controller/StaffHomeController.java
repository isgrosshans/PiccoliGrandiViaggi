package it.univr.studyholiday.controller;
import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import java.io.IOException;

public class StaffHomeController {

    public void LogoutButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("log out");
        GlossaApplication.setRoot("login-view");
    }

    public void SchoolsButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("schools");
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void FutureTripsButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("future trips");
        //GlossaApplication.setRoot("staffFutureTrips-view");
    }

    public void PastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("past trips");
        //GlossaApplication.setRoot("staffPastTrips-view");
    }
}
