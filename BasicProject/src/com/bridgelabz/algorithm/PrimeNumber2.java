package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class PrimeNumber2 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number between o and 1000");
		int number=scanner.nextInt();
		for(int i=0;i<=number;i++)
		{
			if(Utility.primeNumber(i))
			{
				System.out.println(i);
			}
		}
		scanner.close();
	}
}