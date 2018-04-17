/**
 * Purpose All the Admin Operations are here like adding book book and manipulating it.
 * Admin manages the Library.
 * @author Ganesh
 * @since 16 April 2018
 */
package com.bridgelabz.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdminOperationsImp implements AdminOperations
{
	long bookId;
	String bookName;
	String bookAuthor;
	
	Scanner scanner=new Scanner(System.in);
	static List<Book> books=new ArrayList<>();
	Iterator<Student> iterator;

	/* 
	 * Admin adds new Book to library
	 * @param book add this book to library
	 */
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

	/* 
	 * Admin edit existing Book
	 * @param book Edit this book 
	 */
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

	/* 
	 * Delete existing Book
	 * @param book delete this book
	 */
	@Override
	public void deleteBook(Book book)
	{
		books.remove(book);
	}

	/* 
	 * View Students who have Signed Up
	 */
	@Override
	public void viewStudents()
	{
		iterator=StudentOperationsImp.students.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

	/* 
	 * View Issued Book to Students
	 */
	@Override
	public void viewIssuedBooks() 
	{
		Iterator<Map.Entry<Student, Map<String,Book>>> mapIterator=StudentOperationsImp.issuedBooks.entrySet().iterator();
		Iterator<Map.Entry<String,Book>> bookDateIterator=null; 
		while(mapIterator.hasNext())
		{
			Map.Entry<Student, Map<String,Book>> entry=mapIterator.next();
			System.out.println(entry.getKey());
			bookDateIterator=entry.getValue().entrySet().iterator();
			while(bookDateIterator.hasNext())
			{
				System.out.println(bookDateIterator.next());
			}
		}
	}
}