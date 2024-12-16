package com.paravar.labs.lab7.demo;

class P
{
	
}
final class Y extends P
{
	int x = 10;
	public void test()
	{
		x = 30;	
	}
}
/*
class Z extends Y
{
	
}
*/
public class TestFinal
{
	
	public static void main(String[] args)
	{
		X obj1 = new X(50);
		System.out.println("obj1.val = "+obj1.val);
		System.out.println("obj1.arr[0] = "+obj1.arr[0]);
		obj1.arr[0] = 100; // will compile!!!
		System.out.println("obj1.arr[0] = "+obj1.arr[0]);
		//obj.val++;
		X obj2 = new X(60);
		System.out.println("obj2.arr[0] = "+obj2.arr[0]);
		System.out.println("obj2.val = "+obj2.val);
		//obj1.arr = new int[10]; //??
		
		System.out.println("X.T = "+X.T);
		//X.T = 30;
	}
}
class X
{
	public static final int T;  // constant!!
	static
	{
		T = (int)(Math.random()*100);	
	}
	
	final int[] arr = {10,20,30}; // instance ref var
	final int val; // instance primitive var	
	{
		System.out.println("in inst init of X ");
		//val = 20;
	}
	public X(int a)
	{
		val  = a;	
	}
	public void test()
	{
	//	val++;	
	}
}
