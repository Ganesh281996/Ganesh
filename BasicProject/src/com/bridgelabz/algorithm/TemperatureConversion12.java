package com.bridgelabz.algorithm;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class TemperatureConversion12 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		double celsius=0,fahrenheit=0;
		do
		{
			System.out.println("1 Enter Celsius");
			System.out.println("2 Enter Fahrenheit");
			System.out.println("3 Exit.");
			System.out.println("Enter your choice=");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter in Celsius=");
				celsius=scanner.nextInt();
				fahrenheit=Utility.celsiusToFahrenheit(celsius);
				System.out.println("Fahrenheit="+fahrenheit);
				break;
			case 2:
				System.out.println("Enter in Fahrenheit=");
				fahrenheit=scanner.nextInt();
				celsius=Utility.fahrenheitToCelsius(fahrenheit);
				System.out.println("Celsius="+celsius);
				break;
			case 3:
				break;
			default:
				System.out.println("Invalid choice enter again.");
				System.out.println("1 Enter Celsius");
				System.out.println("2 Enter Fahrenheit");
				System.out.println("3 Exit.");
				System.out.println("Enter your choice=");
				choice=scanner.nextInt();
			}
		}
		while(choice!=3);
		scanner.close();
	}
}