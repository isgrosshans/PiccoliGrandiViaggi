package it.univr.studyholiday.util.Database;
import it.univr.studyholiday.model.entities.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;


public class SaveToDB {

    public static void insert (Entity entity){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {

                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO "+getTableNameFor(entity)+
                                " (" + getColumnNamesFor(entity)+
                                ") VALUES ("+
                                getValuesFor(entity)+");")) {

                    System.out.println(pst);
                    rs = pst.executeQuery();
                    rs.next();


                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(entity)+": "+ e1.getMessage());
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }

    }

    public static void insert(Dormitory dormitory, Integer singles, Integer doubles) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int dormitoryid = 0;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            System.out.println();
            //insert new dormitory
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(dormitory)+
                            " (" + getColumnNamesFor(dormitory)+
                            ") VALUES ("+
                            getValuesFor(dormitory)+"); ")) {

                System.out.println(pst);
                rs = pst.executeQuery();
                rs.next();


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

            try (PreparedStatement pst = con.prepareStatement(
                            "SELECT id FROM dormitory " +
                            "WHERE schoolid = ? " +
                            "AND name ILIKE ? " +
                            "AND address ILIKE ? " +
                            "AND sex ILIKE ?; ")) {
                pst.setInt(1, dormitory.getSchoolid());
                pst.setString(2, dormitory.getName());
                pst.setString(3, dormitory.getAddress());
                pst.setString(4, dormitory.getSex());
                rs = pst.executeQuery();
                rs.next();
                dormitory.setId(rs.getInt(1));


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
            }

            //insert rooms
            int i=1;
            for (int j = 0; j < singles; j++) {
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO dormroom "+
                                " ( dormitoryid, roomnumber, beds ) " +
                                "VALUES (?, ?, ?);")) {

                    pst.setInt(1, dormitory.getId());
                    pst.setInt(2, i++);
                    pst.setInt(3, 1);

                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+".rooms: "+ e1.getMessage());
                }
            }
            for (int k = 0; k < doubles; k++) {
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO dormroom "+
                                " ( dormitoryid, roomnumber, beds ) " +
                                "VALUES (?, ?, ?);")) {

                    pst.setInt(1, dormitory.getId());
                    pst.setInt(2, i++);
                    pst.setInt(3, 2);

                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+".rooms: "+ e1.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void insert(Holiday holiday, ArrayList<FieldTrip> fieldTrips){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            System.out.println();
            //insert new dormitory
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(holiday)+
                            " (" + getColumnNamesFor(holiday)+
                            ") VALUES ("+
                            getValuesFor(holiday)+"); ")) {

                System.out.println(pst);
                rs = pst.executeQuery();
                rs.next();


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(holiday)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id FROM holiday " +
                            "WHERE schoolid = ? " +
                            "AND weeks=? " +
                            "AND departuredate = ?; ")) {
                pst.setInt(1, holiday.getSchoolid());
                pst.setInt(2, holiday.getWeeks());
                pst.setDate(3, Date.valueOf(holiday.getDepartureDate()));

                rs = pst.executeQuery();
                rs.next();
                holiday.setId(rs.getInt(1));


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(holiday)+": "+ e1.getMessage());
            }

            //insert fieldtrips
            for (FieldTrip f:fieldTrips) {
                f.setHolidayid(holiday.getId());
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO "+getTableNameFor(f)+
                                " (" + getColumnNamesFor(f)+
                                ") VALUES ("+
                                getValuesFor(f)+");")) {

                    rs = pst.executeQuery();
                    rs.next();


                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(f)+": "+ e1.getMessage());
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }

            }





        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void registerStudent(Student student,Parent parent1, Parent parent2, ArrayList<Allergy> allergies){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int studentid=0;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {

        //insert parents and get their ids
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(parent1)+
                            " (" + getColumnNamesFor(parent1)+
                            ") VALUES ("+
                            getValuesFor(parent1)+");")) {
                rs = pst.executeQuery();
                rs.next();

            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(parent1)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

            rs=null;
            try (PreparedStatement pst = con.prepareStatement(selectIDstmt(parent1))){
                rs = pst.executeQuery();
                rs.next();
                student.setParent1id(rs.getInt(1));
            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(parent1)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

            if(parent2!=null){
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO "+getTableNameFor(parent2)+
                                " (" + getColumnNamesFor(parent2)+
                                ") VALUES ("+
                                getValuesFor(parent2)+");")) {
                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(parent2)+": "+ e1.getMessage());
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }

                rs=null;
                try (PreparedStatement pst = con.prepareStatement(selectIDstmt(parent2))){
                    rs = pst.executeQuery();
                    rs.next();
                    student.setParent2id(rs.getInt(1));
                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(parent2)+": "+ e1.getMessage());
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
            //insert student and get their id
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(student)+
                            " (" + getColumnNamesFor(student)+
                            ") VALUES ("+
                            getValuesFor(student)+");")) {
                rs = pst.executeQuery();
                rs.next();

            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(student)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            rs=null;
            try (PreparedStatement pst = con.prepareStatement(selectIDstmt(student))){
                rs = pst.executeQuery();
                rs.next();
                studentid=(rs.getInt(1));
            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(parent2)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

        //insert allergies
            for (Allergy a : allergies) {
                a.setStudentid(studentid);

                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO "+getTableNameFor(a)+
                                " (" + getColumnNamesFor(a)+
                                ") VALUES ("+
                                getValuesFor(a)+");")) {
                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(a)+": "+ e1.getMessage());
                } catch (IllegalAccessException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }

            }
        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }

    }

    private static String getTableNameFor(Entity e){
        String result="";
        String[] s = e.getClass().getCanonicalName().split("\\.");
        result=s[s.length-1];
        return result;
    }

    private static String getColumnNamesFor(Entity e){
        String result="";
        int i=0;
        Field[] fields = e.getClass().getDeclaredFields();
        for (Field f:fields) {
            if(i++>0) result+=", ";
            result+=f.getName();
        }
        return result;
    }

    private static String getValuesFor(Entity e) throws IllegalAccessException {
        String result="";
        int i=0;
        String temp="";
        Field[] fields = e.getClass().getDeclaredFields();
        for (Field f:fields) {
            if(i++>0) result+=", ";
            if(e.getValue(f)==null) result+=" DEFAULT ";
            else{
                temp=e.getValue(f).toString();

                if (f.getName().endsWith("id")) {
                    if(e.getValue(f).equals(-1)) result+=" DEFAULT ";
                    else result+=temp;
                }

                else if(temp!="true" && temp!="false"){
                    if(temp.contains("'")) temp=temp.replace("'", "''");
                    result+=" '"+temp+"' ";
                }
                else result+=temp;
            }
        }
        return result;
    }

    public static String selectIDstmt(Entity e) throws IllegalAccessException {
        int i=0;
        Field[] fields = e.getClass().getDeclaredFields();
        String result="SELECT id FROM "+getTableNameFor(e)+" WHERE ";
        for (Field f:fields) {
            if (f.getName()!="id" && f.getName()!="psw" && e.getValue(f)!=null && !e.getValue(f).equals(-1)){
                if (i++>0) result += " AND ";
                result+=f.getName();
                if (f.getType().toString().endsWith("String")){
                    if(e.getValue(f).toString().contains("'"))
                        result+=" like '"+e.getValue(f).toString().replace("'","''")+"' ";
                    else
                        result+=" like '"+e.getValue(f)+"' ";
                }
                else if (f.getType().toString().contains("Date")){
                    result+=" = '"+e.getValue(f)+"' ";
                }
                else result+="="+e.getValue(f)+" ";
            }
        }

        return result;
    }
}




