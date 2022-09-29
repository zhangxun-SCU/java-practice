package cw.learn.homework;

import java.util.Scanner;

public class Golonbottle {
    public static void main(String[] args) {
        Golon.menu();
        Scanner scanner = new Scanner(System.in);
    }
}

class Golon {

    private int initialBalls;
    private int initialSlots;
    private int[] slots;

    public Golon() {
        this(1,5);
    }
    public Golon(int i,int n) {
        initialBalls = i;
        initialSlots = n;
        slots = new int[n];
    }
    public static void menu() {
        java.util.Scanner input = new java.util.Scanner(System.in);
        int balls;
        int slots;
        System.out.print("球的个数: ");
        balls = input.nextInt();
        System.out.print("槽个数: ");
        slots = input.nextInt();
        Golon mine = new Golon(balls,slots);
        mine.play();
    }
    public void play() {
        for(int i = 0;i < initialBalls;i++) {
            printPath();
        }
        System.out.println();
        printChart();
    }
    public void printPath() {
        int judge;
        int numberOfR = 0;
        for(int i = 0;i < initialSlots-1;i++) {
            judge = (int)(Math.random()*2);
            if(judge == 0)
                System.out.print("L");
            if(judge == 1) {
                numberOfR++;
                System.out.print("R");
            }
        }
        System.out.println("");
        slots[numberOfR]++;
    }
    public void printChart() {
        int max = getMax();
        for(int i = 0;i < max;i++) {
            for(int j = 0;j < initialSlots;j++) {
                if(slots[j] >= max - i)
                    System.out.print("0");
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public int getMax() {
        int max = slots[0];
        for (int slot : slots) {
            if (slot > max) max = slot;
        }
        return max;
    }
}

