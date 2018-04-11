package com.bridgelabz.addressbook;

public interface AddressBook 
{
	void addPerson();
	Person deletePerson(long phoneNumber);
	Person editPerson(long phoneNumber);
	AddressBookImp sortByName();
	AddressBookImp sortByZip();
}