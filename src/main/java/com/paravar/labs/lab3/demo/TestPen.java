package com.paravar.labs.lab3.demo;

public class TestPen
{
	public static void main(String[] args)
	{
		Pen p1 = new Pen();
		p1.color = "black";
		System.out.println("inkQty in p1 = "+p1.inkQty);
		p1.refill(2);
		System.out.println("inkQty in p1 = "+p1.inkQty);
		p1.write("omg!tomo is bandh!hurray!");
		System.out.println("inkQty in p1 = "+p1.inkQty);
		p1.write("hohohahahahhahooo");
		System.out.println("inkQty in p1 = "+p1.inkQty);
		p1.write("what to write only i dont know...");
		//Pen p2 = new Pen();
		//p2.color = "red";
		
	
	}
}
