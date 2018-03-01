package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Gambler7 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your stakes=");
		int stake=scanner.nextInt();
		System.out.println("Enter the goal=");
		int goal=scanner.nextInt();
		System.out.println("Enter how many times=");
		int times=scanner.nextInt();
		Utility.gambler(stake, goal, times);
		scanner.close();
	}
}