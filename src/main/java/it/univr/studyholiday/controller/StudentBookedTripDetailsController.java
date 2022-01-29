package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentBookedTripDetailsController implements Initializable {
    public void ReturnReservationsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentBookedTrips");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
