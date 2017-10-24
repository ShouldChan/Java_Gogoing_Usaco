package com.cxj.usaco;

import java.lang.reflect.GenericArrayType;

/**
 * 
 * @author shouldchan 2017/10/23
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Zeller {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zeller ze = new Zeller();
		int week = 0;
		// week = ze.zellerDayOfWeek(2017, 10, 22);
		// System.out.println(week);
		// week = ze.zellerDayOfWeek(2006, 7, 21);
		// System.out.println(week);

		String date1 = "2012-02-26";
		String date2 = "2012-03-01";
		ArrayList<String> result = new ArrayList<String>();
		result = ze.generateDate(date1, date2);

		for (int i = 0; i < result.size(); i++) {
			// System.out.println(result.get(i).getClass());
			System.out.println(result.get(i));
			int[] ymd = new int[3];
			ymd = ze.getYMD(result.get(i));
			int year = ymd[0];
			int month = ymd[1];
			int day = ymd[2];
			week = ze.zellerDayOfWeek(year, month, day);
			System.out.println(week);
		}

	}

	// function: use Zeller to calc the ith day of week
	public int zellerDayOfWeek(int year, int month, int day) {
		int week = 0;
		int century = year / 100;
		year = year % 100;
		week = year + year / 4 + century / 4 - 2 * century + (26 * (month + 1)) / 10 + day - 1;
		// System.out.println(week);
		week = week % 7;
		return week;
	}

	String dateFormat = "yyyy-MM-dd";
	SimpleDateFormat format = new SimpleDateFormat(dateFormat);

	// function: to transfer the String into Date
	public Date str2Date(String str) {
		if (str == null)
			return null;
		try {
			return format.parse(str);
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	// function: use Date to generate dates from A to B
	public ArrayList<String> generateDate(String date1, String date2) {
		ArrayList<String> result = new ArrayList<String>();

		if (date1.equals(date2)) {
			System.out.println("The two dates are the same.");
			System.exit(0);
		}
		String tmp;
		// make sure date1 earlier than date2
		if (date1.compareTo(date2) > 0) {
			tmp = date1;
			date1 = date2;
			date2 = tmp;
		}
		// System.out.println(str2Date(date1));
		// System.out.println(str2Date(date1).getTime());
		tmp = format.format(str2Date(date1).getTime() + 3600 * 24 * 1000);

		int num = 0;
		while (tmp.compareTo(date2) < 0) {
			// System.out.println(tmp);
			result.add(tmp);
			num++;
			tmp = format.format(str2Date(tmp).getTime() + 3600 * 24 * 1000);
		}
		if (num == 0) {
			System.out.println("The two dates are the neighbouring.");
		}
		return result;

	}

	// function: to transfer "2012-12-21" into "year""month""day"
	public int[] getYMD(String strDate) {
		String[] tmp = strDate.split("-");
		int year = Integer.valueOf(tmp[0]).intValue();
		int month = Integer.valueOf(tmp[1]).intValue();
		int day = Integer.valueOf(tmp[2]).intValue();
		int[] ymd = new int[3];
		ymd[0] = year;
		ymd[1] = month;
		ymd[2] = day;
		return ymd;
	}

}
