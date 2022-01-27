package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentFutureTripsController implements Initializable {
    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentHome");
    }

    public void TripsTableClick(MouseEvent mouseEvent) throws IOException {
        GlossaApplication.setRoot("StudentFutureTripDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
