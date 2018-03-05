package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/*
 * purpose: to find if the given year is leap year or not
 * @author Ganesh
 * @since 28 Feb 2018
*/
public class LeapYear
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int year=0;
		do
		{
			System.out.println("Enter the Year");
			year=utility.nextInt();
		}
		while(year<1000);
		System.out.println(Utility.leapyear(year));
	}
}