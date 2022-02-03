package it.univr.studyholiday.controller;

import it.univr.studyholiday.pgvApplication;
import it.univr.studyholiday.model.Booking;
import it.univr.studyholiday.model.Trip;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.DormRoom;
import it.univr.studyholiday.model.entities.Dormitory;
import it.univr.studyholiday.model.entities.Family;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.util.Database.FetchFromDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StudentBookedTripDetailsController implements Initializable {

    @FXML private Label DepartureDateLabel;
    @FXML private Label WeeksLabel;
    @FXML private Label NameSchoolLabel;
    @FXML private Label LanguageLabel;
    @FXML private Label DestinationLabel;
    @FXML private Label PaymentLabel;
    @FXML private Label AccomodationsLabel;

    private static Booking booking;
    public static void setBooking(Booking booking) {
        StudentBookedTripDetailsController.booking = booking;
    }

    private static Trip trip;
    public static void setTrip(Trip trip) {
        StudentBookedTripDetailsController.trip = trip;
    }

    private static Reservation reservation;
    private static Family family;
    private static Dormitory dormitory;
    private static DormRoom dormRoom;

    public void ReturnReservationsButtonClick(ActionEvent actionEvent) throws IOException {
        pgvApplication.setRoot("StudentBookedTrips");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reservation= FetchFromDB.reservation(trip.getHoliday().getId(), User.getCurrentStudent().getId());
        System.out.println(reservation.getBedId());
        //if(reservation.getBedid()!=0) {   //null gives back 0 with jdbc
//            if (reservation.getFamilyStay()) {
//                family = FetchFromDB.family(reservation.getBedid());
//            }
//            else{
//                dormRoom=FetchFromDB.dormroom(reservation.getBedid());
//                dormitory=FetchFromDB.dormitory(dormRoom.getDormitoryid());
//            }
//        }
//        else AccomodationsLabel.setText("Alloggio non ancora assegnato.");

    }
}
