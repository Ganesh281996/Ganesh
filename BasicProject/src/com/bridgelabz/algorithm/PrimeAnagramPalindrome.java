/*
 * purpose: Finding numbers which are prime, palindrome and anagram
 * @author Ganesh
 * @since 3 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramPalindrome
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the range=");
		int range=utility.nextInt();
		Utility.primePalindromeAnagram(range);
	}
}