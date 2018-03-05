package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Using Insertion Sort on Strings
 * @author Ganesh
 * @since 1 March 2018
*/
public class InsertionSortString
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the size of array=");
		int size=utility.nextInt();
		String array[]=new String[size];
		System.out.println("Enter elements in array=");
		for(int i=0;i<size;i++)
		{
			array[i]=utility.next();
		}
		array=Utility.insertionSortString(array);
		System.out.println("Sorted Array");
		for(int i=0;i<size;i++)
		{
			System.out.println(array[i]);
		}
	}
}