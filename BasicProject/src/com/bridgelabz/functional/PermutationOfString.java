package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/*
 * purpose: To find all combinations of given String
 * @author Ganesh
 * @since 28 Feb 2018
*/
public class PermutationOfString
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the String=");
		String string=utility.next();
		Utility.permutationOfStringIterative(string);
	}
}