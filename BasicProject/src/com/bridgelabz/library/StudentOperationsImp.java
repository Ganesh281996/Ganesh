/**
 * Purpose All Operations of Student are here like signIn,signUp or Issuing Books
 * @author Ganesh
 * @since 16 April 2018
 */
package com.bridgelabz.library;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
	/* 
	 * Student Views all the Books in Library
	 */
	@Override
	public void browseBooks() 
	{
		iterator=AdminOperationsImp.books.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}

	/* 
	 * Search Book by Name
	 * @param bookName search this Book
	 */
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

	/* 
	 * Search Book by Author
	 * @param bookAuthor search this Book
	 */
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

	/* 
	 * method for SignUp
	 * @param student SignUp this Student 
	 */
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

	/* 
	 * method for SignIn 
	 * @param student SignIn with Student
	 */
	@Override
	public boolean signIn(Student student) 
	{
		return students.contains(student);
	}

	/* 
	 * method for Issuing Books
	 * @param student this student will issue Book
	 */
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

	/* 
	 * method for Returning Books
	 * @param student this student will return Book
	 * @param student will return this Book
	 */
	@Override
	public void returnBook(Student student,Book book)
	{
		bookWithDate=StudentOperationsImp.issuedBooks.get(student);
		if(bookWithDate.size()==1)
		{
			StudentOperationsImp.issuedBooks.remove(student);
			return;
		}
		for(Entry<String, Book> entry:bookWithDate.entrySet())
		{
			if(entry.getValue().equals(book))
			{
				bookWithDate.remove(entry.getKey());
			}
		}
		StudentOperationsImp.issuedBooks.put(student, bookWithDate);
	}
}