package cw.learn.atm;

import java.util.Scanner;

public class ATM {
    Account[] accounts = new Account[10];
    ATM(){
        for(int i = 0; i< 10; i++){
            accounts[i] = new Account(i+1,100);
        }
    }
    Scanner scanner = new Scanner(System.in);
    String choice = "";
    private boolean loop = true;
    void mainMenu(){

        while (true){
            System.out.print("Enter an id:");
            int id = scanner.nextInt();
            // 判断id
            if (id < 0 || id >= 10){
                System.out.println("id错误");
                continue;
            }
            do {
                System.out.println("Main menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                String choice = scanner.next();
                switch (choice){
                    case "1" ->{
                        checkBanlance(id);
                    }
                    case "2" -> {
                        withDraw(id);
                    }
                    case "3" -> {
                        deposit(id);
                    }
                    case "4" -> {
                        exit();
                    }
                }
            }while(loop);
        }

    }

    public void checkBanlance(int id){
        System.out.println("The balance is " + accounts[id].getBalance());
    }

    public void withDraw(int id){
        System.out.print("Enter an amount to withdraw: ");
        double num = scanner.nextDouble();
        accounts[id].withDraw(num);
    }

    public void deposit(int id){
        System.out.print("Enter an amount to deposit: ");
        double num = scanner.nextDouble();
        accounts[id].deposit(num);
    }

    public void exit(){
        System.out.println("退出系统");
        loop = false;
    }
}
