/*
 * purpose: Prints the nth Harmonic number 1/1+1/2+...+1/N 
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class HarmonicNumber
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int harmonicNumber=0;
		do
		{
			System.out.println("Enter Harmonic Number greater than 0");
			harmonicNumber=utility.nextInt();
		}
		while(harmonicNumber<=0);
		System.out.println(Utility.harmonicNumber(harmonicNumber));
	}
}