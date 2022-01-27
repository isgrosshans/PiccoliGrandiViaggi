package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCertificateController implements Initializable {
    public ImageView PGVImageView;

    public void DetailsClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StudentPastTripDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
