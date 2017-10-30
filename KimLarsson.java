package com.cxj.usaco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author shouldchan time: 2017/10/30
 */
public class KimLarsson {
	// 0:Sunday ---6:Saturday
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date1 = "2017-10-15";
		String date2 = "2017-10-30";
		KimLarsson kl = new KimLarsson();
		ArrayList<String> result = new ArrayList<String>();
		result = kl.generateDate(date1, date2);
		int[] ymd = new int[3];

		for (int i = 0; i < result.size(); i++) {
			ymd = kl.getYMD(result.get(i));
			System.out.println(result.get(i));
			int year = ymd[0];
			int month = ymd[1];
			int day = ymd[2];
			int week = kl.kimlarsson_dayofweek(year, month, day);
			System.out.println(week);
		}

	}

	public int kimlarsson_dayofweek(int year, int month, int day) {
		if (month == 1 || month == 2) {
			month += 12;
			year--;
		}
		int week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7;

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
		// result.add(date1);

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
		// result.add(date2);
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
