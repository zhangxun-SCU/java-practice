package cw.learn.homework;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Solution(expression);
    }
    static final int N = (int) 1e6 + 5;

    static void Solution(String str) {
        int[] operands = new int[N];
        char[] operators = new char[N];
        int idx = 0, opnd_len = 0, optr_len = 0;
        while (true) {
            char ch = str.charAt(idx);
            if (ch == '=') break;
            switch (judge(ch)) {
                case 0:
                    System.out.println("ERROR");
                    return;
                case 1:
                    operators[optr_len++] = ch;
                    idx++;
                    break;
                case 2:
                    int l = 1;
                    while (judge(str.charAt(idx + l)) == 2) l++;
                    operands[opnd_len++] = Integer.parseInt(str.substring(idx, idx + l));
                    idx = idx + l;
                default:
                    break;
            }
        }
        if (optr_len != opnd_len - 1) {
            System.out.println("ERROR");
            return;
        }
        for (int i = 0; i < optr_len; i++) {
            if (operators[i] == '/' && operands[i + 1] == 0) {
                System.out.println("ERROR");
                return;
            }
            operands[i + 1] = calculate(operands[i], operators[i], operands[i + 1]);
        }
        System.out.println(operands[opnd_len - 1]);
    }

    static int judge(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') return 1;//操作符
        else if (ch >= '0' && ch <= '9') return 2;//操作数
        else return 0;//非法字符 ERROR
    }

    static int calculate(int l, char theta, int r) {
        switch (theta) {
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '*':
                return l * r;
            case '/':
                return l / r;
            default:
                return -(int) 1e8;
        }
    }
}
