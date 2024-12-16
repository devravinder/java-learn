package com.paravar.labs.lab4.demo;

public class TestStringMethods
{
	public static void main(String[] args)
	{
		String str = "rambambo";
		int len = str.length();
		System.out.println("length of string "+str+" = "+len);
		for(int i = len-1; i >= 0 ; i--)
		{
			char c = str.charAt(i);
			System.out.println("c = "+c);
		}
		String s1 = str.substring(0,3);
		System.out.println("s1 = "+s1);
		String s2 = args[0];
		System.out.println("s2 = "+s2);
		
		String s3 = args[1];
		int x = s2.compareTo(s3);
		System.out.println("x =  "+x);
		if(x > 0)
			System.out.println(s2+" > " + s3);
		if(x < 0)
			System.out.println(s2+" < " + s3);
			
		boolean res = s2.equals(s3);
		System.out.println("res = "+res);
		
		String line = "magambo is stronger than rambo";
		String[] words = line.split(" ");
		for(String w : words)
		{
			System.out.println(w +" len = "+w.length());
			
		}
		System.out.println("replacing..."+line.replace("ambo","jumbo"));
		
	}

	
}




