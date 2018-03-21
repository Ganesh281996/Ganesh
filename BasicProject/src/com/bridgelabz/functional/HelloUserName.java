/*
 * purpose: Take username and print
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class HelloUserName
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		String username;
		do
		{
			System.out.println("Enter Username");
			username=utility.next();		
		}	
		while(username.length()<3);
		System.out.println(Utility.helloUserName(username));
	}
}