/**
 * Purpose finding numbers that are prime and anagram using queue
 * @author Ganesh
 * @since 10 March 2018
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Queue;
import com.bridgelabz.utility.Utility;

public class PrimeAnagramQueue 
{
	public static void main(String[] args) 
	{
		Utility utility=new Utility();
		System.out.println("Enter the range=");
		int range=utility.nextInt();
		Queue<Integer> queue=new Queue<>(range);
		for(int i=0;i<range;i++)
		{
			for(int j=i+1;j<range;j++)
			{
				if(Utility.primeNumber(i) && Utility.primeNumber(j))
				{
					if(Utility.findingAnagram(""+i, ""+j))
					{
						queue.enQueue(i);
						queue.enQueue(j);
					}
				}
			}
		}
		String tostring=queue.toString();
		System.out.println(tostring);
	}
}