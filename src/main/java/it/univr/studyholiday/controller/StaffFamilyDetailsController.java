package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Family;
import it.univr.studyholiday.model.entities.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffFamilyDetailsController implements Initializable {
    @FXML private Label NameSchoolLabel;
    @FXML private Label NameLabel;
    @FXML private Label SurnameLabel;
    @FXML private Label EmailLabel;
    @FXML private Label PhoneLabel;
    @FXML private Label AddressLabel;
    @FXML private Label CityDistanceLabel;
    @FXML private Label MembersLabel;
    @FXML private Label PetsLabel;
    @FXML private Label RoomLabel;
    @FXML private Label BathroomLabel;
    
    private static Family family;
    public static Family getFamily() {
        return family;
    }
    public static void setFamily(Family f) {
        family = f;
    }

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

        NameLabel.setText(family.getFirstName());
        SurnameLabel.setText(family.getLastName());
        EmailLabel.setText(family.getEmail());
        PhoneLabel.setText(family.getPhone());
        AddressLabel.setText(family.getAddress());
        CityDistanceLabel.setText(family.getCityDistance());
        MembersLabel.setText(String.valueOf(family.getMembers()));
        PetsLabel.setText(family.hasPetsIT());
        RoomLabel.setText(String.valueOf(family.getBedrooms()));
        BathroomLabel.setText(String.valueOf(family.getBathrooms()));
    }

        public void ReturnFamiliesButtonClick(ActionEvent actionEvent) throws IOException {
        StaffFamiliesController.setSchool(school);
        pgvApplication.setRoot("StaffFamilies");
    }
}
