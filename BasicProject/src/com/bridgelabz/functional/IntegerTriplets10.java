package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class IntegerTriplets10 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int arraysize;
		System.out.println("Enter Size of array=");
		arraysize=scanner.nextInt();
		int array[]=new int[arraysize];
		System.out.println("Enter "+arraysize+" numbers=");
		for(int i=0;i<arraysize;i++)
		{
			array[i]=scanner.nextInt();
		}
		Utility.integerTriplet(array);
		scanner.close();
	}
}