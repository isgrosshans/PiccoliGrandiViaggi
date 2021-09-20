package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {


    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)
    public static void update(Accommodation accommodation){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Accomodation" +
                            "SET student=?,holiday=?,dormroom=?,family=?,startdate=?,enddate=?,college=?" +
                            "WHERE student=? AND holiday=?")) {
                pst.setString(1, accommodation.getStudent().getEmail());
                pst.setString(2, accommodation.getHoliday().getId());
                if(accommodation.getReservation().isFamilyStay()) {
                    pst.setString(3, "DEFAULT");
                    pst.setString(4, accommodation.getFamily().getEmail());
                }
                if(!accommodation.getReservation().isFamilyStay()) {
                    pst.setString(3, accommodation.getDormRoom().getRoomNumber());
                    pst.setString(4, "DEFAULT");
                }
                pst.setDate(5, Date.valueOf(accommodation.getStartDate()));
                pst.setDate(6, Date.valueOf(accommodation.getEndDate()));
                pst.setString(7, accommodation.getReservation().getHoliday().getId());
                pst.setString(8, accommodation.getStudent().getEmail());
                pst.setString(9, accommodation.getHoliday().getId());

                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    ACTIVITY(college,name,
    //             description)
    public static void update(Activity activity){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Activity" +
                            "SET college=?, name=?, description=?" +
                            "WHERE college=? AND name=?")) {
                pst.setString(1, activity.getCollege().getId());
                pst.setString(2, activity.getName());
                pst.setString(3, activity.getDescription());
                pst.setString(4, activity.getCollege().getId());
                pst.setString(5, activity.getName());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    ALLERGY(student,allergen,
    //            precautions)
    public static void update(Allergy allergy) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE allergy" +
                            "SET student=?, allergen=?, precaution=?" +
                            "WHERE student=? AND allergen=?")) {
                pst.setString(1,allergy.getStudent().getEmail());
                pst.setString(2,allergy.getAllergen());
                pst.setString(3, allergy.getPrecautions());
                pst.setString(4,allergy.getStudent().getEmail());
                pst.setString(5,allergy.getAllergen());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    ANSWER(holiday,question,student,answer)
    public static void update(Answer answer){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Answer" +
                            "SET holiday=?, question=?, student=?, answer=?" +
                            "WHERE holiday=? AND question=? AND student=?")) {
                pst.setString(1,answer.getSurvey().getHoliday().getId());
                pst.setString(2,answer.getQuestion().getQuestion());
                pst.setString(3,answer.getSurvey().getStudent().getEmail());
                pst.setString(4,answer.getAnswer());
                pst.setString(5,answer.getSurvey().getHoliday().getId());
                pst.setString(6,answer.getQuestion().getQuestion());
                pst.setString(7,answer.getSurvey().getStudent().getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }


    //    COLLEGE(id,
    //            name,address,postalcode,city,provinceorstate,country,language)
    public static void update(College college){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE College" +
                            "SET id=?, name=?, address=?, postalCode=?, " +
                            "city=?, provinceorstate=?, country=?,language =?" +
                            "WHERE id=? ")) {

                pst.setString(1, college.getId());
                pst.setString(2, college.getName());
                pst.setString(3, college.getAddress().getAddress());
                pst.setString(4, college.getAddress().getPostalCode());
                pst.setString(5, college.getAddress().getCity());
                pst.setString(6, college.getAddress().getProvinceorstate());
                pst.setString(7, college.getAddress().getCountry());
                pst.setString(8, college.getLanguage());
                pst.setString(9, college.getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    FIELDTRIP(holiday,destination,
    //            hours,price,description)
    public static void update(FieldTrip fieldTrip){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE FieldTrip" +
                            "SET Holiday=?, destination=?, description=?, hours=?, price=?" +
                            "WHERE Holiday=? AND destination=?")) {

                pst.setString(1, fieldTrip.getHoliday().getId());
                pst.setString(2, fieldTrip.getDestination());
                pst.setString(3, fieldTrip.getDescription());
                pst.setInt(4, fieldTrip.getHours());
                pst.setInt(5, fieldTrip.getPrice());
                pst.setString(6, fieldTrip.getHoliday().getId());
                pst.setString(7, fieldTrip.getDestination());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    DORMROOM(college,number,
    //             beds)
    public static void update(DormRoom dormRoom){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE DormRoom" +
                            "SET college=?, number=?, beds=?" +
                            "WHERE college=? AND number=?")) {

                pst.setString(1, dormRoom.getCollege().getId());
                pst.setString(2, dormRoom.getRoomNumber());
                pst.setInt(3, dormRoom.getBeds());
                pst.setString(4, dormRoom.getCollege().getId());
                pst.setString(5, dormRoom.getRoomNumber());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    HOBBY(student,hobby)
    public static void update(Hobby hobby){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE hobby" +
                            "SET student=?, hobby=?" +
                            "WHERE student=? AND hobby=?")) {

                pst.setString(1, hobby.getStudent().getEmail());
                pst.setString(2, hobby.getHobby());
                pst.setString(3, hobby.getStudent().getEmail());
                pst.setString(4, hobby.getHobby());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    FAMILY(email,
    //           college,name,surname,members,pets,bedrooms,bathrooms,citydistance)
    public static void update(Family family){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE family" +
                            "SET email=?, college=?,name=?,surname=?,members=?,pets=?,bedrooms=?,bathrooms=?,citydistance=?" +
                            "WHERE email=?")) {

                pst.setString(1, family.getEmail());
                pst.setString(2, family.getCollege().getId());
                pst.setString(3, family.getName());
                pst.setString(4, family.getSurname());
                pst.setInt(5, family.getmembers());
                pst.setBoolean(6,family.hasPets());
                pst.setInt(7, family.getBedrooms());
                pst.setInt(8, family.getBathrooms());
                pst.setString(9, family.getCityDistance());
                pst.setString(10, family.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    HOLIDAY(id,
    //            startdate,weeks,college)
    public static void update(Holiday holiday){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Holiday" +
                            "SET id=?, startdate=?,weeks=?,college=?" +
                            "WHERE id=?")) {

                pst.setString(1, holiday.getId());
                pst.setDate(2, Date.valueOf(holiday.getStartDate()));
                pst.setInt(3, holiday.getWeeks());
                pst.setString(4, holiday.getCollege().getId());
                pst.setString(5, holiday.getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    PARENT(email,
    //           child,name,surname,phonenumber)
    public static void update(Parent parent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Parent" +
                            "SET email=?, child=?,name=?,surname=?,phonenumber=?" +
                            "WHERE email=?")) {
                pst.setString(1, parent.getEmail());
                pst.setString(2, parent.getChild().getEmail());
                pst.setString(3, parent.getName());
                pst.setString(4, parent.getSurname());
                pst.setString(5, parent.getPhonenumber());
                pst.setString(6, parent.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    QUESTION(holiday,question)
    public static void update(Question question){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Question" +
                            "SET holiday=?, question=?" +
                            "WHERE holiday=? AND question=?")) {
                pst.setString(1, question.getHoliday().getId());
                pst.setString(2, question.getQuestion());
                pst.setString(3, question.getHoliday().getId());
                pst.setString(4, question.getQuestion());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    RESERVATION(holiday,student,
    //                familystay,single*,friend*,paymentmethod)
    public static void update(Reservation reservation){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Reservation" +
                            "SET holiday=?,student=?,familystay=?,single=?,friend=?,paymentmethod=?" +
                            "WHERE holiday=? AND student=?")) {

                pst.setString(1,reservation.getHoliday().getId());
                pst.setString(2, reservation.getStudent().getEmail());
                pst.setBoolean(3,reservation.isFamilyStay());
                if(reservation.isFamilyStay()){
                    pst.setString(4,reservation.getFriend().getEmail());
                    pst.setBoolean(5, false);
                }else{
                    pst.setString(4, "DEFAULT");
                    pst.setBoolean(5, reservation.isSingle());
                }
                pst.setString(6, reservation.getPaymentmethod());
                pst.setString(7,reservation.getHoliday().getId());
                pst.setString(8, reservation.getStudent().getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    SURVEY(holiday,student,
    //           score,comment*)
    public static void update(Survey survey){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE Survey" +
                            "SET holiday=?,student=?,score=?,comment=?" +
                            "WHERE holiday=? AND student=?")) {

                pst.setString(1,survey.getHoliday().getId());
                pst.setString(2, survey.getStudent().getEmail());
                pst.setInt(3,survey.getScore());
                if (survey.hasComment())
                    pst.setString(4, survey.getComment());
                else {
                    pst.setString(4, "DEFAULT");
                }
                pst.setString(5,survey.getHoliday().getId());
                pst.setString(6, survey.getStudent().getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    STUDENT(email,
    //            password,name,surname,birthday,birthplace,address,sex,phonenumber*)
    public static void update(Student student){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE student" +
                            "SET email=?, password=?, name=?, surname=?,\n" +
                            "birthday=?, birthplace=?, sex=?,address, phoneNumber=?" +
                            "WHERE email=?")) {
                pst.setString(1, student.getEmail());
                pst.setString(2, student.getPassword());
                pst.setString(3, student.getName());
                pst.setString(4, student.getSurname());
                pst.setDate(5, Date.valueOf(student.getBirthday()));
                pst.setString(6, student.getBirthplace());
                pst.setString(7, student.getSex());
                pst.setString(8, student.getAddress());
                if(student.getPhonenumber().isBlank())
                    pst.setString(9, "DEFAULT");
                pst.setString(9, student.getPhonenumber());
                pst.setString(10, student.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    TRAVELAGENT(email,
    //                password,name,surname,telephone)
    public static void update(TravelAgent travelAgent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE TABLE TravelAgent" +
                            "SET email=?, password=?, name=?, surname=?,phoneNumber=?" +
                            "WHERE email=?")) {
                pst.setString(1,travelAgent.getEmail());
                pst.setString(2,travelAgent.getPassword());
                pst.setString(3,travelAgent.getName());
                pst.setString(4,travelAgent.getSurname());
                pst.setString(5,travelAgent.getPhonenumber());
                pst.setString(6,travelAgent.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    }





