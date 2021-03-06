package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.entities.Entity;
import it.univr.studyholiday.model.entities.Parent;
import it.univr.studyholiday.model.entities.Reservation;
import it.univr.studyholiday.model.entities.Student;

import java.sql.*;

public class UpdateDB {

    public static void assignAccommodationToReservation(Reservation reservation, int bedId){
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
                pst.executeQuery();

            }catch (SQLException e1) {
                System.out.println("Update Table RESERVATION: "+ e1.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }

    }

    public static void editPersonalInfo(Student student){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection con = Database.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE student " +
                            "SET firstname=?, "+//1
                            "lastname=?, "+     //2
                            "birthday=?, "+     //3
                            "sex=?, "+          //4
                            "address=?, "+      //5
                            "phone=?, "+        //6
                            "hobbies=? "+       //7
                            "WHERE id=?;")) {   //8
                pst.setString(1,student.getFirstName());
                pst.setString(2,student.getLastName());
                pst.setDate(3, Date.valueOf(student.getBirthday()));
                pst.setString(4, student.getSex());
                pst.setString(5, student.getAddress());
                pst.setString(6, student.getPhone());
                pst.setString(7, student.getHobbies());
                pst.setInt(8, student.getId());
                
                pst.executeQuery();

            }catch (SQLException e1) {
                System.out.println("Update student email: "+ e1.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void editEmail(Student student, String email){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection con = Database.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE student " +
                            " SET email=? "+
                            " WHERE id=?;")) {
                pst.setString(1,email);
                pst.setInt(2, student.getId());
                
                pst.executeQuery();

            }catch (SQLException e1) {
                System.out.println("Update student email: "+ e1.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void editEmailAndPassword(Student student, String email, String newpsw){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection con = Database.getConnection()) {

            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE student " +
                            " SET email=? , psw=? "+
                            " WHERE id=?;")) {
                pst.setString(1,email);
                pst.setString(2,LoginDB.encrypy(newpsw));
                pst.setInt(3, student.getId());
                
                pst.executeQuery();

            }catch (SQLException e1) {
                System.out.println("Update student email and psw: "+ e1.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static boolean editParent(Parent parent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs=null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(*) FROM parent " +
                            "WHERE email ilike ? " +
                            "AND id<>?;")) {
                pst.setString(1,parent.getEmail());
                pst.setInt(2,parent.getId());
                rs=pst.executeQuery();
                rs.next();
                if(rs.getInt(1)==0){
                    try (PreparedStatement pst1 = con.prepareStatement(
                            "UPDATE parent " +
                                    "SET firstname=?, "+ //1
                                    "lastname=?, "+      //2
                                    "email=?, "+         //3
                                    "phone=? "+          //4
                                    "WHERE id=?;")) {    //5
                        pst1.setString(1,parent.getFirstName());
                        pst1.setString(2,parent.getLastName());
                        pst1.setString(3,parent.getEmail());
                        pst1.setString(4,parent.getPhone());
                        pst1.setInt(5,parent.getId());
                        pst1.executeQuery();
                        return true;
                    }catch (SQLException e1) {
                        System.out.println("Update parent: "+ e1.getMessage());
                    }
                }
            }catch (SQLException e1) {
                System.out.println("Update parent: "+ e1.getMessage());
            }


        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
        return false;
    }
}
