package com.bridgelabz.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

abstract class abc
{
	abstract void meth();
}
public class Test
{
	public static void main(String[] args) throws Exception 
	{
		new abc() {
			
			@Override
			void meth() {
				// TODO Auto-generated method stub
				
			}
		};
		
		List<Integer> list=new ArrayList<>();
		System.out.println(findCapacity(list));

		System.out.println(list.size());
		list.add(1);
		System.out.println(findCapacity(list));

		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		System.out.println(list.size());
		list.add(1);
		System.out.println(list.size());
		System.out.println(findCapacity(list));

	}
	static int findCapacity(List<Integer> al) throws Exception {
		 
        Field field = ArrayList.class.getDeclaredField("elementData");
 
        field.setAccessible(true);
 
        return ((Object[]) field.get(al)).length;
 
    }
}