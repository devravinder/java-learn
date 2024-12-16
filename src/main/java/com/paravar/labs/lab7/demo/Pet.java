package com.paravar.labs.lab7.demo;

public interface Pet
{
	int X = 10; // p.st.f
	String NAME = "Pingu";
	
	public void play();
}

class Hen implements Pet
{
	public void play()
	{
		System.out.println("Hen playing...");	
	}
}
class TestHen
{
	public static void main(String[] args)
	{
		Pet p = new Hen();
		System.out.println("Pet.X = "+Pet.X+" Pet.NAME = "+Pet.NAME);
		p.play();
	}
	
}
