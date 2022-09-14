package cw.learn.homework;

import java.util.Scanner;

public class AverageScore {
    /**
     * 设计评分系统能自动去掉一个最高分和一个最低分，求出平均分
     */
    public static void main(String[] args) {
//        获得输入，分数
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split(",");
        int[] scores = new int[arr.length];
        int sum = 0;
        int max = Integer.parseInt(arr[0]);
        int min = max;
        for (int i = 0; i < arr.length; i++) {
            scores[i] = Integer.parseInt(arr[i]);
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        float average = (float) (sum - max - min) / (scores.length - 2);
        System.out.println("平均分：" + average);
    }
}
