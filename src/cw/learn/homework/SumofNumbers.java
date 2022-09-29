package cw.learn.homework;

import java.util.Scanner;

public class SumofNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入N：");
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 2;
        for(int i = 2; i <= n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }
        double sum = 0;
        for(int i = 0; i < n; i++){
            sum += (double) array[i+1]/array[i];
        }
        System.out.printf("和为%.2f", sum);
    }
}
