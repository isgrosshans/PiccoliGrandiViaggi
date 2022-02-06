package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentReservationPaymentMethodsController implements Initializable {
    private static Reservation reservation;
    @FXML private Label ErrorMessage;
    @FXML private RadioButton BBRadioButton;
    @FXML private RadioButton CCRadioButton;
    public static void setReservation(Reservation r) {
        reservation = r;
    }
    public static Reservation getReservation() {
        return reservation;
    }

    public void BBRadioClickAction(ActionEvent actionEvent) throws IOException {

    }

    public void BBClick(MouseEvent mouseEvent) throws IOException {

    }

    public void CCRadioClickAction(ActionEvent actionEvent) throws IOException {

    }

    public void CCClick(MouseEvent mouseEvent) throws IOException {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentFutureTripDetails");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(CCRadioButton.isSelected()) {
            reservation.setPaymentMethod("Carta di Credito");
            SaveToDB.insert(reservation);
            pgvApplication.setRoot("StudentBookedTrips");
        }
        else if(BBRadioButton.isSelected()) {
            reservation.setPaymentMethod("Bonifico Bancario");
            SaveToDB.insert(reservation);
            pgvApplication.setRoot("StudentBookedTrips");
        }
        else ErrorMessage.setText("Selezionare una preferenza.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        CCRadioButton.setToggleGroup(toggleGroup);
        BBRadioButton.setToggleGroup(toggleGroup);
    }
}
