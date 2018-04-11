package com.bridgelabz.addressbook;

import com.bridgelabz.utility.Utility;

public class MainAddressBook
{
	public static void main(String[] args) 
	{
		int choice=0;
		String filePath=null;
		String folderPath="/home/bridgeit/Ganesh//BasicProject/Files/AddressBookFiles/";
		AddressBookManager manager=new AddressBookManagerImp();
		MainAddressBook mainAddressBook=new MainAddressBook();
		AddressBookImp addressBook=null;
		Utility utility=new Utility();	
		
		do
		{
			System.out.println("      Main Menu");
			System.out.println("1. Show All Files");
			System.out.println("2. Open Existing Address Book");
			System.out.println("3. Create New Address Book");
			System.out.println("4. Print Current Address Book");
			System.out.println("5. Save Address Book");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice=");
			choice=utility.nextInt();
			
			switch(choice)
			{
			case 1:
				manager.showAllFiles(folderPath);
				break;
			
			case 2:
				System.out.println("Enter Address Book Name");
				filePath=folderPath+utility.next()+".txt";
				addressBook=manager.openAddressBook(filePath);
				manager.printAddressBook(addressBook);
				addressBook=mainAddressBook.addressBookMenu(filePath, addressBook);
				break;
				
			case 3:
				System.out.println("Enter Address Book Name");
				filePath=folderPath+utility.next()+".txt";
				addressBook=manager.newAddressBook(filePath);
				System.out.println("Empty Address Book has been created.");
				addressBook=mainAddressBook.addressBookMenu(filePath, addressBook);
				System.out.println(addressBook.getPersonList());
				break;
				
			case 4:
				manager.printAddressBook(addressBook);
				break;
				
			case 5:
				manager.saveAddressBook(addressBook, filePath);
				System.out.println("Address Book has been Saved.");
				break;
			}
		}
		while(choice!=6);
	}
	
	AddressBookImp addressBookMenu(String filePath,AddressBookImp addressBook)
	{
		int choice=0;
		long phoneNumber=0;
		Utility utility=new Utility();
		AddressBookManagerImp manager=new AddressBookManagerImp();
		
		do
		{
			System.out.println("Address Book Menu");
			System.out.println("1. Add Person");
			System.out.println("2. Edit Person");
			System.out.println("3. Delete Person");
			System.out.println("4. Sort By Name");
			System.out.println("5. Sort By Zip Code");
			System.out.println("6. Print Current Address Book");
			System.out.println("7. Exit");
			System.out.println("Enter your Choice=");
			choice=utility.nextInt();
			
			switch(choice)
			{
			case 1:
				addressBook.addPerson();
				break;
				
			case 2:
				System.out.println("Enter Phone Number");
				phoneNumber=utility.nextLong();
				addressBook.editPerson(phoneNumber);
				break;
				
			case 3:
				System.out.println("Enter Phone Number");
				phoneNumber=utility.nextLong();
				addressBook.deletePerson(phoneNumber);
				break;
				
			case 4:
				addressBook=addressBook.sortByName();
				break;
				
			case 5:
				addressBook=addressBook.sortByZip();
				break;
				
			case 6:
				manager.printAddressBook(addressBook);
				break;
			}
		}
		while(choice!=7);
		return addressBook;
	}
}