package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentBookedTripsController implements Initializable {
    public Button ReturnHomeButton;
    public TableView<Trip> BookingsTable;
    public TableColumn<Trip, String> DestinationColumn;
    public TableColumn<Trip, String> DepartureDateColumn;
    public TableColumn<Trip, String> WeeksColumn;

    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentHome");
    }

    public void TripsTableClick(MouseEvent mouseEvent) throws IOException {
        StudentBookedTripDetailsController.setTrip(BookingsTable.getSelectionModel().getSelectedItem());
        pgvApplication.setRoot("StudentBookedTripDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookingsTable.setEditable(false);
        BookingsTable.setPlaceholder(new Label("Nessuna prenotazione attiva"));
        DestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
        DepartureDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
        WeeksColumn.setCellValueFactory(new PropertyValueFactory<>("Weeks"));

        try {
            BookingsTable.setItems(FXCollections.observableArrayList(FetchFromDB.TripsBookedBy(User.getCurrentStudent().getId())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableView.TableViewSelectionModel<Trip> selectionModel = BookingsTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }
}
