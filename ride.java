package com.cxj.usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * ID: ezanmyd1
 * LANG: JAVA
 * TASK: ride
 */

public class ride {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("./in_file/ride.in"));

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./out_file/ride.out")));

		String s1 = f.readLine();
		String s2 = f.readLine();
		int num1 = 1;
		int num2 = 1;
		for (int i = 0; i < s1.length(); i++) {
			num1 *= s1.charAt(i) - 'A' + 1;
		}
		for (int i = 0; i < s2.length(); i++) {
			num2 *= s2.charAt(i) - 'A' + 1;
		}
		if (num1 % 47 == num2 % 47) {
			out.write("GO" + "\n");
		} else {
			out.write("STAY" + "\n");
		}
		out.close();
		System.exit(0);
	}

}
