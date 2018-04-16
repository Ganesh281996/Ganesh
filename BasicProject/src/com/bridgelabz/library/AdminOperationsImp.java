package com.bridgelabz.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminOperationsImp implements AdminOperations
{
	long bookId;
	String bookName;
	String bookAuthor;
	
	Scanner scanner=new Scanner(System.in);
	static List<Book> books=new ArrayList<>();
	Iterator<Student> iterator;

	@Override
	public Book addBook(Book book) 
	{
		if(!books.contains(book))
		{
			book.setId(book.hashCode());
			books.add(book);
			return book;
		}
		return null;
	}

	@Override
	public void editBook(Book book) 
	{
		books.remove(book);
		System.out.println(book);
		System.out.println("Enter Book Name to change");
		bookName=scanner.next();
		book.setBookName(bookName);
		System.out.println("Enter Book Author to change");
		bookAuthor=scanner.next();
		book.setBookAuthor(bookAuthor);
		books.add(book);
	}

	@Override
	public void deleteBook(Book book)
	{
		books.remove(book);
	}

	@Override
	public void viewStudents()
	{
		iterator=StudentOperationsImp.students.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

	@Override
	public void viewIssuedBooks() 
	{
		Iterator iterator=StudentOperationsImp.issuedBooks.entrySet().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}