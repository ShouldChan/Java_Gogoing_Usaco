package com.cxj.usaco;

/**
 * 
 * @author shouldchan 2017/10/22
 */
public class Zeller {
	public int zellerDayOfWeek(int year, int month, int date) {
		int week = 0;
		int century = year / 100;
		year = year % 100;
		week = year + year / 4 + century / 4 - 2 * century + (26 * (month + 1)) / 10 + date - 1;
//		System.out.println(week);
		week = week % 7;
		return week;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zeller ze = new Zeller();
		int week = 0;
		week = ze.zellerDayOfWeek(2017, 10, 22);
		System.out.println(week);
		week = ze.zellerDayOfWeek(2006, 7, 21);
		System.out.println(week);
	}

}
