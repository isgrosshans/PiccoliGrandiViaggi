package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StaffNewTrip2Controller implements Initializable {

    @FXML private Button CancelButton;
    @FXML private Spinner<Integer> WeeksSpinner;
    @FXML private DatePicker DepartureDatePicker;
    @FXML private Label ErrorMessage;

    private static School school;
    public static void setSchool(School s) {school = s;}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WeeksSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,4,0));
        DepartureDatePicker.setEditable(false);
        DepartureDatePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now().plusDays(1)) );
            }
        });
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffFutureTrips");
    }

    public void NextButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println(DepartureDatePicker);
        if (DepartureDatePicker.getValue()==null)
            ErrorMessage.setText("Selezionare la data di partenza");
        else if(WeeksSpinner.getValue()==0)
            ErrorMessage.setText("Selezionare la durata del viagio.");
        else if(DepartureDatePicker.getValue().isEqual(LocalDate.now()))
            ErrorMessage.setText("Il viaggio non può iniziare oggi.");
        else if(DepartureDatePicker.getValue().isBefore(LocalDate.now()))
            ErrorMessage.setText("Non possiamo viaggiare indietro nel tempo...");
        else{
            StaffFieldTripAddController.setSchool(school);
            StaffFieldTripAddController.setDeparture(DepartureDatePicker.getValue());
            StaffFieldTripAddController.setWeeks(WeeksSpinner.getValue());
            GlossaApplication.setRoot("StaffFieldTripAdd");}
    }

    public void DatePickerClick(ActionEvent actionEvent) {
        //todo remove method
    }


}
