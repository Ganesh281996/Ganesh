/*
 * purpose: Finding elapsed time between search and sorting methods
 * @author Ganesh
 * @since 3 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class SearchSortMethods
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Input size of Arrays=");
		long currentTime=0;
		int elapsedSize=0;
		boolean flag;
		int size=utility.nextInt();
		int inputIntegerArray[]=new int[size];
		int outputIntegerArray[]=new int[size];
		long elapsedTime[]=new long[6];
		String inputStringArray[]=new String[size];
		String outputStringArray[]=new String[size];
		System.out.println("Input integer array=");
		for(int i=0;i<size;i++)
		{
			inputIntegerArray[i]=utility.nextInt();
		}
		System.out.println("Input String array=");
		for(int i=0;i<size;i++)
		{
			inputStringArray[i]=utility.next();
		}
		System.out.println("Enter number to search in integer array=");
		int number=utility.nextInt();
		System.out.println("Enter String to search in String array=");
		String string=utility.next();
		
		currentTime=System.nanoTime();
		outputIntegerArray=Utility.bubbleSortInteger(inputIntegerArray);
		elapsedTime[elapsedSize++]=System.nanoTime()-currentTime;
		System.out.println("Bubble Sort Integer");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputIntegerArray[i]+"  ");
		}
		System.out.println();
		
		currentTime=System.nanoTime();
		outputStringArray=Utility.bubbleSortString(inputStringArray);
		elapsedTime[elapsedSize++]=System.nanoTime()-currentTime;
		System.out.println("Bubble Sort String");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputStringArray[i]+"  ");
		}
		System.out.println();
		
		currentTime=System.nanoTime();
		outputIntegerArray=Utility.insertionSortInteger(inputIntegerArray);
		elapsedTime[elapsedSize++]=System.nanoTime()-currentTime;
		System.out.println("Insertion Sort Integer");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputIntegerArray[i]+"  ");
		}
		System.out.println();
		
		currentTime=System.nanoTime();
		outputStringArray=Utility.insertionSortString(inputStringArray);
		elapsedTime[elapsedSize++]=System.nanoTime()-currentTime;
		System.out.println("Insertion Sort String");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputStringArray[i]+"  ");
		}
		System.out.println();
		
		currentTime=System.nanoTime();
		flag=Utility.binarySearchInteger(inputIntegerArray, number);
		elapsedTime[elapsedSize++]=System.nanoTime()-currentTime;
		System.out.println("Binary Search Integer");
		System.out.println(flag);
		
		currentTime=System.nanoTime();
		flag=Utility.binarySearchString(inputStringArray, string);
		elapsedTime[elapsedSize++]=System.nanoTime()-currentTime;
		System.out.println("Binary Search String");
		System.out.println(flag);
		
		System.out.println("Bubble Sort Integer");
		System.out.println("Bubble Sort String");
		System.out.println("Insertion Sort Integer");
		System.out.println("Insertion Sort String");
		System.out.println("Binary Search Integer");
		System.out.println("Binary Search String");
		System.out.println("BI     BS     II     IS     BI     BS");
		for(int i=0;i<6;i++)
		{
			System.out.print(elapsedTime[i]+"  ");
		}
		System.out.println();
		
		elapsedTime=Utility.sortLongDesc(elapsedTime);
		System.out.println("After sorting in descending order=");
		for(int i=0;i<6;i++)
		{
			System.out.print(elapsedTime[i]+"  ");
		}
	}
}