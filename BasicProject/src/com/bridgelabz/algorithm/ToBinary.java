/*
 * purpose: Converting given decimal number to Binary
 * @author Ganesh
 * @since 3 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class ToBinary
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the number=");
		int number=utility.nextInt();
		String ans=Utility.toBinary(number);
		System.out.println("Binary Form="+ans);
	}
}