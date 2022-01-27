package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.SurveyResults;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffPastTripDetailsController implements Initializable {


    @FXML private Label DepartureDateLabel;
    @FXML private Label NameSchoolLabel;
    @FXML private Label LanguageLabel;
    @FXML private Label DestinationLabel;
    @FXML private Label OverallExperienceScoreLabel;
    @FXML private Label AccomodationScoreLabel;
    @FXML private Label FieldtripsScoreLabel;
    @FXML private Label ActivitiesScoreLabel;
    @FXML private Label LessonsScoreLabel;

    private static Trip trip;
    public static void setTrip(Trip t) {
        trip = t;
    }

    private static SurveyResults surveyResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DepartureDateLabel.setText(trip.getDepartureDate());
        NameSchoolLabel.setText(trip.getSchool().getName());
        LanguageLabel.setText(trip.getSchool().getLanguage());
        DestinationLabel.setText(trip.getDestination());
        surveyResults= FetchFromDB.surveyResults(trip.getHoliday().getId());
        OverallExperienceScoreLabel.setText(surveyResults.getOverallScoreText());
        AccomodationScoreLabel.setText(surveyResults.getAccomodationScoreText());
        FieldtripsScoreLabel.setText(surveyResults.getFieldtripScoreText());
        ActivitiesScoreLabel.setText(surveyResults.getActivitiesScoreText());
        LessonsScoreLabel.setText(surveyResults.getActivitiesScoreText());
    }

    public void ReturnPastTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffPastTrips");
    }
}
