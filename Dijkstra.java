/**
 * Created by shouldchan on 17-5-19.
 */
//public class Dijkstra {
//    public static int M = Integer.MAX_VALUE;
//
//    public static int[] Dijkstra(int[][] weight, int start) {
//        int n = weight.length;
//        int[] shortPath = new int[n];
//        String[] path = new String[n];
//        for (int i = 0; i < n; i++) {
//            path[i] = new String(start + "-->" + i);
//        }
//        int[] visited = new int[n];
//
//        shortPath[start] = 0;
//
//        visited[start] = 1;
//        for (int count = 1; count < n; count++) {
//            int k = -1;
//            int dmin = Integer.MAX_VALUE;
//            for (int i = 0; i < n; i++) {
//                /**
//                 * 如果没有访问过的点，并且权重更小则添加进路径
//                 */
//                if (visited[i] == 0 && weight[start][i] < dmin) {
//                    dmin = weight[start][i];
//                    k = i;
//                }
//            }
//
//            shortPath[k] = dmin;
//
//            visited[k] = 1;
//
//            for (int i = 0; i < n; i++) {
//                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
//                    weight[start][i] = weight[start][k] + weight[k][i];
//
//                    path[i] = path[k] + "-->" + i;
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.println("the shortest path: " + start + "-->" + i + "\t" + path[i]);
//        }
//        return shortPath;
//    }
//
//    public static void main(String[] args) {
//        int[][] weight1 = {
//                {0, 3, 2000, 7, M},
//                {3, 0, 4, 2, M},
//                {M, 4, 0, 5, 4},
//                {7, 2, 5, 0, 6},
//                {M, M, 4, 6, 0}
//        };
//
//        int[][] weight2 = {
//                {0, 10, M, 30, 100},
//                {M, 0, 50, M, M},
//                {M, M, 0, M, 10},
//                {M, M, 20, 0, 60},
//                {M, M, M, M, 0}
//        };
//
//        int start = 0;
//        int[] shortPath = Dijkstra(weight1, start);
//
//        for (int i = 0; i < shortPath.length; i++) {
//            System.out.println(start + "-->" + i + "\t" + shortPath[i]);
//        }
//    }
//}

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class Dijkstra {
    public void inputData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input：");
        int N = 0;
        if (scan.hasNextInt()) {
            N = scan.nextInt();
//            System.out.println("int data:\t" + N);
        } else {
            System.out.println("wrong data!");
        }
        int[][] arr = new int[N][N];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = 0;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        //按行输入各点之间的点名和权值
        int count = 1;
        while (count++ != N + 1) {
            System.out.println("第一层：");
            int i = scan.nextInt();
            int k = scan.nextInt();
            while (k-- != 0) {
                System.out.println("第二层");
                int j = scan.nextInt();
                int value = scan.nextInt();
                arr[i][j] = value;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
//                arr[i][j] = 0;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Dijkstra dij = new Dijkstra();
        dij.inputData();
    }
}