package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.entities.Activity;
import it.univr.studyholiday.model.entities.FieldTrip;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StaffFutureTripDetailsController implements Initializable {



    @FXML private Label DepartureDateLabel;
    @FXML private Label WeeksLabel;
    @FXML private Label NameSchoolLabel;
    @FXML private Label LanguageLabel;
    @FXML private Label TripDestinationLabel;

    @FXML private Label InFamilyLabel;
    @FXML private Label DormitoryLabel;

    @FXML private TableView<FieldTrip> FieldTripsTable;
    @FXML private TableColumn<FieldTrip, String> FieldTripDestinationColumn;
    @FXML private TableColumn<FieldTrip, String> FieldTripHoursColumn;
    @FXML private TableColumn<FieldTrip, String> FieldTripPriceColumn;
    @FXML private TableColumn<FieldTrip, String> FieldTripDescriptionColumn;
    @FXML private Label FieldTripDestinationLabel;
    @FXML private Label HoursLabel;
    @FXML private Label PriceLabel;
    @FXML private Label FieldTripDescriptionLabel;

    @FXML private TableView<Activity> ActivitiesTable;
    @FXML private TableColumn<Activity, String> ActivityNameColumn;
    @FXML private TableColumn<Activity, String> ActivityDescriptionColumn;
    @FXML private Label ActivityNameLabel;
    @FXML private Label ActivityDescriptionLabel;

    private static Trip trip;
    public static void setTrip(Trip t) {
        trip = t;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //initialize Trip////////////////////////////////////////////////////////////////////////////////////
        DepartureDateLabel.setText(trip.getDepartureDate());
        WeeksLabel.setText(String.valueOf(trip.getHoliday().getWeeks()));
        NameSchoolLabel.setText(trip.getSchool().getName());
        LanguageLabel.setText(trip.getSchool().getLanguage());
        TripDestinationLabel.setText(trip.getDestination());
        InFamilyLabel.setText("-");//todo
        DormitoryLabel.setText("-");//todo


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





    public void FieldTripsTableClick(MouseEvent mouseEvent) {
        FieldTripDestinationLabel.setText(FieldTripsTable.getSelectionModel().getSelectedItem().getDestination());
        HoursLabel.setText(String.valueOf(FieldTripsTable.getSelectionModel().getSelectedItem().getHours()));
        PriceLabel.setText("€"+String.valueOf(FieldTripsTable.getSelectionModel().getSelectedItem().getPrice())+",00");
        FieldTripDescriptionLabel.setText(FieldTripsTable.getSelectionModel().getSelectedItem().getDescription());
    }

    public void ActivityTableClick(MouseEvent mouseEvent) {
        ActivityNameLabel.setText(ActivitiesTable.getSelectionModel().getSelectedItem().getName());
        ActivityDescriptionLabel.setText(ActivitiesTable.getSelectionModel().getSelectedItem().getDescription());

    }

    public void ReturnTripsClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffFutureTrips");
    }
}
