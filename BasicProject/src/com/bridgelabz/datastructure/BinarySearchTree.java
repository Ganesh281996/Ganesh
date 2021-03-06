/**
 * Purpose finding number of binary trees for given size
 * @author Ganesh
 *@since 3 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class BinarySearchTree 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter Number of Test cases=");
		int testCases=utility.nextInt();
		int test=0;	
		double noOfTree;
		for(int i=0;i<testCases;i++)
		{
			System.out.print("Enter the case= ");
			test=utility.nextInt();
			noOfTree=Utility.binarySearchTreeTestCase(test);
			System.out.println("No of binary search tree for given test case = "+noOfTree);
		}
	}
}