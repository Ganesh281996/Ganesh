package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class LeapYear3 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int year=0;
		do
		{
			System.out.println("Enter the Year");
			year=scanner.nextInt();
		}
		while(year<1000);
		System.out.println(Utility.leapyear(year));
		scanner.close();
	}
}