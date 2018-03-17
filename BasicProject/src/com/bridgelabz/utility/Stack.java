package com.bridgelabz.utility;

public class Stack<T>
{
	private int mTop;
	private LinkedList<T> mStack;
	private int mCapacity;
	
	public Stack(int capacity)
	{
		mStack=new LinkedList<T>();
		mTop=0;
		this.mCapacity=capacity;
	}
	public boolean isEmpty()
	{
		if(mTop==0)
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
		if(mTop==mCapacity)
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
			mStack.append(item);
			mTop++;
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
			item=mStack.getLastItem();
			mStack.remove(item);
			mTop--;
		}
		return item;
	}
	public T peek()
	{
		return mStack.getLastItem();
	}
	public int size()
	{
		return mTop;
	}
	@Override
	public String toString()
	{
		return mStack.toString();
	}
	public void order()
	{
		mStack.order();
	}
	public void reverseStack()
	{
		mStack.reverseLinkedList();
	}
	public String[] retrieve()
	{
		return mStack.retrieve();
	}
}