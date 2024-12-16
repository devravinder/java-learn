package com.paravar.labs.lab6.demo;

public class Vehicle
{
	String name;
	public Vehicle()
	{
		
	}
	public Vehicle(String n)
	{
		name = n;	
	}
	public void start()
	{
		System.out.println("Vehicle "+name+" starting....brrrrr");	
	}
	public void stop()
	{
		System.out.println("Vehicle "+name+" stopping....bzz");	
	}
	public void drive()
	{
		System.out.println("Vehicle "+name+" driving....whorroooommm");	
	}
}







