package com.paravar.labs.lab3.demo;

public class TestPrime
{
	public static String isPrime(int num)
	{
		if(num < 0)
			return "invalid num!";
		if(num == 0 || num == 1)
			return "no";
		if(num == 2 || num == 3 || num == 5 || num ==7)
			return "yes";
		if((num&1) == 0)
			return "no";
		
		for(int n = 3 ; n < num / 2 ; n += 2)
		{
			if(num % n == 0)
				return "no";
			
		}
		return "yes";
		
	}
	public static void main(String[] args)
	{
		int x;
		String result;
		
		x = 0;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);
		
		x =1;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);
		
		x = 2;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);
		
		x = 3;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);
		
		x = 20;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);

		x = -2;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);

		x = 345;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);

		x = -1>>>1;
		result = TestPrime.isPrime(x);
		System.out.println("is "+x+" prime ? "+result);

	}
}






