package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class StudentCertificateController implements Initializable {
    @FXML private ImageView PGVImageView;
    @FXML private Label FirstNameLabel;
    @FXML private Label LastNameLabel;
    @FXML private Label BirthdayLabel;
    @FXML private Label LanguageLabel;
    @FXML private Label SchoolLabel;
    @FXML private Label PlaceLabel;
    @FXML private Label WhenLabel;
    @FXML private Label LevelLabel;

    private static Trip trip;
    public static void setTrip(Trip trip) {
        StudentCertificateController.trip = trip;
    }
    private static Reservation reservation;

    public void DetailsClick(ActionEvent actionEvent) throws IOException {
        StudentPastTripDetailsController.setTrip(trip);
        pgvApplication.setRoot("StudentPastTripDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reservation= FetchFromDB.reservation(trip.getHoliday().getId(), User.getCurrentStudent().getId());
        FirstNameLabel.setText(User.getCurrentStudent().getFirstName());
        LastNameLabel.setText(User.getCurrentStudent().getLastName());
        BirthdayLabel.setText(User.getCurrentStudent().getBirthdayString());
        LanguageLabel.setText(trip.getSchool().getLanguage());
        SchoolLabel.setText(trip.getSchool().getName());
        PlaceLabel.setText(trip.getSchool().getCity()+", "+trip.getSchool().getCountry());
        if(trip.getWeeks()==1)
            WhenLabel.setText("Dal "+trip.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" per una settimana");
        else
            WhenLabel.setText("Dal "+trip.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+" per "+trip.getWeeks()+" settimane");
        LevelLabel.setText(reservation.getLanguageLevel());
    }
}
