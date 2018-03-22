package com.bridgelabz.utility;

public class SocketObjectAdapter implements SocketAdapter
{
	Socket socket=new Socket();
	@Override
	public Volt get120Volt() 
	{
		return socket.getVolt();
	}

	@Override
	public Volt get3Volt() 
	{
		Volt volt=socket.getVolt();
		return convertVolt(volt, 40);
	}
	
	private Volt convertVolt(Volt volt,int number)
	{
		return new Volt(volt.getVolt()/number);
	}
}