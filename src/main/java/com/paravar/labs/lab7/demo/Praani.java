package com.paravar.labs.lab7.demo;

public class Praani
{
	private String name = "jaanvar";

	public Praani(String a)
	{
		System.out.println("in Praani`s param constr with a = "+a);
		name = a;	
	}
	public Praani()
	{
		System.out.println("in Praani`s no-arg constr");	
	}
	
	public void print()
	{
		System.out.println("I am praani with name "+name);	
	}
	
	public String getName()
	{
		return name;	
	}
	public void setName(String s)
	{
		name = s;	
	}
}
class Bear extends Praani
{
	public Bear()
	{
		super();
		System.out.println("in Bear`s no-arg constr");	
	}
	public void hug()
	{
		System.out.println("bear with name "+ getName() +" hugging...");
	}
}
class MariBear extends Bear
{
	public MariBear()
	{
		super();
		System.out.println("in MariBear`s no-arg constr");
	}
}

class Bull extends Praani
{
	public Bull(String s)
	{
		super(s);
		System.out.println("in Bull`s param constr s = "+s);
		
	}
	
}
class KiddoBull extends Bull
{
	public KiddoBull(String str)
	{
		super(str);
		System.out.println("in KiddoBulls param constr");
	}
}


class TestBear
{
	public static void main(String[] args)
	{
		Bear b = new Bear();
		b.setName("baalu");
		//System.out.println("b.name = "+b.name);
		b.print();
		b.hug();
		
		System.out.println("-------------------");
		
		System.out.println("creating MB obj...");
		MariBear m = new MariBear();
		System.out.println("creating Hen obj...");
		Hen h = new Hen();
		System.out.println("creating a bear obj...");
		Bear b2 = new Bear();
		System.out.println("creating a praani obj...");
		Praani p = new Praani();
		System.out.println("creating a Bull obj...");
		Bull bo = new Bull("Deva");
		System.out.println("name of bo = "+bo.getName());
		KiddoBull kd1 = new KiddoBull("chotu");
		KiddoBull kd2 = new KiddoBull("lambu");
		System.out.println("kd1 name = "+kd1.getName()+" kd2 name = "+kd2.getName());
		
	}
	
}





