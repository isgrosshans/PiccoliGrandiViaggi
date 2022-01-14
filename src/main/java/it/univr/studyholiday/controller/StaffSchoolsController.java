package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.*;
import it.univr.studyholiday.util.Database.Fetch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffSchoolsController implements Initializable {

    @FXML private TableView<School> SchoolTable;
    @FXML private TableColumn<School, String> NameColumn;
    @FXML private TableColumn<School, String> CityColumn;
    @FXML private TableColumn<School, String> LanguageColumn;

    ObservableList<School> myschools=null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
        LanguageColumn.setCellValueFactory(new PropertyValueFactory<>("Language"));

        SchoolTable.setItems(getSchools());












        ////////////////////////////////////////////////////////////////





//        if(getSchools()!=null)
//            myschools = FXCollections.observableArrayList(getSchools());
//        if(myschools!=null)
//            schoolstable.getItems().addAll(myschools);

    }

    public ObservableList<School> getSchools(){
        ObservableList<School> schools=FXCollections.observableArrayList();
        schools.add(new School(1,"a","a","a","a","a","a"));
        schools.add(new School(2,"b","b","b","b","b","b"));
        return schools;
    }

    public void ReturnMenuButtonClick(ActionEvent actionEvent) {
    }

    public void AddSchoolButtonClick(ActionEvent actionEvent) {
    }
}
