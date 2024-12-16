package com.paravar.labs.lab8.demo;

import java.util.*;

class Thing
{
	
}
public class Test3
{
	public static void main(String[] args)
	{
		System.out.println("main starting...");
		int i = 0;
		try
		{	
			ArrayList list = new ArrayList();
			for(i = 0 ; i < 999999999 ; i++)
			{
				list.add(new Thing());
			}
		}
		catch(Throwable t)
		{
			System.out.println("i = "+i);
			t.printStackTrace();	
		}
		System.out.println("main ending...");
	}
}
