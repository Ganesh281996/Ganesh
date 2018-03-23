package com.bridgelabz.utility;

public class Book implements Items
{
	private int price;
	private String bookId;
	
	public Book(int price, String bookId)
	{
		this.price=price;
		this.bookId=bookId;
	}
	
	public int getPrice() 
	{
		return price;
	}

	public String getbookId() 
	{
		return bookId;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) 
	{
		return visitor.visit(this);
	}
}