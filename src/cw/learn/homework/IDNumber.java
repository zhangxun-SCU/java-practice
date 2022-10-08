package cw.learn.homework;


import java.util.Arrays;
import java.util.Scanner;

public class IDNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] ids = new String[n];
        for(int i = 0; i < n; i++){
            ids[i] = scanner.next();
        }
        String[] choices = new String[3];
        int count = 0;
        while(true){
            choices[count] = scanner.next();
            if((!choices[count].equals("sort1")) && (!choices[count].equals("sort2"))){
                count++;
                break;
            }
            count++;
        }
        for(int i = 0; i < count; i++){
            if(choices[i].equals("sort1")){
                String[] tmp1 = sort1(ids);
                for(String s:tmp1){
                    System.out.println(s);
                }
            } else if(choices[i].equals("sort2")){
                String[] tmp2 = sort2(ids);
                for(String s:tmp2){
                    System.out.println(s);
                }
            } else {
                System.out.println("exit");
            }
        }
    }

    public static String[] sort1(String[] ids){
        String[] tmp = new String[ids.length];
        for(int i = 0; i < ids.length; i++){
            tmp[i] = ids[i].substring(6, 10) + "-" + ids[i].substring(10, 12) + "-" + ids[i].substring(12, 14);
        }
        Arrays.sort(tmp, String::compareToIgnoreCase);
        return tmp;
    }

    public static String[] sort2(String[] ids){
        for(int i = 0; i < ids.length - 1; i++){
            for(int j = 0; j < ids.length - i - 1; j++){
                if((ids[j].substring(6, 14)).compareToIgnoreCase(ids[j+1].substring(6,14)) >= 0){
                    String temp = ids[j];
                    ids[j] = ids[j+1];
                    ids[j+1]=temp;
                }
            }
        }
        return ids;
    }
}
