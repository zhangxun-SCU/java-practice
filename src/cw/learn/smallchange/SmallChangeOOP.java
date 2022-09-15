package cw.learn.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeOOP {
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

    //    �˵�
    public void mainMenu() {
        do{
            System.out.println("----------��Ǯͨ�˵�----------");
            System.out.println("\t\t\t1 ��Ǯͨ��ϸ");
            System.out.println("\t\t\t2 ��������");
            System.out.println("\t\t\t3 ����");
            System.out.println("\t\t\t4 �˳�");
            System.out.print("��ѡ��");
            key = scanner.next();

            switch (key) {
                case "1" -> this.detail();
                case "2" -> this.income();
                case "3" -> this.pay();
                case "4" -> this.exit();
                default -> System.out.println("ѡ����������ѡ��");
            }
        }while(loop);
    }

    //    ��ϸ
    public void detail(){
        System.out.println(details);
    }

//    ����
    public void income() {
        System.out.print("�������˽�");
        money = scanner.nextDouble();
//                    money ȡֵУ��
        if (money <= 0) {
            System.out.println("���˽��Ϲ���");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n��������\t+" + money + "\t" + sdf.format(date) + "\t���\t" + balance;
    }

    //    ����
    public void pay() {
        System.out.print("���ѽ�");
        money = scanner.nextDouble();
//                    У��
        if (money <= 0 || money > balance) {
            System.out.println("���ѽ��Ϲ���");
            return;
        }
        System.out.print("����˵����");
        note = scanner.next();
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t���\t" + balance;
    }

    //    �˳�
    public void exit() {
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
}
