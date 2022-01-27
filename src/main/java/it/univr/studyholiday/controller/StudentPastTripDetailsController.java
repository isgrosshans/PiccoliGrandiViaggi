package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentPastTripDetailsController implements Initializable {
    public void ReturnTripButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentPastTrips");
    }

    public void SurveyButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentQuestionnaire");
    }

    public void CertificateButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentCertificate");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
