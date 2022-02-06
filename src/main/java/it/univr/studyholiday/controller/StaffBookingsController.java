package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.entities.Reservation;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StaffBookingsController implements Initializable {
    @FXML private CheckBox AssignedAccomodation;
    @FXML private CheckBox NotAssignetAccomodation;
    @FXML private TableView<Reservation> BookingsTable;
    @FXML private TableColumn<Reservation, String> StudentIdColumn;
    @FXML private TableColumn<Reservation, String> HolidayIdColumn;
    @FXML private TableColumn<Reservation, String> BedIdColumn;

    private static ArrayList<Reservation> allReservations=new ArrayList<>();
    private static ArrayList<Reservation> assignedAccomodationReservations=new ArrayList<>();
    private static ArrayList<Reservation> notAssigniedAccomodationReservations=new ArrayList<>();

    public static void setAllReservations(ArrayList<Reservation> allReservations) {
        StaffBookingsController.allReservations = allReservations;
    }
    public static void setAssignedAccomodationReservations(ArrayList<Reservation> assignedAccomodationReservations) {
        StaffBookingsController.assignedAccomodationReservations = assignedAccomodationReservations;
    }
    public static void setNotAssigniedAccomodationReservations(ArrayList<Reservation> notAssigniedAccomodationReservations) {
        StaffBookingsController.notAssigniedAccomodationReservations = notAssigniedAccomodationReservations;
    }

    public void ReturnHomeButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffHome");
    }

    public void AssignedAccomodationClick(ActionEvent actionEvent) {
        loadTable();
    }

    public void NotAssignedAccomodationClick(ActionEvent actionEvent) {
        loadTable();
    }

    public void BookedClick(MouseEvent mouseEvent) throws IOException {
        StaffBookingDetailsController.setReservation(BookingsTable.getSelectionModel().getSelectedItem());
        pgvApplication.setRoot("StaffBookingDetails");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        StudentIdColumn.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
        HolidayIdColumn.setCellValueFactory(new PropertyValueFactory<>("HolidayId"));
        BedIdColumn.setCellValueFactory(new PropertyValueFactory<>("BedIdString"));

        try {
            FetchFromDB.StaffBookingTableSetReservations();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        BookingsTable.setPlaceholder(new Label(""));
        BookingsTable.setEditable(false);
        loadTable();
        TableView.TableViewSelectionModel<Reservation> selectionModel = BookingsTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    private void loadTable(){
        if(AssignedAccomodation.isSelected() && NotAssignetAccomodation.isSelected()){
            BookingsTable.setItems(FXCollections.observableArrayList(allReservations));
        }

        if(AssignedAccomodation.isSelected() && !NotAssignetAccomodation.isSelected()){
            BookingsTable.setItems(FXCollections.observableArrayList(assignedAccomodationReservations));
        }

        if(!AssignedAccomodation.isSelected() && NotAssignetAccomodation.isSelected()){
            BookingsTable.setItems(FXCollections.observableArrayList(notAssigniedAccomodationReservations));
        }

        if(!AssignedAccomodation.isSelected() && !NotAssignetAccomodation.isSelected()){
            BookingsTable.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        }

    }
}
