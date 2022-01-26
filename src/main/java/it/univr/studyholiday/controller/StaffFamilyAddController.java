package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Family;
import it.univr.studyholiday.model.School;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffFamilyAddController implements Initializable {

    @FXML private Label NameSchoolLabel;
    @FXML private TextField FirstNameTextField;
    @FXML private TextField LastnameTextField;
    @FXML private TextField EmailTextField;
    @FXML private TextField PhoneTextField;
    @FXML private TextField AddressTextField;
    @FXML private TextField CityDistanceField;
    @FXML private Spinner<Integer> MembersSpinner;
    @FXML private CheckBox PetsCheckBox;
    @FXML private Spinner<Integer> RoomsSpinner;
    @FXML private Spinner<Integer> BathroomsSpinner;
    @FXML private Label ErrorMessage;


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
        MembersSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,20,0));
        RoomsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));
        BathroomsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0));

    }

    public void ReturnFamilyButtonClick(ActionEvent actionEvent) throws IOException {
        StaffFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffFamilies");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //check that all mandatory fields are completed
        if(FirstNameTextField.getText().isBlank()
            ||LastnameTextField.getText().isBlank()
            ||EmailTextField.getText().isBlank()
            ||PhoneTextField.getText().isBlank()
            ||AddressTextField.getText().isBlank()
            ||CityDistanceField.getText().isBlank()
            ||MembersSpinner.getValue()==0
            ||RoomsSpinner.getValue()==0
            ||BathroomsSpinner.getValue()==0
        ) ErrorMessage.setText("Compilare tutti i campi.");

        else{
        //save
            SaveToDB.insert(new Family( school.getId(),
                                        EmailTextField.getText(),
                                        FirstNameTextField.getText(),
                                        LastnameTextField.getText(),
                                        MembersSpinner.getValue(),
                                        PetsCheckBox.isSelected(),
                                        RoomsSpinner.getValue(),
                                        BathroomsSpinner.getValue(),
                                        CityDistanceField.getText(),
                                        AddressTextField.getText(),
                                        PhoneTextField.getText()));
            StaffFamiliesController.setSchool(school);
            GlossaApplication.setRoot("StaffFamilies");
        }
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        StaffFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffFamilies");
    }
}
