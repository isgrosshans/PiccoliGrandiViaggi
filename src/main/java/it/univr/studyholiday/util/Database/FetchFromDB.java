package it.univr.studyholiday.util.Database;

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
                            "ORDER BY country; " )) {
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
                System.out.print("Error fetching schools"+e.getMessage());
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
                System.out.print("Error fetching trips"+e.getMessage());
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
                System.out.println(Date.valueOf(LocalDate.now()));
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
                System.out.print("Error fetching trips"+e.getMessage());
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
                            "WHERE h.departuredate > ? " +
                            "OR h.departuredate+(h.weeks*7) > ?" +
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
                System.out.print("Error fetching bookings"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static ArrayList<Reservation> Reservations() throws SQLException {
        ArrayList<Reservation> ral = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT r.id, r.studentid, r.holidayid, r.paymentMethod, r.bedid, r.friendEmail, r.languageLevel, r.familyStay, r.requestedSingle " +
                            "FROM reservation r join holiday h on h.id = r.holidayid "+
                            "WHERE h.departuredate > ?" +
                            "ORDER BY h.departuredate; " )) {
                rs = pst.executeQuery();
                rs.next();
                while (rs.next()){
                    ral.add(new Reservation(
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

            } catch (SQLException e) {
                System.out.print("Error fetching trips"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
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
                System.out.print("Error fetching activities"+e.getMessage());
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
                System.out.print("Error fetching dormitories"+e.getMessage());
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
                System.out.print("Error fetching families"+e.getMessage());
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
        Date departuredate;
        Date returndate;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT departuredate, departuredate+(weeks*7)  " +
                            "FROM holiday " +
                            "WHERE id = ? "
                             )) {
                pst.setInt(1, reservation.getHolidayid());
                rs = pst.executeQuery();
                rs.next();
                departuredate=rs.getDate(1);
                returndate=rs.getDate(2);
            } catch (SQLException e) {
                System.out.print("Error fetching roommates"+e.getMessage());
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
                                    "(?<=h.departuredate AND h.departuredate<?) OR " +
                                    "(?<h.departuredate+(7*weeks) AND h.departuredate+(7*weeks)<=?)" )) {

                pst.setInt(1, reservation.getStudentid());
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
                System.out.print("Error fetching roommates"+e.getMessage());
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
                System.out.print("Error fetching schools"+e.getMessage());
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
                if(rs.getInt(1)==0) return new SurveyResults(-1,-1,-1,-1,-1,-1,null);



            } catch (SQLException e) {
                System.out.print("Error fetching survey results"+e.getMessage());
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
                System.out.print("Error fetching survey results"+e.getMessage());
            }

            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT AVG(overallscore), " +
                            "AVG(schoolscore), " +
                            "AVG(accomodationscore), " +
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
                System.out.print("Error fetching survey results"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return sv;
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
                System.out.print("Error fetching activities"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return ral;
    }

    public static void parents(int parent1id, int parent2id){
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
                System.out.print("Error fetching parents"+e.getMessage());
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
                    System.out.print("Error fetching parents" + e.getMessage());
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
                System.out.print("Error fetching parents"+e.getMessage());
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
                System.out.print("Error fetching parents"+e.getMessage());
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
                System.out.print("Error fetching parents"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return null;
    }

    //public static ArrayList<Student> roomMates(int )

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
                            "WHERE r.studentid=? AND r.holidayid" )) {
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
                System.out.print("Error fetching parents"+e.getMessage());
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
                System.out.print("Error fetching reservation"+e.getMessage());
            }
            rs=null;

        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return true;
    }

}
