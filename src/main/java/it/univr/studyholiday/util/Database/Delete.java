package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)
    public static void delete(Accommodation accommodation) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM accomodation " +
                            " WHERE (student=? AND holiday=?) ")) {
                pst.setString(1, accommodation.getStudent().getEmail());
                pst.setString(2, accommodation.getholiday().getId());
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
    public static void delete(Activity activity) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM activity " +
                            " WHERE (college=? AND name=?) ")) {
                pst.setString(1, activity.getCollege().getId());
                pst.setString(2, activity.getName());
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
    public static void delete(Allergy allergy) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM allergy " +
                            " WHERE (student=? AND allergen=?) ")) {
                pst.setString(1, allergy.getStudent().getEmail());
                pst.setString(2, allergy.getAllergen());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    ANSWER(holiday,question,student,
    //          answer)
    public static void delete(Answer answer) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM Answer " +
                            " WHERE (holiday=? AND student=? AND question=?) ")) {
                pst.setString(1, answer.getSurvey().getHoliday().getId);
                pst.setString(2, answer.getSurvey().getStudent().getEmail());
                pst.setString(3, answer.getQuestion().getQuestion());
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
    public static void delete(College college) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM college " +
                            " WHERE (id = ?) ")) {
                pst.setString(1, college.getId());
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
    public static void delete(FieldTrip fieldTrip) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM FieldTrip " +
                            " WHERE (holiday = ? AND destination=?) ")) {
                pst.setString(1, fieldTrip.getHoliday().getId());
                pst.setString(2, fieldTrip.getDestination());
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

    public static void delete(DormRoom dormRoom) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM DormRoom " +
                            " WHERE (college =? AND number =?) ")) {
                pst.setString(1, dormRoom.getCollege().getId());
                pst.setString(2, dormRoom.getRoomNumber());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    HOBBY(student,hobby)
    public static void delete(Hobby hobby) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM hobby " +
                            " WHERE (student=? AND hobby=?) ")) {
                pst.setString(1, hobby.getStudent().getEmail());
                pst.setString(2, hobby.getHobby());
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

    public static void delete(Family family) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM family " +
                            " WHERE (email = ?) ")) {
                pst.setString(1, family.getEmail());
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

    public static void delete(Holiday holiday) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM holiday " +
                            " WHERE (id = ?) ")) {
                pst.setString(1, holiday.getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    PARENT(email,
    //           child,name,surname,telephone,phonenumber)
    public static void delete(Parent parent) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM parent " +
                            " WHERE (email=?)")) {
                pst.setString(1, parent.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    QUESTION(holiday,question)

    public static void delete(Question question) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM question " +
                            " WHERE (holiday = ? AND question=?) ")) {
                pst.setString(1, question); //TODO
                pst.setString(2, question); //TODO
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

    public static void delete(Reservation reservation) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM Reservation " +
                            " WHERE (holiday = ? AND student=?) ")) {
                pst.setString(1, reservation.getHoliday().getId());
                pst.setString(2, reservation.getStudent().getEmail());
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
    public static void delete(Survey survey) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM Survey " +
                            " WHERE (student = ? AND holiday = ?) ")) {
                pst.setString(1, survey); //TODO
                pst.setString(2, survey.); //TODO
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    STUDENT(email,
    //            password,surname,birthday,birthplace,address,postalcode,city,provinceorstate,country,telephone*)
    public static void delete(Student student) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM student " +
                            " WHERE (email = ?) ")) {
                pst.setString(1, student.getEmail());
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
    public static void delete(TravelAgent travelAgent) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM TravelAgent " +
                            " WHERE (email = ?) ")) {
                pst.setString(1, travelAgent.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
}