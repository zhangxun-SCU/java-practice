package cw.learn.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        double money = 0;
        double balance = 0;
        Date date = null;
//        ���ڸ�ʽ��
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
        String note = "";
        String details = "\n----------��ϸ----------";
        do{
            System.out.println("----------��Ǯͨ�˵�----------");
            System.out.println("\t\t\t1 ��Ǯͨ��ϸ");
            System.out.println("\t\t\t2 ��������");
            System.out.println("\t\t\t3 ����");
            System.out.println("\t\t\t4 �˳�");
            System.out.print("��ѡ��");
            key = scanner.next();

            switch (key) {
                case "1" -> System.out.println(details);
                case "2" -> {
                    System.out.print("�������˽�");
                    money = scanner.nextDouble();
//                    money ȡֵУ��
                    if (money <= 0) {
                        System.out.println("���˽��Ϲ���");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n��������\t+" + money + "\t" + sdf.format(date) + "\t���\t" + balance;
                }
                case "3" -> {
                    System.out.print("���ѽ�");
                    money = scanner.nextDouble();
//                    У��
                    if (money <= 0 || money > balance) {
                        System.out.println("���ѽ��Ϲ���");
                        break;
                    }
                    System.out.print("����˵����");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t���\t" + balance;
                }
                case "4" -> {
                    String choice = "";
                    do {
                        System.out.print("ȷ���˳���");
                        choice = scanner.next();
                    } while (!choice.equals("y") && !choice.equals("n"));
                    if (choice.equals("y")) {
                        System.out.println("�˳�");
                        loop = false;
                    }
                }
                default -> System.out.println("ѡ����������ѡ��");
            }
        }while(loop);
    }
}
