package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.entities.Dormitory;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffDormitoryDetailsController implements Initializable {
    @FXML private Label NameSchoolLabel;
    @FXML private Label NameLabel;
    @FXML private Label AddressLabel;
    @FXML private Label GenderLabel;
    @FXML private Label SingleRoomLabel;
    @FXML private Label DoubleRoomLabel;

    private static Dormitory dormitory;
    public static void setDormitory(Dormitory d) {
        dormitory=d;
    }
    public static Dormitory getDormitory(){
        return dormitory;
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
        NameLabel.setText(dormitory.getName());
        AddressLabel.setText(dormitory.getAddress());
        GenderLabel.setText(dormitory.getSex());
        SingleRoomLabel.setText(String.valueOf(FetchFromDB.amountOfRoomsInDorm(dormitory.getId(), 1)));
        DoubleRoomLabel.setText(String.valueOf(FetchFromDB.amountOfRoomsInDorm(dormitory.getId(), 2)));
    }

    public void ReturnDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoriesController.setSchool(school);
        GlossaApplication.setRoot("StaffDormitories");
    }


}
