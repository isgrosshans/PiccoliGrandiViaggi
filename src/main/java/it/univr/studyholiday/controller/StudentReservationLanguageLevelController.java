package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.model.entities.Student;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentReservationLanguageLevelController implements Initializable {
    @FXML private  ChoiceBox<String> LevelChioicheBox;
    @FXML private  Label ErrorMessage;
    private static Trip trip = new Trip(-1, LocalDate.of(1900,1,1),0,-1,"-","-","-","-","-","-");
    public static void setTrip(Trip t) {
        trip = t;
    }
    private static  Reservation reservation;
    public static void setReservation(Reservation r) {
        reservation = r;
    }
    public static Reservation getReservation() {
        return reservation;
    }

    public void SexClick(MouseEvent mouseEvent) throws IOException {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentFutureTripDetails");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(LevelChioicheBox.getValue()==null)
            ErrorMessage.setText("Selezionare un livello");
        else {
            StudentReservationPaymentMethodsController.setReservation(reservation);
            StudentReservationPaymentMethodsController.getReservation().setLanguageLevel((String) LevelChioicheBox.getValue());
            GlossaApplication.setRoot("StudentReservationPaymentMethods");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LevelChioicheBox.setItems(FXCollections.observableArrayList("A1", "A2", "B1", "B2", "C1", "C2"));
    }
}
