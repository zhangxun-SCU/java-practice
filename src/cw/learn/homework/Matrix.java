package cw.learn.homework;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        Solution(arr);
    }
    static class Point {
        public int x;
        public int y;

        public Point(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static void Solution(int[][] arr) {
        int n = arr.length;
        int[] cols_min = new int[n];
        int[] rows_max = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] < arr[cols_min[j]][j])
                    cols_min[j] = i;
                if (arr[i][j] > arr[i][rows_max[i]])
                    rows_max[i] = j;
            }
        }
        Point[] dots = new Point[n];
        int cnt = 0;
        for (int k = 0; k < n; k++) {
            if (k == cols_min[rows_max[k]]) {
                //a[k][rows_max[k]]---第k行的最大值
                //a[cols_min[rows_max[k]]][rows_max[k]]---第rows_max[k]列的最小值
                //所以只有cols_min[rows_max[k]] == k时，才是马鞍点
                dots[cnt++] = new Point(k, rows_max[k]);
            }
        }
        if (cnt == 0) {
            System.out.println("NONE");
        } else {
            for (int i = 0; i < cnt; i++) {
                System.out.println(dots[i]);
            }
        }
    }
}

