package cw.learn.homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Ten2N {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.nextLine();
        String[] tmps = tmp.split(" ");
        int A = Integer.parseInt(tmps[0]);
        int B = Integer.parseInt(tmps[1]);
        int D = Integer.parseInt(tmps[2]);

        System.out.println(toN(A, B, D));
    }
    static int toN(int A, int B, int D){
        int sum = A + B;
        ArrayList<Integer> arrayList  = new ArrayList<>();
        while(sum != 0){
            arrayList.add(sum % D);
            sum = sum / D;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i : arrayList){
            stringBuffer.append(i + "");
        }
        stringBuffer.reverse();
        return Integer.parseInt(new String(stringBuffer));
    }
}

