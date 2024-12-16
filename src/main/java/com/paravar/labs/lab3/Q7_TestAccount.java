package com.paravar.labs.lab3;

public class Q7_TestAccount {
    public static void main(String[] args) {
        Account account = new Account();
        account.accNum="34032200202";
        account.owner = "ramu";
        account.deposit(100);
        account.withdraw(50);
        account.withdraw(60);
        account.checkBalance();
        account.withdraw(40);
    }
}
class Account{
    String accNum;
    String owner;
    private int balance;
    public void deposit(int amount){
        if(amount > 0)
        balance = balance + amount;
        else System.out.println("amount should be greater than zero");
    }
    public void withdraw(int amount){
        if(amount<0)
            System.out.println("amount should be greater than zero");
        if(amount > balance)
            System.out.println("insufficient balance");
        balance = balance - amount;
    }
    public void checkBalance(){
        System.out.println(accNum+" Account balance is "+balance);
    }
}
