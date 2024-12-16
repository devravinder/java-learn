package com.paravar.labs.lab3.demo;

public class TestCow
{
	public static void main(String[] args)
	{
		Cow c1 = new Cow();
		c1.name = "Jonny";
		c1.moo();
		Cow c2 = c1;// new Cow();
		System.out.println("name of c2 = "+c2.name);
		c2.name = "Bonnie";
		c1.moo();
		Cow c3 = c2;
		c3.name = "Yanni";
		System.out.println("c1.name = "+c1.name);
		System.out.println("c2.name = "+c2.name);
		System.out.println("c3.name = "+c3.name);
		c1.moo();
		
	}

}


