package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class StudentPastTripsController implements Initializable {
    public TableView<Trip> TripsTable;
    public TableColumn<Trip,String> DestinationColumn;
    public TableColumn<Trip,LocalDate> DepartureDateColumn;
    public TableColumn<Trip,String> WeeksColumn;

    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentHome");
    }

    public void PastTripsClick(MouseEvent mouseEvent) throws IOException {
        StudentPastTripDetailsController.setTrip(TripsTable.getSelectionModel().getSelectedItem());
        pgvApplication.setRoot("StudentPastTripDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TripsTable.setEditable(false);
        TripsTable.setPlaceholder(new Label("Nessun viaggio da visualizzare."));
        DestinationColumn.setCellValueFactory(new PropertyValueFactory<>("Destination"));
        DepartureDateColumn.setCellValueFactory(new PropertyValueFactory<>("DepartureDate"));
        WeeksColumn.setCellValueFactory(new PropertyValueFactory<>("Weeks"));

        try {
            TripsTable.setItems(FXCollections.observableArrayList(FetchFromDB.PastTripsForStudent()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        TableView.TableViewSelectionModel<Trip> selectionModel = TripsTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }
}
