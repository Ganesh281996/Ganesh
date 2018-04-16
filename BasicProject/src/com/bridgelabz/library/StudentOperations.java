package com.bridgelabz.library;

import java.util.List;

public interface StudentOperations 
{
	Student signUp(Student student);
	boolean signIn(Student student);
	void browseBooks();
	Book searchBookByName(String bookName);
	List<Book> searchBookByAuthor(String author);
	void issueBook(Student student);
}