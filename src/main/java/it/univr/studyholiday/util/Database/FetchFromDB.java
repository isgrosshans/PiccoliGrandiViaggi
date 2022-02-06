package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.controller.StaffBookingsController;
import it.univr.studyholiday.controller.StudentProfileController;
import it.univr.studyholiday.model.*;
import it.univr.studyholiday.model.entities.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FetchFromDB {
    public static ArrayList<School> Schools() throws SQLException {
        ArrayList<School> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, name, address, postalcode, city, country, language " +
                            "FROM school " +
                            "ORDER BY name; " )) {
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
                System.out.print("Error fetching schools "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Trip> FutureTrips() throws SQLException {
        ArrayList<Trip> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, h.weeks, s.id,s.name,s.address, s.postalCode, s.city, s.country, s.language " +
                            "FROM school s join holiday h on s.id = h.schoolid " +
                            "WHERE h.departuredate > ?" +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                rs = pst.executeQuery();
                rs.next();
                do {
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
                }while (rs.next());

            } catch (SQLException e) {
                System.out.print("Error fetching future trips "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Trip> PastTrips() throws SQLException {
        ArrayList<Trip> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, h.weeks, s.id,s.name,s.address, s.postalCode, s.city, s.country, s.language " +
                            "FROM school s join holiday h on s.id = h.schoolid " +
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
                System.out.print("Error fetching past trips "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Trip> PastTripsForStudent() throws SQLException {
        ArrayList<Trip> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, h.weeks, s.id,s.name,s.address, s.postalCode, s.city, s.country, s.language " +
                            "FROM school s join holiday h on s.id = h.schoolid " +
                            "WHERE h.departuredate+(7*h.weeks) <= ? " +
                            "AND h.id IN (SELECT holidayid from reservation where studentid=?) " +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                pst.setInt(2,User.getCurrentStudent().getId());
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
                System.out.print("Error fetching past trips "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Trip> TripsBookedBy(int studentid) throws SQLException {
        ArrayList<Trip> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, " +
                            "h.weeks, s.id,s.name,s.address, " +
                            "s.postalCode, s.city, s.country, " +
                            "s.language " +
                            "FROM school s " +
                            "join holiday h on s.id = h.schoolid " +
                            "join reservation r on r.holidayid=h.id " +
                            "WHERE (h.departuredate > ? " +
                            "OR h.departuredate+(h.weeks*7) > ?) " +
                            "AND r.studentid=?" +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                pst.setDate(2, Date.valueOf(LocalDate.now()));
                pst.setInt(3,studentid);
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
                System.out.print("Error fetching bookings "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static Trip TripFromHoliday(int holidayid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  h.id, h.departuredate, " +
                            "h.weeks, s.id,s.name,s.address, " +
                            "s.postalCode, s.city, s.country, " +
                            "s.language " +
                            "FROM school s " +
                            "join holiday h on s.id = h.schoolid " +
                            "WHERE h.id=? " +
                            "ORDER BY h.departuredate; " )) {
                pst.setInt(1,holidayid);
                rs = pst.executeQuery();
                rs.next();
                    return (new Trip(rs.getInt(1),// int holidayid,
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


            } catch (SQLException e) {
                System.out.print("Error fetching bookings "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static void StaffBookingTableSetReservations() throws SQLException {
        ArrayList<Reservation> ral1 = new ArrayList<>();
        ArrayList<Reservation> ral2 = new ArrayList<>();
        ArrayList<Reservation> ral3 = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            //set all
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT r.id, r.studentid, r.holidayid, r.paymentMethod, r.bedid, r.friendEmail, r.languageLevel, r.familyStay, r.requestedSingle " +
                            "FROM reservation r join holiday h on h.id = r.holidayid "+
                            "WHERE h.departuredate > ?" +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));

                rs = pst.executeQuery();
                while (rs.next()){
                    ral1.add(new Reservation(
                            rs.getInt(1),       //int id
                            rs.getInt(2),       //int studentid
                            rs.getInt(3),       //int holidayid
                            rs.getString(4),    //String paymentMethod
                            rs.getInt(5),       //int bedid
                            rs.getString(6),    //String friendEmail
                            rs.getString(7),    //String languageLevel
                            rs.getBoolean(8),   //Boolean familyStay
                            rs.getBoolean(9)));    //Boolean requestedSingle)
                }
                StaffBookingsController.setAllReservations(ral1);

            } catch (SQLException e) {
                System.out.print("Error fetching reservations "+e.getMessage());
            }
            rs=null;

            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT r.id, r.studentid, r.holidayid, r.paymentMethod, r.bedid, r.friendEmail, r.languageLevel, r.familyStay, r.requestedSingle " +
                            "FROM reservation r join holiday h on h.id = r.holidayid "+
                            "WHERE h.departuredate > ? " +
                            "AND r.bedid IS NOT NULL " +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                rs = pst.executeQuery();
                while (rs.next()){
                    ral2.add(new Reservation(
                            rs.getInt(1),       //int id
                            rs.getInt(2),       //int studentid
                            rs.getInt(3),       //int holidayid
                            rs.getString(4),    //String paymentMethod
                            rs.getInt(5),       //int bedid
                            rs.getString(6),    //String friendEmail
                            rs.getString(7),    //String languageLevel
                            rs.getBoolean(8),   //Boolean familyStay
                            rs.getBoolean(9)));    //Boolean requestedSingle)
                }
                StaffBookingsController.setAssignedAccomodationReservations(ral2);

            } catch (SQLException e) {
                System.out.print("Error fetching reservations "+e.getMessage());
            }
            rs=null;


            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT r.id, r.studentid, r.holidayid, r.paymentMethod, r.bedid, r.friendEmail, r.languageLevel, r.familyStay, r.requestedSingle " +
                            "FROM reservation r join holiday h on h.id = r.holidayid "+
                            "WHERE h.departuredate > ? " +
                            "AND r.bedid IS NULL " +
                            "ORDER BY h.departuredate; " )) {
                pst.setDate(1, Date.valueOf(LocalDate.now()));
                rs = pst.executeQuery();
                while (rs.next()){
                    ral3.add(new Reservation(
                            rs.getInt(1),       //int id
                            rs.getInt(2),       //int studentid
                            rs.getInt(3),       //int holidayid
                            rs.getString(4),    //String paymentMethod
                            rs.getInt(5),       //int bedid
                            rs.getString(6),    //String friendEmail
                            rs.getString(7),    //String languageLevel
                            rs.getBoolean(8),   //Boolean familyStay
                            rs.getBoolean(9)));    //Boolean requestedSingle)
                }
                StaffBookingsController.setNotAssigniedAccomodationReservations(ral3);

            } catch (SQLException e) {
                System.out.print("Error fetching reservations "+e.getMessage());
            }
            rs=null;




        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
    }

    public static ArrayList<Activity> Activities(int schoolid) throws SQLException {
        ArrayList<Activity> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
                System.out.print("Error fetching activities "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Allergy> Allergies(int studentid) throws SQLException {
        ArrayList<Allergy> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, studentid, allergen, precaution " +
                            "FROM allergy " +
                            "WHERE studentid = " +studentid+" "+
                            "ORDER BY allergen; " )) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new Allergy(rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getString(4)));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching allergies "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Parent> Parents(int parentid1, int parentid2) throws SQLException {
        ArrayList<Parent> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, email, firstname, lastname, phone  " +
                            "FROM parent " +
                            "WHERE id = " +parentid1+" ; ")) {
                rs = pst.executeQuery();
                rs.next();
                ral.add(new Parent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));


            } catch (SQLException e) {
                System.out.print("Error fetching parents "+e.getMessage());
            }

            rs=null;

            if(parentid2!=-1){
                try (PreparedStatement pst = con.prepareStatement(
                        "SELECT id, email, firstname, lastname, phone  " +
                                "FROM parent " +
                                "WHERE id = " +parentid2+" ; ")) {
                    rs = pst.executeQuery();
                    rs.next();
                    ral.add(new Parent(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)));
                } catch (SQLException e) {
                    System.out.print("Error fetching parents "+e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Dormitory> Dormitories(int schoolid) throws SQLException {
        ArrayList<Dormitory> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
                System.out.print("Error fetching dormitories "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Family> Families(int schoolid) throws SQLException {
        ArrayList<Family> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
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
                System.out.print("Error fetching families "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Student> RoomMates(Reservation reservation, Family family, DormRoom dormRoom) throws SQLException {
        ArrayList<Student> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        Date departuredate = null;
        Date returndate = null;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT departuredate, departuredate+(weeks*7)  " +
                            "FROM holiday " +
                            "WHERE id = ? "
                             )) {
                pst.setInt(1, reservation.getHolidayId());
                rs = pst.executeQuery();
                rs.next();
                departuredate=rs.getDate(1);
                returndate=rs.getDate(2);
            } catch (SQLException e) {
                System.out.print("Error fetching roommates "+e.getMessage());
            }
            rs=null;
            String bedcondition;
            if (reservation.getFamilyStay())
                bedcondition="b.familyid="+family.getId();
            else
                bedcondition="b.dormroomid"+dormRoom.getId();
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT  s.id, s.email, s.firstName, s.lastName, s.birthday, s.sex, s.address, s.phone, s.hobbies, s.parent1id, s.parent2id " +
                            "FROM student s " +
                            "WHERE s.id <> ? " + // ? 1
                            "AND s.id IN(" +
                                "SELECT r.studentid " +
                                "FROM reservation r " +
                                "WHERE r.bedid IN(" +
                                    "SELECT b.id " +
                                    "FROM bed b " +
                                    "WHERE  " + bedcondition + "))" +
                            "AND s.id IN " +
                                "SELECT r.studentid " +
                                "FROM reservation r JOIN holiday h on r.holidayid=h.id " +
                                "WHERE " +
                                    "(?<=h.departuredate AND h.departuredate<?) OR " + // ? 2,3
                                    "(?<h.departuredate+(7*weeks) AND h.departuredate+(7*weeks)<=?) ;" )) { // ? 4,5

                pst.setInt(1, reservation.getStudentId());
                pst.setDate(2, departuredate);
                pst.setDate(3, returndate);
                pst.setDate(4, departuredate);
                pst.setDate(5, returndate);
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new Student(
                            rs.getInt(1),               //int id
                            rs.getString(2),            //String email
                            rs.getString(3),            //String firstName
                            rs.getString(4),            //String lastName
                            rs.getDate(5).toLocalDate(),//LocalDate birthday
                            rs.getString(6),            //String sex
                            rs.getString(7),            //String address
                            rs.getString(8),            //String phone
                            rs.getString(9),            //String hobbies
                            rs.getInt(10),              //int parent1id
                            rs.getInt(11)               //int parent2id
                    ));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching roommates "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static int amountOfRoomsInDorm(int dormitoryid, int beds){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(id) " +
                            "FROM dormroom " +
                            "WHERE beds=? " +
                            "AND dormitoryid=?; " )) {
                pst.setInt(1, beds);
                pst.setInt(2, dormitoryid);
                rs = pst.executeQuery();
                rs.next();
                return rs.getInt(1);

            } catch (SQLException e) {
                System.out.print("Error fetching rooms in dormitory "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return 0;
    }

    public static SurveyResults surveyResults(int holidayid){
        SurveyResults sv=new SurveyResults(-1,-1,-1,-1,-1,-1,null);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<String> comments = new ArrayList<>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(*) " +
                            "FROM survey " +
                            "WHERE holidayid=?; " )) {
                pst.setInt(1, holidayid);
                rs = pst.executeQuery();
                rs.next();
                if(rs.getInt(1)==0) return sv;



            } catch (SQLException e) {
                System.out.print("Error fetching survey results "+e.getMessage());
            }

            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT comment " +
                            "FROM survey " +
                            "WHERE holidayid=?; " )) {
                pst.setInt(1, holidayid);
                rs = pst.executeQuery();
                while (rs.next()) {
                    comments.add(rs.getString(1));
                }


            } catch (SQLException e) {
                System.out.print("Error fetching survey results "+e.getMessage());
            }

            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT AVG(overallscore), " +
                            "AVG(schoolscore), " +
                            "AVG(accommodationscore), " +
                            "AVG(activitiesscore), " +
                            "AVG(fieldtripsscore) " +
                            "FROM survey " +
                            "WHERE holidayid=?; " )) {
                pst.setInt(1, holidayid);
                rs = pst.executeQuery();
                rs.next();
                return new SurveyResults(holidayid,
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        comments);

            } catch (SQLException e) {
                System.out.print("Error fetching survey results "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return sv;
    }

    public static Survey survey(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT holidayid, studentid, comment, " +
                            "overallScore, schoolScore, accommodationScore, activitiesScore, fieldtripsScore " +
                            "FROM survey " +
                            "WHERE studentid=?; " )) {
                pst.setInt(1, User.getCurrentStudent().getId());
                rs = pst.executeQuery();
                rs.next();
                return new Survey(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));

            } catch (SQLException e) {
                System.out.print("Error fetching survey results "+e.getMessage());
            }

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static ArrayList<FieldTrip> FieldTrips(int holidayid) {
        ArrayList<FieldTrip> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, holidayid, destination, description, price, hours " +
                            "FROM fieldtrip " +
                            "WHERE holidayid = " +holidayid+" "+
                            "ORDER BY destination; " )) {
                rs = pst.executeQuery();

                while (rs.next()) {
                    ral.add(new FieldTrip(
                            rs.getInt(1), // int id,
                            rs.getInt(2), // int holidayid,
                            rs.getString(3), // String destination,
                            rs.getString(4), // String description,
                            rs.getInt(5), // int price,
                            rs.getInt(6) // int hours) {
                    ));
                }

            } catch (SQLException e) {
                System.out.print("Error fetching fieldtrips "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static void StudentProfileSetParents(int parent1id, int parent2id){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, email, firstname, lastname, phone " +
                            "FROM parent " +
                            "WHERE id=? " )) {
                pst.setInt(1, parent1id);
                rs = pst.executeQuery();
                rs.next();
                StudentProfileController.setParent1(new Parent(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            } catch (SQLException e) {
                System.out.print("Error fetching parents "+e.getMessage());
            }
            rs=null;
            if (parent2id!=0)
            {
                try (PreparedStatement pst = con.prepareStatement(
                        "SELECT id, email, firstname, lastname, phone " +
                                "FROM parent " +
                                "WHERE id=? ")) {
                    pst.setInt(1, parent2id);
                    rs = pst.executeQuery();
                    rs.next();

                    StudentProfileController.setParent2(new Parent(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)));
                } catch (SQLException e) {
                    System.out.print("Error fetching parents " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }

    }

    public static Family family(int bedid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT f.id, f.schoolid, f.email, f.firstname, f.lastname, f.members, f.pets, f.bedrooms, f.bathrooms, f.citydistance, f.address, f.phone  " +
                            "FROM family f join bed b on b.familyid=f.id " +
                            "WHERE b.id=? " )) {
                pst.setInt(1, bedid);
                rs = pst.executeQuery();
                rs.next();
                return new Family(
                        rs.getInt(1),    //int id
                        rs.getInt(2),    //int schoolid
                        rs.getString(3), //String email
                        rs.getString(4), //String firstName
                        rs.getString(5), //String lastName
                        rs.getInt(6),    //int members
                        rs.getBoolean(7),//boolean pets
                        rs.getInt(8),    //int bedrooms
                        rs.getInt(9),    //int bathrooms
                        rs.getString(10), //String cityDistance
                        rs.getString(11), //String address
                        rs.getString(12)  //String phone
                );
            } catch (SQLException e) {
                System.out.print("Error fetching family "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static Dormitory dormitory(int dormroomid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT d.id, d.schoolid, d.name, d.address, d.sex " +
                            "FROM dormitory d " +
                            "WHERE d.id=? " )) {
                pst.setInt(1, dormroomid);
                rs = pst.executeQuery();
                rs.next();
                return new Dormitory(
                        rs.getInt(1),    //int id
                        rs.getInt(2),    //int schoolid
                        rs.getString(3), //String name
                        rs.getString(4), //String address
                        rs.getString(5)  // String sex
                );
            } catch (SQLException e) {
                System.out.print("Error fetching dormitory "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static DormRoom dormroom(int bedid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT dr.id, dr.dormitoryid, dr.roomnumber, dr.beds " +
                            "FROM dormroom dr " +
                            "JOIN bed b on dr.id = b.dormroomid " +
                            "WHERE b.id=? " )) {
                pst.setInt(1, bedid);
                rs = pst.executeQuery();
                rs.next();
                return new DormRoom(
                        rs.getInt(1),   //int id
                        rs.getInt(2),   //int dormitoryid
                        rs.getString(3),//String roomNumber
                        rs.getInt(4)    //int beds
                );
            } catch (SQLException e) {
                System.out.print("Error fetching dormroom "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static String roomMates(Reservation reservation) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String resultstring="";
        int schoolid = 0;
        int dormroomid = 0;
        int familyid = 0;
        Date departuredate = null;
        Date returndate = null;
        ResultSet rs = null;


        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT schoolid, departuredate, departuredate+(7*weeks) " +
                            "FROM holiday " +
                            "WHERE id=?; ")) {
                pst.setInt(1, reservation.getHolidayId());
                rs = pst.executeQuery();

                rs.next();
                schoolid = rs.getInt(1);
                departuredate = rs.getDate(2);
                returndate = rs.getDate(3);

            } catch (SQLException e) {
                System.out.print("Error fetching room mates " + e.getMessage());
            }
            rs = null;

            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT dormroomid, familyid " +
                            "FROM bed " +
                            "WHERE id=?; ")) {
                pst.setInt(1, reservation.getBedId());
                rs = pst.executeQuery();
                rs.next();
                dormroomid = rs.getInt(1);
                familyid = rs.getInt(2);
            } catch (SQLException e) {
                System.out.print("Error fetching room mates " + e.getMessage());
            }
            rs = null;

            //people staying in same family or in same dormroom
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT student.firstname, student.lastname \n" +
                            "FROM student \n" +
                            "JOIN reservation on student.id = reservation.studentid \n" +
                            "JOIN holiday on reservation.holidayid = holiday.id \n" +
                            "JOIN bed on reservation.bedid = bed.id \n" +
                            "WHERE reservation.bedid is not null \n" +
                            "  AND student.id<>? \n" +  //1
                            "  AND ((dormroomid is not null AND dormroomid=?) OR familyid is not null AND familyid=?) \n" + //2,3
                            "  AND ((holiday.departuredate<=? AND ?<holiday.departuredate+(7*holiday.weeks)) \n" + //?4,5  DEP DEP
                            "    OR (holiday.departuredate<=? AND ?<holiday.departuredate+(7*holiday.weeks)))")) { //?6,7  RET RET
                pst.setInt(1, User.getCurrentStudent().getId());
                pst.setInt(2, dormroomid);
                pst.setInt(3, familyid);
                pst.setDate(4, departuredate);
                pst.setDate(5, departuredate);
                pst.setDate(6, returndate);
                pst.setDate(7, returndate);
                rs = pst.executeQuery();
                int i=0;
                while (rs.next()) {
                    if (i++==0){
                        resultstring+="con \t"+rs.getString(1)+" "+rs.getString(2);
                    }
                    else{
                        resultstring+=",\n\t"+rs.getString(1)+" "+rs.getString(2);
                    }
                }
                return resultstring;

            } catch (SQLException e) {
                System.out.print("Error fetching room mates " + e.getMessage());
            }
        }
        return "";
    }

    public static Reservation reservation(int holidayid, int studentid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT r.id, r.studentid, r.holidayid, r.paymentMethod, r.bedid, r.friendEmail, r.languageLevel, r.familyStay, r.requestedSingle " +
                            "FROM reservation r " +
                            "WHERE r.studentid=? AND r.holidayid=? ;" )) {
                pst.setInt(1, studentid);
                pst.setInt(2, holidayid);
                rs = pst.executeQuery();
                rs.next();
                return new Reservation(
                        rs.getInt(1),       //int id
                        rs.getInt(2),       //int studentid
                        rs.getInt(3),       //int holidayid
                        rs.getString(4),    //String paymentMethod
                        rs.getInt(5),       //int bedid
                        rs.getString(6),    //String friendEmail
                        rs.getString(7),    //String languageLevel
                        rs.getBoolean(8),   //Boolean familyStay
                        rs.getBoolean(9)    //Boolean requestedSingle
                );
            } catch (SQLException e) {
                System.out.print("Error fetching reservation "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static boolean hasReservation(int studentid, int holidayid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(*) " +
                            "FROM reservation " +
                            "WHERE studentid=? AND holidayid=?" )) {
                pst.setInt(1, studentid);
                pst.setInt(2, holidayid);

                rs = pst.executeQuery();
                rs.next();
                if(rs.getInt(1)==0)return false;
            } catch (SQLException e) {
                System.out.print("HasReservation: Error fetching reservation"+e.getMessage());
            }
            rs=null;

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return true;
    }

    public static boolean emailAlreadyRegistered(String email){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(*) " +
                            "FROM student " +
                            "WHERE email=?" )) {
                pst.setString(1,email);

                rs = pst.executeQuery();
                rs.next();
                if(rs.getInt(1)==0)return false;
            } catch (SQLException e) {
                System.out.print("HasReservation: Error fetching reservation"+e.getMessage());
            }
            rs=null;

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return true;
    }

    public static boolean parentInfoConflict(Parent parent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(*) " +
                            "FROM parent " +
                            "WHERE email ilike ? and " +
                            "firstName ilike ? and  " +
                            "lastName ilike ? and  " +
                            "phone ilike ?")) {
                pst.setString(1,parent.getEmail());
                pst.setString(2,parent.getFirstName());
                pst.setString(3,parent.getLastName());
                pst.setString(4,parent.getPhone());

                rs = pst.executeQuery();
                rs.next();
                if(rs.getInt(1)==0)return false;
                else{
                    rs=null;
                    try (PreparedStatement pst1 = con.prepareStatement(
                            "SELECT COUNT(*) " +
                                    "FROM parent " +
                                    "WHERE email ilike ?")) {
                        pst.setString(1,parent.getEmail());
                        rs = pst.executeQuery();
                        rs.next();
                        if(rs.getInt(1)==0)return false;
                    } catch (SQLException e) {
                        System.out.print("HasReservation: Error fetching reservation"+e.getMessage());
                    }

                }
            } catch (SQLException e) {
                System.out.print("HasReservation: Error fetching reservation"+e.getMessage());
            }
            rs=null;

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return true;
    }

    public static boolean hasFilledSurvey(int studentid, int holidayid){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT COUNT(*) " +
                            "FROM survey " +
                            "WHERE studentid=? AND holidayid=?" )) {
                pst.setInt(1, studentid);
                pst.setInt(2, holidayid);

                rs = pst.executeQuery();
                rs.next();
                if(rs.getInt(1)==0)return false;
            } catch (SQLException e) {
                System.out.print("HasReservation: Error fetching reservation"+e.getMessage());
            }
            rs=null;

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return true;
    }

    public static Accommodation accommodation(Reservation reservation) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        int schoolid = 0;

        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT b.id, b.familyid, d.dormitoryid, " + //bed 1,2,3
                            "   d.id, d.dormitoryid, d.roomnumber, d.beds, " + //dormroom 4,5,6,7
                            "   dy.id, dy.schoolid, dy.name, dy.address, dy.sex, " + //dormitory. 8,9,10,11,12
                            "   f.id, f.schoolid, f.email, f.firstName, f.lastName, " + //family, 13,14,15,16,17
                            "   f.members, f.pets, f.bedrooms, f.bathrooms, f.cityDistance, " + //family 18,19,20,21,22
                            "   f.address, f.phone " + //family 23,24
                            "FROM bed b " +
                            "LEFT JOIN family f ON b.familyid=f.id " +
                            "LEFT JOIN dormroom d ON b.dormroomid=d.id " +
                            "LEFT JOIN dormitory dy on d.dormitoryid=dy.id " +
                            "WHERE b.id=? " )) {
                pst.setInt(1,reservation.getBedId());
                rs=pst.executeQuery();
                while (rs.next()){
                    if(rs.getInt(13)>0){
                        return(new Accommodation(
                                new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)),
                                new Family(rs.getInt(13), //int id;
                                        rs.getInt(14), //int schoolid;
                                        rs.getString(15), //String email;
                                        rs.getString(16), //String firstName;
                                        rs.getString(17), //String lastName;
                                        rs.getInt(18), //int members;
                                        rs.getBoolean(19), //boolean pets;
                                        rs.getInt(20), //int bedrooms;
                                        rs.getInt(21), //int bathrooms;
                                        rs.getString(22), //String cityDistance;
                                        rs.getString(23), //String address;
                                        rs.getString(24) //String phone;
                                )
                        ));
                    }
                    else{
                        return(new Accommodation(new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)),
                                new Dormitory(rs.getInt(8),// int id,
                                        rs.getInt(9),// int schoolid,
                                        rs.getString(10),// String name,
                                        rs.getString(11),// String address,
                                        rs.getString(12)// String sex
                                ),
                                new DormRoom(rs.getInt(4), //int id,
                                        rs.getInt(5), // int dormitoryid,
                                        rs.getString(6), // String roomNumber,
                                        rs.getInt(7)// int beds
                                )));
                    }
                }
            }catch (SQLException e){
                System.out.print("Error fetching accommodations "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    public static ArrayList<Accommodation> Accommodations(Reservation reservation) { //todo check
        ArrayList<Accommodation> ral = new ArrayList<>();
        ArrayList<Bed> tal = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        int schoolid = 0;
        Date departuredate = null;
        Date returndate = null;

        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT schoolid, departuredate, departuredate+(7*weeks) " +
                            "FROM holiday " +
                            "WHERE id=?; " )) {
                pst.setInt(1,reservation.getHolidayId());
                rs = pst.executeQuery();

                rs.next();
                schoolid=rs.getInt(1);
                departuredate=rs.getDate(2);
                returndate=rs.getDate(3);

            } catch (SQLException e) {
                System.out.print("Error fetching accommodations "+e.getMessage());
            }

            //available beds (all of them bc fuck u)
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT b.id, b.familyid, d.dormitoryid, " + //bed 1,2,3
                            "   d.id, d.dormitoryid, d.roomnumber, d.beds, " + //dormroom 4,5,6,7
                            "   dy.id, dy.schoolid, dy.name, dy.address, dy.sex, " + //dormitory. 8,9,10,11,12
                            "   f.id, f.schoolid, f.email, f.firstName, f.lastName, " + //family, 13,14,15,16,17
                            "   f.members, f.pets, f.bedrooms, f.bathrooms, f.cityDistance, " + //family 18,19,20,21,22
                            "   f.address, f.phone " + //family 23,24
                            "FROM bed b " +
                            "LEFT JOIN family f ON b.familyid=f.id " +
                            "LEFT JOIN dormroom d ON b.dormroomid=d.id " +
                            "LEFT JOIN dormitory dy on d.dormitoryid=dy.id " +
                            "WHERE (f.schoolid=? OR dy.schoolid=?) " +
                            "AND b.id not in( " +
                                "SELECT distinct reservation.bedid  " +
                                "FROM holiday JOIN reservation ON reservation.holidayid=holiday.id " +
                                "WHERE reservation.bedid is not null " +
                                "AND ((holiday.departuredate<=? AND ?<holiday.departuredate+(7*holiday.weeks))" + //?dep       holiday.departuredate
                                "OR (holiday.departuredate<=? AND ?<holiday.departuredate+(7*holiday.weeks)))); ")) { //?ret    holiday.departuredate+(7*holiday.weeks)
                pst.setInt(1,schoolid);
                pst.setInt(2,schoolid);
                pst.setDate(3, departuredate);
                pst.setDate(4, departuredate);
                pst.setDate(5, returndate);
                pst.setDate(6, returndate);
                rs=pst.executeQuery();
                while (rs.next()){
                    if(rs.getInt(13)>0){
                        ral.add(new Accommodation(
                                new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)),
                                new Family(rs.getInt(13), //int id;
                                        rs.getInt(14), //int schoolid;
                                        rs.getString(15), //String email;
                                        rs.getString(16), //String firstName;
                                        rs.getString(17), //String lastName;
                                        rs.getInt(18), //int members;
                                        rs.getBoolean(19), //boolean pets;
                                        rs.getInt(20), //int bedrooms;
                                        rs.getInt(21), //int bathrooms;
                                        rs.getString(22), //String cityDistance;
                                        rs.getString(23), //String address;
                                        rs.getString(24) //String phone;
                                )
                        ));
                    }
                    else{
                        ral.add(new Accommodation(new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)),
                                new Dormitory(rs.getInt(8),// int id,
                                        rs.getInt(9),// int schoolid,
                                        rs.getString(10),// String name,
                                        rs.getString(11),// String address,
                                        rs.getString(12)// String sex
                                ),
                                new DormRoom(rs.getInt(4), //int id,
                                        rs.getInt(5), // int dormitoryid,
                                        rs.getString(6), // String roomNumber,
                                        rs.getInt(7)// int beds
                                )));
                    }
                }
                return ral;

            }catch (SQLException e){
                System.out.print("Error fetching accommodations "+e.getMessage());
            }




















//            try (PreparedStatement pst = con.prepareStatement(
//                    "SELECT b.id, b.familyid, dormroomid " +
//                            "FROM bed b " +
//                            "WHERE b.id NOT IN(" +
//                            "SELECT r.bedid " +
//                            "FROM reservation r " +
//                            "JOIN holiday h on h.id = r.holidayid " +
//                            "WHERE" +
//                            "(?<=h.departuredate AND h.departuredate<?) OR " +  //? 1,2
//                            "(?<h.departuredate+(7*weeks) AND h.departuredate+(7*weeks)<=?)"+   //? 3,4
//                            ") " +
//                            "AND b.id IN(" +
//                            "SELECT b2.id FROM bed b2 " +
//                            "JOIN family f on b2.familyid = f.id " +
//                            "JOIN dormroom dr on b2.dormroomid = dr.id " +
//                            "JOIN dormitory d on dr.dormitoryid = d.id " +
//                            "WHERE f.schoolid=? OR d.schoolid=?) " +    //?5,6
//                            "; " )) {
//
//                rs = pst.executeQuery();
//                pst.setDate(1, departuredate);
//                pst.setDate(2, returndate);
//                pst.setDate(3, departuredate);
//                pst.setDate(4, returndate);
//                pst.setInt(5,schoolid);
//                pst.setInt(6,schoolid);
//                while (rs.next()) {
//                    tal.add(new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
//                }
//
//            } catch (SQLException e) {
//                System.out.print("Error fetching accommodations "+e.getMessage());
//            }

            //if reservation.getFamilyStay()

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Accommodation> AccommodationsWithFriend(Reservation reservation) {
        ArrayList<Accommodation> ral = new ArrayList<>();
        ArrayList<Bed> tal = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        int schoolid = 0;
        Date departuredate = null;
        Date returndate = null;
        int friendfamilyid = 0;

        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT schoolid, departuredate, departuredate+(7*weeks) " +
                            "FROM holiday " +
                            "WHERE id=?; " )) {
                pst.setInt(1,reservation.getHolidayId());
                rs = pst.executeQuery();

                rs.next();
                schoolid=rs.getInt(1);
                departuredate=rs.getDate(2);
                returndate=rs.getDate(3);

            } catch (SQLException e) {
                System.out.print("Error fetching accommodations "+e.getMessage());
            }

            //reservation -> friend (student) -> family
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT b1.familyid " +
                            "FROM bed b1 " +
                            "JOIN reservation r1 on r1.bedid=b1.id " +
                            "WHERE holidayid=? " +
                            "AND studentid = (" +
                                "SELECT s2.id FROM student s2 " +
                                "WHERE s2.email ilike ?);")) {
                pst.setInt(1,reservation.getHolidayId());
                pst.setString(2,reservation.getFriendEmail());
                rs = pst.executeQuery();
                rs.next();
                friendfamilyid=rs.getInt(1);
            } catch (SQLException e) {
                System.out.print("Error fetching accommodations "+e.getMessage());
            }

            //available beds in specific family
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT b.id, b.familyid, d.dormitoryid, " + //bed 1,2,3
                            "   f.id, f.schoolid, f.email, f.firstName, f.lastName, " + //family, 4,5,6,7,8
                            "   f.members, f.pets, f.bedrooms, f.bathrooms, f.cityDistance, " + //family 9,10,11,12,13
                            "   f.address, f.phone " + //family 14,15
                            "FROM bed b " +
                            "LEFT JOIN family f ON b.familyid=f.id " +
                            "LEFT JOIN dormroom d ON b.dormroomid=d.id " +
                            "LEFT JOIN dormitory dy on d.dormitoryid=dy.id " +
                            "WHERE f.id=? " +
                            "AND b.id not in( " +
                            "SELECT distinct reservation.bedid  " +
                            "FROM holiday JOIN reservation ON reservation.holidayid=holiday.id " +
                            "WHERE reservation.bedid is not null " +
                            "AND ((holiday.departuredate<=? AND ?<holiday.departuredate+(7*holiday.weeks))" + //?dep       holiday.departuredate
                            "OR (holiday.departuredate<=? AND ?<holiday.departuredate+(7*holiday.weeks)))); ")) { //?ret    holiday.departuredate+(7*holiday.weeks)
                pst.setInt(1,friendfamilyid);
                pst.setDate(2, departuredate);
                pst.setDate(3, departuredate);
                pst.setDate(4, returndate);
                pst.setDate(5, returndate);
                rs=pst.executeQuery();

                while (rs.next()){
                    if(rs.getInt(4)>0){
                        ral.add(new Accommodation(
                                new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)),
                                new Family(rs.getInt(4), //int id;
                                        rs.getInt(5), //int schoolid;
                                        rs.getString(6), //String email;
                                        rs.getString(7), //String firstName;
                                        rs.getString(8), //String lastName;
                                        rs.getInt(9), //int members;
                                        rs.getBoolean(10), //boolean pets;
                                        rs.getInt(11), //int bedrooms;
                                        rs.getInt(12), //int bathrooms;
                                        rs.getString(13), //String cityDistance;
                                        rs.getString(14), //String address;
                                        rs.getString(15) //String phone;
                                )
                        ));
                    }
                    else{
                        ral.add(new Accommodation(new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)),
                                new Dormitory(rs.getInt(8),// int id,
                                        rs.getInt(9),// int schoolid,
                                        rs.getString(10),// String name,
                                        rs.getString(11),// String address,
                                        rs.getString(12)// String sex
                                ),
                                new DormRoom(rs.getInt(4), //int id,
                                        rs.getInt(5), // int dormitoryid,
                                        rs.getString(6), // String roomNumber,
                                        rs.getInt(7)// int beds
                                )));
                    }
                }
                return ral;

            }catch (SQLException e){
                System.out.print("Error fetching accommodations "+e.getMessage());
            }




















//            try (PreparedStatement pst = con.prepareStatement(
//                    "SELECT b.id, b.familyid, dormroomid " +
//                            "FROM bed b " +
//                            "WHERE b.id NOT IN(" +
//                            "SELECT r.bedid " +
//                            "FROM reservation r " +
//                            "JOIN holiday h on h.id = r.holidayid " +
//                            "WHERE" +
//                            "(?<=h.departuredate AND h.departuredate<?) OR " +  //? 1,2
//                            "(?<h.departuredate+(7*weeks) AND h.departuredate+(7*weeks)<=?)"+   //? 3,4
//                            ") " +
//                            "AND b.id IN(" +
//                            "SELECT b2.id FROM bed b2 " +
//                            "JOIN family f on b2.familyid = f.id " +
//                            "JOIN dormroom dr on b2.dormroomid = dr.id " +
//                            "JOIN dormitory d on dr.dormitoryid = d.id " +
//                            "WHERE f.schoolid=? OR d.schoolid=?) " +    //?5,6
//                            "; " )) {
//
//                rs = pst.executeQuery();
//                pst.setDate(1, departuredate);
//                pst.setDate(2, returndate);
//                pst.setDate(3, departuredate);
//                pst.setDate(4, returndate);
//                pst.setInt(5,schoolid);
//                pst.setInt(6,schoolid);
//                while (rs.next()) {
//                    tal.add(new Bed(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
//                }
//
//            } catch (SQLException e) {
//                System.out.print("Error fetching accommodations "+e.getMessage());
//            }

            //if reservation.getFamilyStay()

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static Student student(int studentId) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, email, firstName, lastName, birthday,sex, address, phone, hobbies, parent1id, parent2id " +
                            "FROM student " +
                            "WHERE id=?; " )) {
                pst.setInt(1, studentId);
                rs = pst.executeQuery();
                rs.next();
                return new Student(
                        rs.getInt(1),// int id,
                        rs.getString(2),// String email,
                        rs.getString(3),// String firstName,
                        rs.getString(4),// String lastName,
                        rs.getDate(5).toLocalDate(),// LocalDate birthday,
                        rs.getString(6),// String sex,
                        rs.getString(7),// String address,
                        rs.getString(8),// String phone,
                        rs.getString(9),// String hobbies,
                        rs.getInt(10),// int parent1id,
                        rs.getInt(11)// int parent2id
                        );

            } catch (SQLException e) {
                System.out.print("Error fetching dormroom "+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

}
