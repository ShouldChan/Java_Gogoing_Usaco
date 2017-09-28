package com.cxj.usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
ID: ezanmyd1
LANG: JAVA
TASK: gift1
 */
class Person {
	Person(String name, int money, int sendCount) {
		this.name = name;
		this.initialMoney = this.money = money;
		this.sendCount = sendCount;
		friends = new String[sendCount];
		if (sendCount <= 0 || money <= 0) {
			avgMoney = 0;
		} else {
			avgMoney = money / sendCount;
			this.money = money % sendCount;
		}

	}

	public int avgMoney;
	public String name;
	public int money;
	public int initialMoney;
	public int sendCount;
	public String[] friends;
}

public class gift1 {

	public static void main(String[] args) throws IOException {
		// use BufferedReader is much faster
		BufferedReader f = new BufferedReader(new FileReader("./in_file/gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./out_file/gift1.out")));
		int sum = Integer.parseInt(f.readLine());
		// initial parameters
		String tempName;
		int tempMoney, tempSend;
		Person tempPerson1, tempPerson2;
		String temp;
		String[] names = new String[sum];
		HashMap<String, Person> hm = new HashMap<String, Person>();
		for (int i = 0; i < sum; i++) {
			names[i] = f.readLine();
		}

		StringTokenizer st;
		for (int i = 0; i < sum; i++) {
			tempName = f.readLine();
			temp = f.readLine();
			st = new StringTokenizer(temp);
			
			tempMoney = Integer.parseInt(st.nextToken());
			tempSend = Integer.parseInt(st.nextToken());
			tempPerson1 = new Person(tempName, tempMoney, tempSend);
			for (int j = 0; j < tempSend; j++) {
				tempPerson1.friends[j] = f.readLine();
			}
			hm.put(tempName, tempPerson1);
		}
		for (int i = 0; i < sum; i++) {
			tempPerson1 = hm.get(names[i]);
			for (int j = 0; j < tempPerson1.sendCount; j++) {
				tempPerson2 = hm.get(tempPerson1.friends[j]);
				tempPerson2.money += tempPerson1.avgMoney;
			}
		}
		for (int i = 0; i < sum; i++) {
			tempPerson1 = hm.get(names[i]);
			out.write(tempPerson1.name + " " + (tempPerson1.money - tempPerson1.initialMoney)+"\n");
			System.out.println(tempPerson1.name + " " + (tempPerson1.money - tempPerson1.initialMoney));
			// out.println(tempPerson1.name+" "
			// +(tempPerson1.money-tempPerson1.initialMoney));
		}
	}

}
