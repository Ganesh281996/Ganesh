package com.bridgelabz.utility;

public class Queue<T>
{
	private int mRear;
	private LinkedList<T> mQueue;
	private int mSize;
	
	public Queue(int capacity)
	{
		mSize=capacity;
		mQueue=new LinkedList<>();
		mRear=-1;
	}
	public boolean isEmpty()
	{
		if(mRear==-1)
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
		if(mRear==mSize)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int size()
	{
		return mRear+1;
	}
	public void enQueue(T item)
	{	
		if(isFull())
		{
			System.out.println("Queue is Full.");
		}
		else
		{
			mRear++;
			mQueue.append(item);
		}
	}
	public T deQueue()
	{
		T item=null;
		if(isEmpty())
		{
			System.out.println("Queue is Empty.");
		}
		else
		{
			item=mQueue.getFirstItem();
			mQueue.remove(item);
			mRear--;
		}
		return item;
	}
	@Override
	public String toString()
	{
		return mQueue.toString();
	}
	public String[] retrieve()
	{
		return mQueue.retrieve();
	}
	public void order()
	{
		mQueue.order();
	}
	public void orderString()
	{
		mQueue.orderString();
	}
}