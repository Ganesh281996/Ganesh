/*
 * purpose: Finding elapsed time between two inputs
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class StopWatch
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter a number to start stopwatch=");
		utility.nextInt();
		double elapsedTime=Utility.stopWatch();
		System.out.println("Elapsed Time="+elapsedTime+" Seconds");
	}
}