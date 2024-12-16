package com.paravar.labs.lab8.demo;

public class Item
{
	private double price;
	private String name;
	
	public String getName()
	{
		return name;
	}	
	public double getPrice()
	{
		return price;	
	}
	
	public void setPrice(double p)
	{
		if(p < 0)
			throw new IllegalArgumentException("price cannot be null, you moron!");
		price = p;	
	}
	
	public Item(String n, double p)
	{
		//first perform invoker input validations!
		if(n == null)
			throw new IllegalArgumentException("name of item cannot null, you nameless!");
		if(p < 0)
			throw new IllegalArgumentException("price cannot be < 0, you moron!");
		name = n;
		price = p;
		
	}
	
}





