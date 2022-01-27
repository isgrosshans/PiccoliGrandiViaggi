package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.entities.Dormitory;
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

public class StaffDormitoriesController implements Initializable {

    @FXML private Label SchoolNameLabel;
    @FXML private TableView<Dormitory> DormitoriesTable;
    @FXML private TableColumn<Dormitory, String> DormitoryColumn;
    @FXML private TableColumn<Dormitory, String> AddressColumn;
    @FXML private TableColumn<Dormitory, String> MFColumn;

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
        DormitoriesTable.setEditable(false);
        DormitoryColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        MFColumn.setCellValueFactory(new PropertyValueFactory<>("Sex"));

        try {
            DormitoriesTable.setItems(FXCollections.observableArrayList(FetchFromDB.Dormitories(school.getId())));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TableView.TableViewSelectionModel<Dormitory> selectionModel = DormitoriesTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

    }

    public void ReturnDetailsSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        StaffSchoolDetailsController.setSchool(school);
        GlossaApplication.setRoot("StaffSchoolDetails");
    }

    public void AddDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoryAddController.setSchool(school);
        GlossaApplication.setRoot("StaffDormitoryAdd");
    }

    public void CellClicked(MouseEvent mouseEvent) throws IOException {
        StaffDormitoryDetailsController.setSchool(school);
        StaffDormitoryDetailsController.setDormitory(DormitoriesTable.getSelectionModel().getSelectedItem());
        GlossaApplication.setRoot("StaffDormitoryDetails");
    }
}
