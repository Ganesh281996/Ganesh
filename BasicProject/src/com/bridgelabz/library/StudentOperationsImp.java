package com.bridgelabz.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentOperationsImp implements StudentOperations 
{
	static List<Student> students=new ArrayList<>();
	static Map<Student, Map<String,Book>> issuedBooks=new HashMap<>();
	Map<String, Book> bookWithDate;
	Scanner scanner=new Scanner(System.in);
	Iterator<Book> iterator; 
	Date date;
	List<Book> searchBooks;
	Book book;
	String bookName;
	Student student;
	long studentId;
	
	@Override
	public void browseBooks() 
	{
		iterator=AdminOperationsImp.books.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

	@Override
	public Book searchBookByName(String bookName)
	{
		iterator=AdminOperationsImp.books.iterator();
		while(iterator.hasNext())
		{
			book=iterator.next();
			if(book.getBookName().equals(bookName))
			{
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> searchBookByAuthor(String author)
	{
		searchBooks=new ArrayList<>();
		iterator=AdminOperationsImp.books.iterator();
		while(iterator.hasNext())
		{
			book=iterator.next();
			if(book.getBookAuthor().equals(author))
			{
				searchBooks.add(book);
			}
		}
		return searchBooks;
	}

	@Override
	public Student signUp(Student student) 
	{
		if(!students.contains(student))
		{
			student.setStudentId(student.hashCode());
			students.add(student);
			return student;
		}
		return null;
	}

	@Override
	public boolean signIn(Student student) 
	{
		return students.contains(student);
	}

	@Override
	public void issueBook(Student student) 
	{
		System.out.println("Enter Book to Issue");
		bookName=scanner.next();
		if(searchBookByName(bookName)!=null)
		{
			if(issuedBooks.get(student)!=null)
			{
				bookWithDate=issuedBooks.get(student);
				date=new Date();
				bookWithDate.put(date.toString(), book);
				issuedBooks.put(student, bookWithDate);
				System.out.println("Book was Issued Successfully");
			}
			else
			{
				date=new Date();
				bookWithDate=new HashMap<>();
				bookWithDate.put(date.toString(), book);
				issuedBooks.put(student, bookWithDate);
				System.out.println("Book was Issued Successfully");
			}
		}
		else
		{
			System.out.println("Book not Found.");
		}
	}
}