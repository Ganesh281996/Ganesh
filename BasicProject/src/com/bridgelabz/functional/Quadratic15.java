package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Quadratic15 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter three numbers to find roots");
		double a=scanner.nextDouble();
		double b=scanner.nextDouble();
		double c=scanner.nextDouble();
		double rootarray[]=Utility.quadratic(a, b, c);
		for(int i=0;i<rootarray.length;i++)
		{
			System.out.println("Root"+i+" of x is "+rootarray[i]);
		}
		scanner.close();
	}
}