package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class GuessNumber5 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number such that N=2^n=");
		int bign=scanner.nextInt();
		int mul=2;
		int i;
		if(bign==1)
		{
			i=0;
		}
		else
		{
			for(i=1;i<bign;i++)
			{
				if(mul==bign)
				{
					break;
				}
				mul=mul*2;
			}
		}
		int smalln=i;
		System.out.println("My number=");
		int mynumber=scanner.nextInt();
		Utility.guessNumber(bign, smalln, mynumber);
		scanner.close();
	}
}