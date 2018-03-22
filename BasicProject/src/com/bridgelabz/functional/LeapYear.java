/*
 * purpose: to find if the given year is leap year or not
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

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
		while(year<0);
		boolean flag=Utility.leapYear(year);
		if(flag==true)
		{
			System.out.println("The year "+year+" is a Leap Year");
		}
		else
		{
			System.out.println("The year "+year+" is not a Leap Year");
		}
	}
}