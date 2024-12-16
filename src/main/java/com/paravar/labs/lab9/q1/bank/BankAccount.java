package com.paravar.labs.lab9.q1.bank;


import com.paravar.labs.lab9.q1.acc.Account;

public class BankAccount implements Account {
    private double balance;

    public BankAccount(double balance) {
        this.setBalance(balance);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0)
            throw  new IllegalArgumentException("Invalid balance");
        this.balance = balance;
    }


    @Override
    public void deposit(double amt){
        if(amt < 0)
            throw  new IllegalArgumentException("Invalid amount");
        balance = balance + amt;
        System.out.println("Balance after deposit is "+balance);
    }

    @Override
    public void withdraw(double amt) {
        if(amt < 0)
            throw  new IllegalArgumentException("Invalid amount");
        if(amt > balance)
            throw  new IllegalArgumentException("Insufficient balance");
        balance = balance - amt;
        System.out.println("Balance after withdraw is "+balance);
    }

    @Override
    public double checkBalance() {
        return this.getBalance();
    }
}
