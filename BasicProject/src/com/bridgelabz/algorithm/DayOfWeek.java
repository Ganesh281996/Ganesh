/*
 * purpose: Finding day of given date
 * @author Ganesh
 * @since 1 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class DayOfWeek
{
	public static void main(String[] args) 
	{
		int day=Integer.parseInt(args[0]);
		int month=Integer.parseInt(args[1]);
		int year=Integer.parseInt(args[2]);
		System.out.println("The three command line arguments are ");
		System.out.print(args[0]+"  "+args[1]+"  "+args[2]);
		System.out.println();
		day=Utility.dayOfWeek(day, month, year);
		System.out.println("Day="+day);
	}
}