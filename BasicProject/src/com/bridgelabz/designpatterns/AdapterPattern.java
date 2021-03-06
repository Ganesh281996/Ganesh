package com.bridgelabz.designpatterns;

import com.bridgelabz.utility.SocketAdapter;
import com.bridgelabz.utility.SocketClassAdapter;
import com.bridgelabz.utility.Volt;

public class AdapterPattern 
{
	public static void main(String[] args) 
	{
		System.out.println("Socket Object Adapter");
		SocketAdapter socketClassAdapter=new SocketClassAdapter();
		Volt v3Object=socketClassAdapter.get3Volt();
		System.out.println("3 Volts using Object Adapter="+v3Object.getVolt());
	
		System.out.println("Socket Class Adapter");
		SocketAdapter socketObjectAdapter=new SocketClassAdapter();
		Volt v3Class=socketObjectAdapter.get3Volt();
		System.out.println("3 Volts using Class Adapter="+v3Class.getVolt());
	}
}