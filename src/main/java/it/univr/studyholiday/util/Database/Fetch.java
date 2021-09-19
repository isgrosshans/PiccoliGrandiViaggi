package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.Address;
import it.univr.studyholiday.model.College;
import it.univr.studyholiday.model.Family;
import it.univr.studyholiday.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fetch {
    //DONE
    public static Family family(String email) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Family family = null;
        ResultSet rs;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT email, name, surname, college, "  +
                            " members, havepets, bedrooms, bathrooms, " +
                            "citydistance"  +
                            " FROM family "  +
                            " WHERE email=? " )) {
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                family = (new Family(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getBoolean(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getString(9)));
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return family;
    }

    public static Student student(String email) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Student student = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT email, password, name, surname, " +
                            " birthday, birthplace, sex, phoneNumber" +
                            " address, postalcode, city, provinceorstate, country" +
                            " FROM student "  +
                            " WHERE email=? " )) {
                pst.setString(1, email);
                rs = pst.executeQuery();

                rs.next();
                student = (new Student(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        new Address(
                                rs.getString(9),
                                rs.getString(10),
                                rs.getString(11),
                                rs.getString(12),
                                rs.getString(13)
                        )));


            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return student;
    }

    public static College college (String collegeid) {

            try {
                Class.forName("org.postgresql.Driver");
            } catch (java.lang.ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            College college = null;
            ResultSet rs;
            try (Connection con = Database.getConnection()) {
                try (PreparedStatement pst = con.prepareStatement(
                        " SELECT id, name, language, address, " +
                                " postalcode, city, provinceorstate, country"  +
                                " FROM college "  +
                                " WHERE id=? " )) {
                    pst.setString(1, collegeid);
                    rs = pst.executeQuery();

                    rs.next();
                    college = (new College(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            new Address(
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getString(6),
                                    rs.getString(7),
                                    rs.getString(8))));


                } catch (SQLException e) {
                    System.out.print(e.getMessage());
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
            return college;

    }

    public static Student travelAgent(String text) {
    }
}
