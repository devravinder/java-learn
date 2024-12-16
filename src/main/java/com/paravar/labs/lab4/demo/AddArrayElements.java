package com.paravar.labs.lab4.demo;

/*Take a number of input numbers from the user. Code an add() method that will add all the numbers given and return the result
	(use array of ints as param to the add() method).*/
public class AddArrayElements {

	public static void main(String[] args)
	{
		int len=args.length;
		int[] ar=new int[args.length];
		for(int i=0;i<len;i++)
		{
			int value=Integer.parseInt(args[i]); //converting string to int value.
			ar[i]=value;

		}
		long result=add(ar);
		System.out.println("sum of array elements is  "+result);

	}
	public static long add(int[] arr)//adding of all elements of array.
	{
		long sum=0;
		for(int i=0;i<arr.length;i++)
			sum=sum+arr[i];

		return sum;
	}

}
