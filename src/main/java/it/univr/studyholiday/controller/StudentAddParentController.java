package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentAddParentController implements Initializable {
    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("Login");
    }

    public void AddParentButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentAddParent2");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentHome");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
