package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.Activity;
import it.univr.studyholiday.model.School;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FetchFromDB {
    public static ArrayList<School> FetchSchools () throws SQLException {
        try {
                Class.forName("org.postgresql.Driver");
            } catch (java.lang.ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            ArrayList<School> ral = new ArrayList<School>();
            ResultSet rs = null;
            try (Connection con = Database.getConnection()) {
                try (PreparedStatement pst = con.prepareStatement(
                        "SELECT id, name, address, postalcode, city, country, language " +
                                "FROM school " +
                                "ORDER BY country; " )) {
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        ral.add(new School(rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7)));
                    }

                } catch (SQLException e) {
                    System.out.print("Error fetching schools"+e.getMessage());
                }
            } catch (SQLException e) {
                System.out.print("Connection error: "+e.getMessage());
            }
            return ral;
    }

    public static ArrayList<Activity> FetchActivities(int schoolid) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Activity> ral = new ArrayList<Activity>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, schoolid, name, description " +
                            "FROM activity " +
                            "WHERE schoolid = " +schoolid+" "+
                            "ORDER BY name; " )) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new Activity(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4)));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching activitys"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }
}
