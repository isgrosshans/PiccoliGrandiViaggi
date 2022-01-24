package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Dormitory;
import it.univr.studyholiday.model.School;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffDormitoriesController implements Initializable {

    @FXML private TableView<Dormitory> DormitoriesTable;
    @FXML private TableColumn DormitoryColumn;
    @FXML private TableColumn AddressColumn;
    @FXML private TableColumn MFColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        DormitoryColumn.setCellValueFactory(new PropertyValueFactory<>("Dormitory"));
//        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
//        MFColumn.setCellValueFactory(new PropertyValueFactory<>("Sex"));
    }

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

    public void AddDormitoryButtonClick(ActionEvent actionEvent) throws IOException {
        StaffDormitoryAddController.setSchool(school);
        GlossaApplication.setRoot("StaffDormitoryAdd");
    }

    public void CellClicked(MouseEvent mouseEvent) throws IOException {
        StaffDormitoryDetailsController.setSchool(school);
        StaffDormitoryDetailsController.setDormitory(DormitoriesTable.getSelectionModel().getSelectedItem());
        GlossaApplication.setRoot("StaffSchoolDetails");
    }
}
