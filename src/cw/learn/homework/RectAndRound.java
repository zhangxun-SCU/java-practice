package cw.learn.homework;

import java.util.Date;
import java.util.Scanner;

public class RectAndRound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer message = new StringBuffer("");
        for(int i = 0; i < n; i++){
            int choice = scanner.nextInt();
            if(choice == 1){
                // Ô²
                double r = scanner.nextDouble();
                Round round = new Round(r);
                message.append(String.format("%.2f", round.getArea())).append(" ").append(String.format("%.2f", round.getPerimeter())).append("\n");
            } else if (choice == 2) {
                // ¾ØÐÎ
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                Rect rect = new Rect(a, b);
                message.append(String.format("%.2f", rect.getArea())).append(" ").append(String.format("%.2f", rect.getPerimeter())).append("\n");
            }
        }
        System.out.print(message);
    }
}

// Ô²
class Round implements Shape{
    private double r;

    public Round(double r) {
        this.r = r;
    }

    public double getArea(){
        return 3.14 * r * r;
    }

    public double getPerimeter(){
        return 2 * 3.14 * r;
    }
}
 // ¾ØÐÎ
class Rect implements Shape{
    private double a;
    private double b;

    public Rect(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getArea(){
        return a * b;
    }

    public double getPerimeter(){
        return 2 * (a + b);
    }
}

interface Shape{
    double getArea();
    double getPerimeter();
}
