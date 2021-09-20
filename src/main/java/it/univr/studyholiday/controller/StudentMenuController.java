package it.univr.studyholiday.controller;

import it.univr.studyholiday.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StudentMenuController {

    @FXML
    public Button viaggiButton;
    @FXML
    public Button profiloButton;
    @FXML
    public Button logoutButton;

    public void viaggiButtonAction() throws IOException {
        HelloApplication.setRoot("student_catalog_view");
    }

    public void profiloButtonAction() throws IOException {
        HelloApplication.setRoot("student_profile");
    }

    public void logoutButtonAction() throws IOException {
        HelloApplication.setRoot("login-view");
    }

}
