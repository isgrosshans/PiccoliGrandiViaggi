package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Activity;
import it.univr.studyholiday.model.School;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffSchoolActivitiesController implements Initializable {


    @FXML private TableView<Activity> ActivitiesTable;
    @FXML private TableColumn<Activity, String> NameColumn;
    @FXML private TableColumn<Activity, String> DescriptionColumn;
    
    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ActivitiesTable.setEditable(false);
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));

        try {
            ActivitiesTable.setItems(FXCollections.observableArrayList(getActivities()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ActivitiesTable.setEditable(false);


    }

    private ArrayList<Activity> getActivities() throws SQLException {
        ArrayList<Activity> activities= FetchFromDB.FetchActivities(school.getId());
        return activities;
    }

    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDetailsController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDetails");
    }

    public void AddActivityButtonClick(ActionEvent actionEvent) throws IOException {
        StaffAddActivityController.setSchool(school);
        GlossaApplication.setRoot("StaffAddActivity");
    }

//    public Button ReturnDetailsSchoolButton;
//    public Label ActivityLabel;
//    public Label StaffLabel;
//    public Label ScoolNameLabel;
//    public Button AddActivitylButton;
//    public TableView ActivitiesTable;
//    public TableColumn NameColumn;
//    public TableColumn DescriptionColumn;
//
//    private static School school;
//
//    public static void setSchool(School s) {
//        school = s;
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println(StaffSchoolDetailsController.getSchool().getName());
//    }
//
//
//
//    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
//        StaffSchoolDetailsController.setSchool(school);
//        GlossaApplication.setRoot("StaffSchoolDetails-view");
//    }
}
