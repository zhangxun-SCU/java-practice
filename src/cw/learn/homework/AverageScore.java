package cw.learn.homework;

import java.util.Scanner;

public class AverageScore {
    /**
     * �������ϵͳ���Զ�ȥ��һ����߷ֺ�һ����ͷ֣����ƽ����
     */
    public static void main(String[] args) {
//        ������룬����
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
        System.out.println("ƽ���֣�" + average);
    }
}
