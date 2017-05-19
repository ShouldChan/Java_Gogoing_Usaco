/**
 * ID: ezanmyd1
 * LANG: JAVA
 * TASK: test
 * From: Section 1.1
 * Created by Administrator on 2017/4/10.
 */

import java.io.*;
import java.util.StringTokenizer;

public class SubTest {
    //    read the test.in file, then plus the first number and the second number, regardless of the following number.
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("./in_file/test.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("./out_file/test.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int i1 = Integer.parseInt(st.nextToken());    // first integer
        int i2 = Integer.parseInt(st.nextToken());    // second integer
        out.println(i1 + i2);                           // output result
        out.close();                                  // close the output file
    }
}
