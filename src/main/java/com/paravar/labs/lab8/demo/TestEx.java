package com.paravar.labs.lab8.demo;

public class TestEx
{
	public static void main(String[] args)
	{
		System.out.println("main() starting...");
		try
		{
			int n1 = Integer.parseInt(args[0]);
			int n2 = Integer.parseInt(args[1]);
			
			double result = n1 / n2;
			
			System.out.println("result = "+result);
		}
		catch(Throwable t)
		{
			System.out.println("Oops something bad happened....consult the developer!If you are developer, consult God!");
		}
		System.out.println("main() ending...");
	}

}




