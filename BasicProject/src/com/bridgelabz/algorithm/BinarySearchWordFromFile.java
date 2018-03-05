package com.bridgelabz.algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import com.bridgelabz.utility.Utility;

/*
 * purpose: Using Binary search on words taken from a a file
 * @author Ganesh
 * @since 1 March 2018
*/
public class BinarySearchWordFromFile
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int content=0;boolean flag=false;
		String string="";
		String stringarray1[],stringarray[];
		InputStream inputfile=null;
		try 
		{
			inputfile=new FileInputStream("/home/bridgeit/Ganesh/Files/File1");
			while((content=inputfile.read())!=-1)
			{
				string=string+(char)content;
			}
			System.out.print(string);
			stringarray1=string.split(" ");	
			stringarray=new String[stringarray1.length-1];
			for(int i=0;i<stringarray.length;i++)
			{
				stringarray[i]=stringarray1[i];
			}
			stringarray=Utility.bubbleSortString(stringarray);
			for(int i=0;i<stringarray.length;i++)
			{
				System.out.println(stringarray[i]);
			}
			System.out.println("Enter the string to search=");
			string=utility.next();
			flag=Utility.binarySearchString(stringarray, string);
			if(flag==true)
			{
				System.out.println("The word is present.");
			}
			else
			{
				System.out.println("The word was not found.");
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				inputfile.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
}