package com.paravar.labs.lab8.demo;

public class TestThrow
{
	public static void main(String[] args)
	{	
		System.out.println("main()->starting...");
		try
		{
			System.out.println("going to raise ex...");		
			Exception e = new Exception();
			if(1==1)
				throw e;
			System.out.println("after throwing...");
			
		}
		catch(RuntimeException t)
		{ 	
			t.printStackTrace();
		}
		catch (Exception e){
			e.printStackTrace();
		}

		System.out.println("main()->ending...");
		
	
	}

}
