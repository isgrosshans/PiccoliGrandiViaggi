package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentQuestionnaireController implements Initializable {
    //todo if questionnaire never filled, don't preload info, else preload answers
    //is filled questionnaire updateable?
    //questionnaire not updatable> make sure to activate and deactivate buttons and set editable or not
    public void ReturnTripsClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentPastTrips");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentPastTrips");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentPastTrips");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
