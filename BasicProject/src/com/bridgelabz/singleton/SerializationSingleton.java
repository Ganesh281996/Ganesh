package com.bridgelabz.singleton;

import java.io.Serializable;

public class SerializationSingleton implements Serializable
{
	private static final long serialVersionUID = 7488057899100223471L;

	private SerializationSingleton()
	{

	}

	private static class InnerClass
	{
		private static final SerializationSingleton instance=new SerializationSingleton();
	}

	public static SerializationSingleton getInstance()
	{
		return InnerClass.instance;
	}
}