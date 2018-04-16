package com.bridgelabz.library;

import java.util.Scanner;

public class LibraryManagement 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int choice=0;
		ManageLogins logins=new ManageLoginsImp();
		do
		{
			System.out.println("Logins");
			System.out.println("1. Admin");
			System.out.println("2. User");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				logins.adminLogin();
				break;
			case 2:
				logins.userLogin();
				break;
			default:
				if(choice>3 || choice<1)
				{
					System.out.println("Invalid Input try again");
					System.out.println("Logins");
					System.out.println("1. Admin");
					System.out.println("2. User");
					System.out.println("3. Exit");
					System.out.println("Enter your choice");
					choice=scanner.nextInt();
				}
			}
		}
		while(choice!=3);
		scanner.close();
	}
}