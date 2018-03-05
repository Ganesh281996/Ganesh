package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Flip coin and find percentage of heads and tails
 * @author Ganesh
 * @since 28 Feb 2018
*/
public class FlipCoin
{
	public static void main(String[] args) 
	{
		int fliptimes=0;
		Utility utility=new Utility();
		do
		{
			System.out.println("Enter how many times to flip the coin?");
			fliptimes=utility.nextInt();
		}
		while(fliptimes<=0);
		double headpercent=Utility.flipCoin(fliptimes);
		double tailpercent=100-headpercent;
		System.out.println("HeadPercent = "+headpercent+"%");
		System.out.println("Tailpercent = "+tailpercent+"%");
	}
}