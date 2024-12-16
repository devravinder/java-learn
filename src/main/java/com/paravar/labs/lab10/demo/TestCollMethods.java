package com.paravar.labs.lab10.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollMethods {

	public static void main(String[] args) {
		
		HashSet col = new HashSet();
		
		String s1 = "TheLift";
		String s2 = "Happy New Year";
		String s3 = "Agent Vinod!";
		String s4 = "Ra.1";
		String s5 = "Humshakals";
		String s6 = new String("Ra.1");
		
		System.out.println("is s4==s6 ? "+(s4==s6));
		System.out.println("is s4.equals(s6) ? "+(s4.equals(s6)));
		

		System.out.println("adding "+s1+" into list = "+col.add(s1));
		System.out.println("adding "+s2+" into list = "+col.add(s2));
		System.out.println("adding "+s3+" into list = "+col.add(s3));
		System.out.println("adding "+s4+" into list = "+col.add(s4));
		System.out.println("adding "+s5+" into list = "+col.add(s5));
		System.out.println("adding "+s5+" into list = "+col.add(s5));		
		
		System.out.println(col);
		System.out.println("size = "+col.size());
		
		String s7 = "Agent Vinod!";
		
		System.out.println("searching "+s7+" in col = "+col.contains(s7));
		
		col.remove(s7);
		System.out.println(col);
		//col.clear();
		System.out.println("is col empty = "+col.isEmpty());
		
		
		Collection col2 = new ArrayList();
	
		col2.addAll(col);
		
		System.out.println("col2 = "+col2);
		col2.add(s5);
		col2.add(s5);
		col2.add(s5);
		col2.add("Hero");
		col2.add("Finding Fanny");
		
	//	col2.removeAll(col);
		col2.add("HumTum");
		
		System.out.println("col2 = "+ col2);
		
		System.out.println("col2.contains(Hum) = "+col2.contains("Hum") );
		
		
		for(Object o : col2)
		{
			
			String s = (String) o;
			//System.out.println(s);
			if(s.contains("Hum"))
				System.out.println(s+" contains Hum!");
			
		}
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");		
	}

}









