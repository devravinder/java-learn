package com.paravar.labs.lab3.demo;

public class Pen
{	
	int inkQty;
	String color;
	
	public void write(String data)
	{
		if(inkQty > 0)
		{
			System.out.println("Pen writing "+ data+" in "+color+" color");
			inkQty--;
		}
		else
			System.out.println("Yakappa, first fill ink and then write maadi...");
	}
	public void refill(int qty)
	{
		inkQty = inkQty + qty;
	}

}






