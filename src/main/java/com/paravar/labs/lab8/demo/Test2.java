package com.paravar.labs.lab8.demo;
public class Test2
{
	static int count = 0;
	public static void main(String[] args)
	{
		
		try
		{
			count++;
			Test2.main(null);
		}
		catch(Throwable t)
		{
			System.out.println("in catch()...count = "+count);
		//	t.printStackTrace();
		}
	}
}
