package com.bridgelabz.designpatterns;

import org.json.simple.JSONObject;

import com.bridgelabz.utility.FacadeImplementation;

public class FacadePattern 
{
	public static void main(String[] args) 
	{
		String path="/home/bridgeit/Ganesh/BasicProject/Files/AddressBook.json";
		FacadeImplementation implementation=new FacadeImplementation();
		JSONObject jsonObject=implementation.getDetailsFromFile(path);
		implementation.printDetails(jsonObject);
	}
}