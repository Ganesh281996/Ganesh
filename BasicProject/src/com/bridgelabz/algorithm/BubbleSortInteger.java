package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class BubbleSortInteger 
{	
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of array=");
		int size=scanner.nextInt();
		int array[]=new int[size];
		System.out.println("Enter elements in array=");
		for(int i=0;i<size;i++)
		{
			array[i]=scanner.nextInt();
		}
		array=Utility.bubbleSortInteger(array);
		System.out.println("Sorted Array");
		for(int i=0;i<size;i++)
		{
			System.out.println(array[i]);
		}
		scanner.close();
	}
}