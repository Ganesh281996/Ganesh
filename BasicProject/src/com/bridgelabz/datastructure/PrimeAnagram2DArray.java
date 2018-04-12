/**
 * Purpose finding numbers that are Prime and Anagram using 2D Array
 * @author Ganesh
 * @since 10 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class PrimeAnagram2DArray 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		int col;
		String array[][];
		System.out.println("Enter range=");
		int range=utility.nextInt();
		if(range%100==0)
		{
			col=range/100;
			array=new String[100][col];
		}
		else
		{
			col=(range/100)+1;
			array=new String[100][col];
		}
		array=Utility.twoDPrimeAnagram(range,col);
		array=Utility.removeNull(array, col);
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print(array[i][j]+"  ");
				if(array[i][j].equals(""))
				{
					System.out.print("       ");
				}
			}
			System.out.println();
		}
	}
}