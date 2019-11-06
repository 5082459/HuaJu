package com.HuJuHomePage.Utilities;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTool {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static boolean isOutDate(String startTime) {
        Date date = null;
        try {
            date = simpleDateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date currentDate = new Date(System.currentTimeMillis());
        return date == null || currentDate.after(date);
    }


    public static boolean canOrder(int dataLimit, int timeLimit, String startTime, String endTime) {
        Date currentDate = new Date(System.currentTimeMillis());
        Date startDate;
        Date endDate;
        try {
            startDate = simpleDateFormat.parse(startTime);
            endDate = simpleDateFormat.parse(endTime);
            long toCurrent = (startDate.getTime() - currentDate.getTime())/(1000*60*60*24);
            long gap = (endDate.getTime() - startDate.getTime())/(1000*60*60);
            System.out.println("toCurrent = " + toCurrent + "  " + "gap = " + gap + " " + "dataLimit = " + dataLimit + " " + timeLimit);
            if (toCurrent > dataLimit || gap > timeLimit){
                return false;
            }
        } catch (ParseException e) {
            System.out.println("预约时间太长...");
            e.printStackTrace();
        }
        return true;
    }

    public static String getCurrentStr() {
        Date currentDate = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(currentDate);
    }
}
