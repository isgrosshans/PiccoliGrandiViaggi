package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.UserType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StaffHomeController {

    @FXML
    public Button collegeButton;
    @FXML
    public Button viaggiFuturiButton;
    @FXML
    public Button viaggiPassatiButton;
    @FXML
    public Button logoutButton;

    public void viaggiFuturiButtonAction() throws IOException {}

    public void collegeButtonAction() throws IOException {
        GlossaApplication.setRoot("admincollege-view");
    }

    public void logoutButtonAction() throws IOException {
        UserType.setMode();
        GlossaApplication.setRoot("login-view");
    }

    public void LogoutButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("login-view");
    }

    public void SchoolsButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("schools");
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void FutureTripsButtonClick(ActionEvent actionEvent) {
        System.out.println("future trips");
    }

    public void PastTripsButtonClick(ActionEvent actionEvent) {
        System.out.println("past trips");
    }
}
