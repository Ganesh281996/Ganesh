package com.bridgelabz.utility;

public class Employee implements Cloneable 
{
	private int id;
	private String name;
	private long mobileNumber;
	private int age;
	
	public Employee(int id, String name, long mobileNumber, int age) 
	{
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.age = age;
	}
	
	public Employee()
	{
		
	}
	
	public int getId() 
	{
		return id;
	}

	public String getName() 
	{
		return name;
	}

	public long getMobileNumber()
	{
		return mobileNumber;
	}

	public int getAge() 
	{
		return age;
	}
	
	@Override
	public String toString() 
	{
		return "Employee [id=" + id + ", name=" + name + ", mobileNumber=" +
							mobileNumber + ", age=" + age + "]";
	}

	@Override
	public Object clone()
	{
		return new Employee(id, name, mobileNumber, age);
	}
}