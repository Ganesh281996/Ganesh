/*
 * purpose: converting temperature from fahrenheit to celsius and vice versa
 * @author Ganesh
 * @since 3 March 2018
*/
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class TemperatureConversion
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int choice=0;
		double celsius=0,fahrenheit=0;
		do
		{
			System.out.println("1 Enter Celsius");
			System.out.println("2 Enter Fahrenheit");
			System.out.println("3 Exit.");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter in Celsius=");
				celsius=utility.nextInt();
				fahrenheit=Utility.celsiusToFahrenheit(celsius);
				System.out.println("Fahrenheit="+fahrenheit);
				break;
			case 2:
				System.out.println("Enter in Fahrenheit=");
				fahrenheit=utility.nextInt();
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
				choice=utility.nextInt();
			}
		}
		while(choice!=3);
	}
}