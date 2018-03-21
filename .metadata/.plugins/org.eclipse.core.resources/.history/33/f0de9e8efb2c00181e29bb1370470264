package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/*
 * purpose: Reading and Printing 2d arrays of integer double and boolean
 * @author Ganesh
 * @since 28 Feb 2018
*/
public class TwoDArray
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();	
		int choice=0;
		int row,col;
		System.out.println("Enter Rows and Columns of array=");
		row=utility.nextInt();
		col=utility.nextInt();
		do
		{
			System.out.println("1 Integers.");
			System.out.println("2 Double.");
			System.out.println("3 Boolean.");
			System.out.println("4 Exit.");
			System.out.println("Enter your choice=");
			choice=utility.nextInt();
			switch(choice)
			{
			case 1:
				Integer twodarrayinteger[][]=new Integer[row][col];
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.print("Enter "+(row*col)+" numbers.");
						twodarrayinteger[i][j]=utility.nextInt();
					}
				}
				Utility.generic2DArray(twodarrayinteger,row,col);
				break;
			case 2:
				Double twodarraydouble[][]=new Double[row][col];
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.print("Enter "+(row*col)+" numbers.");
						twodarraydouble[i][j]=utility.nextDouble();
					}
				}
				Utility.generic2DArray(twodarraydouble,row,col);
				break;
			case 3:
				Boolean twodarrayboolean[][]=new Boolean[row][col];
				for(int i=0;i<row;i++)
				{
					for(int j=0;j<col;j++)
					{
						System.out.print("Enter "+(row*col)+" numbers.");
						twodarrayboolean[i][j]=utility.nextBoolean();
					}
				}
				Utility.generic2DArray(twodarrayboolean,row,col);
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid input Enter again");
				System.out.println("1 Integers.");
				System.out.println("2 Double.");
				System.out.println("3 Boolean.");
				System.out.println("4 Exit.");
				System.out.println("Enter your choice=");
				choice=utility.nextInt();
			}
		}
		while(choice!=4);
	}
}