package com.paravar.labs.lab6.demo;

public class TestVehicle
{
	public static void main(String[] args)
	{
		Mechanic m1 = new Mechanic();
		JCB jcb = new JCB();
		jcb.name = "volvo";
		Scooter s1 = new Scooter();
		s1.name = "bajaj";
		m1.test(jcb);
		System.out.println("");
		m1.test(s1);
		
	
	}
}

