package com.paravar.labs.lab7.demo;

public abstract class Insect
{
	String name = "kitanu";
	{
		System.out.println("in inst init of Insect");	
	}
	public Insect()
	{
		System.out.println("in Insect no-arg constr");	
	}
	public abstract void buzz();
}
abstract class Fly extends Insect
{
	public Fly()
	{
		System.out.println("in Fly`s no-arg constr");	
	}
	public void fly()
	{
		System.out.println("Fly flying...");
	}
}
class Millipede extends Insect
{
	public Millipede()
	{
		System.out.println("in Millipede`s no-arg constr");	
	}
	public void buzz()
	{
		System.out.println("Millipede buzzingg..buzzz...");	
	}
}
class TestInsect
{
	public static void main(String[] args)
	{
		Insect i = new Millipede();
		i.buzz();
		Mosquito m = new Mosquito();
		FlyKeeper fk = new FlyKeeper();
		fk.keep(m);
	}
	
}
class Mosquito extends Fly
{
	public Mosquito()
	{
		System.out.println("in Mosquito`s no-arg constr");	
	}
	public void bite()
	{
		System.out.println("Mosquito biting....");	
	}
	public final void buzz()
	{
		System.out.println("Mosquito buzzinggg...ummmmm");	
	}
}
class FlyKeeper
{
	public void keep(Fly f)
	{
		System.out.println("FlyKeeper asked to keep fly");
		f.fly();
		f.buzz();
		if(f instanceof Mosquito)
		{
			Mosquito m = (Mosquito)f;	
			m.bite();
		}
	}
	
}

