package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

public class WindChill16 
{
	public static void main(String[] args) 
	{
		double t=Double.parseDouble(args[0]);
		double v=Double.parseDouble(args[1]);
		System.out.println("Command Line arguments are "+t+"  "+v);
		double w=Utility.windChill(t, v);
		System.out.println("w="+w);
	}
}