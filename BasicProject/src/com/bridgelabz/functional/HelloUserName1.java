package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class HelloUserName1 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		String username;
		do
		{
			System.out.println("Enter Username");
			username=scanner.next();		
		}	
		while(username.length()<3);
		System.out.println(Utility.helloUserName(username));
		scanner.close();
	}
}