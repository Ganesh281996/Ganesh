/*
 * purpose: Takes two command line args and prints wind chill using formula
 * @author Ganesh
 * @since 28 Feb 2018
*/
package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class WindChill
{
	public static void main(String[] args) 
	{
		double t=Double.parseDouble(args[0]);
		double v=Double.parseDouble(args[1]);
		System.out.println("Command Line arguments are "+t+"  "+v);
		if(t>50 && (v>3 && v<120))
		{
			System.out.println("Invalid Inputs");
		}
		else
		{
			double w=Utility.windChill(t, v);
			System.out.println("w="+w);
		}
	}
}