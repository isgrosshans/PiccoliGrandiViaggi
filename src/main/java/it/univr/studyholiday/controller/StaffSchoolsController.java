package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.FetchFromDB;
//import it.univr.studyholiday.util.Database.TempDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;

public class StaffSchoolsController implements Initializable {

    @FXML private TableView<School> SchoolTable;
    @FXML private TableColumn<School, String> NameColumn;
    @FXML private TableColumn<School, String> CityColumn;
    @FXML private TableColumn<School, String> LanguageColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
        LanguageColumn.setCellValueFactory(new PropertyValueFactory<>("Language"));

        try {
            SchoolTable.setItems(FXCollections.observableArrayList(FetchFromDB.Schools()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SchoolTable.setEditable(false);

        TableView.TableViewSelectionModel<School> selectionModel = SchoolTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public void ReturnMenuButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffHome");
    }

    public void AddSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffSchoolAdd");
    }

    public void CellCliked(MouseEvent mouseEvent) throws IOException {
        //System.out.println(SchoolTable.getSelectionModel().getSelectedItem());
        StaffSchoolDetailsController.setSchool(SchoolTable.getSelectionModel().getSelectedItem());
        pgvApplication.setRoot("StaffSchoolDetails");
    }
}
