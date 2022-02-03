package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentAllergyEditController implements Initializable {
    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    public void SaveButtonClick(ActionEvent actionEvent) throws IOException {
        //pgvApplication.setRoot("StudentProfile");
    }

    public void DeleteButtonClick(ActionEvent actionEvent) throws IOException {
        //pgvApplication.setRoot("");
    }

    public void AllergyTableClick(MouseEvent mouseEvent) throws IOException {
        //pgvApplication.setRoot("");
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
