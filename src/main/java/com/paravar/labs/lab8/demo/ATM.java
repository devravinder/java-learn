package com.paravar.labs.lab8.demo;

public class ATM
{
	//non-user facing methods!
	/***
	* This method withdraws money. The method
	* will succeed only if non-null card and non-neg amt
	* is passed and the card has enough balance
	***/
	public void withDraw(Card c, double amt) throws NotEnoughMoneyInCardException
	{
		//first perform invoker input val.
		if(c == null)
			throw new IllegalArgumentException("Card is null, you fool...pass non-null card for withdrawal!");
		
		if(amt < 0)
			throw new IllegalArgumentException("amt to withdraw cannot be negative, you negative minded creature!");
		//then perform business val.
		if(c.balance < amt)
			throw new NotEnoughMoneyInCardException("Your card has balance "+c.balance +" which is less than amt "+amt+" that you are trying to withdraw...what you want bitti money or what!!??");
		//then only perform busi.logic
		
		c.balance = c.balance - amt;
	}

}



