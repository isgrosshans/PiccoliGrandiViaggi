package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Fetch {


    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)
    public static Accommodation accommodation(String student, String holiday) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Accommodation accommodation = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT student,holiday," +
                            " dormroom,family,startdate,enddate "  +
                            " FROM accomodation "  +
                            " WHERE student=? AND holiday=? " )) {
                pst.setString(1, student);
                pst.setString(2, holiday);
                rs = pst.executeQuery();

                rs.next();
                accommodation = (new Accommodation(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getDate(6).toLocalDate()));


            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return accommodation;
    }

    //    ACTIVITY(college,name,
    //             description)
    public static ArrayList<Activity> collegeActivities(String collegeid) {
        ArrayList<Activity> activities=null;
        //TODO
        return activities;
    }

    //    ALLERGY(stident,allergen,
    //            precautions)
    public static void allAllergiesFor(String email) {
    }

    //    ANSWER(holiday,question,student)

    //    COLLEGE(id,
    //            name,address,postalcode,city,provinceorstate,country,language)
    public static College college(String collegeID){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        College college = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT id, name, language, address, " +
                            " postalcode, city, provinceorstate, country "  +
                            " FROM college "  +
                            " WHERE id=? " )) {
                pst.setString(1, collegeID);
                rs = pst.executeQuery();

                rs.next();
                college = (new College(
                        rs.getString(1),
                        rs.getString(2),
                        new Address(
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7))));


            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return college;}

    public static ArrayList<College> allColleges() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<College> ol = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT name, language, address, postalCode, " +
                            " city, provinceorstate, country "  +
                            " FROM college "  +
                            " GROUP BY idcode " )) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ol.add(new College(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            new Address(
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6),
                                rs.getString(7),
                                rs.getString(8))));
                }

            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return ol;
    }

    //    DORMROOM(college,number,
    //             beds)
    public static DormRoom dormRoom(String college, String number){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        DormRoom dormRoom = null;
        ResultSet rs;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT beds"+
                            " FROM dormRoom "  +
                            " WHERE college=? AND number=? " )) {
                pst.setString(1, college);
                pst.setString(2, number);
                rs = pst.executeQuery();
                rs.next();
                dormRoom = (new DormRoom(college, number, rs.getInt(1)));
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return dormRoom;
    }

    //    HOBBY(student,hobby)
    public static ArrayList<Hobby> hobbiesFor(String student) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Hobby> hobbies = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT hobby "  +
                            " FROM hobby "  +
                            " WHERE studente=? " )) {
                pst.setString(1, student);
                rs = pst.executeQuery();
                while (rs.next()) {
                    hobbies.add(new Hobby(student, rs.getString(1)));
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return hobbies;
    }

    //    FAMILY(email,
    //           college,name,surname,members,pets,bedrooms,bathrooms,citydistance)
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

    //    FIELDTRIP(holiday,destination,
    //              hours,price,description)
    public static ArrayList<FieldTrip> fieldTripsFor(String id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<FieldTrip> fieldTrips = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT destination, description, hours, price "  +
                            " FROM fieldtrip "  +
                            " WHERE holiday=? " )) {
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {
                    fieldTrips.add(new FieldTrip(id,
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4)));
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return fieldTrips;
    }

    //    HOLIDAY(id,
    //            startdate,weeks,college)
    public static Holiday holiday(String id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Holiday holiday = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT id,startdate,weeks,college "  +
                            " FROM holiday "  +
                            " ORDER BY departureDate")) {
                rs = pst.executeQuery();
                    holiday = (new Holiday(
                            rs.getString(1),
                            rs.getDate(2).toLocalDate(),
                            rs.getInt(3),
                            rs.getString(4)));

            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return holiday;
    }

    public static ArrayList<Holiday> AllHolidays() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Holiday> ol = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT id,startdate,weeks,college "  +
                            " FROM holiday "  +
                            " ORDER BY departureDate")) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ol.add(new Holiday(
                            rs.getString(1),
                            rs.getDate(2).toLocalDate(),
                            rs.getInt(3),
                            rs.getString(4)));
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return ol;
    }

    public static ArrayList<Holiday> AllHolidaysUntil(LocalDate date) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Holiday> ol = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT id,startdate,weeks,college "  +
                            " FROM holiday "  +
                            " WHERE departureDate <= ? " +
                            " ORDER BY departureDate")) {
                pst.setDate(1, Date.valueOf(date));
                rs = pst.executeQuery();

                while (rs.next()) {
                    ol.add(new Holiday(
                            rs.getString(1),
                            rs.getDate(2).toLocalDate(),
                            rs.getInt(3),
                            rs.getString(4)));
                }

            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return ol;
    }

    public static ArrayList<Holiday> AllHolidaysAfter(LocalDate date) {
        try {
            Class.forName("org.postgresql.Driver " );
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Holiday> ol = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT id,startdate,weeks,college "  +
                            " FROM holiday "  +
                            " WHERE departureDate > ? " +
                            " ORDER BY h.departureDate")) {
                pst.setDate(1, Date.valueOf(date));
                rs = pst.executeQuery();

                while (rs.next()) {
                    ol.add(new Holiday(
                            rs.getString(1),
                            rs.getDate(2).toLocalDate(),
                            rs.getInt(3),
                            rs.getString(4)));
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return ol;
    }

    //    PARENT(email,
    //           child,name,surname,phonenumber)
    public static ArrayList<Parent> parentsFor(String student) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Parent> parents = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT email, name, surname, phonenumber "  +
                            " FROM Parent "  +
                            " WHERE studente=? " )) {
                pst.setString(1, student);
                rs = pst.executeQuery();
                while (rs.next()) {
                    parents.add(new Parent(
                                    rs.getString(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    student));
                }
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return parents;
    }

    //    QUESTION(holiday,question)

    //    RESERVATION(holiday,student,
    //                familystay*,single*,friend*,paymentmethod)
    public static Reservation reservation(String email, String collegeid) {
        return null;
    }

    public static ArrayList<Reservation> allReservationsFor(String email) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Reservation> ol = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT  a.holiday, a.destination, a.language, a.departuredate,  "  +
                            " a.weeks, a.college, a.level, a.paymentmethod "  +
                            " FROM archive a JOIN student ON a.student=s.email "  +
                            " WHERE h.departureDate >= ? AND s.email=? " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                pst.setString(2, student.getemail());
                rs = pst.executeQuery();

                while (rs.next()) {
                    ol.add(new Archive(student,
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getDate(4).toLocalDate(),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)));
                }

            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return ol;
    }

    //    SURVEY(holiday,student,
    //           score,comment*)
    public static Survey survey(String holiday, String student) {
        //TODO
        return null;
    }
    
    //    STUDENT(email,
    //            password,name,surname,birthday,birthplace,address,phonenumber*)
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
                            " address" +
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
                        rs.getString(9)));


            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return student;
    }

    //    TRAVELAGENT(email,
    //                password,name,surname,phonenumber)
    public static TravelAgent travelAgent(String email) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        TravelAgent travelAgent = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT email, password, firstname, lastname, " +
                            " phonenumber "  +
                            " FROM travelagent "  +
                            " WHERE email=? " )) {
                pst.setString(1, email);
                rs = pst.executeQuery();

                rs.next();
                travelAgent = (new TravelAgent(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));


            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return travelAgent;
    }

    public static Question question(String holiday, String question) {
    }



//    public static College college (String collegeid) {
//
//            try {
//                Class.forName("org.postgresql.Driver");
//            } catch (java.lang.ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//            }
//            College college = null;
//            ResultSet rs;
//            try (Connection con = Database.getConnection()) {
//                try (PreparedStatement pst = con.prepareStatement(
//                        " SELECT  " +
//                                " FROM  "  +
//                                " WHERE =? " )) {
//                    pst.setString(1, collegeid);
//                    rs = pst.executeQuery();
//
//                    rs.next();

//                } catch (SQLException e) {
//                    System.out.print(e.getMessage());
//                }
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//            return null;
//    }




}
