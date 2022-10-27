package cw.learn.homework;

import java.util.Scanner;

public class EgSentence {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(" ");
        for(int i = temp.length - 1; i >= 0; i--){
            stringBuffer.append(temp[i]).append(" ");
        }
        System.out.println(stringBuffer);
    }
}
