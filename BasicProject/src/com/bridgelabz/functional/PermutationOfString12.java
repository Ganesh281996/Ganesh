package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class PermutationOfString12 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String=");
		String string=scanner.next();
		Utility.permutationOfStringIterative(string);
		scanner.close();
	}
}