package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class PowerValue4 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int power=Integer.parseInt(args[0]);
		if(power>=0 &&power<31)
		{
			Utility.powerValue(power);
		}
		else
		{
			System.out.println("The number is not between 0 and 31");
		}	
		scanner.close();
	}
}