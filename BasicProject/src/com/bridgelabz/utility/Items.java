package com.bridgelabz.utility;

public interface Items 
{
	int accept(ShoppingCartVisitor visitor);
}




interface ShoppingCartVisitor
{

	int visit(Book book);
	int visit(Fruit fruit);
}