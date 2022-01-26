package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FetchFromDB {
    public static ArrayList<School> Schools() throws SQLException {
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

    public static ArrayList<Trip> FutureTrips() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Trip> ral = new ArrayList<Trip>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, h.weeks, s.id,s.name,s.address, s.postalCode, s.city, s.country, s.language " +
                            "FROM school s join holiday h on s.id = h.id " +
                            "WHERE h.departuredate > ?" +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                rs = pst.executeQuery();

                while (rs.next()) {
                ral.add(new Trip(rs.getInt(1),// int holidayid,
                        rs.getDate(2).toLocalDate(),// LocalDate holidaystart,
                        rs.getInt(3),// int holidayweeks,
                        rs.getInt(4),// int schoolid,
                        rs.getString(5),// String schoolname,
                        rs.getString(6),// String schooladdress,
                        rs.getString(7),// String schoolpostalCode,
                        rs.getString(8),// String schoolcity,
                        rs.getString(9),// String schoolcountry,
                        rs.getString(10)// String schoollanguage
                        ));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching trips"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Trip> PastTrips() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Trip> ral = new ArrayList<Trip>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, h.weeks, s.id,s.name,s.address, s.postalCode, s.city, s.country, s.language " +
                            "FROM school s join holiday h on s.id = h.id " +
                            "WHERE h.departuredate <= ?" +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new Trip(rs.getInt(1),// int holidayid,
                            rs.getDate(2).toLocalDate(),// LocalDate holidaystart,
                            rs.getInt(3),// int holidayweeks,
                            rs.getInt(4),// int schoolid,
                            rs.getString(5),// String schoolname,
                            rs.getString(6),// String schooladdress,
                            rs.getString(7),// String schoolpostalCode,
                            rs.getString(8),// String schoolcity,
                            rs.getString(9),// String schoolcountry,
                            rs.getString(10)// String schoollanguage
                    ));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching trips"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Activity> Activities(int schoolid) throws SQLException {
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
                System.out.print("Error fetching activities"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Dormitory> Dormitories(int schoolid) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Dormitory> ral = new ArrayList<Dormitory>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, schoolid, name, address, sex " +
                            "FROM dormitory " +
                            "WHERE schoolid = " +schoolid+" "+
                            "ORDER BY name; " )) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new Dormitory(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching dormitories"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Family> Families(int schoolid) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Family> ral = new ArrayList<Family>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, schoolid, email, " +
                            "firstname, lastname, members, " +
                            "pets, bedrooms, bathrooms, " +
                            "citydistance, address, phone " +
                            "FROM family " +
                            "WHERE schoolid = " +schoolid+" "+
                            "ORDER BY lastname; " )) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new Family(rs.getInt(1),//int id
                            rs.getInt(2),           //int schoolid,
                            rs.getString(3),        // String email,
                            rs.getString(4),        // String firstName,
                            rs.getString(5),        // String lastName,
                            rs.getInt(6),           // int members,
                            rs.getBoolean(7),       // boolean pets,
                            rs.getInt(8),           // int bedrooms,
                            rs.getInt(9),           // int bathrooms,
                            rs.getString(10),       // String cityDistance,
                            rs.getString(11),       // String address
                            rs.getString(12)));     // String phone
                }

            } catch (SQLException e) {
                System.out.print("Error fetching families"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }


   //public static ArrayList<Holiday> HolidaysBefore(LocalDate date) {}

    //public static ArrayList<Holiday> HolidaysAfter(LocalDate date) {}





}
