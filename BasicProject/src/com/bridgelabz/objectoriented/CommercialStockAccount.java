/**
 * Purpose managing commercial stock account . Buying and selling shares using json
 * @author Ganesh
 * @since 16 March 2018
 */
package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Customer;
import com.bridgelabz.utility.StockAccount;
import com.bridgelabz.utility.Utility;

public class CommercialStockAccount 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		Customer customer=null;
		StockAccount account=new StockAccount();
		StockAccount stockAccount=new StockAccount();
		String name=null,symbol=null;;
		long money=0,noOfShares=0,priceOfEachShare=0;
		long total_share=0;
		int choice=0;
		do
		{
			System.out.println("1. Create Account");
			System.out.println("2. Buy Shares");
			System.out.println("3. Sell Shares");
			System.out.println("4. Add Company");
			System.out.println("5. Remove Company");
			System.out.println("6. Display Transaction Details");
			System.out.println("7. Display Report");
			System.out.println("8. Exit");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter your Name=");
				name=utility.next();
				System.out.println("Enter Initial Money=");
				money=utility.nextLong();
				customer=new Customer(name, money, total_share);
				account=new StockAccount(customer);
				break;
			case 2:
				System.out.println("Enter your Name=");
				name=utility.next();
				System.out.println("Enter the Symbol of company to buy Shares=");
				symbol=utility.next();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.nextLong();
				stockAccount.buy(symbol, noOfShares, name);
				break;
			case 3:
				System.out.println("Enter your Name=");
				name=utility.next();
				System.out.println("Enter the Symbol of company to buy Shares=");
				symbol=utility.next();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.nextLong();
				stockAccount.sell(symbol, noOfShares, name);
				break;
			case 4:
				System.out.println("Enter the Symbol of Company to Add in File=");
				symbol=utility.next();
				System.out.println("Enter no of Shares=");
				noOfShares=utility.nextLong();
				System.out.println("Enter Price of Shares");
				priceOfEachShare=utility.nextLong();
				stockAccount.addNewSymbol(symbol, noOfShares, priceOfEachShare);
				break;
			case 5:
				System.out.println("Enter the Symbol of Company to Add in File=");
				symbol=utility.next();
				account.removeSymbol(symbol);
				break;
			case 6:
				stockAccount.displayTransactionDetails();
				break;
			case 7:
				stockAccount.displayReport();
				break;
			}
		}
		while(choice!=8);
	}
}