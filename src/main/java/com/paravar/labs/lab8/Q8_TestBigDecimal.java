package com.paravar.labs.lab8;

import java.math.BigDecimal;

public class Q8_TestBigDecimal {
    public static void main(String[] args) {


        Account account = new Account(new BigDecimal(1000));
        try {
            account.withDraw(new BigDecimal(1000));
            account.withDraw(new BigDecimal(1000));
        } catch (LessBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
class Account {
    private BigDecimal balance;

    Account(BigDecimal balance){
        this.setBalance(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        if(balance.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException(("Invalid balance"));
        }
        this.balance = balance;
    }

    public void withDraw(BigDecimal amt) throws LessBalanceException {
        if(amt.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException(("Invalid amount to withdraw"));
        }
        if(balance.compareTo(amt) < 0){
            throw new LessBalanceException(("Insufficient balance"));
        }
        balance = balance.subtract(amt);
        System.out.println("with draw successful balance = "+balance);
    }
}

class LessBalanceException extends Exception{
    public LessBalanceException(String msg){
        super(msg);
    }
}