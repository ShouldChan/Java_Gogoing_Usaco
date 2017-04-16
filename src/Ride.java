/**
 * ID: ezanmyd1
 * LANG: JAVA
 * TASK: Ride
 * From: Section 1.1
 * Created by Administrator on 2017/4/10.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Ride {
    public static final String IN_FILE = "./in_file/";
    public static final String OUT_FILE = "./out_file/";

//    public int char2num(String str){
//    return 0;
//    }
//    public int charReplace(String str) {
//        int num = 0;
////        BufferedReader f = new BufferedReader(new FileReader(IN_FILE + "ride.in"));
//        return num;
//    }

    public static void main(String[] args) throws IOException {
        Map<Character,Integer> map =new HashMap<Character,Integer>();
//        map.put('A',1);
        int num=1;
        for(char letter='A';letter<='Z';letter++){

            map.put(letter,num);
            num++;
        }
        System.out.println(map);
        BufferedReader f = new BufferedReader(new FileReader(IN_FILE + "ride.in"));
        StringTokenizer st = new StringTokenizer(f.readLine(),"\n");
        String s1=st.nextToken();
        int i=0;
        System.out.println(s1.length());
        int acc=1;
        while(i<s1.length()){
            int x = map.get(s1.charAt(i));
            i++;
            System.out.println(x);
            acc*=x;
            System.out.println(acc);
        }
        int result=0;
        result=acc%47;
        System.out.println(result);
        System.out.println(s1);

//        while(st.hasMoreElements()){
//            System.out.println(st.nextToken());
//        }

    }
}
