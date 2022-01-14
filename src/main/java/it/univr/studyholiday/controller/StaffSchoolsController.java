package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.*;
import it.univr.studyholiday.util.Database.Fetch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffSchoolsController implements Initializable {
    @FXML private Button menu;
    @FXML private Button aggiungicollege;
    @FXML private TableView<School> SchoolTable;
    @FXML private TableColumn<School, String> NameColumn;
    @FXML private TableColumn<School, String> CityColumn;
    @FXML private TableColumn<School, String> LanguageColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Initialize table
        //TableColumn<School, String> c1 = NameColumn;
        NameColumn.setCellValueFactory(new PropertyValueFactory<School, String>("name"));
        CityColumn.setCellValueFactory(new PropertyValueFactory<School, String>("city"));
        LanguageColumn.setCellValueFactory(new PropertyValueFactory<School, String>("language"));

        SchoolTable.setItems(getSchools());



        //ArrayList<School> schools = new ArrayList<>();


//        ObservableList<College> mycolleges=null;
//        if(Fetch.allColleges()!=null)
//            mycolleges = FXCollections.observableArrayList(Fetch.allColleges());
//        if(mycolleges!=null)
//            SchoolTable.getItems().addAll(mycolleges);
    }

    public ObservableList<School> getSchools(){
        ObservableList<School> schools=FXCollections.observableArrayList();
        schools.add(new School("A", "A", "A"));
        schools.add(new School("b","b","b"));
        return schools;
    }

    public void ReturnMenuButtonClick(ActionEvent actionEvent) {
    }

    public void AddSchoolButtonClick(ActionEvent actionEvent) {
    }
}
