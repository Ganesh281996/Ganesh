package com.bridgelabz.datastructure;

import java.util.HashMap;
import java.util.Map;
import com.bridgelabz.utility.LinkedList;
import com.bridgelabz.utility.Utility;

public class HashingSearchSlotNumber 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		@SuppressWarnings("unchecked")
		LinkedList<Integer> listarray[]=new LinkedList[11];
		Map<Integer, LinkedList<Integer>> map=new HashMap<Integer, LinkedList<Integer>>();
		String path="/home/bridgeit/Ganesh/Files/HashingFunction";
		String stringarray[]=Utility.getFileContents(path);
		int intarray[]=new int[stringarray.length-1];
		int temp=0;
		String tostring="";
		for(int i=0;i<intarray.length;i++)
		{
			intarray[i]=Integer.parseInt(stringarray[i]);
		}
		for(int i=0;i<11;i++)
		{
			listarray[i]=new LinkedList<Integer>();
		}
		for(int j=0;j<intarray.length;j++)
		{
			temp=intarray[j]%11;
			listarray[temp].add(intarray[j]);
		}
		for(int j=0;j<intarray.length;j++)
		{
			listarray[j].order();
		}
		for(int i=0;i<11;i++)
		{
			map.put(i, listarray[i]);
		}
		for(Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet())
		{
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		System.out.println("Enter Number to search=");
		int number=utility.nextInt();
		boolean flag=false;
		temp=number%11;
		for(Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet())
		{
			if(entry.getKey()==temp)
			{
				flag=entry.getValue().search(number);
			}
		}	
		if(flag==true)
		{
			System.out.println("Number was Found.");
			listarray[temp].remove(number);
			listarray[temp].order();
		}
		else
		{
			System.out.println("Number was not Found.");
			listarray[temp].add(number);
			listarray[temp].order();
		}
		for(int i=0;i<11;i++)
		{
			tostring=tostring+listarray[i].toString()+" ";
		}
		byte bytearray[]=tostring.getBytes();
		Utility.bytesToFile(bytearray, path);
		stringarray=Utility.getFileContents(path);
		for(int i=0;i<stringarray.length;i++)
		{
			System.out.println(stringarray[i]);
		}
	}
}