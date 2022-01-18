//package it.univr.studyholiday.util.Database;
//
//import it.univr.studyholiday.model.Accommodation;
//import it.univr.studyholiday.model.DormRoom;
//import it.univr.studyholiday.model.Reservation;
//import it.univr.studyholiday.model.Student;
//
//import java.sql.*;
//
////Accommodation(student,holiday,
////				dormroom,family,startdate,enddate)
//public class AssignAccommodation {
//
////    DORMROOM(college,number,
////             beds)
//    public static boolean singleDorm (Reservation reservation){
//        boolean assigned=false;
//        String roomNumber="";
//
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (java.lang.ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        ResultSet rs = null;
//        try (Connection con = Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    " SELECT MAX(number)" +
//                            " FROM dormroom" +
//                            " WHERE beds=1 " +
//                            " AND college = ?" +    //reservation->holiday->college->id
//                            " number NOT IN(" +
//                                " SELECT dormroom " +
//                                " FROM accommodation" +
//                                " WHERE college=?" + //reservation->holiday->college->id
//                                " AND (startdate BETWEEN (? AND ?)) " + //reservation->startdate and enddate
//                                " OR enddate BETWEEN (? AND ?))"  )) { //reservation->startdate and enddate
//                pst.setString(1, reservation.getHoliday().getCollege().getId());
//                pst.setString(2, reservation.getHoliday().getCollege().getId());
//                pst.setDate(3, Date.valueOf(reservation.getHoliday().getStartDate()));
//                pst.setDate(4, Date.valueOf(reservation.getHoliday().getEndDate()));
//                pst.setDate(5, Date.valueOf(reservation.getHoliday().getStartDate()));
//                pst.setDate(6, Date.valueOf(reservation.getHoliday().getEndDate()));
//
//                rs = pst.executeQuery();
//                rs.next();
//                roomNumber=rs.getString(1);
//
//                try (PreparedStatement pst2 = con.prepareStatement(
//                        " INSERT INTO Accommodation(student,holiday, " +
//                                " dormroom,startdate,enddate,college)"  +
//                                " VALUES (?,?, "  +
//                                " ?,?,?,? ) "  )) {
//                    pst2.setString(1, reservation.getStudent().getEmail());
//                    pst2.setString(2, reservation.getHoliday().getId());
//                    pst2.setString(3, roomNumber);
//                    pst2.setDate(4, Date.valueOf(reservation.getHoliday().getStartDate()));
//                    pst2.setDate(5, Date.valueOf(reservation.getHoliday().getEndDate()));
//                    pst2.setString(6, reservation.getHoliday().getCollege().getId());
//                    pst2.executeUpdate();
//
//                    assigned=true;
//
//                } catch (SQLException e) {
//                    System.out.print("Database.login error:"+e.getMessage());
//                }
//            } catch (SQLException e) {
//                System.out.print("Database.login error:"+e.getMessage());
//            }
//        } catch (SQLException e) {
//            System.out.print("Connection error: "+e.getMessage());
//        }
//        return assigned;
//    }
//
//    public static boolean sharedDorm (Reservation reservation){
//        boolean assigned=false;
//        String roomNumber="";
//
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (java.lang.ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        ResultSet rs = null;
//        try (Connection con = Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "SELECT MAX(d0.number) FROM dormroom d0 " +
//                            "WHERE d0.beds>1 AND d0.college = ? " +
//                            "AND d0.beds <> ( " +
//                            "SELECT COUNT(*) FROM accommodation a1 " +
//                            "WHERE a1.dormroom=d0.number " +
//                            "AND a1.college=? " +
//                            " AND (startdate BETWEEN (? AND ?)) " + //reservation->startdate and enddate
//                            " OR enddate BETWEEN (? AND ?))"  )) { //reservation->startdate and enddate
//                pst.setString(1, reservation.getHoliday().getCollege().getId());
//                pst.setString(2, reservation.getHoliday().getCollege().getId());
//                pst.setDate(3, Date.valueOf(reservation.getHoliday().getStartDate()));
//                pst.setDate(4, Date.valueOf(reservation.getHoliday().getEndDate()));
//                pst.setDate(5, Date.valueOf(reservation.getHoliday().getStartDate()));
//                pst.setDate(6, Date.valueOf(reservation.getHoliday().getEndDate()));
//
//
//                rs = pst.executeQuery();
//                rs.next();
//                roomNumber=rs.getString(1);
//
//                try (PreparedStatement pst2 = con.prepareStatement(
//                        " INSERT INTO Accommodation(student,holiday, " +
//                                " dormroom,startdate,enddate,college)"  +
//                                " VALUES (?,?, "  +
//                                " ?,?,?,? ) "  )) {
//                    pst2.setString(1, reservation.getStudent().getEmail());
//                    pst2.setString(2, reservation.getHoliday().getId());
//                    pst2.setString(3, roomNumber);
//                    pst2.setDate(4, Date.valueOf(reservation.getHoliday().getStartDate()));
//                    pst2.setDate(5, Date.valueOf(reservation.getHoliday().getEndDate()));
//                    pst2.setString(6, reservation.getHoliday().getCollege().getId());
//                    pst2.executeUpdate();
//
//                    assigned=true;
//
//                } catch (SQLException e) {
//                    System.out.print("Database.login error:"+e.getMessage());
//                }
//            } catch (SQLException e) {
//                System.out.print("Database.login error:"+e.getMessage());
//            }
//        } catch (SQLException e) {
//            System.out.print("Connection error: "+e.getMessage());
//        }
//        return assigned;
//    }
//
//
//
//
////    FAMILY(email,
////           college,name,surname,members,pets,bedrooms,bathrooms,citydistance)
//    public static Boolean family (Reservation reservation){
//        boolean assigned=false;
//        String family="";
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (java.lang.ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        ResultSet rs = null;
//        try (Connection con = Database.getConnection()) {
//            try (PreparedStatement pst = con.prepareStatement(
//                    "SELECT MAX(f0.email) FROM family f0 " +
//                            "WHERE f0.college = ? " +
//                            "AND f0.bedrooms <> ( " +
//                            "SELECT COUNT(*) FROM accommodation a1 " +
//                            "WHERE a1.family=f0.email " +
//                            "AND a1.college=? " +
//                            " AND (startdate BETWEEN (? AND ?)) " + //reservation->startdate and enddate
//                            " OR enddate BETWEEN (? AND ?))"  )) { //reservation->startdate and enddate
//                pst.setString(1, reservation.getHoliday().getCollege().getId());
//                pst.setString(2, reservation.getHoliday().getCollege().getId());
//                pst.setDate(3, Date.valueOf(reservation.getHoliday().getStartDate()));
//                pst.setDate(4, Date.valueOf(reservation.getHoliday().getEndDate()));
//                pst.setDate(5, Date.valueOf(reservation.getHoliday().getStartDate()));
//                pst.setDate(6, Date.valueOf(reservation.getHoliday().getEndDate()));
//                rs = pst.executeQuery();
//                rs.next();  family=rs.getString(1);
//                try (PreparedStatement pst2 = con.prepareStatement(
//                        " INSERT INTO Accommodation(student,holiday, " +
//                                " family,startdate,enddate,college)"  +
//                                " VALUES (?,?, "  +
//                                " ?,?,?,? ) "  )) {
//                    pst2.setString(1, reservation.getStudent().getEmail());
//                    pst2.setString(2, reservation.getHoliday().getId());
//                    pst2.setString(3, family);
//                    pst2.setDate(4, Date.valueOf(reservation.getHoliday().getStartDate()));
//                    pst2.setDate(5, Date.valueOf(reservation.getHoliday().getEndDate()));
//                    pst2.setString(6, reservation.getHoliday().getCollege().getId());
//                    pst2.executeUpdate();
//
//                    assigned=true;
//
//                } catch (SQLException e) {
//                    System.out.print("Database.login error:"+e.getMessage());
//                }
//
//
//
//            } catch (SQLException e) {
//                System.out.print("Database.login error:"+e.getMessage());
//            }
//        } catch (SQLException e) {
//            System.out.print("Connection error: "+e.getMessage());
//        }
//
//        return assigned;
//    }
//
//
//
//
//
//
//
//
//
//}
