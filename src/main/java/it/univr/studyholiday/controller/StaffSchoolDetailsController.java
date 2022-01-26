package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Family;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffSchoolDetailsController implements Initializable {
    @FXML private Label NameSchoolLabel;
    @FXML private Label AddressLabel;
    @FXML private Label LanguageLabel;
    @FXML private Label CityLabel;
    @FXML private Label CountryLabel;
    @FXML private Label PostalCodeLabel;


    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("school: "+school);
        NameSchoolLabel.setText(school.getName());
        AddressLabel.setText(school.getAddress());
        LanguageLabel.setText(school.getLanguage());
        CityLabel.setText(school.getCity());
        PostalCodeLabel.setText(school.getPostalCode());
        CountryLabel.setText(school.getCountry());
    }

    public void ReturnSchoolsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools");
    }

    public void FamilyButtonClick(ActionEvent actionEvent) throws IOException {
        StaffFamiliesController.setSchool(school);
        GlossaApplication.setRoot("StaffFamilies");
    }

    public void DormitoriesButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffDormitories");
    }

    public void ActivityButtonClick(ActionEvent actionEvent) throws IOException {
        StaffActivitiesController.setSchool(school);
        GlossaApplication.setRoot("StaffActivities");
    }

}
