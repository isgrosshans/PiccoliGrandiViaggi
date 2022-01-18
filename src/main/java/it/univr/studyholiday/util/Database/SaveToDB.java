package it.univr.studyholiday.util.Database;

import it.univr.studyholiday.model.Staff;
import it.univr.studyholiday.model.Student;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SaveToDB {

    public static void insert (Entity... entities){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ResultSet rs = null;
        try (Connection con = Database.getConnection()) {
            for (Entity e:entities) {
                try (PreparedStatement pst = con.prepareStatement(
                        "INSERT INTO "+getTableNameFor(e)+
                                " (" + getColumnNamesFor(e)+
                                ") VALUES ("+
                                getValuesFor(e)+");")) {

                    rs = pst.executeQuery();
                    rs.next();


                }catch (SQLException e1) {
                    System.out.println("SaveToDB.insert."+getTableNameFor(e)+": "+ e1.getMessage());
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
        Field[] fields = e.getClass().getDeclaredFields();
        for (Field f:fields) {
            if(i++>0) result+=", ";
            if (e.getValue(f).getClass()==String.class && e.getValue(f).equals("")) result+=" DEFAULT ";
            else result+=" '"+e.getValue(f)+"' ";
        }
        return result;
    }



}
