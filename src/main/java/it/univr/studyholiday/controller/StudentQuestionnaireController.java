package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Survey;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentQuestionnaireController implements Initializable {


    @FXML private  Slider OverallSlider;
    @FXML private  Slider AccomodationSlider;
    @FXML private  Slider FieldTripsSlider;
    @FXML private  Slider SchoolSlider;
    @FXML private  Slider ActivitiesSlider;
    @FXML private  TextArea CommentTextArea;


    private static Trip trip=null;
    public static void setTrip(Trip trip) {
        StudentQuestionnaireController.trip = trip;
    }

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
        pgvApplication.setRoot("StudentPastTrips");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OverallSlider.setValue(10.0);
        AccomodationSlider.setValue(10.0);
        FieldTripsSlider.setValue(10.0);
        SchoolSlider.setValue(10.0);
        ActivitiesSlider.setValue(10.0);
    }
}
