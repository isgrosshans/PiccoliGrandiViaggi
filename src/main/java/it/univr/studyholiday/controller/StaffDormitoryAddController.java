package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.DormRoom;
import it.univr.studyholiday.model.Dormitory;
import it.univr.studyholiday.model.School;
import it.univr.studyholiday.util.Database.Entity;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class StaffDormitoryAddController implements Initializable {

    @FXML private Label NameSchoolLabel;
    @FXML private TextField NameTextField;
    @FXML private TextField AdressTextField;
    @FXML private ChoiceBox GenderCoiceBox;
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
        GenderCoiceBox.setItems(FXCollections.observableArrayList("Maschile", "Femminile"));
        SingleRoomSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0));
        DoubleRoomSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0));
    }

    public void ReturnDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffDormitories");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //todo save
        if(NameTextField.getText().isBlank()
                || AdressTextField.getText().isBlank()
                || GenderCoiceBox.getSelectionModel().getSelectedItem()==null
            )   ErrorMessage.setText("Riempire tutti i campi per procedere.");
        else if(SingleRoomSpinner.getValue()+DoubleRoomSpinner.getValue()==0)
            ErrorMessage.setText("Il dormitorio deve avere delle camere.");

        else{
            String mf;
                    if(GenderCoiceBox.getSelectionModel().getSelectedItem().toString().equals("Maschile")) mf="m";
                    else mf="f";
            System.out.println(school.getId());
            SaveToDB.insert(new Dormitory(school.getId(), NameTextField.getText(),
                            AdressTextField.getText(), mf)
                    ,SingleRoomSpinner.getValue(),DoubleRoomSpinner.getValue());

            StaffDormitoriesController.setSchool(school);
            GlossaApplication.setRoot("StaffDormitories");
        }
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffDormitories");
    }
}
