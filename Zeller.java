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
import java.util.Scanner;

public class Zeller {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zeller ze = new Zeller();
		int week = 0;
		// save the count in day of week
		// 0: Sunday --------- 6: Saturday
		// week = ze.zellerDayOfWeek(1900, 1, 26);
		// System.out.println("week:" + week);
		int[] week_count = new int[7];

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int end_year = 1900 + n - 1;
		String str_year = String.valueOf(end_year);
		String date1 = "1900-01-01";
		String date2 = str_year + "-12-31";
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
			// System.out.println("week:" + week);
			// System.out.println("week_count:" + week_count[2]);
			week_count[week] += 1;
		}
		System.out.println(week_count[6] + " " + week_count[0] + " " + week_count[1] + " " + week_count[2] + " "
				+ week_count[3] + " " + week_count[4] + " " + week_count[5] + " ");
	}

	// function: use Zeller to calc the i_th day of week
	public int zellerDayOfWeek(int year, int month, int day) {
		if (month == 1) {
			month = 13;
			year--;
		}
		if (month == 2) {
			month = 14;
			year--;
		}
		int century = year / 100;
		year = year % 100;
		int week = year + year / 4 + century / 4 - 2 * century + (26 * (month + 1)) / 10 + day - 1;
		week = week % 7;
		week = Math.abs(week);
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
		result.add(date1);

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
		result.add(date2);
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
