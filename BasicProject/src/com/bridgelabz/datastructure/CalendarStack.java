/**
 * Purpose creating calendar using Stack
 * @author Ganesh
 * @since  4 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Stack;
import com.bridgelabz.utility.Utility;

public class CalendarStack 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the Year =");
		int year=utility.nextInt();
		System.out.println("Enter the Month=");
		int month=utility.nextInt();
		String array[][]=Utility.calender(year, month);
		Stack<String> weekdays[]=Utility.calendarStack(array);
		String arr[];
		for(int i=0;i<7;i++)
		{
			arr=weekdays[i].retrieve();
			for(int j=0;j<7;j++)
			{
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
	}
}