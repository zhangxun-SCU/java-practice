package cw.learn.homework;

import java.util.Scanner;

public class ReString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入字符串: ");
        String tmp = scanner.nextLine();
        StringBuilder str = new StringBuilder(tmp);
        str.reverse();
        String newStr = new String(str);
        if(tmp.equals(newStr)){
            System.out.println("yes");
        } else{
            System.out.println("no");
        }
    }
}


