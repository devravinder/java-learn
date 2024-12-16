package com.paravar.labs.lab8.demo;

//custom ex, user defined ex
public class NotEnoughMoneyInCardException extends Exception
{
	public NotEnoughMoneyInCardException()
	{
		
	}
	public NotEnoughMoneyInCardException(String msg)
	{
		super(msg);	
	}
}



