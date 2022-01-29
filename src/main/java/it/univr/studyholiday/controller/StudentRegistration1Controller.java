package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistration1Controller implements Initializable {
    public void SexClick(MouseEvent mouseEvent) throws IOException {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentRegistration2");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
