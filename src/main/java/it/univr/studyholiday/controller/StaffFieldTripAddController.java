package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.FieldTrip;
import it.univr.studyholiday.model.entities.Holiday;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffFieldTripAddController implements Initializable {

    private int maxFieldtripHours=10;

    @FXML private Button ReturnButton;
    @FXML private Label NameSchoolLabel;
    @FXML private TextField DestinationTextField;
    @FXML private TextField PriceTextField;
    @FXML private Spinner<Integer> HoursSpinner;
    @FXML private TextField DescriptionTextField;
    @FXML private Label ErrorMessage;

    private static int fieldtripcounter=0;
    public static void setFieldtripcounter(int fieldtripcounter) {
        StaffFieldTripAddController.fieldtripcounter = fieldtripcounter;
    }
    private static boolean warned=false;
    private static School school;
        public static void setSchool(School s) {school = s;}
    private static LocalDate departure;
        public static void setDeparture(LocalDate d) {departure = d;}
    private static int weeks;
        public static void setWeeks(int w) {weeks=w;}

    private static ArrayList<FieldTrip> fieldTrips=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PriceTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    PriceTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        ReturnButton.setVisible(false);
        NameSchoolLabel.setText(school.getName());
        HoursSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,maxFieldtripHours,0));
    }

    public void ReturnButtonClick(ActionEvent actionEvent) throws IOException {
        //pgvApplication.setRoot("StaffNewTrip2");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffFutureTrips");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //check that all fields have been filled
        if(allfilled()){
            TempSaveFieldtrip();
            SaveToDB.insertHoliday(new Holiday(departure, weeks, school.getId()), fieldTrips);
            pgvApplication.setRoot("StaffFutureTrips");
        }
        else if(fieldTrips.size()==0) {
            ErrorMessage.setText("Inserire almeno una gita: compila tutti i dati richiesti");
        }
        else if(!warned){
            ErrorMessage.setText("Questa gita non verrà salvata. Cliccare conferma per avanzare comunque.");
        warned=true;
        }
        else{
            //save holiday and fieldtrips to db
            SaveToDB.insertHoliday(new Holiday(departure, weeks, school.getId()), fieldTrips);
            pgvApplication.setRoot("StaffFutureTrips");
        }
    }

    public void AddFieldTripButtonClick(ActionEvent actionEvent) throws IOException {
        if(!allfilled()) {
            ErrorMessage.setText("Compilare tutti i campi.");
        }
        else{
        TempSaveFieldtrip();
        DestinationTextField.clear();
        PriceTextField.clear();
        HoursSpinner.decrement(maxFieldtripHours+1);
        DescriptionTextField.clear();
        }
    }

    private void TempSaveFieldtrip() {
        Boolean flag = false;
        FieldTrip temp = new FieldTrip(DestinationTextField.getText(),
                DescriptionTextField.getText(),
                Integer.parseInt(PriceTextField.getText()),
                HoursSpinner.getValue());

        if(fieldTrips!=null){
            for (FieldTrip f : fieldTrips) {
                if (temp.sameAs(f)) flag = true;
            }
        }
        if(flag) ErrorMessage.setText("Questa gita è già presente.");
        else fieldTrips.add(temp);
    }

    private boolean allfilled(){
        if(DescriptionTextField.getText().isBlank()
                ||PriceTextField.getText().isBlank()
                ||HoursSpinner.getValue()==0
                ||DestinationTextField.getText().isBlank()) return false;
        return true;
    }
}

