package com.paravar.labs.lab7.demo;

public class Graduate
{
	static int count  = 1; // static F.I
	static 
	{
		++count;
		System.out.println("in static init of Graduate count = "+count);
	}
	String name = "Mr.Ping"; // inst F.I
	int age;
	{ // inst init
		System.out.println("in inst init of Graduate ");
		age = 20;
	}	
	public Graduate()
	{
		System.out.println("in Graduate no-arg constr count = "+count+ " name = "+name+" age = "+age);	
		
	}
}
class TestGraduate
{
	
	public static void main(String[] args)
	{
		Graduate g1 = null;
	//	System.out.println("main()->Graduate.count = "+Graduate.count);
	//	System.out.println("main()->g1.count = "+g1.count);
	
		//g1 = new Graduate();
		//System.out.println("main()->g1.name = "+g1.name+" g1.age = "+g1.age+" g1.count = "+g1.count);
		
		PostGraduate pg = new PostGraduate();
		
		System.out.println("main()->ending...");
	}
}

class PostGraduate extends Graduate
{	
	static int x = 3;
	static
	{
		System.out.println("in static init of PG x = "+x);	
	}
	int y = 30;
	{
		System.out.println("in inst init of PG y = "+y);	
	}
	public PostGraduate()
	{
		System.out.println("in PG no-arg constr");	
	}
	
}


