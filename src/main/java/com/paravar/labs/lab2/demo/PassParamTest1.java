package com.paravar.labs.lab2.demo;

public class PassParamTest1
{
	public static void process()
	{
		System.out.println("in process()");
	}
	public static void main(String[] args)
	{
		System.out.println("main() starting...");
		PassParamTest1.process();
		System.out.println("main() ending...");
	}
}
class ParamTest2
{
	public static void process(int x) // x is local to this method
	{
		System.out.println("in process() x = "+x);
		x = 45;
		//does y value change? can we access y here?
		System.out.println("in process() x = "+x);
	}
	public static void main(String[] args)
	{
		System.out.println("main() starting...");
		int y = 10; // local variable. Where is this stored?
		System.out.println("main() y = "+y);
		ParamTest2.process(y); // is y passed or its copy?
		System.out.println("main() y = "+y);
		System.out.println("main() ending...");
	}
}
class ParamTest3
{
	public static int process(int x) // x is local to this method
	{
		System.out.println("in process() x = "+x);
		x = 45;
		//does y value change? can we access y here?
		System.out.println("in process() x = "+x);
		return x;
		//can you have statements after return?
	}
	public static void main(String[] args)
	{
		System.out.println("main() starting...");
		int y = 10; // local variable. Where is this stored?
		System.out.println("main() y = "+y);
		y = ParamTest3.process(y); 
		System.out.println("main() y = "+y); // has y valued changed?
		System.out.println("main() ending...");
	}
}
