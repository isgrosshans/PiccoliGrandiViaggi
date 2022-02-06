package it.univr.studyholiday.util.Database;
import it.univr.studyholiday.model.User;
import it.univr.studyholiday.model.entities.*;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;


public class SaveToDB {

    public static void insert(Entity entity){
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
//
//    public static void insertReservation(Entity entity){
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (java.lang.ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//        ResultSet rs = null;
//        try (Connection con = Database.getConnection()) {
//
//            try (PreparedStatement pst = con.prepareStatement(
//                    "INSERT INTO "+getTableNameFor(entity)+
//                            " (" + getColumnNamesFor(entity)+
//                            ") VALUES ("+
//                            getValuesFor(entity)+");")) {
//
//                
//                rs = pst.executeQuery();
//                rs.next();
//
//
//            }catch (SQLException e1) {
//                System.out.println("SaveToDB.insert."+getTableNameFor(entity)+": "+ e1.getMessage());
//            } catch (IllegalAccessException illegalAccessException) {
//                illegalAccessException.printStackTrace();
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Connection error: "+e.getMessage());
//        }
//
//    }

    public static void insertFamily(Family family) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int familyid = 0;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            System.out.println();

            //insert new family
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(family)+
                            " (" + getColumnNamesFor(family)+
                            ") VALUES ("+
                            getValuesFor(family)+"); ")) {
                rs = pst.executeQuery();
                rs.next();


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(family)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            rs=null;

            //get id of newly inserted family
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id FROM family " +
                            "WHERE firstname ilike ? " +    //? 1
                            "AND lastname ilike ?" +        //? 2
                            "AND email ilike ?" +           //? 3
                            "AND phone ilike ?" +           //? 4
                            "AND address ilike ?" +         //? 5
                            "AND members = ? " +            //? 6
                            "AND pets = ?" +                //? 7
                            "AND bathrooms = ?" +           //? 8
                            "AND bedrooms = ?" +            //? 9
                            "AND citydistance ilike ?" +    //? 10
                            "AND schoolid = ?; ")) {        //? 11
                pst.setString(1, family.getFirstName());
                pst.setString(2,family.getLastName());
                pst.setString(3,family.getEmail());
                pst.setString(4,family.getPhone());
                pst.setString(5,family.getAddress());
                pst.setInt(6,family.getMembers());
                pst.setBoolean(7,family.getPets());
                pst.setInt(8,family.getBathrooms());
                pst.setInt(9,family.getBedrooms());
                pst.setString(10,family.getCityDistance());
                pst.setInt(11,family.getSchoolid());
                rs = pst.executeQuery();
                rs.next();
                family.setId(rs.getInt(1));
                familyid=rs.getInt(1);

            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(family)+": "+ e1.getMessage());
            }
            rs=null;

            //insert beds
            for (int i = 0; i < family.getBedrooms(); i++) {
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO bed "+
                                " ( familyid ) " +
                                "VALUES ( ? );")) {

                    pst.setInt(1, familyid);
                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(family)+".rooms: "+ e1.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void insertParent(Parent parent){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int studentid=0;
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {

            //insert parent
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(parent)+
                            " (" + getColumnNamesFor(parent)+
                            ") VALUES ("+
                            getValuesFor(parent)+");")) {
                rs = pst.executeQuery();
                rs.next();

            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(parent)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            rs=null;

            //get new parent id
            try (PreparedStatement pst = con.prepareStatement(selectIDstmt(parent))){
                rs = pst.executeQuery();
                rs.next();
                User.getCurrentStudent().setParent2id(rs.getInt(1));
            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(parent)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            //update student
            try (PreparedStatement pst = con.prepareStatement(
                    "UPDATE student " +
                            "SET parent2id=? " +
                            "WHERE id=?;")) {
                pst.setInt(1,User.getCurrentStudent().getParent2id());
                pst.setInt(2,User.getCurrentStudent().getId());
                rs = pst.executeQuery();
                rs.next();

            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert.student: "+ e1.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void insertDormRooms(Dormitory dormitory, Integer singles, Integer doubles) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        int dormitoryid = 0;
        ArrayList<DormRoom> dormRooms=new ArrayList<>();
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            //insert new dormitory
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(dormitory)+
                            " (" + getColumnNamesFor(dormitory)+
                            ") VALUES ("+
                            getValuesFor(dormitory)+"); ")) {

                
                rs = pst.executeQuery();
                rs.next();


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

            //get id of newly inserted dormitory
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

            //get newly inserted rooms
            try (PreparedStatement pst = con.prepareStatement(
                    "SELECT id, dormitoryid, roomNumber, beds FROM dormroom " +
                            "WHERE dormitoryid=? " +
                            //"AND id not in(SELECT DISTINCT dormroomid FROM bed)" +
                            ";")) {
                pst.setInt(1, dormitory.getId());
                rs = pst.executeQuery();
                while (rs.next()){dormRooms.add(new DormRoom(
                        rs.getInt(1),    //int id
                        rs.getInt(2),    //int dormitoryid
                        rs.getString(3), //String roomNumber
                        rs.getInt(4)));     //int beds
                }
            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
            }

            //add beds
            for (DormRoom d:dormRooms) {
                for (int j = 0; j < d.getBeds(); j++) {
                    try (PreparedStatement pst = con.prepareStatement(
                            "INSERT INTO bed "+
                                    " ( dormroomid ) " +
                                    "VALUES ( ? );")) {
                        pst.setInt(1, d.getId());
                        rs = pst.executeQuery();
                        rs.next();

                    }catch (SQLException e1) {
                        System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+".rooms: "+ e1.getMessage());
                    }
                }
            }



        } catch (SQLException e) {
            System.out.println("Connection error: "+e.getMessage());
        }
    }

    public static void insertHoliday(Holiday holiday, ArrayList<FieldTrip> fieldTrips){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            //insert new dormitory
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(holiday)+
                            " (" + getColumnNamesFor(holiday)+
                            ") VALUES ("+
                            getValuesFor(holiday)+"); ")) {

                
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

                if (f.getName().endsWith("id") || f.getName().endsWith("Id")) {
                    if(e.getValue(f).equals(-1)) result+=" DEFAULT ";
                    else if(e.getValue(f).equals(-2)) result+=" default ";
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




