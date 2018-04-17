/**
 * Purpose Manage logins for User and Admin and give access to them according to there Logins
 * @author Ganesh
 * @since 16 April 2018
 */
package com.bridgelabz.library;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ManageLoginsImp implements ManageLogins
{
	Scanner scanner=new Scanner(System.in);
	StudentOperations studentOperations=new StudentOperationsImp(); 
	AdminOperations adminOperations=new AdminOperationsImp();
	boolean flag;
	Student student;
	Book book;
	List<Book> searchBooks;
	Iterator<Book> iterator;
	String studentName;
	long bookId;
	String bookName;
	String bookAuthor;
	long contactNumber;
	int choice=0;
	
	/* 
	 * method for all Admin Operations
	 */
	@Override
	public void adminLogin() 
	{
		System.out.println("Enter Admin Code");
		if(scanner.nextLong()==12345)
		{
			do
			{
				System.out.println("1. View Students");
				System.out.println("2. View Books");
				System.out.println("3. Add new Book");
				System.out.println("4. Delete Book");
				System.out.println("5. Edit Book");
				System.out.println("6. View Issued Books");
				System.out.println("7. Exit");
				System.out.println("Enter your Choice");
				choice=scanner.nextInt();
				
				switch(choice)
				{
				case 1:
					adminOperations.viewStudents();
					break;
				case 2:
					studentOperations.browseBooks();
					break;
				case 3:
					System.out.println("Enter Book Name");
					bookName=scanner.next();
					System.out.println("Enter Book Author");
					bookAuthor=scanner.next();
					book=new Book(bookName, bookAuthor);
					book=adminOperations.addBook(book);
					if(book==null)
					{
						System.out.println("Book already present");
						break;
					}
					System.out.println("Book Added Successfully");
					break;
				case 4:
					flag=false;
					System.out.println("Enter Book Id");
					bookId=scanner.nextLong();
					iterator=AdminOperationsImp.books.iterator();
					while(iterator.hasNext())
					{
						book=iterator.next();
						if(book.getId()==bookId)
						{
							adminOperations.deleteBook(book);
							flag=true;
							break;
						}
					}
					if(!flag)
					{
						System.out.println("Book Not Found");
					}
					break;
				case 5:
					flag=false;
					System.out.println("Enter Book Id");
					bookId=scanner.nextLong();
					while(iterator.hasNext())
					{
						book=iterator.next();
						if(book.getId()==bookId)
						{
							adminOperations.editBook(book);
							System.out.println("Book SUccessfully Edited");
							flag=true;
							break;
						}
					}
					if(!flag)
					{
						System.out.println("Book Not Found");
					}
					break;
				case 6:
					adminOperations.viewIssuedBooks();
					break;
				default:
					if(choice<1 || choice>7)
					{
						System.out.println("Invalid input try again.");
						System.out.println("1. View Students");
						System.out.println("2. View Books");
						System.out.println("3. Add new Book");
						System.out.println("4. Delete Book");
						System.out.println("5. Edit Book");
						System.out.println("6. View Issued Books");
						System.out.println("7. Exit");
						System.out.println("Enter your Choice");
					}
					
				}
			}
			while(choice!=7);
		}
		else
		{
			System.out.println("Invalid Code");
		}
	}

	/* 
	 * Method for user login and SignUp
	 */
	@Override
	public void userLogin()
	{
		do
		{
			System.out.println("1. SignUp");
			System.out.println("2. SignIn");
			System.out.println("3. Exit");
			System.out.println("Enter your Choice");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter Student Name");
				studentName=scanner.next();
				System.out.println("Enter Contact Number");
				contactNumber=scanner.nextLong();
				student=new Student(studentName, contactNumber);
				student=studentOperations.signUp(student);
				if(student==null)
				{
					System.out.println("Student already Present. Try Signing In");
					break;
				}
				System.out.println("Signed Up");
				break;
			case 2:
				System.out.println("Enter Student Name");
				studentName=scanner.next();
				System.out.println("Enter Contact Number");
				contactNumber=scanner.nextLong();
				student=new Student(studentName, contactNumber);
				if(studentOperations.signIn(student))
				{
					System.out.println("Signed In Successfully.");
					studentLoginOperations(student);
					break;
				}
				System.out.println("Student not Found. Try Sign Up");
				break;
			default:
				if(choice<1 || choice>3)
				{
					System.out.println("Invalid Input");
					System.out.println("1. SignUp");
					System.out.println("2. SignIn");
					System.out.println("3. Exit");
					System.out.println("Enter your Choice");
				}
			}
		}
		while(choice!=3);
	}
	
	/**
	 * Student Operations
	 * @param student who is currently logged in
	 */
	void studentLoginOperations(Student student)
	{
		do
		{
			System.out.println("1. Browse Books");
			System.out.println("2. Search Book by Name");
			System.out.println("3. Search Book by Author");
			System.out.println("4. Issue Book");
			System.out.println("5. Return Book");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				studentOperations.browseBooks();
				break;
			case 2:
				System.out.println("Enter Book Name");
				bookName=scanner.next();
				book=studentOperations.searchBookByName(bookName);
				if(book==null)
				{
					System.out.println("Book was not found");
					break;
				}
				System.out.println("Book was Found");
				System.out.println(book);
				break;
			case 3:
				System.out.println("Enter Book Author");
				bookAuthor=scanner.next();
				searchBooks=studentOperations.searchBookByAuthor(bookAuthor);
				if(searchBooks.isEmpty())
				{
					System.out.println("Book was not found");
					break;
				}
				iterator=searchBooks.iterator();
				while(iterator.hasNext())
				{
					System.out.println(iterator.next());
				}
				break;
			case 4:
				studentOperations.issueBook(student);
				break;
			case 5:
				flag=false;
				if(StudentOperationsImp.issuedBooks.containsKey(student))
				{
					System.out.println("Enter Book Name");
					bookName=scanner.next();
					iterator=AdminOperationsImp.books.iterator();
					while(iterator.hasNext())
					{
						book=iterator.next();
						if(book.getBookName().equals(bookName))
						{
							studentOperations.returnBook(student, book);
							System.out.println("Book was Returned");
							flag=true;
							break;
						}
					}
					if(!flag)
					{
						System.out.println("You dont have that Book");
					}
				}
				else
				{
					System.out.println("You dont have any Books");
				}
				break;
			default:
				if(choice<1 || choice>6)
				{
					System.out.println("Invalid Input Try Again.");
					System.out.println("1. Browse Books");
					System.out.println("2. Search Book by Name");
					System.out.println("3. Search Book by Author");
					System.out.println("4. Issue Book");
					System.out.println("5. Return Book");
					System.out.println("6. Exit");
					System.out.println("Enter your Choice");
				}
			}
		}
		while(choice!=6);
	}
}