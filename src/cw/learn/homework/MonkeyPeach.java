package cw.learn.homework;

import java.util.Scanner;

public class MonkeyPeach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println("第一天有" + monkeyPeach(1, N) + "个桃子");
    }

    public static int monkeyPeach(int n, int totalDays){
        if(n < 0){
            return -1;
        }
        if(n == totalDays){
            return 1;
        }
        return (monkeyPeach(n + 1, totalDays) + 1) * 2;

    }
}
