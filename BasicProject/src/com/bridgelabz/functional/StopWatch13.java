package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class StopWatch13 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter a number to start stopwatch=");
		scanner.nextInt();
		long elapsedtime=Utility.stopWatch();
		System.out.println("Elapsed Time="+elapsedtime+" MilliSeconds");
		scanner.close();
	}
}