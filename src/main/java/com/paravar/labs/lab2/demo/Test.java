package com.paravar.labs.lab2.demo;

public class Test
{
	public static void main(String[] args)
	{
		/*
		for(int i = 10; i > 0 ; i--)
		{
			System.out.println("Hello Java "+i);
			if(i % 3 != 0)
				System.out.println(i+" not divisible by 3");
			else
				System.out.println(i+" is divisible by 3");
		}
		
		
		int n=0;
		while(n<10)
		{
			System.out.println("n = "+n);
			n++;
		}
		do
		{
			System.out.println("do while n = "+n);
			n--;
		}
		while(n>0);
		
		if(1==1)
			System.out.println("hoo haa");
		
		
		System.out.println("main()->starts");
		
		byte b = 10;
		b += 1; // b = (byte) (b + 1);
		
		//int i = -1 >>> 1;
		
		//System.out.println("i = "+i);
		
		System.out.println("Hello");
		System.out.println("Hai");
		
		char c = '0';
		System.out.println("c = "+c);
		int x = c;
		System.out.println("x = "+x);
		x = c + 1;
		System.out.println("char = "+ (char) x);
			
		for(int i = 0 ; i<64535; i++)
			System.out.println("char for "+i+" = "+(char)i);
		
		System.out.println("main()->ends");
		*/
		for(int i = 0 ; i < 100 ; i++)
		{
			if((i & 1) == 0)
				System.out.println(i+" is even");
			else
				System.out.println(i+" is odd");
		}
		
		
	}
}



