package com.paravar.labs.lab3.demo;

public class Croc {
	String name;
	public void eat(Fish f)
	{
		System.out.println(" croc name is"+"  "+name+"  "+"fish name is"+"  "+f.name);
		//f=null;//it wont affects
		f=new Fish();//creating new fish object assaigning new name to it
		f.name="flippy";
		System.out.println(" after croc name is"+"  "+name+"  "+"fish name is"+"  "+f.name);//prints fish name as flippy
	}
	

}
