package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class Distance11 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		
		int x=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		System.out.println("Two command line arguments are "+x+" "+y);
		double distance=Utility.distance(x, y);
		System.out.println("The Euclidian Distance is "+distance);
		scanner.close();
	}
}