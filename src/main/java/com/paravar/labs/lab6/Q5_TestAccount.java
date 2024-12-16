package com.paravar.labs.lab6;

public class Q5_TestAccount {
    public static void main(String[] args) {

        Account savings = new BankAccount(1000, 200000);
        Account credit = new CreditCardAccount(-500000, 2000000);

        Person person = new Person();
        person.setAccount(savings);
        person.deposit(5000);
        person.withdraw(1000);
        person.withdraw(4000);
        person.withdraw(1000);
        person.checkBalance();

        System.out.println("===============");
        person.setAccount(credit);
        person.withdraw(1000);
        person.checkBalance();

    }
}
class Person{

    private Account account;

    public void deposit(double amount){
        account.deposit(amount);
    }
    public void withdraw(double amount){
        account.withdraw(amount);
    }
    public void  checkBalance(){
        System.out.println("balance = "+account.checkBalance());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposit success balance = "+balance);
        }

        else System.out.println("amount should be greater than zero");
    }
    public void withdraw(double amount){
        if(balance<=0){
            System.out.println("insufficient balance");
            return;
        }
        if(amount<0){
            System.out.println("amount should be greater than zero");
            return;
        }

        if(amount > balance){
            System.out.println("insufficient balance");
            return;
        }

        balance -= amount;
        System.out.println(amount+ " Withdraw success balance = "+balance);
    }

    public double checkBalance(){
            return balance;
    }

}

class BankAccount extends Account {
    private double minBalance;
    private double maxBalance = Double.MAX_VALUE;

    public BankAccount(double minBalance, double maxBalance) {
        this.setMaxBalance(maxBalance);
        this.setMinBalance(minBalance);
    }

    @Override
    public void deposit(double amount) {
        if(amount > 0){
            if(amount + getBalance() > maxBalance)
            {
                System.out.println(amount+ " deposit failed, reaching max limit "+maxBalance);
                return;
            }
            super.deposit(amount);
        }
        else System.out.println("amount should be greater than zero");
    }

    @Override
    public void withdraw(double amount) {
        if(getBalance()<=0)
            System.out.println("insufficient balance");
        if (amount > 0){
            if(getBalance() - amount < minBalance)
            {
                System.out.println(amount+" withdraw failed,reaching min limit "+minBalance);
                return;
            }
            super.withdraw(amount);
        }
        else System.out.println("amount should be greater than zero");
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        if(minBalance < 0){
            System.out.println("min balance should be greater than zero");
            return;
        }
        if(minBalance > maxBalance){
            System.out.println("min balance should be less than max balance");
            return;
        }
        this.minBalance = minBalance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(double maxBalance) {
        if(maxBalance < 0){
            System.out.println("max balance should be greater than zero");
            return;
        }
        if(maxBalance < minBalance){
            System.out.println("max balance should be greater than min balance");
            return;
        }
        this.maxBalance = maxBalance;
    }
}

class CreditCardAccount extends  Account {
    private double minBalance;
    private double maxBalance = Double.MAX_VALUE;

    public CreditCardAccount(double minBalance, double maxBalance) {
        this.setMaxBalance(maxBalance);
        this.setMinBalance(minBalance);
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0){
            if(getBalance() - amount < minBalance)
            {
                System.out.println(amount+ " withdraw failed,reaching min limit "+maxBalance);
                return;
            }
            super.setBalance(getBalance() - amount);
            System.out.println(amount+ " Withdraw success balance = "+getBalance());

        }
        else System.out.println("amount should be greater than zero");
    }

    @Override
    public void deposit(double amount) {
        if(amount > 0){
            if(amount + getBalance() > maxBalance)
            {
                System.out.println(amount+" deposit failed,reaching max limit "+maxBalance);
                return;
            }
            super.deposit(amount);
        }
        else System.out.println("amount should be greater than zero");
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {

        if(minBalance > maxBalance){
            System.out.println("min balance should be less than max balance");
            return;
        }
        this.minBalance = minBalance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(double maxBalance) {
        if(maxBalance < 0){
            System.out.println("max balance should be greater than zero");
            return;
        }
        if(maxBalance < minBalance){
            System.out.println("max balance should be greater than min balance");
            return;
        }
        this.maxBalance = maxBalance;
    }



}