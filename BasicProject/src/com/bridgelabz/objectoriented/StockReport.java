package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Utility;

public class StockReport 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		String path="/home/bridgeit/Ganesh/BasicProject/Files/StockReport";
		System.out.println("Enter Number of Stocks=");
		int no_of_stocks=utility.nextInt();
		Utility.stockReport(no_of_stocks,path);
	}
}