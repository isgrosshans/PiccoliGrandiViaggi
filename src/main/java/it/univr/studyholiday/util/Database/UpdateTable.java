package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.entities.Entity;
import it.univr.studyholiday.model.entities.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateTable {
    public static void assignAccomodationToReservation(Reservation reservation, int bedId){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection con = Database.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE reservation " +
                            " SET bedid=" + bedId +
                            " WHERE id=" + reservation.getId() + ";")) {
                System.out.println(pst);
                pst.executeQuery();

            }catch (SQLException e1) {
                System.out.println("Update Table RESERVATION: "+ e1.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }

    }
}
