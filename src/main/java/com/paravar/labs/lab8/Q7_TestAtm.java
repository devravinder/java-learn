package com.paravar.labs.lab8;

public class Q7_TestAtm {
    public static void main(String[] args) {

        ATM atm = new ATM();
        Card c = new Card(50);
        try {
            atm.withDraw(c, 400);
        }
        catch (InSufficientBalanceException e) {
            System.out.println("Oye, you have no money or what!! msg = "+e.getMessage());
        }
        try {
            atm.withDraw(c, 40);
        } catch (InSufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class Card {
    double amount;

    public Card(double amt) {
        amount = amt;
    }

    public void withDraw(double amt) throws InSufficientBalanceException {
        if(amt < 0)
            throw new IllegalArgumentException("Invalid amount to withdraw");
        if(amount < amt) {
            throw new InSufficientBalanceException("Insufficient balance");
        }
        amount -= amt;
        System.out.println("with draw successful balance = "+amount);
    }

}
class ATM {
    public void withDraw(Card c, double amt) throws InSufficientBalanceException {
        c.withDraw(amt);
    }
}

class InSufficientBalanceException extends Exception {

    public InSufficientBalanceException(String msg) {
        super(msg);
    }
}