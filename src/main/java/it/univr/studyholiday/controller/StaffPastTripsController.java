package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.Trip;
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
import java.util.ResourceBundle;

public class StaffPastTripsController implements Initializable {
    @FXML private TableView<Trip> TripsTable;
    @FXML private TableColumn<Trip, String> DestinationColumn;
    @FXML private TableColumn<Trip, String> DepartureDateColumn;
    @FXML private TableColumn<Trip, Integer> WeeksColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TripsTable.setEditable(false);
        DestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
        DepartureDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
        WeeksColumn.setCellValueFactory(new PropertyValueFactory<>("Weeks"));

        try {
            TripsTable.setItems(FXCollections.observableArrayList(FetchFromDB.PastTrips()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableView.TableViewSelectionModel<Trip> selectionModel = TripsTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffHome");
    }

    public void CellCliked(MouseEvent mouseEvent) throws IOException {
        StaffPastTripDetailsController.setTrip(TripsTable.getSelectionModel().getSelectedItem());
        pgvApplication.setRoot("StaffPastTripDetails");
    }
}
