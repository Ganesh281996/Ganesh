package com.bridgelabz.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
public class StockAccount 
{
	String mCustomerPath="/home/bridgeit/Ganesh/BasicProject/Files/StockCustomer.json";
	String mStockPath="/home/bridgeit/Ganesh/BasicProject/Files/StockAccount.json";
	
	Map<String, String> transaction=new HashMap<String,String>();
	SimpleDateFormat dateFormat=new SimpleDateFormat("hh-mm-ss dd/MM/YYYY");
	Date date=new Date();
	int count=1;
	
	public StockAccount()
	{
		
	}
	public StockAccount(Customer customer)
	{
		JSONObject name=new JSONObject();
		JSONObject jsonObject=Utility.readJsonFile(mCustomerPath);
		if(jsonObject==null)
		{
			jsonObject=new JSONObject();
		}
		name.put("Money", customer.getMoney());
		name.put("TotalShare", customer.getTotal_share());
		jsonObject.put(customer.getName(), name);
		Utility.writeJsonFile(mCustomerPath, jsonObject);
	}
	public void buy(String symbol,long no_of_shares,String name)
	{
		JSONObject jsonStock=Utility.readJsonFile(mStockPath);
		JSONObject stockSymbol=(JSONObject)jsonStock.get(symbol);
		long price=(long)stockSymbol.get("Price");
		stockSymbol.put("NumberOfShare", (long)stockSymbol.get("NumberOfShare")-no_of_shares);
		jsonStock.put(symbol, stockSymbol);
		Utility.writeJsonFile(mStockPath, jsonStock);
		boolean flag=false;
		JSONObject jsonObject=Utility.readJsonFile(mCustomerPath);
		JSONObject customer=(JSONObject)jsonObject.get(name);
		JSONObject share_value=null;
		if(customer.get("Shares")==null)
		{
			share_value=new JSONObject();
			flag=true;
		}
		else
		{
			share_value=(JSONObject)customer.get("Shares");
			flag=false;
		}
		if(flag==true)
		{
			share_value.put(symbol, no_of_shares);
		}
		else
		{
			if(share_value.get(symbol)==null)
			{
				share_value.put(symbol, no_of_shares);
			}
			else
			{
				share_value.put(symbol, (long)share_value.get(symbol)+no_of_shares);
			}
		}
		customer.put("Money", (long)customer.get("Money")-(no_of_shares*price));
		customer.put("TotalShare", (long)customer.get("TotalShare")+no_of_shares);
		customer.put("Shares", share_value);
		jsonObject.put(name, customer);
		Utility.writeJsonFile(mCustomerPath, jsonObject);
		transaction.put((count++)+" "+symbol, name+" bought "+no_of_shares+" Share at time "+dateFormat.format(date));
		
	}
	public void sell(String symbol,long no_of_shares,String name)
	{
		JSONObject customerJson=Utility.readJsonFile(mCustomerPath);
		JSONObject stockJson=Utility.readJsonFile(mStockPath);
		
		JSONObject symbolJson=(JSONObject)stockJson.get(symbol);
		long price=(long)symbolJson.get("Price");
		symbolJson.put("NumberOfShare", (long)symbolJson.get("NumberOfShare")+no_of_shares);
		stockJson.put(symbol, symbolJson);
		Utility.writeJsonFile(mStockPath, stockJson);
		
		JSONObject nameJson=(JSONObject)customerJson.get(name);
		nameJson.put("Money", (long)nameJson.get("Money")+(price*no_of_shares));
		customerJson.put(name, nameJson);
		
		nameJson.put("TotalShare", (long)nameJson.get("TotalShare")-no_of_shares);
		customerJson.put(name, nameJson);
		
		JSONObject share=(JSONObject)nameJson.get("Shares");
		share.put(symbol, (long)share.get(symbol)-no_of_shares);
		
		nameJson.put("Shares", share);
		customerJson.put(name, nameJson);
		
		Utility.writeJsonFile(mCustomerPath, customerJson);
		
		transaction.put((count++)+" "+symbol, name+" sold "+no_of_shares+" Share at time "+dateFormat.format(date));
	}
	public void addNewSymbol(String symbol,long noOfShares,long priceOfEachShare)
	{
		JSONObject jsonObject=Utility.readJsonFile(mStockPath);
		JSONObject jsonSymbol=new JSONObject();
		jsonSymbol.put("NumberOfShare", noOfShares);
		jsonSymbol.put("Price", priceOfEachShare);
		jsonObject.put(symbol, jsonSymbol);
		Utility.writeJsonFile(mStockPath, jsonObject);
	}
	public void removeSymbol(String symbol)
	{
		JSONObject jsonObject=Utility.readJsonFile(mStockPath);
		jsonObject.remove(symbol);
		Utility.writeJsonFile(mStockPath, jsonObject);
	}
	public void displayTransactionDetails()
	{
		Iterator<Map.Entry<String, String>> iterator=transaction.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<String, String> entry=iterator.next();
			System.out.println(entry.getKey()+"    "+entry.getValue());
		}
	}
	public void displayReport()
	{
		JSONObject jsonStock=Utility.readJsonFile(mStockPath);
		System.out.println(jsonStock.toJSONString());
		JSONObject jsonCustomer=Utility.readJsonFile(mCustomerPath);
		System.out.println(jsonCustomer.toJSONString());
	}
}