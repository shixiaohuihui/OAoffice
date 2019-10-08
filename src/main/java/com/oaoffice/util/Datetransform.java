package com.oaoffice.util;


import java.text.*;
import java.util.*;


public class Datetransform {
	/**
	 * 将字符串转为日期
	 * @param date
	 * @param format
	 * @return
	 */

	public static String param(Date date, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(date);

		return strDate;
	}

	/**
	 * 将日期转为字符串
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static java.util.Date parse(String pStrDate, String pformat) {
		SimpleDateFormat sdf = new SimpleDateFormat(pformat);
		Date date = null;
		try {
			date = sdf.parse(pStrDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}

	
}
