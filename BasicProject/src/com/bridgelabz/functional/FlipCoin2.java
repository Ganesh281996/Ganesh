package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class FlipCoin2
{
	public static void main(String[] args) 
	{
		int fliptimes=0;
		Scanner scanner=new Scanner(System.in);
		do
		{
			System.out.println("Enter how many times to flip the coin?");
			fliptimes=scanner.nextInt();
		}
		while(fliptimes<=0);
		double headpercent=Utility.flipCoin(fliptimes);
		double tailpercent=100-headpercent;
		System.out.println("HeadPercent = "+headpercent+"%");
		System.out.println("Tailpercent = "+tailpercent+"%");
		scanner.close();
	}
}