/**
 * Purpose Finding content in a Ordered Linked List
 * @author Ganesh
 * @since 6 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.LinkedList;
import com.bridgelabz.utility.Utility;

public class OrderedList 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		String path="/home/bridgeit/Ganesh/BasicProject/Files/OrderedList";
		String array[]=Utility.getFileContents(path);
		LinkedList<Integer> list=new LinkedList<>();
		list.emptyList();
		for(int i=0;i<array.length-1;i++)
		{
			list.add(Integer.parseInt(array[i]));
		}
		list.order();
		list.display();
		System.out.println("Enter the Number=");
		int number=utility.nextInt();
		if(list.search(number))
		{
			list.removeInteger(number);
		}
		else
		{
			list.add(number);
		}
		String tostring=list.toString();
		System.out.println(tostring);
		byte bytearray[]=tostring.getBytes();
		Utility.bytesToFile(bytearray, path);
	}
}