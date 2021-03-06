/*
 * purpose: To find distance using Math.pow() function
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class Distance
{
	public static void main(String[] args) 
	{
		int x=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		System.out.println("Two command line arguments are "+x+" "+y);
		double distance=Utility.distance(x, y);
		System.out.println("The Euclidian Distance is "+distance);
	}
}