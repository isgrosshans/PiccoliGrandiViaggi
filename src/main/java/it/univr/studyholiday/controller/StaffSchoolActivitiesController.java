package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffSchoolActivitiesController /*implements Initializable*/ {

    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDetailsController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDetails");
    }

    public void AddActivityButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffAddActivity");
    }

//    public Button ReturnDetailsSchoolButton;
//    public Label ActivityLabel;
//    public Label StaffLabel;
//    public Label ScoolNameLabel;
//    public Button AddActivitylButton;
//    public TreeTableView ActivitiesTable;
//    public TreeTableColumn NameColumn;
//    public TreeTableColumn DescriptionColumn;
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
