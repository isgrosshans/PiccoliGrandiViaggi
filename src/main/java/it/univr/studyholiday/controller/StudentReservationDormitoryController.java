package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Reservation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentReservationDormitoryController implements Initializable {
    @FXML private Label ErrorMessage;
    @FXML private RadioButton SingleRadioButton;
    @FXML private RadioButton DoubleRadioButton;

    private static Trip trip = new Trip(-1, LocalDate.of(1900,1,1),0,-1,"-","-","-","-","-","-");
    public static void setTrip(Trip t) {
        trip = t;
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
        pgvApplication.setRoot("StudentFutureTripDetails");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(SingleRadioButton.isSelected()||DoubleRadioButton.isSelected()) {
            StudentReservationLanguageLevelController.setReservation(new Reservation(User.getCurrentStudent().getId(), trip.getHoliday().getId(),false, false));
            if(SingleRadioButton.isSelected())
                StudentReservationLanguageLevelController.getReservation().setRequestedSingle(true);
            pgvApplication.setRoot("StudentReservationLanguageLevel");
        }
        else ErrorMessage.setText("Selezionare una preferenza.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        SingleRadioButton.setToggleGroup(toggleGroup);
        DoubleRadioButton.setToggleGroup(toggleGroup);
    }
}
