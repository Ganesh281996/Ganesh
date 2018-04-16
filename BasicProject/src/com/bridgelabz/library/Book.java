package com.bridgelabz.library;

public class Book 
{
	private long bookId;
	private String bookName;
	private String bookAuthor;
	
	public Book(String bookName, String bookAuthor) 
	{
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	
	public long getId() 
	{
		return bookId;
	}
	public void setId(long bookId) 
	{
		this.bookId = bookId;
	}
	public String getBookName()
	{
		return bookName;
	}
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	public String getBookAuthor() 
	{
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) 
	{
		this.bookAuthor = bookAuthor;
	}
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + "]";
	}
}