package it.univr.studyholiday.controller;

import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.entities.Accommodation;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StaffBookingDetailsController implements Initializable {
    @FXML private TableView<Accommodation> AccommodationTable;
    @FXML private TableColumn<Accommodation, String> NameColumn;
    @FXML private TableColumn<Accommodation, String> AddressColumn;
    @FXML private TableColumn<Accommodation, String> TypeColumn;

    private Reservation reservation;
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void ReturnReservationsButtonClick(ActionEvent actionEvent) {
    }

    public void FriendCheckClick(ActionEvent actionEvent) {
    }

    public void AccommodationClick(MouseEvent mouseEvent) {
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        AccommodationTable.setEditable(false);
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));

        AccommodationTable.setItems(FXCollections.observableArrayList(FetchFromDB.Accomodations(reservation)));
        TableView.TableViewSelectionModel<Accommodation> selectionModel = AccommodationTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

    }
}
