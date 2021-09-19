package it.univr.studyholiday.util;

public class LoginUtil {
    public static String encrypy(String in){
        String out="";
        int k=Character.getNumericValue(in.charAt(0));
        k=k%100;
        char r;
        int t;
        for (int i = 0; i < in.length(); i++) {
            r=in.charAt(i);
            t=Character.valueOf(r);
            t+=k;
            while(t>126){
                t-=94;
            }
            r=(char) (t);
            out+=r;
        }
        return out;
    }

    public static boolean emailIsAdmin(String email){
        if(email.contains("@glossa.it"))
            return true;
        return false;
    }
}
