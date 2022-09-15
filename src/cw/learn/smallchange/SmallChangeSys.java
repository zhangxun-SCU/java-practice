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
//        日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
        String note = "";
        String details = "\n----------明细----------";
        do{
            System.out.println("----------零钱通菜单----------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.print("请选择：");
            key = scanner.next();

            switch (key) {
                case "1" -> System.out.println(details);
                case "2" -> {
                    System.out.print("收益入账金额：");
                    money = scanner.nextDouble();
//                    money 取值校验
                    if (money <= 0) {
                        System.out.println("入账金额不合规则");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
                }
                case "3" -> {
                    System.out.print("消费金额：");
                    money = scanner.nextDouble();
//                    校验
                    if (money <= 0 || money > balance) {
                        System.out.println("消费金额不合规则");
                        break;
                    }
                    System.out.print("消费说明：");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
                }
                case "4" -> {
                    String choice = "";
                    do {
                        System.out.print("确认退出吗：");
                        choice = scanner.next();
                    } while (!choice.equals("y") && !choice.equals("n"));
                    if (choice.equals("y")) {
                        System.out.println("退出");
                        loop = false;
                    }
                }
                default -> System.out.println("选择有误，重新选择");
            }
        }while(loop);
    }
}
