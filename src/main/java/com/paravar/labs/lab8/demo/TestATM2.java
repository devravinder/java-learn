package com.paravar.labs.lab8.demo;

public class TestATM2
{
	public static void main(String[] args)
	{
		try
		{
			ATM a = new ATM();
			Card c = new Card(50,"Timma");
			a.withDraw(c,400);
			System.out.println("withdrawal done!");
		}
		catch(NotEnoughMoneyInCardException e)
		{
			System.out.println("Oye, you have no money or what!! msg = "+e.getMessage());
		}
		catch(Throwable t)
		{
			t.printStackTrace();
		}
	}

}
