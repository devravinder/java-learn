package com.paravar.labs.lab3.demo;

public class TestHippo
{
	public static void main(String[] args)
	{
		System.out.println("main()->starting...");
		Hippo h1 = new Hippo();
		System.out.println(h1);
		System.out.println("h1.size = "+h1.size);
		//h1.sing();
		h1.size = 20;
		System.out.println("h1.size = "+h1.size);
		Hippo h2 = new Hippo();
		h2.size = 30;
		System.out.println("h2.size = "+h2.size);
		System.out.println("h1.size after creating h2 = "+h1.size);
		h1.size = h2.size;
		System.out.println("h1.size after assigning h1.size = h2.size => "+h1.size);
		h1.size = 60;
		System.out.println("h1.size = "+h1.size);
		System.out.println("h2.size = "+h2.size);
		h1 = h2; // what is happening here? both ref are pointing
			// to same object!!
		System.out.println("after h1=h2");
		System.out.println("h1.size = "+h1.size);
		System.out.println("h2.size = "+h2.size);
		h1.size = 45;
		System.out.println("after assigning h1.size = 45");
		System.out.println("h1.size = "+h1.size);
		System.out.println("h2.size = "+h2.size);
		System.out.println("main()->ending...");
	}

}	






