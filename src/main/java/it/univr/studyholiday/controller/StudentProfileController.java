package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentProfileController implements Initializable {
    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentHome");
    }

    public void EditMenuClick(ActionEvent actionEvent) throws IOException {

    }

    public void EditPersonalDataClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentProfileEdit");
    }

    public void EditEmailPswClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentEmailPswEdit");
    }

    public void EditAllergyClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentAllergyEdit");
    }

    public void EditParentsClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentParentEdit");
    }

    public void AllergiesTableClick(MouseEvent mouseEvent) throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
