package com.locadora.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static Date strToDate(String strDt) throws ParseException {
        DateFormat dtForm = new SimpleDateFormat("yyyy-MM-dd");
        dtForm.setLenient(false);
        return dtForm.parse(strDt);
    }

    public static String dateToStr(Date dt) {
        DateFormat dtForm = new SimpleDateFormat("dd/MM/yyyy");
        dtForm.setLenient(false);
        return dtForm.format(dt);
    }
}
