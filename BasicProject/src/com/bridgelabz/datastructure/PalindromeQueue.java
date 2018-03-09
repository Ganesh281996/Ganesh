package com.bridgelabz.datastructure;

import com.bridgelabz.utility.DeQueue;
import com.bridgelabz.utility.Utility;

public class PalindromeQueue 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the String to check for Palindrome=");
		String string=utility.next();
		DeQueue<Character> dequeue=new DeQueue<Character>(string.length());
		DeQueue<Character> dequeuereverse=new DeQueue<Character>(string.length());
		for(int i=0;i<string.length();i++)
		{
			dequeue.addFront(string.charAt(i));
		}
		for(int i=0;i<string.length();i++)
		{
			dequeuereverse.addRear(string.charAt(i));
		}
		if(dequeue.toString().equals(dequeuereverse.toString()))
		{
			System.out.println("String is Palindrome");
		}
		else
		{
			System.out.println("String is not Palindrome");
		}
	}
}