package cw.learn.homework;

import java.util.Scanner;

public class Ball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入：");
        String str = scanner.nextLine();
        String[] strs = new String[2];
        strs = str.split(" ");
        int h = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        double distant = (double)h;
        double newh = (double)h / 2;
        for(int i = 0; i < n; i++){
            distant += 2*newh;
            newh /= 2;
        }
        newh *= 2;
        distant -= newh;
        System.out.printf("距离：%.1f, 高度：%.1f", distant, newh);
    }
}
