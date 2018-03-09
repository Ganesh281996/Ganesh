package com.bridgelabz.utility;

public class Queue<T>
{
	private int rear;
	private LinkedList<T> queue;
	private int size;
	
	public Queue(int capacity)
	{
		size=capacity;
		queue=new LinkedList<>();
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
	public void enQueue(T item)
	{	
		if(isFull())
		{
			System.out.println("Queue is Full.");
		}
		else
		{
			rear++;
			queue.append(item);
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
			item=queue.getFirstItem();
			queue.remove(item);
			rear--;
		}
		return item;
	}
	@Override
	public String toString()
	{
		return queue.toString();
	}
}