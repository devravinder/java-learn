package com.paravar.labs.lab6.demo;

public class Mechanic
{
	public void test(Vehicle v)
	{
		System.out.println("Mechanic going to test vehicle with name "+v.name);
		v.start();
		if(v instanceof JCB)
		{
			JCB j1 = (JCB) v;
			j1.showHand();
		}
		if(v instanceof Scooter)
		{
			Scooter s = (Scooter) v;
			s.makeSound();
		}
		
		v.drive();
		v.stop();
	
	}

}
