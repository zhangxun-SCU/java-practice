package cw.learn.homework;

import java.util.Scanner;

public class MakeFood {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] nums = input.nextLine().split(" ");
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        makefood(arr);
    }

    private static void makefood(int[] arr) {
        int max_same = 0;
        int[] book = new int[105];
        for (int j : arr) {
            book[j]++;
            if (book[j] > max_same) {
                max_same = book[j];
            }
        }
        if (max_same <= (arr.length + 1) / 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
