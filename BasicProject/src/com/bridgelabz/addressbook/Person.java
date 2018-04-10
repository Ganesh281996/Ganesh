package com.bridgelabz.addressbook;

public class Person 
{
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private Address address;
	
	public Person(String firstName, String lastName, long phoneNumber, Address address) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Person()
	{
		
	}
	
	public long getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() 
	{
		return address;
	}

	public void setAddress(Address address) 
	{
		this.address = address;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	@Override
	public String toString() 
	{
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
}