package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentFutureTripDetailsController implements Initializable {
    public void ReturnTripsClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentFutureTrips");
    }

    public void FieldTripsTableClick(MouseEvent mouseEvent) throws IOException {

    }

    public void ActivityTableClick(MouseEvent mouseEvent) throws IOException {

    }

    public void BookTripMenuClick(ActionEvent actionEvent) throws IOException {

    }

    public void OnFamilyClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentReservationFamily");
    }

    public void OnDormitoryClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentReservationDormitory");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
