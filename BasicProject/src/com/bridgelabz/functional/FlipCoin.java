/*
 * purpose: Flip coin and find percentage of heads and tails
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class FlipCoin
{
	public static void main(String[] args) 
	{
		int flipTimes=0;
		Utility utility=new Utility();
		do
		{
			System.out.println("Enter how many times to flip the coin?");
			flipTimes=utility.nextInt();
		}
		while(flipTimes<=0);
		double headPercent=Utility.flipCoin(flipTimes);
		double tailPercent=100-headPercent;
		System.out.println("HeadPercent = "+headPercent+"%");
		System.out.println("Tailpercent = "+tailPercent+"%");
	}
}