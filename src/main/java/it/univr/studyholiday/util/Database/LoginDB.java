package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.Staff;
import it.univr.studyholiday.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {

    // password is encrypted before getting sent to the database
    public static String encrypy(String in){
        String out="";
        int k=Character.getNumericValue(in.charAt(0));
        k=k%100;
        char r;
        int t;
        for (int i = 0; i < in.length(); i++) {
            r=in.charAt(i); t=Character.valueOf(r); t+=k;
            while(t>126){   t-=94;  }
            r=(char) (t);   out+=r;
        }
        return out;
    }

//    public static boolean emailIsAdmin(String email){
//        if(email.contains("@pgv.it"))
//            return true;
//        return false;
//    }


    public static Object login(String email, String password){
        password = encrypy(password);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {

            //try to login as staff
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT COUNT(*) FROM staff WHERE email=? AND psw=? " )) {

                pst.setString(1, email);
                pst.setString(2, password);

                rs = pst.executeQuery();
                rs.next();

                if (rs.getInt(1) == 1) {
                    try (PreparedStatement pst1 = con.prepareStatement(
                            "SELECT id, firstname, lastname, phone " +
                                    " FROM staff " +
                                    " WHERE email=? AND psw=? ")) {
                        pst1.setString(1, email);
                        pst1.setString(2, password);

                        rs = pst1.executeQuery();
                        rs.next();
                        return new Staff( rs.getString(1),
                                email,
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4));

                    }catch (SQLException e1) {
                        System.out.println("Database.login error retrieving student information"+ e1.getMessage());
                    }
                }
            } catch (SQLException e) {
                System.out.println("Database.login error checking credentials:"+e.getMessage());
            }

            //try to login as student
            try (PreparedStatement pst = con.prepareStatement(
                    " SELECT COUNT(*) FROM student WHERE email=? AND psw=? " )) {

                pst.setString(1, email);
                pst.setString(2, password);

                rs = pst.executeQuery();
                rs.next();

                if (rs.getInt(1) == 1) {
                    try (PreparedStatement pst1 = con.prepareStatement(
                            "SELECT firstname, lastname, birthday, sex, " +
                                    " address, phone, hobby, idparent1, idparent2 " +
                                    " FROM student " +
                                    " WHERE email=? AND psw=? ")) {
                        pst1.setString(1, email);
                        pst1.setString(2, password);

                        rs = pst1.executeQuery();
                        rs.next();
                        return new Student( email,
                                            rs.getString(1),
                                            rs.getString(2),
                                            rs.getDate(3).toLocalDate(),
                                            rs.getString(4),
                                            rs.getString(5),
                                            rs.getString(6),
                                            rs.getString(7),
                                            rs.getString(8),
                                            rs.getString(9));

                    }catch (SQLException e1) {
                        System.out.println("Database.login error retrieving student information"+ e1.getMessage());
                    }
                }
            } catch (SQLException e) {
                System.out.println("Database.login error checking credentials:"+e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
        return false;
    }
}
