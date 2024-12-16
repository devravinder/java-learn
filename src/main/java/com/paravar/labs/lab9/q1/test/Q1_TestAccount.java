package com.paravar.labs.lab9.q1.test;

import com.paravar.labs.lab9.q1.acc.Account;
import com.paravar.labs.lab9.q1.acc.Person;
import com.paravar.labs.lab9.q1.bank.BankAccount;

public class Q1_TestAccount {
    public static void main(String[] args) {
        Account acc = new BankAccount(1000);
        Person ramu = new Person();
        ramu.setAccount(acc);
        ramu.deposit(5000);
        System.out.println(ramu.getAccount().checkBalance());
        ramu.withdraw(2000);
       // ramu.withdraw(6000);
    }
}
