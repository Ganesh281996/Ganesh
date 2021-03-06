package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Purpose contains all the methods used in Address Book using json
 * @author Ganesh
 * @since 15 March 2018
 */

@SuppressWarnings("unchecked")
public class AddressBook 
{
	String mAdressBookPath="/home/bridgeit/Ganesh/BasicProject/Files/AddressBook.json";
	String mSortedAddressBookPath="/home/bridgeit/Ganesh/BasicProject/Files/SortedAddressBook.json";
	
	public boolean addPerson(String firstName,String lastName,long zip,
							long mobile,String address,String city,String state)
	{
		JSONObject jsonObject=Utility.readJsonFile(mAdressBookPath);
		JSONObject person=null;
		if(jsonObject.get(firstName)==null)
		{
			person=new JSONObject();
			person.put("LastName", lastName);
			person.put("Zip", zip);
			person.put("Mobile", mobile);
			person.put("Address", address);
			person.put("City", city);
			person.put("State", state);
			jsonObject.put(firstName, person);
			Utility.writeJsonFile(mAdressBookPath, jsonObject);
			return true;
		}
		return false;
	}
	
	public boolean editPerson(String firstName,String lastName,long zip,
							long mobile,String address,String city,String state)
	{
		JSONObject jsonObject=Utility.readJsonFile(mAdressBookPath);
		JSONObject person=null;
		if(jsonObject.get(firstName)!=null)
		{
			person=new JSONObject();
			person.put("LastName", lastName);
			person.put("Zip", zip);
			person.put("Mobile", mobile);
			person.put("Address", address);
			person.put("City", city);
			person.put("State", state);
			jsonObject.put(firstName, person);
			Utility.writeJsonFile(mAdressBookPath, jsonObject);
			return true;
		}
		return false;
	}
	
	public boolean deletePerson(String firstName)
	{
		JSONObject jsonObject=Utility.readJsonFile(mAdressBookPath);
		if(jsonObject.get(firstName)!=null)
		{
			jsonObject.remove(firstName);
			Utility.writeJsonFile(mAdressBookPath, jsonObject);
			return true;
		}
		return false;
	}
	
	public void display()
	{
		JSONObject jsonObject=Utility.readJsonFile(mAdressBookPath);
		Iterator<JSONObject> iterator=jsonObject.entrySet().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
	
	public void displaySortedAddressBook()
	{
		JSONObject jsonObject=Utility.readJsonFile(mSortedAddressBookPath);
		JSONArray jsonArray=(JSONArray)jsonObject.get("AddressBook");
		Iterator<JSONObject> iterator=jsonArray.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
	}
	
	public void sortByName()
	{
		JSONObject jsonObject=Utility.readJsonFile(mAdressBookPath);
		JSONObject person=null,name=null;
		JSONArray jsonArray=new JSONArray();
		JSONObject temp=new JSONObject();
		List<String > list=new ArrayList<String>();
		Map<String, JSONObject> map=new TreeMap<String,JSONObject>();
		Iterator<JSONObject> iterator=jsonObject.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry<String, String> entry=(Entry<String, String>) iterator.next();
			temp=(JSONObject)jsonObject.get(entry.getKey());
			map.put(entry.getKey(), temp);
			list.add(entry.getKey());
		}
		Collections.sort(list);
		
		Iterator<Entry<String, JSONObject>> iterate=map.entrySet().iterator();
		for(int i=0;i<list.size();i++)
		{
			name=new JSONObject();
			Entry<String, JSONObject> entry=iterate.next();
			person=entry.getValue();
			name.put(list.get(i), person);
			jsonArray.add(name);
		}
		jsonObject=new JSONObject();
		jsonObject.put("AddressBook", jsonArray);
		Utility.writeJsonFile(mSortedAddressBookPath, jsonObject);
	}
	
	public void sortByZip()
	{
		JSONObject jsonObject=Utility.readJsonFile(mAdressBookPath);
		JSONObject person=null,name=null;
		long zip=0;
		JSONArray jsonArray=new JSONArray();
		
		List<String > names=new ArrayList<String>();
		Map<Long, JSONObject> list=new TreeMap<Long,JSONObject>();
		Iterator<JSONObject> iterator=jsonObject.entrySet().iterator();
		while(iterator.hasNext())
		{
			Map.Entry<String, String> entry=(Entry<String, String>) iterator.next();
			person=(JSONObject)jsonObject.get(entry.getKey());
			zip=(long)person.get("Zip");
			list.put(zip, person);
			names.add(entry.getKey());
		}
		
		Iterator<Entry<Long, JSONObject>> iterate=list.entrySet().iterator();
		for(int i=0;i<list.size();i++)
		{
			name=new JSONObject();
			Entry<Long, JSONObject> entry=iterate.next();
			person=entry.getValue();
			name.put(names.get(i), person);
			jsonArray.add(name);
		}
		jsonObject=new JSONObject();
		jsonObject.put("AddressBook", jsonArray);
		Utility.writeJsonFile(mSortedAddressBookPath, jsonObject);
	}
}