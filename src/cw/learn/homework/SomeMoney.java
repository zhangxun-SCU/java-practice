package cw.learn.homework;

import java.util.Scanner;

public class SomeMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入零钱：");
        int count = 0;
        int x = scanner.nextInt();
        for(int i = 0; i <= 20; i++){
            for(int j = 0; j <= 50; j++){
                if(i * 5 + j * 2 + (x - i*5 - j*2) == x && (x - 5*i - 2*j) > 0){
                    System.out.println("fen5:" + i + ",fen2:" + j + ",fen1:" + (x-i*5-j*2) + ",total:" + (i + j + (x - 5*i - 2*j)));
                    count++;
                }
            }
        }
        System.out.println("count=" + count);
    }
}
