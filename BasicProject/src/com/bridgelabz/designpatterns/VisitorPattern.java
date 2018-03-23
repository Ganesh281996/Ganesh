package com.bridgelabz.designpatterns;

import com.bridgelabz.utility.Book;
import com.bridgelabz.utility.Fruit;
import com.bridgelabz.utility.Items;
import com.bridgelabz.utility.ShoppingCartVisitorImpl;

public class VisitorPattern 
{
	public static void main(String[] args) 
	{
		Book book1=new Book(20, "1");
		Book book2=new Book(30, "2");
		Book book3=new Book(40, "3");
		Fruit fruit1=new Fruit(12,101,"Banana");
		Fruit fruit2=new Fruit(14,102,"Mango");
		Fruit fruit3=new Fruit(16,103,"Orange");
		
		Items[] items = new Items[]{book1,book2,book3,fruit1,fruit2,fruit3};
		
		int total = calculatePrice(items);
		System.out.println("Total Cost = "+total);
	}

	private static int calculatePrice(Items[] items) 
	{
		ShoppingCartVisitorImpl visitor = new ShoppingCartVisitorImpl();
		int sum=0;
		for(Items item : items)
		{
			sum = sum + item.accept(visitor);
		}
		return sum;
	}
}