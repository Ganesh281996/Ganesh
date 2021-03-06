/*
 * purpose: Finding if the two strings are anagram of each other or not
 * @author Ganesh
 * @since 1 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class Anagram
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter two Strings=");
		String string1=utility.nextLine();
		String string2=utility.nextLine();
		string1=string1.replaceAll(" ", "");
		string2=string2.replaceAll(" ", "");
		boolean flag=Utility.findingAnagram(string1, string2);
		if(flag)
		{
			System.out.println("Two Strings are anagram.");
		}
		else
		{
			System.out.println("Two Strings are not anagram.");
		}
	}
}