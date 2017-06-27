package com.partshighway.ups.xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by elmer on 6/16/17.
 */
public class UPSHelper {

    public static String todayDate(String pattern){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date myDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, -0);
        return dateFormat.format(cal.getTime());

    }

    public static String todayDate(String pattern,int daysBack){

        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date myDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);

        if(daysBack > 0 ){
            cal.add(Calendar.DATE, -daysBack);
            return dateFormat.format(cal.getTime());
        }
        else {
            cal.add(Calendar.DATE, -0);
            return dateFormat.format(cal.getTime());

        }
    }

    public static String todayDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, -0);
        return dateFormat.format(cal.getTime());

    }

    public static String todayDate(int daysBack){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);

        if(daysBack > 0 ){
            cal.add(Calendar.DATE, -daysBack);
            return dateFormat.format(cal.getTime());
        }
        else {
            cal.add(Calendar.DATE, -0);
            return dateFormat.format(cal.getTime());
        }
    }

    public static void main(String[] args){
        System.out.println(todayDate("yyyyMMddHHmmss",1));
    }
}
