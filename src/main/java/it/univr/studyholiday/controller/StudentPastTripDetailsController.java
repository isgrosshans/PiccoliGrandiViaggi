package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class StudentPastTripDetailsController implements Initializable {
    @FXML private Button SurveyButton;
    @FXML private Label DepartureDateLabel;
    @FXML private  Label WeeksLabel;
    @FXML private  Label NameSchoolLabel;
    @FXML private  Label LanguageLabel;
    @FXML private  Label DestinationLabel;

    private static Trip trip=null;
    public static void setTrip(Trip trip) {
        StudentPastTripDetailsController.trip = trip;
    }

    public void ReturnTripButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentPastTrips");
    }

    public void SurveyButtonClick(ActionEvent actionEvent) throws IOException {
        StudentSurveyController.setTrip(trip);
        pgvApplication.setRoot("StudentSurvey");
    }

    public void CertificateButtonClick(ActionEvent actionEvent) throws IOException {
        StudentCertificateController.setTrip(trip);
        pgvApplication.setRoot("StudentCertificate");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DepartureDateLabel.setText(trip.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        WeeksLabel.setText(String.valueOf(trip.getWeeks()));
        NameSchoolLabel.setText(trip.getSchool().getName());
        LanguageLabel.setText(trip.getSchool().getLanguage());
        DestinationLabel.setText(trip.getDestination());

    }
}
