package com.official.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFomatUtil {
	
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date());
	}

	public static Date stringToDate(String strDate, String pattern) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date Date = sdf.parse(strDate);
		return Date;
	}

	public static String dateToString(Date date) {
		return dateToString(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String dateToString() {
		return dateToString(new Date());
	}

	public Date stringToDate(String strDate) throws ParseException {
		return stringToDate(strDate, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date longToDate(Long time) {
		return new Date(time);
	}

	public static String longToDateString(Long time) {
		return dateToString(new Date(time));
	}

}
