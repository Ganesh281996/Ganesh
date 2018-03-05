package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Reading and Printing 2d arrays of integer double and boolean
 * @author Ganesh
 * @since 28 Feb 2018
*/
public class TwoDArray
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();		
		int choice=0;
		do
		{
			System.out.println("1 Integers.");
			System.out.println("2 Double.");
			System.out.println("3 Boolean.");
			System.out.println("4 Exit.");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			switch(choice)
			{
			case 1:Utility.integer2DArray();
				break;
			case 2:Utility.double2DArray();
				break;
			case 3:Utility.boolean2DArray();
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid input Enter again");
				System.out.println("1 Integers.");
				System.out.println("2 Double.");
				System.out.println("3 Boolean.");
				System.out.println("4 Exit.");
				System.out.println("Enter your choice=");
				choice=utility.nextInt();
			}
		}
		while(choice!=4);
	}
}