package com.bridgelabz.utility;

public class DeQueue<T>
{
	private int mRear;
	private LinkedList<T> mDeque;
	private int mSize;
	
	public DeQueue(int capacity)
	{
		mSize=capacity;
		mDeque=new LinkedList<>();
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
	public void addRear(T item)
	{	
		if(isFull())
		{
			System.out.println("Queue is Full.");
		}
		else
		{
			mRear++;
			mDeque.append(item);
		}
	}
	public void addFront(T item)
	{
		if(isFull())
		{
			System.out.println("Queue is Full.");
		}
		else
		{
			mRear++;
			mDeque.add(item);
		}
	}
	public T removeFront()
	{
		T item=null;
		if(isEmpty())
		{
			System.out.println("Queue is Empty.");
		}
		else
		{
			item=mDeque.getFirstItem();
			mDeque.remove(item);
			mRear--;
		}
		return item;
	}
	public T removeRear()
	{
		T item=null;
		if(isEmpty())
		{
			System.out.println("Queue is Empty.");
		}
		else
		{
			item=mDeque.getLastItem();
			mDeque.remove(item);
			mRear--;
		}
		return item;
	}
	@Override
	public String toString()
	{
		return mDeque.toString();
	}
	public String[] retrieve()
	{
		return mDeque.retrieve();
	}
}