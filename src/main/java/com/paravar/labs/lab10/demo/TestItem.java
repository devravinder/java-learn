package com.paravar.labs.lab10.demo;

import java.util.ArrayList;


class Item
{
	private String name;
	private double price;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof Item)
		{
			Item it = (Item) o;
			if(this.name.equals(it.name) && this.price == it.price)
					return true;
			else
				return false;
		}
		else
			return false;
	}
	
	@Override
	public String toString() {
		
		return "Item:"+name+","+price;
	}
	
}

public class TestItem {

	public static void main(String[] args) {
		

		Item it1 = new Item("pen",60);
		Item it2 = new Item("pen",60);
		System.out.println("it1==it2 > "+(it1==it2));
		System.out.println("it1.equals(it2) - "+it1.equals(it2));
	
		System.out.println("it1 = "+it1);
		
		ArrayList list = new ArrayList();
		list.add(it1);
		System.out.println("is it2 present in col = "+list.contains(it2));
		System.out.println(list);
		list.remove(it1);
		System.out.println(list);
	
	}

}







