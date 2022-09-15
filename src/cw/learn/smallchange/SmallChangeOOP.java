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
    //        日期格式化
    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
    String note = "";
    String details = "\n----------明细----------";

    //    菜单
    public void mainMenu() {
        do{
            System.out.println("----------零钱通菜单----------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");
            System.out.print("请选择：");
            key = scanner.next();

            switch (key) {
                case "1" -> this.detail();
                case "2" -> this.income();
                case "3" -> this.pay();
                case "4" -> this.exit();
                default -> System.out.println("选择有误，重新选择");
            }
        }while(loop);
    }

    //    明细
    public void detail(){
        System.out.println(details);
    }

//    收入
    public void income() {
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
//                    money 取值校验
        if (money <= 0) {
            System.out.println("入账金额不合规则");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
    }

    //    消费
    public void pay() {
        System.out.print("消费金额：");
        money = scanner.nextDouble();
//                    校验
        if (money <= 0 || money > balance) {
            System.out.println("消费金额不合规则");
            return;
        }
        System.out.print("消费说明：");
        note = scanner.next();
        balance -= money;
        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t余额\t" + balance;
    }

    //    退出
    public void exit() {
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
}
