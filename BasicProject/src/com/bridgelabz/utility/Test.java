package com.bridgelabz.utility;

public class Test 
{
	public static void main(String[] args) 
	{
		Queue<String> queue=new Queue<>(5);
		LinkedList<String> list=new LinkedList<String>();
		list.add("abc");
		list.add("bcd");
//		list.remove("bcd");
		System.out.println(list.search("abc"));
		String tostring=list.toString();
		System.out.println(tostring);
		String a=list.getFirstItem();
		list.remove(list.getFirstItem());
		System.out.println(list.search(a));
	}
}