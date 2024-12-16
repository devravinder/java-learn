package com.paravar.labs.lab8.demo;

public class TestATM
{
	public static void main(String[] args)
	{
		
		System.out.println("main()->starting...");
		try
		{
			ATM a = new ATM();
			Card c = new Card(5000,"Mogambo");
			System.out.println("going to invoke withdraw()");
			a.withDraw(c,400);
			System.out.println("after withdrawal in main() c.balance = "+c.getBalance());
			System.out.println("doing other things...");
		}
		catch(Throwable t)
		{
			System.out.println("Oops something bad happened msg = "+t.getMessage());
			t.printStackTrace();	
			
		}
				
		System.out.println("main()->ending...");
	}

}



