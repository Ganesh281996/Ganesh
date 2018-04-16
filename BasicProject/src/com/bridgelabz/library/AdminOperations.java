package com.bridgelabz.library;

public interface AdminOperations 
{
	Book addBook(Book book);
	void editBook(Book book);
	void deleteBook(Book book);
	void viewStudents();
	void viewIssuedBooks();
}