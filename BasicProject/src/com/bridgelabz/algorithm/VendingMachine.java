/**
 * purpose: taking money as input and finding number of notes needed to take change
 * @author Ganesh
 * @since 6 march 2018
 */
package com.bridgelabz.algorithm;

import com.bridgelabz.utility.Utility;

public class VendingMachine 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the amount=");
		int amount=utility.nextInt();
		int notes[]=new int[]{1000,500,100,10,5,2,1};
		int noofnotes[]=Utility.noOfNotes(amount);
		System.out.println("No of Notes are as follows=");
		for(int i=0;i<notes.length;i++)
		{
			System.out.println(notes[i]+"Rs notes="+noofnotes[i]);
		}
	}
}