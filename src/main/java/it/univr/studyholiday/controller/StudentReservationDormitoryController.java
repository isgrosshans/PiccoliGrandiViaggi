package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentReservationDormitoryController implements Initializable {
    public void ReturnDetailsTripButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    public void SingleRoomAction(ActionEvent actionEvent) throws IOException {

    }

    public void SingleRoomClick(MouseEvent mouseEvent) throws IOException {

    }

    public void DoubleRoomAction(ActionEvent actionEvent) throws IOException {

    }

    public void DoubleRoomClick(MouseEvent mouseEvent) throws IOException {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentFutureTripDetails");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentReservationLanguageLevel");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
