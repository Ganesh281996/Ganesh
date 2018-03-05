package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Finding elapsed time between search and sorting methods
 * @author Ganesh
 * @since 3 March 2018
*/
public class SearchSortMethods
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Input size of Arrays=");
		long currenttime;
		int elapsedsize=0;
		boolean flag;
		int size=utility.nextInt();
		int inputintegerarray[]=new int[size];
		int outputintegerarray[]=new int[size];
		long elapsedtime[]=new long[6];
		String inputstringarray[]=new String[size];
		String outputstringarray[]=new String[size];
		System.out.println("Input integer array=");
		for(int i=0;i<size;i++)
		{
			inputintegerarray[i]=utility.nextInt();
		}
		System.out.println("Input String array=");
		for(int i=0;i<size;i++)
		{
			inputstringarray[i]=utility.next();
		}
		System.out.println("Enter number to search in integer array=");
		int number=utility.nextInt();
		System.out.println("Enter String to search in String array=");
		String string=utility.next();
		
		currenttime=System.currentTimeMillis();
		outputintegerarray=Utility.bubbleSortInteger(inputintegerarray);
		elapsedtime[elapsedsize]=System.currentTimeMillis()-currenttime;
		System.out.println("Bubble Sort Integer");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputintegerarray[i]+"  ");
		}
		System.out.println();
		
		currenttime=System.currentTimeMillis();
		outputstringarray=Utility.bubbleSortString(inputstringarray);
		elapsedtime[elapsedsize++]=System.currentTimeMillis()-currenttime;
		System.out.println("Bubble Sort String");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputstringarray[i]+"  ");
		}
		System.out.println();
		
		currenttime=System.currentTimeMillis();
		outputintegerarray=Utility.insertionSortInteger(inputintegerarray);
		elapsedtime[elapsedsize++]=System.currentTimeMillis()-currenttime;
		System.out.println("Insertion Sort Integer");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputintegerarray[i]+"  ");
		}
		System.out.println();
		
		currenttime=System.currentTimeMillis();
		outputstringarray=Utility.insertionSortString(inputstringarray);
		elapsedtime[elapsedsize++]=System.currentTimeMillis()-currenttime;
		System.out.println("Insertion Sort String");
		for(int i=0;i<size;i++)
		{
			System.out.print(outputstringarray[i]+"  ");
		}
		System.out.println();
		
		currenttime=System.currentTimeMillis();
		flag=Utility.binarySearchInteger(inputintegerarray, number);
		elapsedtime[elapsedsize++]=System.currentTimeMillis()-currenttime;
		System.out.println("Binary Search Integer");
		System.out.println(flag);
		
		currenttime=System.currentTimeMillis();
		flag=Utility.binarySearchString(inputstringarray, string);
		elapsedtime[elapsedsize++]=System.currentTimeMillis()-currenttime;
		System.out.println("Binary Search String");
		System.out.println(flag);
		
		System.out.println("Bubble Sort Integer");
		System.out.println("Bubble Sort String");
		System.out.println("Insertion Sort Integer");
		System.out.println("Insertion Sort String");
		System.out.println("Binary Search Integer");
		System.out.println("Binary Search String");
		for(int i=0;i<size;i++)
		{
			System.out.print(elapsedtime[i]+"  ");
		}
		System.out.println();
		
		elapsedtime=Utility.sortLongDesc(elapsedtime);
		System.out.println("After sorting in descending order=");
		for(int i=0;i<elapsedsize;i++)
		{
			System.out.print(elapsedtime[i]+"  ");
		}
	}
}