package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class CouponNumber8
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter number of distinct coupon number=");
		int number=scanner.nextInt();
		Utility.couponNumber(number);
		scanner.close();
	}
}