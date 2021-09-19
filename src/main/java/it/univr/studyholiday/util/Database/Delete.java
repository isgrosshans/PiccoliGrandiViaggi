package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    //    ACCOMODATION(student,holiday,
    //                 dormroom,family,startdate,enddate)

    //    ACTIVITY(college,name,
    //             description)

    //    ALLERGY(stident,allergen,
    //            precautions)
    public static void delete(Allergy allergy) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM allergy "  +
                            " WHERE (student=? AND allergen=?) " )) {
                pst.setString(1, allergy.getStudent().getEmail());
                pst.setString(1, allergy.getAllergen());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
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
    public static void delete(Parent parent) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM parent "  +
                            " WHERE (email=? AND childsemail=?) " )) {
                pst.setString(1,parent.getEmail());
                pst.setString(2,parent.getChild().getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    //    QUESTION(holiday,question)

    //    RESERVATION(holiday,student,
    //                familystay,single*,friend*,paymentmethod)

    //    SURVEY(holiday,student,
    //           score,comment*)

    //    STUDENT(email,
    //            password,,surname,birthday,birthplace,address,postalcode,city,provinceorstate,country,telephone*)
    public static void delete(Student student) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " DELETE FROM student "  +
                            " WHERE (email = ?) " )) {
                pst.setString(1,student.getEmail());
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
                    " DELETE FROM TravelAgent "  +
                            " WHERE (email = ?) " )) {
                pst.setString(1, travelAgent.getEmail());
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }



//
//    //    Activity (college, name, description)
//    public static void add(Activity activity){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO Activity (college, name, description) "  +
//                            " VALUES (?,?,?) " )){
//                pst.setString(1, activity.getCollege().getIdcode());
//                pst.setString(2, activity.getName());
//                pst.setString(3, activity.getDescription());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Allergy (student, allergen, precautions)
//
//
//    //    Archive(student, holiday, destination, language, departureDate, weeks, college, level, paymentMethod)//TODO PAYMENT METHOD
//    //TODO NO LONGER GOING TO USE ARCHIVE, JUST HOLIDAY
//    public static void add(Archive archive){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO Archive (student, holiday, destination, language,  "  +
//                            " departureDate, college, weeks, level, paymentMethod) "  +
//                            " VALUES (?,?,?,?, "  +
//                            "        ?,?,?,?,?) " )){
//                pst.setString(1, archive.getStudent().getEmailAddress());
//                pst.setString(2, archive.getHolidayID());
//                pst.setString(3, archive.getDestination());
//                pst.setString(4, archive.getLanguage());
//                pst.setDate(5, Date.valueOf(archive.getDepartureDate()));
//                pst.setString(6, archive.getCollegeName());
//                pst.setInt(7, archive.getWeeks());
//                pst.setString(8, archive.getLevel());
//                pst.setString(9,archive.getPaymentMethod());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    College (idcode, name, address, postalCode, city, provinceorstate, country)
//    public static void add(College college){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO College(idcode,name, address, postalCode, city,  "  +
//                            " provinceorstate, country) "  +
//                            " VALUES (?,?,?,?, "  +
//                            " ?,?,?) " )){
//                pst.setString(1, college.getIdcode());
//                pst.setString(2, college.getName());
//                pst.setString(3, college.getAddress().getAddress());
//                pst.setString(4, college.getAddress().getPostalCode());
//                pst.setString(5, college.getAddress().getCity());
//                pst.setString(6, college.getAddress().getProvinceorstate());
//                pst.setString(7, college.getAddress().getCountry());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    DormRoom (college, roomNumber, guest)
//    public static void add(DormRoom dormRoom){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO DormRoom (college, roomNumber, guests) "  +
//                            " VALUES (?,?,?) " )){
//                pst.setString(1, dormRoom.getCollege().getIdcode());
//                pst.setString(2, dormRoom.getRoomNumber());
//                pst.setInt(3, dormRoom.getGuests());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Family (HouseHolder, college, familysize, havePets, bedrooms, bathrooms, guests, distancefromcity)
//    public static void add(Family family){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO Family(HouseHolder, college, havePets, bedrooms,  "  +
//                            " bathrooms, guests, familySize, distanceFromCity) "  +
//                            " VALUES (?,?,?,?, "  +
//                            " ?,?,?,?)")){
//                pst.setString(1, family.getHouseHolder().getEmailAddress());
//                pst.setString(2, family.getCollege().getIdcode());
//                pst.setBoolean(3, family.isHavePets());
//                pst.setInt(4, family.getBedrooms());
//                pst.setInt(5, family.getBathrooms());
//                pst.setInt(6, family.getGuests());
//                pst.setInt(7, family.getFamilySize());
//                pst.setString(8, family.getCityDistance());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    FieldTrip (Holiday, destination, description, hours, price)
//    public static void add(FieldTrip fieldTrip){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO FieldTrip (Holiday, destination, description, hours,  "  +
//                            " price) "  +
//                            " VALUES (?,?,?,?,  "  +
//                            " ?) " )){
//                pst.setString(1, fieldTrip.getHoliday().getIdcode());
//                pst.setString(2, fieldTrip.getDestination());
//                pst.setString(3, fieldTrip.getDescription());
//                pst.setInt(4, fieldTrip.getHours());
//                pst.setInt(5, fieldTrip.getPrice());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Hobby (student, hobby)
//    public static void add(Hobby hobby){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO Hobby (student, hobby) "  +
//                            " VALUES (?,?) " )){
//                pst.setString(1, hobby.getStudent().getEmailAddress());
//                pst.setString(2, hobby.getHobby());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Holiday (idcode, college, language, departureDate, weeks)
//    public static void add(Holiday holiday){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO Holiday (idcode, college, language, departureDate,  "  +
//                            " weeks) "  +
//                            " VALUES (?,?,?,?, "  +
//                            " ?) " )){
//                pst.setString(1, holiday.getIdcode());
//                pst.setString(2, holiday.getCollege().getIdcode());
//                pst.setString(3, holiday.getLanguage());
//                pst.setDate(4, Date.valueOf(holiday.getDepartureDate()));
//                pst.setInt(5, holiday.getWeeks());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    HouseHolder (email, firstName, lastName, phoneNumber, birthday)
//    public static void add(HouseHolder houseHolder){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO HouseHolder (email, firstName, lastName, phoneNumber,  "  +
//                            " birthday) "  +
//                            " VALUES (?,?,?,?, "  +
//                            " ?) " )){
//                pst.setString(1, houseHolder.getEmailAddress());
//                pst.setString(2, houseHolder.getFirstName());
//                pst.setString(3, houseHolder.getLastName());
//                pst.setString(4, houseHolder.getPhoneNumber());
//                pst.setDate(5, Date.valueOf(houseHolder.getBirthday()));
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    OccupancyDorms (holiday, roomNumber, college, Student, ArrivalDate, WEEKS)
//    public static void add(OccupancyDorms occupancyDorms){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "  INSERT INTO OccupancyDorms (holiday, roomNumber, college, Student,   "   +
//                            "  ArrivalDate, weeks)  "   +
//                            "  VALUES (?,?,?,?,  "   +
//                            "  ?,?)  "  )){
//                pst.setString(1, occupancyDorms.getReservation().getHoliday().getIdcode());
//                pst.setString(2, occupancyDorms.getDormRoom().getRoomNumber());
//                pst.setString(3, occupancyDorms.getDormRoom().getCollege().getIdcode());
//                pst.setString(4, occupancyDorms.getStudent().getEmailAddress());
//                pst.setDate(5, Date.valueOf(occupancyDorms.getHoliday().getDepartureDate()));
//                pst.setInt(6, occupancyDorms.getHoliday().getWeeks());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    OccupancyFamily(holiday, Family, Student, ArrivalDate, Weeks)
//    public static void add(OccupancyFamily occupancyFamily){
//        try {
//            Class.forName( "org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "  INSERT INTO  (holiday, Family, Student, ArrivalDate,   "   +
//                            "  Weeks)  "   +
//                            "  VALUES (?,?,?,?,  "   +
//                            "  ?)  "  )){
//                pst.setString(1,occupancyFamily.getReservation().getHoliday().getIdcode());
//                pst.setString(2, occupancyFamily.getFamily().getHouseHolder().getEmailAddress());
//                pst.setString(3, occupancyFamily.getStudent().getEmailAddress());
//                pst.setDate(4, Date.valueOf(occupancyFamily.getHoliday().getDepartureDate()));
//                pst.setInt(5, occupancyFamily.getHoliday().getWeeks());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Parent (email, firstName, lastName, phoneNumber, childsemail)
//    public static void add(Parent parent){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        //Parent(EMAIL, phoneNumber, firstName, lastName, childsemail)
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "  INSERT INTO Parent(email, phoneNumber, firstName, lastName,   "   +
//                            "  childsemail)  "   +
//                            "  VALUES (?,?,?,?,  "   +
//                            "  ?  "  )){
//                pst.setString(1, parent.getEmailAddress());
//                pst.setString(2, parent.getPhoneNumber());
//                pst.setString(3, parent.getFirstName());
//                pst.setString(4, parent.getLastName());
//                pst.setString(5, parent.getChild().getEmailAddress());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //  Reservation (student, holiday, requestedsingle*, level,familystay, friendsemail*, paymentmethod) //TODO PAYMENT METHOD
//    public static void add(Reservation reservation){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO Reservation (student, holiday, level,   "   +
//                            "  friendseamil, requestedsingle, familystay, paymentmethod)  "   +
//                            "  VALUES (?,?,?,?,  "   +
//                            "  ?,?,?)  "  )){
//                pst.setString(1,reservation.getStudent().getEmailAddress());
//                pst.setString(2, reservation.getHoliday().getIdcode());
//                pst.setString(3, reservation.getLevel());
//                if(reservation.getFamilyStay()){
//                    pst.setString(4,reservation.getFriend());
//                    pst.setBoolean(5, false);
//                }else{
//                    pst.setString(4, "DEFAULT");
//                    pst.setBoolean(5, reservation.requestedSingle());
//                }
//                pst.setBoolean(6, reservation.getFamilyStay());
//                pst.setString(7, reservation.getPaymentMethod());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Student (email, password, firstName, lastName, birthday, birthplace, sex, phoneNumber*)
//    public static void add(Student student){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        //Student(email, password, firstName, lastName, birthDay, birthPlace, sex, phoneNumber*)
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "  INSERT INTO  Student (email, password, firstName, lastName,   "   +
//                            "  birthday, birthplace, sex, phoneNumber)  "   +
//                            "  VALUES (?,?,?,?,  "   +
//                            "  ?,?,?,?)  "  )){
//                pst.setString(1, student.getEmailAddress());
//                pst.setString(2, student.getPassword());
//                pst.setString(3, student.getFirstName());
//                pst.setString(4, student.getLastName());
//                pst.setDate(5, Date.valueOf(student.getBirthday()));
//                pst.setString(6, student.getBirthplace());
//                pst.setString(7, student.getSex());
//                if(student.getEmailAddress()==null||student.getPhoneNumber().isBlank())
//                    pst.setString(8, "DEFAULT");
//                pst.setString(8, student.getPhoneNumber());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    Survey (holiday, student, score, comment*, hasquestions, answered, hascomment)
//    public static void add(Survey survey){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "INSERT INTO Survey (holiday, student, score, comment, "  +
//                            "  hasquestions, answered, hascomment)   "    +
//                            "  VALUES (?,?,?,?" +
//                            " ,?,?,?) "  )){
//                pst.setString(1, survey.getArchive().getHolidayID());
//                pst.setString(2,survey.getArchive().getStudent().getEmailAddress());
//                pst.setInt(3,survey.getScore());
//                if(survey.getHasComment())
//                    pst.setString(4, survey.getComment());
//                pst.setString(4, "DEFAULT");
//                pst.setBoolean(5,survey.hasAdditionalQuestions());
//                pst.setBoolean(6,survey.getAnswered());
//                pst.setBoolean(7,survey.getHasComment());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    SurveyAnswer (holiday, student, question, answer)
//    public static void add(SurveyAnswer surveyAnswer){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO SurveyAnswer (holiday, student, question, answer) "  +
//                            " VALUES (?,?,?,?) " )){
//                pst.setString(1,surveyAnswer.getSurvey().getArchive().getHolidayID());
//                pst.setString(2,surveyAnswer.getSurvey().getArchive().getStudent().getEmailAddress());
//                pst.setString(3,surveyAnswer.getQuestion().getQuestionText());
//                pst.setString(4,surveyAnswer.getAnswer());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    SurveyQuestion (holiday,question)
//    public static void add(SurveyQuestion surveyQuestion){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO SurveyQuestion (holiday, question) "  +
//                            " VALUES (?,?) " )){
//                pst.setString(1,surveyQuestion.getHolidayID());
//                pst.setString(2,surveyQuestion.getQuestionText());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//
//    //    TravelAgent (email, password, firstName, lastName,phoneNumber)
//    public static void add(TravelAgent travelAgent){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        try(Connection con=Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " INSERT INTO TravelAgent (email, password, firstName, lastName,phoneNumber "  +
//                            " VALUES (?,?,?,?,? " )){
//                pst.setString(1,travelAgent.getEmail());
//                pst.setString(2,travelAgent.getPassword());
//                pst.setString(3,travelAgent.getFirstName());
//                pst.setString(4,travelAgent.getLastName());
//                pst.setString(5,travelAgent.getPhoneNumber());
//                pst.executeUpdate();
//            } catch (SQLException e) {
//                System.out.print(e.getMessage());
//            }
//        }catch(SQLException e){
//            System.out.print(e.getMessage());
//        }
//    }
//

}
