package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistration2Controller implements Initializable {
    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    public void AddButtonClick(ActionEvent actionEvent) {

    }

    public void AllergyTableClick(MouseEvent mouseEvent) {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentAddParent");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
