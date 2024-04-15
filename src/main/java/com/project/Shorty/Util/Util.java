package com.project.Shorty.Util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp getCurrentTimeStamp(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static String convertURLToMD5Hash(String url){
        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(url.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(Integer.toHexString(0xFF & b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
