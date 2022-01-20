package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class StaffAddSchoolController {

    @FXML private TextField NameTextField;
    @FXML private TextField LanguageTextField;
    @FXML private TextField AddressTextField;
    @FXML private TextField CountryTextField;
    @FXML private TextField CityTextField;
    @FXML private TextField PostalCodeTextField;
    @FXML private Label ErrorMessage;

    public void ReturnSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        //TODO save to database

        //check that all fields are filled
        if(!allFilled()) ErrorMessage.setText("Compilare tutti i campi prima di procedere.");
        else  {
//            //save school to database
            SaveToDB.insert(new School(NameTextField.getText(),
                    AddressTextField.getText(),
                    PostalCodeTextField.getText(),
                    CityTextField.getText(),
                    CountryTextField.getText(),
                    LanguageTextField.getText()));

            GlossaApplication.setRoot("StaffSchools-view");
        }


        //StaffSchoolsController.addSchool(new School("3","c","c","c","c","c","c"));
        //GlossaApplication.setRoot("StaffSchools-view");
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