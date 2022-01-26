package it.univr.studyholiday.controller;

import it.univr.studyholiday.GlossaApplication;
import it.univr.studyholiday.model.School;
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

public class StaffNewTrip1Controller implements Initializable {
    @FXML private Label ErrorMessage;
    @FXML private TableView<School> SchoolTable;
    @FXML private TableColumn<School, String> NameColumn;
    @FXML private TableColumn<School, String> CityColumn;
    @FXML private TableColumn<School, String> LanguageColumn;

    private Boolean schoolselected=false;

    public void initialize(URL location, ResourceBundle resources) {
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        CityColumn.setCellValueFactory(new PropertyValueFactory<>("City"));
        LanguageColumn.setCellValueFactory(new PropertyValueFactory<>("Language"));

        try {
            SchoolTable.setItems(FXCollections.observableArrayList(FetchFromDB.Schools()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SchoolTable.setEditable(false);

        TableView.TableViewSelectionModel<School> selectionModel = SchoolTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
    }

    public void ReturnTripsButtonClick(ActionEvent actionEvent) throws IOException {
        GlossaApplication.setRoot("StaffFutureTrips");
    }

    public void NextButtonClick(ActionEvent actionEvent) throws IOException {
        if(schoolselected){
            StaffNewTrip2Controller.setSchool(SchoolTable.getSelectionModel().getSelectedItem());
            GlossaApplication.setRoot("StaffNewTrip2");
        }
        else ErrorMessage.setText("Selezionare una scuola");
    }

    public void CellCliked(MouseEvent mouseEvent) throws IOException {
        schoolselected=true;
        ErrorMessage.setText("");
        //GlossaApplication.setRoot("StaffNewTrip2");
    }
}
