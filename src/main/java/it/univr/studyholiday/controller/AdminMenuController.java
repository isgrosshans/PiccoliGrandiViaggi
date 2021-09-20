package it.univr.studyholiday.controller;

import it.univr.studyholiday.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminMenuController {

    @FXML
    public Button collegeButton;
    @FXML
    public Button viaggiFuturiButton;
    @FXML
    public Button viaggiPassatiButton;
    @FXML
    public Button logoutButton;

    public void collegeButtonAction() throws IOException {

    }

    public void logoutButtonAction() throws IOException {
        // TODO svuotare singleton informazioni utente
        HelloApplication.setRoot("login-view");
    }

}
