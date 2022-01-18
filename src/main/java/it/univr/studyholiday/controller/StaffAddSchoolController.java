package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StaffAddSchoolController {

    public Button ReturnSchoolButton;
    public Button CancelButton;
    public Button ConfirmButton;
    public TextField NameTextField;
    public TextField LanguageTextField;
    public TextField AddressTextField;
    public TextField CountryTextField;
    public TextField CityTextField;
    public TextField PostalCodeTextField;
    public Label ErrorMessage;

    public void ReturnSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //TODO save to database

        //check that all fields are filled
        ErrorMessage.setText("Compilare tutti i campi prima di procedere.");


        StaffSchoolsController.addSchool(new School(3,"c","c","c","c","c","c"));
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public boolean allFilled(){
        if(this.NameTextField.getText().isEmpty()) return false;
        if(this.LanguageTextField.getText().isEmpty()) return false;
        if(this.AddressTextField.getText().isEmpty()) return false;
        if(this.CountryTextField.getText().isEmpty()) return false;
        if(this.CityTextField.getText().isEmpty()) return false;
        if(this.PostalCodeTextField.getText().isEmpty()) return false;
        return true;
    }


}
