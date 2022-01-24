package it.univr.studyholiday.util.Database;
import it.univr.studyholiday.model.Dormitory;
import javafx.beans.property.SimpleStringProperty;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


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
        String dormitoryid = "";
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {

            //insert new dormitory
            try (PreparedStatement pst = con.prepareStatement(
                    "INSERT INTO "+getTableNameFor(dormitory)+
                            " (" + getColumnNamesFor(dormitory)+
                            ") VALUES ("+
                            getValuesFor(dormitory)+");" +
                        "SELECT id FROM dormitory " +
                            "WHERE name="+dormitory.getName()+
                            "' AND address='"+dormitory.getAddress()+
                            "' AND sex='"+dormitory.getSex()+";")) {

                rs = pst.executeQuery();
                rs.next();
                dormitoryid=rs.getString(1);


            }catch (SQLException e1) {
                System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }

            //insert rooms
            int i=1;
            for (int j = 0; j < singles; j++) {
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO dormroom "+
                                " ( dormitoryid, roomnumber, beds ) " +
                                "VALUES (?, ?, ?);")) {

                    pst.setString(1, dormitoryid);
                    pst.setString(2, String.valueOf(i++));
                    pst.setString(3, String.valueOf(1));

                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
                }
            }
            for (int k = 0; k < doubles; k++) {
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO dormroom "+
                                " ( dormitoryid, roomnumber, beds ) " +
                                "VALUES (?, ?, ?);")) {

                    pst.setString(1, dormitoryid);
                    pst.setString(2, String.valueOf(i++));
                    pst.setString(3, String.valueOf(2));

                    rs = pst.executeQuery();
                    rs.next();

                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(dormitory)+": "+ e1.getMessage());
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

    public static String getValuesFor(Entity e) throws IllegalAccessException {
        String result="";
        int i=0;
        String temp;
        Field[] fields = e.getClass().getDeclaredFields();
        for (Field f:fields) {
            temp=e.getValue(f).toString();
            if(i++>0) result+=", ";
            if(temp.contains("'")) temp=temp.replace("'", "''");
            if(temp.equals("")) result+=" DEFAULT ";
            else result+=" '"+temp+"' ";
        }
        return result;
    }


}




