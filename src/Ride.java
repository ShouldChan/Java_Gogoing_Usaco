/**
 * ID: ezanmyd1
 * LANG: JAVA
 * TASK: Your Ride Is here
 * From: Section 1.1
 * Created by Administrator on 2017/4/10.
 */

import java.io.*;
import java.util.*;


public class Ride {
    public static final String IN_FILE = "./in_file/";
    public static final String OUT_FILE = "./out_file/";
    public static final Map<Character, Integer> map = new HashMap<Character, Integer>();
    public static final List<String> lst = new ArrayList<String>();

    public static void saveMap() {
        int num = 1;
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            map.put(letter, num);
            num++;
        }
        System.out.println(map);
    }

    public static void readTxt() {
        String line = null;
        try {
            File file = new File(IN_FILE + "ride.in");
            if (!file.exists())
                throw new FileNotFoundException();
            FileInputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            do {
                line = br.readLine();
                lst.add(line);
//                System.out.println(line);
            } while (line != null);

//            kick the null out
            lst.remove(null);
            System.out.println(lst);
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void computeAndsave() {
        int j = 0;
        int[] result = new int[2];
        try {
            File file = new File(OUT_FILE + "ride.out");
            if (!file.exists())
                file.createNewFile();
            FileOutputStream out = new FileOutputStream(file, false);
            for (String s : lst) {
                int acc = 1;
                System.out.println(s);
                for (int i = 0; i < s.length(); i++) {
                    int x = map.get(s.charAt(i));
                    acc *= x;
                    System.out.println(acc);
                }
                result[j] = acc % 47;
//                System.out.println(j);
                System.out.println(result[j]);
                j++;
            }
            StringBuffer sb = new StringBuffer();
            if (result[0] == result[1]) {
                sb.append("GO");
                out.write(sb.toString().getBytes("utf-8"));
            } else {
                sb.append("STAY");
                out.write(sb.toString().getBytes("utf-8"));
            }
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        saveMap();
        readTxt();
        computeAndsave();
    }
}
