package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.entities.Allergy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteFromDB {
    public static void delete(Allergy allergy) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM allergy " +
                            " WHERE (id=?) ")) {
                pst.setInt(1, allergy.getId());
                pst.executeUpdate();
            }catch (SQLException e1) {
                System.out.println("Delete allergy: "+ e1.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }
}
