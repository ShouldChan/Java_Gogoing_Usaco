import com.sun.org.apache.bcel.internal.classfile.LineNumber;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ID: ezanmyd1
 * LANG: JAVA
 * TASK: Greedy Gift Givers
 * From: Section 1.1
 * Created by Administrator on 2017/4/22.
 * Step1: read the number of people, then read their names by lines
 * Step2: read the giver's name, then read the second in the form of 'money num'
 * Step3:
 */
public class Gift {

    public static final String IN_FILE = "./in_file/";
    public static final String OUT_FILE = "./out_file/";
    public static final Map<String, Integer> map = new HashMap<String, Integer>();

    public static final List<String> lst = new ArrayList<String>();

    //read file according to the num of lines, eg: lineNumber is 4, read the fourth line
    public static String readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader linereader = new LineNumberReader(in);
//        List<String> lst_line = new ArrayList<String>();
        String s = "asd";
        if (lineNumber <= 0 || lineNumber > getTotalLines(sourceFile)) {
            System.out.println("lineNumber is wrong!");
            System.exit(0);
        }
        int lines = 0;
        String ss = null;
        while (s != null) {
            lines++;
            s = linereader.readLine();
            if ((lines - lineNumber) == 0) {
//                lst_line.add(s);
//                System.out.println(s);
                ss = s;
//                System.exit(0);
            }
        }
//        System.out.println(s);
        linereader.close();
        in.close();
        return ss;
    }

    public static int getTotalLines(File file) throws IOException {
//        File file = new File(filename);
        FileReader in = new FileReader(file);
        LineNumberReader linereader = new LineNumberReader(in);
        String s = linereader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = linereader.readLine();
        }
        linereader.close();
        in.close();
        return lines;
    }

    public static void readTxt() {
        String line = null;
        try {
            File file = new File(IN_FILE + "gift1.in");
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            do {
                line = br.readLine();
                lst.add(line);
//                System.out.println(line);
            } while (line != null);

            lst.remove(null);
            System.out.println(lst);
            in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void process(int a, int b, int lines, File file, String[] two_array,int[][] matrix,int v1) throws IOException {
        for (int i = 0; i < two_array.length; i++) {
            if (i == 0) {
                a = Integer.parseInt(two_array[i]);
                System.out.println(two_array[i]);
                System.out.println("a: " + a);
            } else if (i == 1) {
                b = Integer.parseInt(two_array[i]);
                System.out.println(two_array[i]);
                System.out.println("b: " + b);
            }

        }

        while (b > 0) {
            String name = readAppointedLineNumber(file, ++lines);
            int v2 = map.get(name);
            matrix[v1][v2] = a;
            System.out.println(matrix[v1][v2]);
            b--;
        }
    }

    public static void readTxtByLine() {
        File file = new File(IN_FILE + "gift1.in");
        try {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileInputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String eachline = br.readLine();
            //1. read nums of people
            int lines = 2;    //start from the second, and map them
            int total_num = Integer.parseInt(eachline);   // convert str to int
            System.out.println("Total numbers of people: " + total_num);
            int[][] matrix = new int[total_num][total_num];


//            Digraph dg = new Digraph(lines);
            int no = 0; //everyone's name map with a No
            while (no < total_num) {
                String name = readAppointedLineNumber(file, lines);
//                System.out.println(name);
                map.put(name, no);
                System.out.println("No: " + no + "\tName: " + name);
                no++;
                lines++;
            }
            System.out.println("we have read to:\t" + lines + "\tlines");

            //2. "dave" "200 3" "laura" "owen" "vick"

            int v1 = map.get(readAppointedLineNumber(file, lines++));
            String two = readAppointedLineNumber(file, lines++);
            String[] two_array = two.split(" ");
            int a = 0, b = 0;
//            process(a,b,lines,file,two_array,matrix,v1);
            for (int i = 0; i < two_array.length; i++) {
                if (i == 0) {
                    a = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("a: " + a);
                } else if (i == 1) {
                    b = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("b: " + b);
                }

            }

            while (b > 0) {
                String name = readAppointedLineNumber(file, ++lines);
                int v2 = map.get(name);
                matrix[v1][v2] = a;
                System.out.println(matrix[v1][v2]);
                b--;
            }

            // "owen" "500 1" "dave"
            v1 = map.get(readAppointedLineNumber(file, lines++));
            two = readAppointedLineNumber(file, lines++);
            two_array = two.split(" ");
//            process(500,1,lines,file,two_array,matrix,v1);
            for (int i = 0; i < two_array.length; i++) {
                if (i == 0) {
                    a = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("a: " + a);
                } else if (i == 1) {
                    b = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("b: " + b);
                }

            }

            while (b > 0) {
                String name = readAppointedLineNumber(file, ++lines);
                int v2 = map.get(name);
                matrix[v1][v2] = a;
                System.out.println(matrix[v1][v2]);
                b--;
            }
            // "amr" "150 2" "vick owen"
            v1 = map.get(readAppointedLineNumber(file, lines++));
            two = readAppointedLineNumber(file, lines++);
            two_array = two.split(" ");
//            process(500,1,lines,file,two_array,matrix,v1);
            for (int i = 0; i < two_array.length; i++) {
                if (i == 0) {
                    a = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("a: " + a);
                } else if (i == 1) {
                    b = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("b: " + b);
                }

            }

            while (b > 0) {
                String name = readAppointedLineNumber(file, ++lines);
                int v2 = map.get(name);
                matrix[v1][v2] = a;
                System.out.println(matrix[v1][v2]);
                b--;
            }

            // "laura" "0 2" "amr vick"
            v1 = map.get(readAppointedLineNumber(file, lines++));
            two = readAppointedLineNumber(file, lines++);
            two_array = two.split(" ");
//            process(500,1,lines,file,two_array,matrix,v1);
            for (int i = 0; i < two_array.length; i++) {
                if (i == 0) {
                    a = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("a: " + a);
                } else if (i == 1) {
                    b = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("b: " + b);
                }

            }

            while (b > 0) {
                String name = readAppointedLineNumber(file, ++lines);
                int v2 = map.get(name);
                matrix[v1][v2] = a;
                System.out.println(matrix[v1][v2]);
                b--;
            }

            // "vick" "0 0"
            v1 = map.get(readAppointedLineNumber(file, lines++));
            two = readAppointedLineNumber(file, lines++);
            two_array = two.split(" ");
//            process(500,1,lines,file,two_array,matrix,v1);
            for (int i = 0; i < two_array.length; i++) {
                if (i == 0) {
                    a = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("a: " + a);
                } else if (i == 1) {
                    b = Integer.parseInt(two_array[i]);
                    System.out.println(two_array[i]);
                    System.out.println("b: " + b);
                }

            }

            while (b > 0) {
                String name = readAppointedLineNumber(file, ++lines);
                int v2 = map.get(name);
                matrix[v1][v2] = a;
                System.out.println(matrix[v1][v2]);
                b--;
            }
            br.close();
            in.close();
            // travse the matrix
            for(int i=0;i<total_num;i++){
                for(int j=0;j<total_num;j++){
                    System.out.print(matrix[i][j]+"\t");
                }
                System.out.println();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            System.out.println("still need to be improved");
        }

    }


    public static void main(String[] args) throws IOException {
//        readTxt();
//        String filename = IN_FILE + "gift.in";
//        File file = new File(IN_FILE + "gift1.in");
//        System.out.println(getTotalLines(file));
        readTxtByLine();

//        System.out.println(readAppointedLineNumber(file, 4));
    }

}
