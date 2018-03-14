package com.bridgelabz.utility;

import java.util.Map;

public class Customer
{
	private String name;
	private long money;
	private long total_share;
	
	public Customer(String name, long money, long total_share) 
	{
		this.name = name;
		this.money = money;
		this.total_share = total_share;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public long getMoney() 
	{
		return money;
	}

	public void setMoney(long money) 
	{
		this.money = money;
	}


	public long getTotal_share() 
	{
		return total_share;
	}

	public void setTotal_share(int total_share) 
	{
		this.total_share = total_share;
	}

	@Override
	public String toString() 
	{
		return "Customer [name=" + name + ", money=" + money + ", total_share=" + total_share	+ "]";
	}	
	
}