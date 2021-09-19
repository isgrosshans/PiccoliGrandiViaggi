package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {

    //todo check single queries

    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)

    //    ACTIVITY(college,name,
    //             description)

    //    ALLERGY(stident,allergen,
    //            precautions)
    public static void add(Allergy allergy){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Allergy (student, allergen, precautions) "  +
                            " VALUES (?,?,?) " )){
                pst.setString(1, allergy.getStudent().getEmail());
                pst.setString(2, allergy.getAllergen());
                pst.setString(3, allergy.getPrecautions());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
    }

    //    ANSWER(holiday,question,student)

    //    COLLEGE(id,
    //            name,address,postalcode,city,provinceorstate,country,language)

    //    DAYTRIP(holiday,destination,
    //            hours,price,description)

    //    DORMROOM(college,number,
    //             beds)

    //    HOBBY(student,hobby)

    //    FAMILY(email,
    //           college,name,surname,members,pets,bedrooms,bathrooms,citydistance)

    //    HOLIDAY(id,
    //            startdate,weeks,college)

    //    PARENT(email,
    //           child,name,surname,telephone)
    public static void add(Parent parent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }

        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "  INSERT INTO Parent(email, phoneNumber, firstName, lastName,   "   +
                            "  childsemail)  "   +
                            "  VALUES (?,?,?,?,  "   +
                            "  ?  "  )){
                pst.setString(1, parent.getEmail());
                pst.setString(2, parent.getPhonenumber());
                pst.setString(3, parent.getName());
                pst.setString(4, parent.getSurname());
                pst.setString(5, parent.getChild().getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add parent "+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add parent "+e.getMessage());
        }
    }

    //    QUESTION(holiday,question)

    //    RESERVATION(holiday,student,
    //                familystay,single*,friend*,paymentmethod)

    //    SURVEY(holiday,student,
    //           score,comment*)

    //    STUDENT(email,
    //            password,,surname,birthday,birthplace,address,postalcode,city,provinceorstate,country,telephone*)
    public static void add(Student student){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        //Student(email, password, firstName, lastName, birthDay, birthPlace, sex, phoneNumber*)
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "  INSERT INTO  Student (email, password, firstName, lastName,   "   +
                            "  birthday, birthplace, sex, phoneNumber)  "   +
                            "  VALUES (?,?,?,?,  "   +
                            "  ?,?,?,?)  "  )){
                pst.setString(1, student.getEmail());
                pst.setString(2, student.getPassword());
                pst.setString(3, student.getName());
                pst.setString(4, student.getSurname());
                pst.setDate(5, Date.valueOf(student.getBirthday()));
                pst.setString(6, student.getBirthplace());
                pst.setString(7, student.getSex());
                if(student.getPhonenumber().isBlank())
                    pst.setString(8, "DEFAULT");
                pst.setString(8, student.getPhonenumber());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add student "+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add student "+e.getMessage());
        }
    }

    //    TRAVELAGENT(email,
    //                password,name,surname,telephone)
    public static void add(TravelAgent travelAgent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO TravelAgent (email, password, firstName, lastName,phoneNumber "  +
                            " VALUES (?,?,?,?,? " )){
                pst.setString(1,travelAgent.getEmail());
                pst.setString(2,travelAgent.getPassword());
                pst.setString(3,travelAgent.getName());
                pst.setString(4,travelAgent.getSurname());
                pst.setString(5,travelAgent.getPhonenumber());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
    }



}
