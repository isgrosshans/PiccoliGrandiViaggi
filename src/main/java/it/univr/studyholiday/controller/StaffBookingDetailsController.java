package it.univr.studyholiday.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StaffBookingDetailsController implements Initializable {
    public TableView<Object> AccomodationTableView;
    public TableColumn<Object, String> NameColumn;
    public TableColumn<Object, String> AddressColumn;
    public TableColumn<Object, String> TypeColumn;

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
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

    }
}
