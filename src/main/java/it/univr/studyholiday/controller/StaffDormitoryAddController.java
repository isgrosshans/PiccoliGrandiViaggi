package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Dormitory;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;

import java.util.ResourceBundle;

public class StaffDormitoryAddController implements Initializable {

    @FXML private Label NameSchoolLabel;
    @FXML private TextField NameTextField;
    @FXML private TextField AddressTextField;
    @FXML private ChoiceBox GenderChoiceBox;
    @FXML private Spinner<Integer> SingleRoomSpinner;
    @FXML private Spinner<Integer> DoubleRoomSpinner;
    @FXML private Label ErrorMessage;

    private Array args;

    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameSchoolLabel.setText(school.getName());
        GenderChoiceBox.setItems(FXCollections.observableArrayList("Maschile", "Femminile"));
        SingleRoomSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,50,0));
        DoubleRoomSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,50,0));
    }

    public void ReturnDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoriesController.setSchool(school);
        pgvApplication.setRoot("StaffDormitories");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(NameTextField.getText().isBlank()
            || AddressTextField.getText().isBlank()
            || GenderChoiceBox.getSelectionModel().getSelectedItem()==null
        ) ErrorMessage.setText("Compilare tutti i campi.");
        else if(SingleRoomSpinner.getValue()+DoubleRoomSpinner.getValue()==0)
            ErrorMessage.setText("Il dormitorio deve avere delle camere.");

        else{
            String mf;
                    if(GenderChoiceBox.getSelectionModel().getSelectedItem().toString().equals("Maschile")) mf="m";
                    else mf="f";
            System.out.println(school.getId());
            SaveToDB.insertDormRooms(new Dormitory(  school.getId(),
                                            NameTextField.getText(),
                                            AddressTextField.getText(), mf),
                            SingleRoomSpinner.getValue(),
                            DoubleRoomSpinner.getValue());

            StaffDormitoriesController.setSchool(school);
            pgvApplication.setRoot("StaffDormitories");
        }
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoriesController.setSchool(school);
        pgvApplication.setRoot("StaffDormitories");
    }
}
