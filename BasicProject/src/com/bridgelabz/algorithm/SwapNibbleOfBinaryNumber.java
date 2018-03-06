package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

/**
 * purpose: swapping nibbles of binary number and finding if the resultant number is power of 2 or not
 * @author Ganesh
 * @since 6 march 2018
 */
public class SwapNibbleOfBinaryNumber 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter number=");
		int number=utility.nextInt();
		boolean flag=Utility.swapNibble(number);
		if(flag==true)
		{
			System.out.println("The decimal number is power of 2");
		}
		else
		{
			System.out.println("It is not power of 2");
		}
	}
}