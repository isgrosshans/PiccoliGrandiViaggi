package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentReservationFamilyController implements Initializable {
    public void ReturnDetailsTripButtonClick(ActionEvent actionEvent) throws IOException {
        //todo remove
    }

    public void YesFriendAction(ActionEvent actionEvent) throws IOException {

    }

    public void YesFriendClick(MouseEvent mouseEvent) throws IOException {

    }

    public void NoFriendAction(ActionEvent actionEvent) throws IOException {

    }

    public void NoFriendClicked(MouseEvent mouseEvent) throws IOException {

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
