package com.cxj.usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
ID: ezanmyd1
LANG: JAVA
TASK: ride
 */

public class friday {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./in_file/friday.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("./out_file/friday.out")));
		friday fri = new friday();
		int week = 0;
		// save the count in day of week
		// 0: Sunday --------- 6: Saturday

		int[] week_count = new int[7];
		int n = Integer.parseInt(br.readLine());
		// Scanner scan = new Scanner(System.in);
		// int n = scan.nextInt();
		int end_year = 1900 + n - 1;
		String str_year = String.valueOf(end_year);
		String date1 = "1900-01-01";
		String date2 = str_year + "-12-31";
		ArrayList<String> result = new ArrayList<String>();
		result = fri.getDate(date1, date2);

		for (int i = 0; i < result.size(); i++) {
			// System.out.println(result.get(i).getClass());
			// System.out.println(result.get(i));
			int[] ymd = new int[3];
			ymd = fri.getYMD(result.get(i));
			int year = ymd[0];
			int month = ymd[1];
			int day = ymd[2];
			week = fri.zellerDayOfWeek(year, month, day);
			// System.out.println("week:" + week);
			// System.out.println("week_count:" + week_count[2]);
			week_count[week] += 1;
		}
		System.out.println(week_count[6] + " " + week_count[0] + " " + week_count[1] + " " + week_count[2] + " "
				+ week_count[3] + " " + week_count[4] + " " + week_count[5] + " ");
		pw.println(week_count[6] + " " + week_count[0] + " " + week_count[1] + " " + week_count[2] + " " + week_count[3]
				+ " " + week_count[4] + " " + week_count[5]);
	}

	// function: get each year 's 13th as result days
	public ArrayList<String> getDate(String date1, String date2) {
		ArrayList<String> result = new ArrayList<String>();
		String[] start_tmp = date1.split("-");
		int start_year = Integer.valueOf(start_tmp[0]).intValue();
		int start_month = Integer.valueOf(start_tmp[1]).intValue();
		String[] end_tmp = date2.split("-");
		int end_year = Integer.valueOf(end_tmp[0]).intValue();
		int end_month = Integer.valueOf(end_tmp[1]).intValue();
		// String str_13thday="13";
		for (int i = start_year; i <= end_year; i++) {
			String year = String.valueOf(i);
			for (int j = 1; j <= 12; j++) {
				String month = String.valueOf(j);
				String date = year + "-" + month + "-" + "13";
				result.add(date);
			}
		}

		return result;
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
