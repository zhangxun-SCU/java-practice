package cw.learn.homework;

import java.util.Scanner;

public class NumberBlackHole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // get input and split
        int n = scanner.nextInt();
        int[] numbers = new int[4];
        split(n, numbers);
        // sort
        sort(numbers);
        int min = getMin(numbers);
        int max = getMax(numbers);
        while(true){
            int temp = max - min;
            if(temp == 0){
                System.out.println(max + "-" + min + "=0000");
                break;
            }
            System.out.println(max + "-" + min + "=" + temp);
            if(temp == 6174){
                break;
            }
            split(temp, numbers);
            sort(numbers);
            min = getMin(numbers);
            max = getMax(numbers);
        }
    }

    static void split(int n, int[] numbers){
        for(int i = 0; i < 4; i++){
            numbers[i] = n % 10;
            n /= 10;
        }
    }

    static void sort(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - i - 1; j++){
                if(numbers[j] > numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

    static int getMin(int[] numbers){
        return numbers[3] + numbers[2] * 10 + numbers[1] * 100 + numbers[0] * 1000;
    }

    static int getMax(int [] numbers){
        return numbers[0] + numbers[1] * 10 + numbers[2] * 100 + numbers[3] * 1000;
    }
}

