package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Family;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StaffFamiliesController implements Initializable {

    @FXML private TableView<Family> FamiliesTable;
    @FXML private TableColumn<Family, String> HouseHolderColumn;
    @FXML private TableColumn<Family, String> AddressColumn;
    @FXML private Label SchoolNameLabel;
    
    private static School school;
    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SchoolNameLabel.setText(school.getName());
        FamiliesTable.setEditable(false);
        HouseHolderColumn.setCellValueFactory(new PropertyValueFactory<>("HouseholderName"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        try {
            FamiliesTable.setItems(FXCollections.observableArrayList(FetchFromDB.Families(school.getId())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableView.TableViewSelectionModel<Family> selectionModel = FamiliesTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDetailsController.setSchool(school);
        pgvApplication.setRoot("StaffSchoolDetails");
    }

    public void AddFamilyButtonAction(ActionEvent actionEvent) throws IOException {
        StaffFamilyAddController.setSchool(school);
        pgvApplication.setRoot("StaffFamilyAdd");
    }

    public void CellCliked(MouseEvent mouseEvent) throws IOException {
        StaffFamilyDetailsController.setSchool(school);
        StaffFamilyDetailsController.setFamily(FamiliesTable.getSelectionModel().getSelectedItem());
        pgvApplication.setRoot("StaffFamilyDetails");
    }
}
