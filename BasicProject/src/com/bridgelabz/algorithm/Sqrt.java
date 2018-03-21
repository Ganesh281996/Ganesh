/*
 * purpose: Finding square root of positive integer
 * @author Ganesh
 * @since 3 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class Sqrt
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter value of c=");
		double c=utility.nextDouble();
		c=Utility.sqrt(c);
		System.out.println("Square Root="+c);
	}
}