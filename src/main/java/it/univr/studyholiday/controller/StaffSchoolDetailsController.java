package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.ShutdownChannelGroupException;
import java.util.ResourceBundle;

public class StaffSchoolDetailsController implements Initializable {
    @FXML private Label NameSchoolLabel;
    @FXML private Label AddressLabel;
    @FXML private Label LanguageLabel;
    @FXML private Label CityLabel;
    @FXML private Label CountryLabel;
    @FXML private Label PostalCodeLabel;
    @FXML private Button FamilyButton;
    @FXML private Button DormitoryButton;
    @FXML private Button ActivityButton;

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

    public void ReturnScoolButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffSchools-view");
    }

    public void FamilyButtonClick(ActionEvent actionEvent) throws IOException {
        //GlossaApplication.setRoot("-view");
        GlossaApplication.setRoot("StaffSchoolActivities-view");
    }

    public void DoormroomButtonClick(ActionEvent actionEvent) throws IOException {
        //GlossaApplication.setRoot("-view");
        GlossaApplication.setRoot("StaffSchoolActivities-view");
    }

    public void ActivityButtonClick(ActionEvent actionEvent) throws IOException {
        System.out.println("attivita");
        //StaffSchoolActivitiesController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolActivities-view");
    }

}
