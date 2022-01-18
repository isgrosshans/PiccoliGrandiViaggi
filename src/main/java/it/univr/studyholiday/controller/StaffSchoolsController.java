package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.*;
import it.univr.studyholiday.util.Database.TempDB;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class StaffSchoolsController implements Initializable {

    @FXML private TableView<School> SchoolTable;
    @FXML private TableColumn<School, String> NameColumn;
    @FXML private TableColumn<School, String> CityColumn;
    @FXML private TableColumn<School, String> LanguageColumn;

    private static ObservableList<School> myschools;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TempDB.addSchool(new School(1,"Carl Duisberg Berlin","Jaegerstrasse 64, Toreinfahrt 63 a","10117","Berlino","Germania","Tedesco"));
        myschools= (ObservableList<School>) TempDB.getSchools();
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
        LanguageColumn.setCellValueFactory(new PropertyValueFactory<>("Language"));

        SchoolTable.setItems((ObservableList<School>) TempDB.getSchools());
        SchoolTable.setEditable(false);
        //SchoolTable.setOnMouseClicked();

        TableView.TableViewSelectionModel<School> selectionModel = SchoolTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

//    public ObservableList<School> getSchools(){
//        ObservableList<School> schools=FXCollections.observableArrayList();
//        schools.add(new School(1,"Carl Duisberg Berlin","Jaegerstrasse 64, Toreinfahrt 63 a","10117","Berlino","Germania","Tedesco"));
//        //schools.add(new School(2,"b","b","b","b","b","b"));
//        return schools;
//    }

    public static void addSchool(School school){
        myschools.add(school);
    }

    public void ReturnMenuButtonClick(ActionEvent actionEvent) {
    }

    public void AddSchoolButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffAddSchool-view");
    }

    public void CellCliked(MouseEvent mouseEvent) throws IOException {
        System.out.println(SchoolTable.getSelectionModel().getSelectedItem());
        StaffSchoolDetailsController.setSchool(SchoolTable.getSelectionModel().getSelectedItem());
        GlossaApplication.setRoot("StaffSchoolDetails-view");
    }
}
