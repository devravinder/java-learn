package com.paravar.labs.lab7.demo;

//design of an immutable class!!
//=> final class with final inst var with paramterized constr!!!
public final class Human
{
	public final String name;
	public final int age;
	
	public Human(String n, final int a)
	{
		name = n;
		age = a;
	}
	public static void main(String[] args)
	{
		Human h1 = new Human("Hanuman",40);
		Human h2 = new Human("Babaji",18);
		System.out.println("h1.name = "+h1.name+" h1.age = "+h1.age);
		//h1.age = 30;
		
		
	}
}
