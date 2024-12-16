package com.paravar.labs.lab7.demo;

public class Jaanvar
{
	String name = "jantuhu";
	
	public Jaanvar(String name)
	{ 
		//local variable hides instance variable!
		this.name = name;
	}
	public static void main(String[] args)
	{
		//Jaanvar j1 = new Jaanvar("praani");
		//System.out.println("j1.name = "+j1.name);
		MariElephant m1 = new MariElephant("jambu");
		System.out.println("m1.name = "+m1.name); //mariaane!!!
		Elephant e1 = m1;
		System.out.println("e1.name = "+e1.name); // haathi!!
		Jaanvar j = e1;
		System.out.println("j.name = "+j.name); // jambu!!!
	}
}
class Elephant extends Jaanvar
{
	String name = "haathi"; // redeclaration of name...2 copies!!!!
	public Elephant(String name)
	{
		super(name);
		System.out.println("in Elephants param constr name = "+super.name);
	}
	
}
class MariElephant extends Elephant
{
	String name = "mariaane";
	public MariElephant(String n)
	{
		super(n);	
	}
}




