/*
 * purpose: Using Binary search on words taken from a a file
 * @author Ganesh
 * @since 1 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class BinarySearchWordFromFile
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		boolean flag=false;
		String string="",path="/home/bridgeit/Ganesh/BasicProject/Files/BinarySearch";
		String stringArray1[],stringArray2[];
		stringArray1=Utility.getFileContents(path);
		stringArray2=new String[stringArray1.length-1];
		for(int i=0;i<stringArray2.length;i++)
		{
			stringArray2[i]=stringArray1[i];
		}
		stringArray2=Utility.bubbleSortString(stringArray2);
		for(int i=0;i<stringArray2.length;i++)
		{
			System.out.println(stringArray2[i]);
		}
		System.out.println("Enter the string to search=");
		string=utility.next();
		flag=Utility.binarySearchString(stringArray2, string);
		if(flag==true)
		{
			System.out.println("The word is present.");
		}
		else
		{
			System.out.println("The word was not found.");
		}
	}
}