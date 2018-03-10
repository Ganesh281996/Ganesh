package com.bridgelabz.utility;

public class DeQueue<T>
{
	private int rear;
	private LinkedList<T> dequeue;
	private int size;
	
	public DeQueue(int capacity)
	{
		size=capacity;
		dequeue=new LinkedList<>();
		rear=-1;
	}
	public boolean isEmpty()
	{
		if(rear==-1)
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
		if(rear==size)
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
		return rear+1;
	}
	public void addRear(T item)
	{	
		if(isFull())
		{
			System.out.println("Queue is Full.");
		}
		else
		{
			rear++;
			dequeue.append(item);
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
			rear++;
			dequeue.add(item);
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
			item=dequeue.getFirstItem();
			dequeue.remove(item);
			rear--;
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
			item=dequeue.getLastItem();
			dequeue.remove(item);
			rear--;
		}
		return item;
	}
	@Override
	public String toString()
	{
		return dequeue.toString();
	}
	public String[] retrieve()
	{
		return dequeue.retrieve();
	}
}