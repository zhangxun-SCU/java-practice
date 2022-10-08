package cw.learn.atm;


import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0;
    static private double annualInterestRate = 0;
    private Date dateCreated;
    public Account() {
        id = 0;
        balance = 0;
        dateCreated = new Date();
    }

    public Account(int i, double bal) {
        this.id = i;
        this.balance = bal;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    public double getMonthlyInterestRate() {
        double monthlyInterestRate = annualInterestRate / 12;
        return monthlyInterestRate;
    }

    public void withDraw(double num) {
        if (this.balance >= num) {
            System.out.println("You successfully withdraw " + num + " from your account.");
            this.balance -= num;
        }
    }

    public void deposit(double num) {
        this.balance += num;
        System.out.println("You successfully deposit " + num + " to your account.");
    }
}