package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.Activity;
import it.univr.studyholiday.model.entities.FieldTrip;
import it.univr.studyholiday.util.Database.FetchFromDB;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class StudentFutureTripDetailsController implements Initializable {
    @FXML private MenuButton BookTripMenu;
    @FXML private Label TagPlacesAvailableLabel;
    @FXML private Label TagInFamilyLabel;
    @FXML private Label TagInDormitoryLabel;
    @FXML private Label TripDepartureDateLabel;
    @FXML private Label TripWeeksLabel;
    @FXML private Label TripSchoolNameLabel;
    @FXML private Label TripLanguageLabel;
    @FXML private Label TripDestinationLabel;

    @FXML private Label InFamilyLabel;
    @FXML private Label DormitoryLabel;

    @FXML private TableView<FieldTrip> FieldTripsTable;
    @FXML private TableColumn<FieldTrip, String> FieldTripDestinationColumn;
    @FXML private TableColumn<FieldTrip, String> FieldTripHoursColumn;
    @FXML private TableColumn<FieldTrip, String> FieldTripPriceColumn;
    @FXML private TableColumn<FieldTrip, String> FieldTripDescriptionColumn;
    @FXML private Label FieldTripDestinationLabel;
    @FXML private Label FieldTripHoursLabel;
    @FXML private Label FieldTripPriceLabel;
    @FXML private Label FieldTripDescriptionLabel;

    @FXML private TableView<Activity> ActivitiesTable;
    @FXML private TableColumn<Activity, String> ActivityNameColumn;
    @FXML private TableColumn<Activity, String> ActivityDescriptionColumn;
    @FXML private Label ActivityNameLabel;
    @FXML private Label ActivityDescriptionLabel;

    private static Trip trip = new Trip(-1, LocalDate.of(1900,1,1),0,-1,"-","-","-","-","-","-");
    public static void setTrip(Trip t) {
        trip = t;
    }

    public void ReturnTripsClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentFutureTrips");
    }

    public void FieldTripsTableClick(MouseEvent mouseEvent) throws IOException {
        FieldTripDestinationLabel.setText(FieldTripsTable.getSelectionModel().getSelectedItem().getDestination());
        FieldTripHoursLabel.setText(String.valueOf(FieldTripsTable.getSelectionModel().getSelectedItem().getHours()));
        FieldTripPriceLabel.setText("€"+String.valueOf(FieldTripsTable.getSelectionModel().getSelectedItem().getPrice())+",00");
        FieldTripDescriptionLabel.setText(FieldTripsTable.getSelectionModel().getSelectedItem().getDescription());
    }

    public void ActivityTableClick(MouseEvent mouseEvent) throws IOException {
        ActivityNameLabel.setText(ActivitiesTable.getSelectionModel().getSelectedItem().getName());
        ActivityDescriptionLabel.setText(ActivitiesTable.getSelectionModel().getSelectedItem().getDescription());
    }

    public void BookTripMenuClick(ActionEvent actionEvent) throws IOException {

    }

    public void OnFamilyClick(ActionEvent actionEvent) throws IOException {
        StudentReservationFamilyController.setTrip(trip);
        pgvApplication.setRoot("StudentReservationFamily");
    }

    public void OnDormitoryClick(ActionEvent actionEvent) throws IOException {
        StudentReservationDormitoryController.setTrip(trip);
        pgvApplication.setRoot("StudentReservationDormitory");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (FetchFromDB.hasReservation(User.getCurrentStudent().getId(), trip.getHoliday().getId()))
            BookTripMenu.setVisible(false);

        //initialize Trip////////////////////////////////////////////////////////////////////////////////////
        TripDepartureDateLabel.setText(trip.getDepartureDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        TripWeeksLabel.setText(String.valueOf(trip.getHoliday().getWeeks()));
        TripSchoolNameLabel.setText(trip.getSchool().getName());
        TripLanguageLabel.setText(trip.getSchool().getLanguage());
        TripDestinationLabel.setText(trip.getDestination());

        //last minute change //todo give it its actiual place
        TagPlacesAvailableLabel.setText("");
        TagInFamilyLabel.setText("id viaggio:");
        TagInDormitoryLabel.setText("");
        InFamilyLabel.setText(String.valueOf(trip.getHoliday().getId()));
        DormitoryLabel.setText("");


        //initialize Activities//////////////////////////////////////////////////////////////////////////////
        ActivitiesTable.setEditable(false);
        ActivityNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ActivityDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));

        try {
            ActivitiesTable.setItems(FXCollections.observableArrayList(FetchFromDB.Activities(trip.getSchool().getId())));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TableView.TableViewSelectionModel<Activity> selectionModel = ActivitiesTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);



        //initialize FieldTrips//////////////////////////////////////////////////////////////////////////////
        FieldTripsTable.setEditable(false);
        FieldTripDestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
        FieldTripHoursColumn.setCellValueFactory(new PropertyValueFactory<>("Hours"));
        FieldTripPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        FieldTripDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Description"));

        FieldTripsTable.setItems(FXCollections.observableArrayList(FetchFromDB.FieldTrips(trip.getHoliday().getId())));

    }
}
