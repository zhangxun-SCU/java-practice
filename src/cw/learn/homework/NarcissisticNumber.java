package cw.learn.homework;

import java.util.Scanner;

public class NarcissisticNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        for(int i = m; i <= n; i++){
            if(isNarcissisticNumber(i)){
                System.out.println(i);
            }
        }
        System.out.println();
    }

    public static boolean isNarcissisticNumber(int number){
        int tmp = number;
        int sum = 0;
        int i = 0;
        while(i < 3){
            int a = tmp % 10;
            tmp = tmp / 10;
            sum += a*a*a;
            i += 1;
        }
        return sum == number;
    }
}
