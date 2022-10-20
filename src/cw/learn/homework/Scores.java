package cw.learn.homework;

import java.util.Scanner;

public class Scores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < n; i++){
            try {
                scores[i] = scanner.nextInt();
                if(scores[i] < 0 || scores[i] > 100){
                    throw new ScoreException(scores[i]);
                }
            } catch (ScoreException e) {
                i--;
                message.append(e.toString()).append("\n");
            }
        }
        int count = 0;
        for(int i :scores){
            if(i >= 60){
                count++;
            }
        }
        System.out.print(message);
        System.out.println(count);
        System.out.println(scores.length - count);
    }
}

class ScoreException extends Exception{
    private int score;
    ScoreException(int score){
        this.score = score;
    }
    @Override
    public String toString() {
        return score + "invalid";
    }
}
