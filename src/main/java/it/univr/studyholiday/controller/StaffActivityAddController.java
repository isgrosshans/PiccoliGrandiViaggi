package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Activity;
import it.univr.studyholiday.model.entities.School;
import it.univr.studyholiday.util.Database.SaveToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StaffActivityAddController implements Initializable{

    @FXML private Label ErrorLabel;
    @FXML private TextField NameActivityTextField;
    @FXML private TextArea DescriptionActivityTextField;
    @FXML private Label NameSchoolLabel;



    private static School school;


    public static void setSchool(School s) {
        school=s;
    }
    public static School getSchool(){
        return school;
    }


    public void ReturnActivityButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffActivities");
    }

    public void CancelButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffActivities");
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        if(NameActivityTextField.getText().isBlank() || DescriptionActivityTextField.getText().isBlank()){
            ErrorLabel.setText("Riempire tutti i campi per procedere.");
        }
        else {
            SaveToDB.insert(new Activity(school.getId(), NameActivityTextField.getText(), DescriptionActivityTextField.getText()));
            pgvApplication.setRoot("StaffActivities");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NameSchoolLabel.setText(school.getName());

    }
}
