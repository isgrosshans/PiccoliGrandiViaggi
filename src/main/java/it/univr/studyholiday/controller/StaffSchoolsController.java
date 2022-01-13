package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.College;
import it.univr.studyholiday.util.Database.Fetch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StaffSchoolsController implements Initializable {
    @FXML private Button menu;
    @FXML private Button aggiungicollege;
    @FXML private ListView<College> collegelistview;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        ObservableList<College> mycolleges=null;
//        if(Fetch.allColleges()!=null)
//            mycolleges = FXCollections.observableArrayList(Fetch.allColleges());
//        if(mycolleges!=null)
//            collegelistview.getItems().addAll(mycolleges);
    }

    public void ReturnMenuButtonClick(ActionEvent actionEvent) {
    }

    public void AddSchoolButtonClick(ActionEvent actionEvent) {
    }
}
