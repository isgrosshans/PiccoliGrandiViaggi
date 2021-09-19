package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {


    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)
    public static void update(Accommodation accommodation){
        //TODO
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
                pst.setString(1, activity.getCollege().getIdcode());
                pst.setString(2, activity.getName());
                pst.setString(3, activity.getDescription());
                pst.setString(4, activity.getCollege().getIdcode());
                pst.setString(5, activity.getName());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    ALLERGY(stident,allergen,
    //            precautions)
    public static void update(Allergy allergy) {
    }

    //    ANSWER(holiday,question,student)
    public static void update(Answer answer){}


    //    COLLEGE(id,
    //            name,address,postalcode,city,provinceorstate,country,language)
    public static void update(College college){}

    //    FIELDTRIP(holiday,destination,
    //            hours,price,description)
    public static void update(FieldTrip fieldTrip){}

    //    DORMROOM(college,number,
    //             beds)
    public static void update(DormRoom dormRoom){}

    //    HOBBY(student,hobby)
    public static void update(Hobby hobby){}

    //    FAMILY(email,
    //           college,name,surname,members,pets,bedrooms,bathrooms,citydistance)
    public static void update(Family family){}

    //    HOLIDAY(id,
    //            startdate,weeks,college)
    public static void update(Holiday holiday){}

    //    PARENT(email,
    //           child,name,surname,telephone)
    public static void update(Parent parent){}

    //    QUESTION(holiday,question)
    public static void update(Question question
    ){}

    //    RESERVATION(holiday,student,
    //                familystay,single*,friend*,paymentmethod)
    public static void update(Reservation reservation){}

    //    SURVEY(holiday,student,
    //           score,comment*)
    public static void update(Survey survey){}

    //    STUDENT(email,
    //            password,,surname,birthday,birthplace,address,postalcode,city,provinceorstate,country,telephone*)
    public static void update(Student student){}

    //    TRAVELAGENT(email,
    //                password,name,surname,telephone)
    public static void update(TravelAgent travelAgent){}




}
