package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class TwoDArray9
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);		
		int choice=0;
		do
		{
			System.out.println("1 Integers.");
			System.out.println("2 Double.");
			System.out.println("3 Boolean.");
			System.out.println("4 Exit.");
			System.out.println("Enter your choice=");
			choice=scanner.nextInt();
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
				choice=scanner.nextInt();
			}
		}
		while(choice!=4);
		scanner.close();
	}
}