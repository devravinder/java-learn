package com.paravar.labs.lab9.q1.acc;

public class Person {
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void deposit(double amt){
        if(amt < 0)
            throw  new IllegalArgumentException("Invalid amount");

        account.deposit(amt);

    }

    public void withdraw(double amt){
        if(amt < 0)
            throw  new IllegalArgumentException("Invalid amount");

        account.withdraw(amt);
    }
}
