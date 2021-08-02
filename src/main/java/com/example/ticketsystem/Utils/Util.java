package com.example.ticketsystem.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Util {

    public String changeUpperCaseStatus (String status)
    {
        String res = status.toUpperCase();
        return res;
    }

    public String convertDateToString(Date date, String format)
    {
        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setCalendar(new GregorianCalendar());
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        return dateFormat.format(date);

    }
}
