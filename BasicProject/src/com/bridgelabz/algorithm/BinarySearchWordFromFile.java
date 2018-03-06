package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Using Binary search on words taken from a a file
 * @author Ganesh
 * @since 1 March 2018
*/
public class BinarySearchWordFromFile
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		boolean flag=false;
		String string="",path="/home/bridgeit/Ganesh/Files/BinarySearch";
		String stringarray1[],stringarray[];
		stringarray1=Utility.getFileContents(path);
		stringarray=new String[stringarray1.length-1];
		for(int i=0;i<stringarray.length;i++)
		{
			stringarray[i]=stringarray1[i];
		}
		stringarray=Utility.bubbleSortString(stringarray);
		for(int i=0;i<stringarray.length;i++)
		{
			System.out.println(stringarray[i]);
		}
		System.out.println("Enter the string to search=");
		string=utility.next();
		flag=Utility.binarySearchString(stringarray, string);
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