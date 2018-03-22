/*
 * purpose: Finding if the number is prime or not
 * @author Ganesh
 * @since 3 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class PrimeNumber
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter Range");
		int number=utility.nextInt();
		for(int i=0;i<=number;i++)
		{
			if(Utility.primeNumber(i))
			{
				System.out.println(i);
			}
		}
	}
}