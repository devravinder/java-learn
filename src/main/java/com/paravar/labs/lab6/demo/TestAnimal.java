package com.paravar.labs.lab6.demo;

public class TestAnimal
{
	public static void main(String[] args)
	{
		Vet v = new Vet();
		v.name = "Dr.Soma";
		Snake s = new Snake();
		s.name = "Shakuni";
		Dog d = new Dog();
		d.name = "Rambo";
		
		v.treat(s);
		System.out.println("");
		v.treat(d);
		System.out.println("");
		Orangutan o = new Orangutan();
		o.name = "Tambi";
		v.treat(o);
	}

}
