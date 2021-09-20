package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Add {

    //todo check single queries

    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)
    public static void add (Accommodation accommodation){
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO College(student,holiday, " +
                            " dormroom,family,startdate,enddate)"  +
                            " VALUES (?,?, "  +
                            " ?,?,?,? ) " )){
                pst.setString(1, accommodation.getReservation().getStudent().getEmail());
                pst.setString(2, accommodation.getReservation().getHoliday().getId());
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
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add college "+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add college "+e.getMessage());
        }*/
    }

    //    ACTIVITY(college,name,
    //             description)
    public static void add(Activity activity){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Activity (college, name, description) "  +
                            " VALUES (?,?,?) " )){
                pst.setString(1, activity.getCollege().getId());
                pst.setString(2, activity.getName());
                pst.setString(3, activity.getDescription());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add activity"+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add activity "+e.getMessage());
        }
    }

    public static void Add(ArrayList<Activity> activities){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }

            try(Connection con=Database.getConnection()) {
                for (Activity activity:activities) {
                    try (PreparedStatement pst = con.prepareStatement(
                            " INSERT INTO Activity (college, name, description) " +
                                    " VALUES (?,?,?) ")) {
                        pst.setString(1, activity.getCollege().getId());
                        pst.setString(2, activity.getName());
                        pst.setString(3, activity.getDescription());
                        pst.executeUpdate();
                    } catch (SQLException e) {
                        System.out.print("add activity" + e.getMessage());
                    }
                }
            }catch(SQLException e){
                System.out.print("add activity "+e.getMessage());
        }
    }

    //    ALLERGY(student,allergen,
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
    public static void add(Answer answer){
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Answer (holiday, question, student) "  +
                            " VALUES (?,?,?) " )){
                pst.setString(1, answer.); //TODO
                pst.setString(2, answer.); //TODO
                pst.setString(3, answer.); //TODO
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }*/
    }

    //    COLLEGE(id,
    //            name,address,postalcode,city,provinceorstate,country,language)
    public static void add(College college){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO College(id,name, address, postalcode, " +
                            " city, provinceorstate, country, language ) "  +
                            " VALUES (?,?,?,?, "  +
                            " ?,?,?,? ) " )){
                pst.setString(1, college.getId());
                pst.setString(2, college.getName());
                pst.setString(3, college.getAddress().getAddress());
                pst.setString(4, college.getAddress().getPostalCode());
                pst.setString(5, college.getAddress().getCity());
                pst.setString(6, college.getAddress().getProvinceorstate());
                pst.setString(7, college.getAddress().getCountry());
                pst.setString(8, college.getLanguage());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add college "+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add college "+e.getMessage());
        }
    }

    //    FIELDTRIP(holiday,destination,
    //            hours,price,description)
    public static void add(FieldTrip fieldTrip){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO FieldTrip (Holiday, destination, description, hours,  "  +
                            " price) "  +
                            " VALUES (?,?,?,?,  "  +
                            " ?) " )){
                pst.setString(1, fieldTrip.getHoliday().getId());
                pst.setString(2, fieldTrip.getDestination());
                pst.setString(3, fieldTrip.getDescription());
                pst.setInt(4, fieldTrip.getHours());
                pst.setInt(5, fieldTrip.getPrice());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add fieldtrip"+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add fieldtrip"+e.getMessage());
        }
    }
    //    DORMROOM(college,number,
    //             beds)

    public static void add(DormRoom dormRoom){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO dormRoom (college, number , beds) "  +
                            " VALUES (?,?,?) " )){
                pst.setString(1, dormRoom.getCollege().getId());
                pst.setString(2, dormRoom.getRoomNumber());
                pst.setInt(3, dormRoom.getBeds());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add activity"+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add activity "+e.getMessage());
        }
    }


    //    HOBBY(student,hobby)
    public static void add(Hobby hobby){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Hobby (student, hobby) "  +
                            " VALUES (?,?) " )){
                pst.setString(1, hobby.getStudent().getEmail());
                pst.setString(2, hobby.getHobby());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add hobby"+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add hobby"+e.getMessage());
        }
    }

    //    FAMILY(email,
    //           college,name,surname,members,pets,bedrooms,bathrooms,citydistance)

    public static void add(Family family){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Family(email, college, name, surname,  "  +
                            " members, pets, bedrooms, bathrooms,citydistance) "  +
                            " VALUES (?,?,?,?, "  +
                            " ?,?,?,?,?)")){
                pst.setString(1, family.getEmail());
                pst.setString(2, family.getCollege().getId());
                pst.setString(3, family.getName());
                pst.setString(4, family.getSurname());
                pst.setInt(5, family.getmembers());
                pst.setBoolean(6, family.hasPets());
                pst.setInt(7, family.getBedrooms());
                pst.setInt(8, family.getBathrooms());
                pst.setString(9,family.getCityDistance());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
    }

    //    HOLIDAY(id,
    //            startdate,weeks,college)
    public static void add(Holiday holiday){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Holiday (id, startdate, college, weeks) "  +
                            " VALUES (?,?,?,?) " )){
                pst.setString(1, holiday.getId());
                pst.setDate(2, Date.valueOf(holiday.getStartDate());
                pst.setString(3, holiday.getCollege().getId());
                pst.setInt(4, holiday.getWeeks());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add holiday"+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add holiday"+e.getMessage());
        }
    }


    //    PARENT(email,
    //           child,name,surname,phonenumber)
    public static void add(Parent parent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }

        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "  INSERT INTO Parent(email,child,name,surname,phonenumber)  "   +
                            "  VALUES (?,?,?,?,?")){
                pst.setString(1, parent.getEmail());
                pst.setString(2, parent.getChild().getEmail());
                pst.setString(3, parent.getName());
                pst.setString(4, parent.getSurname());
                pst.setString(5, parent.getPhonenumber());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print("add parent "+e.getMessage());
            }
        }catch(SQLException e){
            System.out.print("add parent "+e.getMessage());
        }
    }

    //    QUESTION(holiday,question)

    public static void add(Question question){
        /*try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Question (holiday, question) "  +
                            " VALUES (?,?) " )){
                pst.setString(1,question.); //TODO
                pst.setString(2,question.);//TODO
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }*/
    }

    //    RESERVATION(holiday,student,
    //                familystay,single*,friend*,paymentmethod)

    public static void add(Reservation reservation){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " INSERT INTO Reservation (holiday,student,familystay,single,friend,paymentmethod)  "   +
                            "  VALUES (?,?,?,?,  "   +
                            "  ?,?)  "  )){
                pst.setString(1,reservation.getHoliday().getId());
                pst.setString(2, reservation.getStudent().getEmail();
                pst.setBoolean(3,reservation.isFamilyStay());
                if(reservation.isFamilyStay()){
                    pst.setString(4,reservation.getFriend().getEmail());
                    pst.setBoolean(5, false);
                }else{
                    pst.setString(4, "DEFAULT");
                    pst.setBoolean(5, reservation.isSingle());
                }
                pst.setString(6, reservation.getPaymentmethod());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
    }

    //    SURVEY(holiday,student,
    //           score,comment*)


    //    STUDENT(email,
    //            password,name,surname,birthday,birthplace,address,postalcode,city,provinceorstate,country,telephone*)
    public static void add(Student student){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(""+e.getMessage());
        }
        //Student(email, password, firstName, lastName, birthDay, birthPlace, sex, phoneNumber*)
        try(Connection con=Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "  INSERT INTO  Student (email, password, name, surname,   "   +
                            " birthday, birthplace, sex, address, " +
                            " phoneNumber )  "   +
                            "  VALUES (?,?,?,?,  "   +
                            "  ?,?,?,?" +
                            "  ?)  "  )){
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
