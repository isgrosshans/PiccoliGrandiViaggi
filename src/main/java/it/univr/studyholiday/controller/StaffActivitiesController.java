package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Activity;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffActivitiesController implements Initializable {


    @FXML private Label TagNameLabel;
    @FXML private Label TagDescriptionLabel;
    @FXML private Label SchoolLabel;
    @FXML private Label NameLabel;
    @FXML private Label DescriptionLabel;
    @FXML private Label SchoolNameLabel;
    @FXML private TableView<Activity> ActivitiesTable;
    @FXML private TableColumn<Activity, String> NameColumn;
    @FXML private TableColumn<Activity, Text> DescriptionColumn;
    
    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ActivitiesTable.setFixedCellSize(Region.USE_COMPUTED_SIZE);
        TagDescriptionLabel.setVisible(false);
        TagNameLabel.setVisible(false);
        SchoolNameLabel.setText(school.getName());
        ActivitiesTable.setEditable(false);
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));


        try {
            ActivitiesTable.setItems(FXCollections.observableArrayList(getActivities()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ActivitiesTable.setEditable(false);

        TableView.TableViewSelectionModel<Activity> selectionModel = ActivitiesTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

    }

    private ArrayList<Activity> getActivities() throws SQLException {
        ArrayList<Activity> activities= FetchFromDB.Activities(school.getId());
        return activities;
    }

    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDetailsController.setSchool(school);
        pgvApplication.setRoot("StaffSchoolDetails");
    }

    public void AddActivityButtonClick(ActionEvent actionEvent) throws IOException {
        StaffActivityAddController.setSchool(school);
        pgvApplication.setRoot("StaffActivityAdd");
    }

    public void CellClicked(MouseEvent mouseEvent) {
        TagDescriptionLabel.setVisible(true);
        TagNameLabel.setVisible(true);
        NameLabel.setText(ActivitiesTable.getSelectionModel().getSelectedItem().getName());
        DescriptionLabel.setText(ActivitiesTable.getSelectionModel().getSelectedItem().getDescription());
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
//        pgvApplication.setRoot("StaffSchoolDetails-view");
//    }
}
