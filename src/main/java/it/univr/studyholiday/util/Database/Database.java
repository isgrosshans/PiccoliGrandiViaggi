package it.univr.studyholiday.util.Database;

import java.sql.*;

public class Database {
    private static String url = "jdbc:postgresql://hattie.db.elephantsql.com/buztakgk";
    private static final String username = "buztakgk";
    private static final String password = "MUubzucXQNb1f7uECJLMRMz9M_dxY9aV";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public static boolean emailInUse(String email){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT COUNT(*)  "  +
                            " FROM student "  +
                            " WHERE email='?' " )) {
                pst.setString(1, email);
                rs = pst.executeQuery();
                rs.next();
                if (rs.getInt(1) == 0 ) return false;
            } catch (SQLException e) {
                System.out.print(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return true;
    }

    public static boolean studentLogin(String email, String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT COUNT(*) FROM student WHERE email=? "  +
                            "  AND password=?  " )) {

                pst.setString(1, email);
                pst.setString(2, password);
                rs = pst.executeQuery();
                rs.next();
                System.out.println(rs.getInt(1));
                if (rs.getInt(1) == 1) return true;
            } catch (SQLException e) {
                System.out.print("Database.login error:"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return false;
    }

    public static boolean adminLogin(String email, String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement pst = con.prepareStatement(

                    " SELECT COUNT(*) FROM staff WHERE email=? "  +
                            "  AND psw=?  " )) {

                pst.setString(1, email);
                pst.setString(2, password);
                rs = pst.executeQuery();
                rs.next();
                System.out.println(rs.getInt(1));
                if (rs.getInt(1) == 1) return true;
            } catch (SQLException e) {
                System.out.print("Database.login error:"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.print("Connection error: "+e.getMessage());
        }
        return false;
    }

}
