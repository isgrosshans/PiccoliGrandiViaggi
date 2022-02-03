package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.Accommodation;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.entities.Allergy;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.model.entities.Student;
import it.univr.studyholiday.util.Database.FetchFromDB;
import it.univr.studyholiday.util.Database.UpdateTable;
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

public class StaffBookingDetailsController implements Initializable {

    @FXML private Button ConfirmButton;
    @FXML private Label HolidayIdLabel;
    @FXML private Label DestinationLabel;
    @FXML private Label DepartureDateLabel;
    @FXML private Label WeeksLabel;
    @FXML private Label StudentIdLabel;
    @FXML private Label StudentFirstNameLabel;
    @FXML private Label StudentLastNameLabel;
    @FXML private Label StudentBirthdayLabel;
    @FXML private Label SudentSexLabel;
    @FXML private TextArea AllergiesTextArea;
    @FXML private TextArea HobbiesTextArea;

    //show these if family stay
    @FXML private Label ALTTagFamilyLabel;
    @FXML private CheckBox ALTFriendCheck;
    @FXML private Label ALTTagEmailLabel;
    @FXML private Label ALTFriendEmailLabel;

    //show these if dorm
    @FXML private Label ALTDormitoryLabel;
    @FXML private Label ALTSingleRoomLabel;  //show if singleroom was requested

    @FXML private TableView<Accommodation> AccommodationTable;
    @FXML private TableColumn<Accommodation, String> NameColumn;
    @FXML private TableColumn<Accommodation, String> AddressColumn;
    @FXML private TableColumn<Accommodation, String> TypeColumn;
    @FXML private TextArea AccommodationInfo;

    private static Accommodation accommodation=null;
    private static Reservation reservation;
    public static void setReservation(Reservation reservation) {
        StaffBookingDetailsController.reservation = reservation;
    }

    private static Trip trip=null;

    private static ArrayList<Accommodation> accommodations=new ArrayList<>();
    private static Accommodation friendsFamily=null;


    public void ReturnReservationsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StaffBookings");

    }

    public void FriendCheckClick(ActionEvent actionEvent) {
        if(ALTFriendCheck.isSelected()){
            AccommodationTable.setItems(FXCollections.observableArrayList(friendsFamily));
        }
    }

    public void AccommodationClick(MouseEvent mouseEvent) {
        AccommodationInfo.setVisible(true);
        AccommodationInfo.setText(AccommodationTable.getSelectionModel().getSelectedItem().italianDescription());
        ConfirmButton.setDisable(false);
    }

    public void ConfirmButtonClick(ActionEvent actionEvent) throws IOException {
        UpdateTable.assignAccomodationToReservation(reservation, AccommodationTable.getSelectionModel().getSelectedItem().getBedId());
        pgvApplication.setRoot("StaffBookings");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showStudentInfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showTripInfo();

        AccommodationTable.setEditable(false);
        NameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));

        AccommodationTable.setItems(FXCollections.observableArrayList(FetchFromDB.Accomodations(reservation)));
        TableView.TableViewSelectionModel<Accommodation> selectionModel = AccommodationTable.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        showAccommodationALT();
        AccommodationInfo.setText("");
        if (reservation.getBedId()!=0){
            AccommodationTable.setDisable(true);
            try {
                accommodation=FetchFromDB.accommodation(reservation);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            AccommodationInfo.setVisible(true);
            AccommodationInfo.setText(accommodation.italianDescription());
        }
    }

    private void showAccommodationALT(){
        if(reservation.getFamilyStay()){
            ALTTagFamilyLabel.setVisible(true);
            if (reservation.getFriendEmail()!=null){
                ALTFriendCheck.setVisible(true);
                ALTTagEmailLabel.setVisible(true);
                ALTFriendEmailLabel.setVisible(true);
                ALTFriendEmailLabel.setText(reservation.getFriendEmail());
            }
        }
        else{
            ALTDormitoryLabel.setVisible(true);
            if (reservation.getRequestedSingle()){
                ALTSingleRoomLabel.setVisible(true);
            }
        }
    }

    private void showStudentInfo() throws SQLException {
        Student student = FetchFromDB.student(reservation.getStudentId());
        StudentIdLabel.setText(String.valueOf(student.getId()));
        StudentFirstNameLabel.setText(student.getFirstName());
        StudentLastNameLabel.setText(student.getLastName());
        StudentBirthdayLabel.setText(student.getBirthdayString());
        SudentSexLabel.setText(student.getSex());
        ArrayList<Allergy> allergies= FetchFromDB.Allergies(student.getId());
        String s = "";
        for (Allergy a:allergies) {
            s+=a.toString()+"\n";
        }
        AllergiesTextArea.setWrapText(true);
        AllergiesTextArea.setEditable(false);
        AllergiesTextArea.setText(s);
        HobbiesTextArea.setWrapText(true);
        HobbiesTextArea.setEditable(false);
        HobbiesTextArea.setText(student.getHobbies());

    }

    private void showTripInfo(){
        trip=FetchFromDB.TripFromHoliday(reservation.getHolidayId());
        HolidayIdLabel.setText(String.valueOf(trip.getHoliday().getId()));
        DestinationLabel.setText(trip.getDestination());
        DepartureDateLabel.setText(trip.getDepartureDate());
        WeeksLabel.setText(String.valueOf(trip.getWeeks()));

    }


}
