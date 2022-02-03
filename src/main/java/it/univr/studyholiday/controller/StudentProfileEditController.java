package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentProfileEditController implements Initializable {
    public void DateClick(MouseEvent mouseEvent) throws IOException {
    }

    public void SexClick(MouseEvent mouseEvent) throws IOException {
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentProfile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
