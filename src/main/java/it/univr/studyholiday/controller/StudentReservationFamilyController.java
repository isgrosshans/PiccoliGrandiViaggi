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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentReservationFamilyController implements Initializable {
    @FXML private Label ErrorMessage;
    @FXML private Label EmailLabel;
    @FXML private Label FirstNameLabel;
    @FXML private Label LastNameLabel;
    @FXML private Label DescriptionLabel2;
    @FXML private RadioButton YesRadioButton;
    @FXML private  RadioButton NoRadioButton;
    @FXML private  TextField EmailTextField;
    @FXML private  TextField FirstNameTextField;
    @FXML private  TextField LastNameTextField;

    private static Trip trip = new Trip(-1, LocalDate.of(1900,1,1),0,-1,"-","-","-","-","-","-");
    public static void setTrip(Trip t) {
        trip = t;
    }

    public void YesFriendAction(ActionEvent actionEvent) throws IOException {
        ErrorMessage.setText("");
        EmailTextField.setDisable(false);
        FirstNameTextField.setDisable(false);
        LastNameTextField.setDisable(false);
        EmailLabel.setDisable(false);
        FirstNameLabel.setDisable(false);
        LastNameLabel.setDisable(false);
        DescriptionLabel2.setDisable(false);
    }

    public void YesFriendClick(MouseEvent mouseEvent) throws IOException {

    }

    public void NoFriendAction(ActionEvent actionEvent) throws IOException {
        ErrorMessage.setText("");
        EmailTextField.setDisable(true);
        FirstNameTextField.setDisable(true);
        LastNameTextField.setDisable(true);
        EmailLabel.setDisable(true);
        FirstNameLabel.setDisable(true);
        LastNameLabel.setDisable(true);
        DescriptionLabel2.setDisable(true);
    }

    public void NoFriendClicked(MouseEvent mouseEvent) throws IOException {

    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentFutureTripDetails");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(YesRadioButton.isSelected()){
            if(EmailTextField.getText().isBlank()||FirstNameTextField.getText().isBlank()|| LastNameTextField.getText().isBlank())
                ErrorMessage.setText("Compilare tutti i campi.");
            else {
                StudentReservationLanguageLevelController.setReservation(new Reservation(User.getCurrentStudent().getId(), trip.getHoliday().getId(), true, false));
                StudentReservationLanguageLevelController.getReservation().setFriendEmail(EmailTextField.getText());
                pgvApplication.setRoot("StudentReservationLanguageLevel");
            }
        }
        else if(NoRadioButton.isSelected()){
            StudentReservationLanguageLevelController.setReservation(new Reservation(User.getCurrentStudent().getId(), trip.getHoliday().getId(),true, false));
            pgvApplication.setRoot("StudentReservationLanguageLevel");
        }
        else
            ErrorMessage.setText("Selezionare una preferenza.");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        YesRadioButton.setToggleGroup(toggleGroup);
        NoRadioButton.setToggleGroup(toggleGroup);
    }
}
