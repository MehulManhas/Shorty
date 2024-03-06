package com.project.Shorty.Util;


import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp getCurrentTimeStamp(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

}
