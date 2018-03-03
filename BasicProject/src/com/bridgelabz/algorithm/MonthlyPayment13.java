package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class MonthlyPayment13 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		double p=Double.parseDouble(args[0]);
		double y=Double.parseDouble(args[1]);
		double r=Double.parseDouble(args[2]);
		System.out.println("Inputs are "+p+"  "+y+"  "+r);
		double payment=Utility.monthlyPayment(p, y, r);
		System.out.println("Payment="+payment);
		scanner.close();
	}
}