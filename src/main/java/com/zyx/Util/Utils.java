package com.zyx.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static int getDays(Date bigDate,Date smallDate) throws ParseException {
        return (int)(bigDate.getTime()-smallDate.getTime())/(1000*60*60*24);
    }
}
