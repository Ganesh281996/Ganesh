package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Finding numbers which are prime, palindrome and anagram
 * @author Ganesh
 * @since 3 March 2018
*/
public class PrimeAnagramPalindrome
{
	public static void main(String[] args) 
	{
		for(int i=0;i<1000;i++)
		{
			if(Utility.primeNumber(i) && Utility.palindrome(i))
			{
				System.out.println(i);
			}
		}
	}
}