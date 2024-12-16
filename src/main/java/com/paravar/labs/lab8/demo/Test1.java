package com.paravar.labs.lab8.demo;

public class Test1
{
	public static void main(String[] args)
	{
		System.out.println("main()->starting...");
		try
		{
			int[] arr = new int[10];
			//System.out.println("accessing arr content "+arr[10]);
			
			String str = null;
			//System.out.println("str length = "+str.length());
		
			//Animal a = new Animal();
			//Duck d = (Duck) a;
			
			int num = Integer.parseInt(args[0]);
			System.out.println("num = "+num);
			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("in catch() msg = "+e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("in catch() msg = "+e.getMessage());
			e.printStackTrace();
		}
				
		System.out.println("main()->ending...");
	}
}
