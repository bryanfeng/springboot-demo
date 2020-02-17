package com.bryan.demo.service.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    static public  String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        return  df.format(new Date());
    }

    static public Long getTimeStamp(){
        return System.currentTimeMillis();
    }

}
