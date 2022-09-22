package cw.learn.homework;

import java.util.Scanner;

public class number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int[][] array = new int[row][];
        for(int i = 0; i < row ;i++){
            array[i] = new int[row - i];
        }
        int i = 0, j = -1;
        int num = 1;
        for(int times_1 = 0; times_1 < row; times_1++){
            int times_2 = array[times_1].length - 1;
            while (times_2 >= 0){
                if(times_1 % 3 == 0){
                    j += 1;
                    array[i][j] = num;
                } else if (times_1 % 3 == 1) {
                    i += 1;
                    j -= 1;
                    array[i][j] = num;
                } else {
                    i -= 1;
                    array[i][j] = num;
                }
                times_2 -= 1;
                num += 1;
            }
        }

        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%-3d", anInt);
            }
            System.out.println();
        }
    }
}
