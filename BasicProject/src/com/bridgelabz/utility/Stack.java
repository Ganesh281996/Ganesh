package com.bridgelabz.utility;

public class Stack<T>
{
	private int top;
	private LinkedList<T> stack=null;
	private int capacity;
	
	public Stack(int capacity)
	{
		stack=new LinkedList<T>();
		top=0;
		this.capacity=capacity;
	}
	public boolean isEmpty()
	{
		if(top==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isFull()
	{ 
		if(top==capacity)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void push(T item)
	{
		if(!isFull())
		{
			stack.append(item);
			top++;
		}
		else
		{
			System.out.println("Stack is Full.");
		}
	}
	public T pop()
	{
		T item=null;
		if(isEmpty())
		{
			System.out.println("Stack is Empty.");
		}
		else
		{
			item=stack.getLastItem();
			stack.remove(item);
			top--;
		}
		return item;
	}
	public T peek()
	{
		return stack.getLastItem();
	}
	public int size()
	{
		return top;
	}
	@Override
	public String toString()
	{
		return stack.toString();
	}
	public void order()
	{
		stack.order();
	}
	public void reverseStack()
	{
		stack.reverseLinkedList();
	}
	public String[] retrieve()
	{
		return stack.retrieve();
	}
}