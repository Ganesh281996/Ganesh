package com.bridgelabz.datastructure;

import com.bridgelabz.utility.LinkedList;
import com.bridgelabz.utility.Utility;

public class UnOrderedList 
{
	public static void main(String[] args) 
	{
		String path="/home/bridgeit/Ganesh/BasicProject/Files/UnOrderedList";
		String array[]=Utility.getFileContents(path);
		Utility utility=new Utility();
		LinkedList<String> list=new LinkedList<String>();
		for(int i=0;i<array.length;i++)
		{
			list.append(array[i]);
		}
		list.display();
		System.out.println("Enter the word to search=");
		String word=utility.next();
		if(list.search(word)==true)
		{
			list.remove(word);
		}
		else
		{
			list.add(word);
		}
		list.display();
		String tostring=list.toString();
		byte bytearray[]=tostring.getBytes();
		Utility.bytesToFile(bytearray,path);
		
	}
}