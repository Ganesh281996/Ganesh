package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class PrimeAnagramPalindrome3 
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