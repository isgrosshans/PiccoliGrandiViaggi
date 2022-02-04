package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Survey;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentSurveyController implements Initializable {


    @FXML private Label InstructionsLabel;
    @FXML private Button ConfirmButton;
    @FXML private Button CancelButton;
    @FXML private  Slider OverallSlider;
    @FXML private  Slider AccomodationSlider;
    @FXML private  Slider FieldTripsSlider;
    @FXML private  Slider SchoolSlider;
    @FXML private  Slider ActivitiesSlider;
    @FXML private  TextArea CommentTextArea;

    private static Survey survey=null;
    private static Trip trip=null;
    public static void setTrip(Trip trip) {
        StudentSurveyController.trip = trip;
    }

    public void ReturnTripsClick(ActionEvent actionEvent) throws IOException {
        StudentPastTripDetailsController.setTrip(trip);
        pgvApplication.setRoot("StudentPastTripDetails");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        StudentPastTripDetailsController.setTrip(trip);
        pgvApplication.setRoot("StudentPastTripDetails");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //Survey(int holidayid, int studentid, String comment, int overallScore, int schoolScore, int accomodationScore, int activitiesScore, int fieldtripScore)
        SaveToDB.insert(new Survey(
            trip.getHoliday().getId(),
                User.getCurrentStudent().getId(),
                CommentTextArea.getText(),
                (int) OverallSlider.getValue(),
                (int) SchoolSlider.getValue(),
                (int) AccomodationSlider.getValue(),
                (int) ActivitiesSlider.getValue(),
                (int) FieldTripsSlider.getValue()
        ));
        StudentPastTripDetailsController.setTrip(trip);
        pgvApplication.setRoot("StudentPastTripDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(FetchFromDB.hasFilledSurvey(User.getCurrentStudent().getId(),trip.getHoliday().getId())){
            ConfirmButton.setVisible(false);
            CancelButton.setVisible(false);
            InstructionsLabel.setText("Questionario compilato");
            survey=FetchFromDB.survey();
            OverallSlider.setValue(survey.getOverallScore());
            OverallSlider.setDisable(true);
            AccomodationSlider.setValue(survey.getAccommodationScore());
            AccomodationSlider.setDisable(true);
            FieldTripsSlider.setValue(survey.getFieldtripsScore());
            FieldTripsSlider.setDisable(true);
            SchoolSlider.setValue(survey.getSchoolScore());
            SchoolSlider.setDisable(true);
            ActivitiesSlider.setValue(survey.getActivitiesScore());
            ActivitiesSlider.setDisable(true);
            CommentTextArea.setText(survey.getComment());
            CommentTextArea.setEditable(false);
            CommentTextArea.setDisable(true);
        }
        else{
            OverallSlider.setValue(10.0);
            AccomodationSlider.setValue(10.0);
            FieldTripsSlider.setValue(10.0);
            SchoolSlider.setValue(10.0);
            ActivitiesSlider.setValue(10.0);
        }


    }
}
