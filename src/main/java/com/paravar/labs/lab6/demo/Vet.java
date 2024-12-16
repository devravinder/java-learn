package com.paravar.labs.lab6.demo;

public class Vet
{
	String name;
	
	public void treat(Animal a) // polymorphic code
	{
		System.out.println("Vet "+name+" treating animal "+a.name);
		if(a instanceof Dog)
		{
			Dog d = (Dog) a;
			d.bark();
		}

		a.dance();
		a.eat();
		a.sleep();
		
	}

}
