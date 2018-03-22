package com.bridgelabz.designpatterns;

import com.bridgelabz.utility.Computer;
import com.bridgelabz.utility.ComputerFactory;
import com.bridgelabz.utility.Utility;

public class FactoryPattern 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter Pc,Server,Laptop to create Object of it.");
		String details=utility.next();
		ComputerFactory factory=new ComputerFactory();
		Computer computer=factory.getComputer(details);
		System.out.println(computer);
	}
}