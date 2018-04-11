package com.bridgelabz.addressbook;

public interface AddressBookManager 
{
	void saveAddressBook(AddressBookImp addressBook,String filePath);
	AddressBookImp openAddressBook(String filePath);
	AddressBookImp newAddressBook(String filePath);
	void printAddressBook(AddressBookImp addressBook);
	void showAllFiles(String folderPath);
}