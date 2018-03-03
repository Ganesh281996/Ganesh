package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utility
{
	static Scanner scanner=new Scanner(System.in);
	
	public static double monthlyPayment(double p,double y,double r)
	{
		double smallr=r/(12*100);
		double smalln=12*y;
		double payment=(p*smallr)/(1-Math.pow((1+smallr), -smalln));
		return payment;
	}
	public static void guessNumber(int bign,int smalln,int mynumber)
	{
		int array[]=new int[bign];
		boolean flag=false;
		int i;
		for(i=0;i<bign;i++)
		{
			array[i]=i;
		}
		Random random=new Random();
		int randomnumber=0;
		int first=0,last=bign-1,mid=bign;
		for(i=0;i<smalln;i++)
		{
			do
			{
				randomnumber=random.nextInt(mid);
			}
			while(randomnumber<=first || randomnumber>=last);
			if(randomnumber==mynumber)
			{
				System.out.println(randomnumber);
				System.out.println("Number was found.");
				break;
			}
			else
			{
				System.out.println(randomnumber);
				System.out.println("Enter true if the number is greater than the number u thought=");
				flag=scanner.nextBoolean();
			}
			if(flag==true)
			{
				last=randomnumber-1;
			}
			else
			{
				first=randomnumber+1;
			}
			mid=(first+last)/2;
		}
		if(i>=bign)
		{
			System.out.println("Number was not found.");
		}
	}
	public static double celsiusToFahrenheit(double celsius)
	{
		return ((celsius*9/5)+32);
	}
	public static double fahrenheitToCelsius(double Fahrenheit) 
	{
		return ((Fahrenheit-32)*5/9);
	}
	public static String[] insertionSortString(String array[])
	{
		String key;
		int j;
		for(int i=1;i<array.length;i++)
		{
			key = array[i];  
            j=i-1;  
            while((j>=0) && (array[j].compareToIgnoreCase(key))>0) 
            {  
                array[j+1]=array[j];  
                j--;  
            }
            array[j+1]=key;
		}
		return array;
	}
	public static int[] insertionSortInteger(int array[])
	{
		int key,j;
		for(int i=0;i<array.length;i++)
		{
			key = array[i];  
            j=i-1;  
            while((j>-1) && (array[j]>key)) 
            {  
                array[j+1]=array[j];  
                j--;  
            }
            array[j+1]=key;
		}
		return array;
	}
	public static boolean binarySearchInteger(int array[],int number)
	{
		array=bubbleSortInteger(array);
		int first=0,mid=array.length/2,last=array.length-1;
		int count=0;
		int originallast=last;
		do
		{
			for(int i=0;i<originallast;i++)
			{
				mid=(first+last)/2;
				if(number==array[mid])
				{
					return true;
				}
				else
				{
					if(number>array[mid])
					{
						first=mid+1;
					}
					else
					{
						last=mid-1;
					}
				}
			}
			count++;
			if(count>originallast)
			{
				return false;
			}
		}
		while(mid>0 && mid<originallast-1);
		return false;
	}
	public static boolean binarySearchString(String array[],String string)
	{
		array=bubbleSortString(array);
		int first=0,mid=array.length/2,last=array.length-1;
		int count=0;
		int originallast=last;
		do
		{
			for(int i=0;i<originallast;i++)
			{
				mid=(first+last)/2;
				if(string.equals(array[mid]))
				{
					return true;
				}
				else
				{
					if(string.compareToIgnoreCase(array[mid])>0)
					{
						first=mid+1;
					}
					else
					{
						last=mid-1;
					}
				}
			}
			count++;
			if(count>originallast)
			{
				return false;
			}
		}
		while(mid>0 && mid<originallast-1);
		return false;
	}
	public static String[] bubbleSortString(String[] array)
	{
		String temp="";
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(array[j].compareToIgnoreCase(array[j+1])>0)
				{
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	public static int[] bubbleSortInteger(int[] array)
	{
		int temp=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(array[j]>array[j+1])
				{
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	public static boolean palindrome(int number)
	{
		int reversenumber=0;
		int originalnumber=number;
		while(number!=0)
		{
			reversenumber=(10*reversenumber)+(number%10);
			number=number/10;
		}
		if(originalnumber==reversenumber)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean primeNumber(int number)
	{
		if(number==0 || number==1)
		{
			return false;
		}
		if(number==2)
		{
			return true;
		}
		for(int i=2;i<number;i++)
		{
			if(number%i==0)
			{
				return false;
			}
		}
		return true;
	}
	public static char[] sortCharArray(char[] chararray)
	{
		char temp=0;
		for(int i=0;i<chararray.length;i++)
		{
			for(int j=0;j<chararray.length;j++)
			{
				if(chararray[i]>chararray[j])
				{
					temp=chararray[i];
					chararray[i]=chararray[j];
					chararray[j]=temp;
				}
			}
		}
		return chararray;
	}
	public static boolean findingAnagram(String string1,String string2)
	{
		int count=0;
		if(string1.length()!=string2.length())
		{
			return false;
		}
		char chararray1[]=string1.toCharArray();
		char chararray2[]=string2.toCharArray();
		chararray1=sortCharArray(chararray1);
		chararray2=sortCharArray(chararray2);
		for(int i=0;i<chararray1.length;i++)
		{
			for(int j=0;j<chararray1.length;j++)
			{
				if(chararray1[i]==chararray2[j])
				{
					count++;
					break;
				}
			}
		}
		if(count==chararray1.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static double windChill(double t,double v)
	{
		double w=35.74+0.6215*t+(((0.4275*t)-35.75)*Math.pow(v, 0.16));
		return w;
	}
	public static double[] quadratic(double a,double b,double c)
	{
		double rootarray[]=new double[2];
		double bsquare=b*b;
		double delta=bsquare-(4*a*c);
		rootarray[0]=(-b+Math.sqrt(delta))%(2*a);
		rootarray[1]=(-b-Math.sqrt(delta))%(2*a);
		return rootarray;
	}
	public static String ticTacToeResult(char[][] game)
	{
		String userwon="Player 1 User has won.";
		String computerwon="Player 2 Computer has won.";
		String draw="It was a Draw.";
		for(int j=0;j<3;j++)
		{
			for(int i=0;i<3;i++)
			{
				if(i==j && game[i][j]==game[i+1][j+1] && game[i+1][j+1]==game[i+2][j+2])
				{
					if(game[i][j]=='X')
					{
						return userwon;
					}
					else if(game[i][j]=='O')
					{
						return computerwon;
					}
				}
				if(i+j==2 && game[i-2][j]==game[i-1][j+1] && game[i-1][j+1]==game[i][j+2])
				{
					if(game[i-2][j]=='X')
					{
						return userwon;
					}
					else if(game[i-2][j]=='O')
					{
						return computerwon;
					}
				}
				if(game[i][j]==game[i][j+1] && game[i][j+1]==game[i][j+2])
				{
					if(game[i][j]=='X')
					{
						return userwon;
					}
					else if(game[i][j]=='O')
					{
						return computerwon;
					}
				}
				if(game[j][i]==game[j+1][i] && game[j+1][i]==game[j+2][i])
				{
					if(game[i][j]=='X')
					{
						return userwon;
					}
					else if(game[i][j]=='O')
					{
						return computerwon;
					}
				}
			}
			j=0;
		}
		return draw;
	}
	public static char[][] ticTacToe(char[][] game)
	{
		String userwon="Player 1 User has won.";
		String computerwon="Player 2 Computer has won.";
		System.out.println("Player 1 :User");
		System.out.println("Player 2 :Computer");
		System.out.println("User will start the game.");
		int rounds=0;
		int row,col;
		int computer=0;
		Random random=new Random();
		int randomrow,randomcol;
		do
		{
			do
			{
				System.out.println("Enter column and row to mark as X between 0 and 3");
				row=scanner.nextInt();
				col=scanner.nextInt();
			}
			while(game[row][col]=='X' || game[row][col]=='O');
			game[row][col]='X';
			rounds++;
			if(rounds==9)
			{
				break;
			}
//			if(Utility.ticTacToeResult(game)==userwon || Utility.ticTacToeResult(game)==computerwon)
//			{
//				return game;
//			}
			do
			{
				randomrow=random.nextInt(3);
				randomcol=random.nextInt(3);
				if(game[randomrow][randomcol]=='*')
				{
					game[randomrow][randomcol]='O';
					computer++;
					rounds++;
//					if(Utility.ticTacToeResult(game)==userwon || Utility.ticTacToeResult(game)==computerwon)
//					{
//						return game;
//					}
				}
			}
			while(computer!=1);
			computer=0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					System.out.print(game[i][j]+"  ");
				}
				System.out.println();
			}	
			System.out.println("Play next turn");
		}
		while(rounds<=9);
		return game;
	}
	public static long stopWatch()
	{
		long starttime=System.currentTimeMillis();
		long stoptime=0;
		System.out.println("Enter number to stop the watch=");
		scanner.nextInt();
		stoptime=System.currentTimeMillis();
		long elapsedtime=stoptime-starttime;
		return elapsedtime;
	}
	public static void permutationOfStringIterative(String string)
	{
		
	}
	public static double distance(int x,int y)
	{
		double xsquare=Math.pow(x, 2);
		double ysquare=Math.pow(y, 2);
		double sumofsquares=xsquare+ysquare;
		double distance=Math.pow(sumofsquares, 0.5);
		return distance;
	}
	public static void integerTriplet(int array[])
	{
		int numoftriplets=0;
		for(int i=0;i<array.length-2;i++)
		{
			for(int j=i+1;j<array.length-1;j++)
			{
				for(int k=j+1;k<array.length;k++)
				{
					if(i!=j && j!=k)
					{
						if(array[i]+array[j]+array[k]==0)
						{
							System.out.println(array[i]+" "+array[j]+" "+array[k]);
							numoftriplets++;
						}
					}
				}
			}
		}
		System.out.println("Number of Triplets="+numoftriplets);
	}
	public static void integer2DArray()
	{	
		int row,col;
		System.out.println("Enter Rows and Columns of array=");
		row=scanner.nextInt();
		col=scanner.nextInt();
		int twodarray[][]=new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print("Enter "+(row*col)+" numbers.");
				twodarray[i][j]=scanner.nextInt();
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.println("arr["+i+"]["+j+"]="+twodarray[i][j]);
			}
		}
	}
	public static void double2DArray()
	{
		int row,col;
		System.out.println("Enter Rows and Columns of array=");
		row=scanner.nextInt();
		col=scanner.nextInt();
		double twodarray[][]=new double[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print("Enter "+(row*col)+" numbers.");
				twodarray[i][j]=scanner.nextDouble();
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.println("arr["+i+"]["+j+"]="+twodarray[i][j]);
			}
		}
	}
	public static void boolean2DArray()
	{
		int row,col;
		System.out.println("Enter Rows and Columns of array=");
		row=scanner.nextInt();
		col=scanner.nextInt();
		boolean twodarray[][]=new boolean[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.println("Enter "+(row*col)+" numbers.");
				twodarray[i][j]=scanner.nextBoolean();
			}
		}
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print("arr["+i+"]["+j+"]="+twodarray[i][j]);
			}
		}
	}
	public static void couponNumber(int number)
	{
		int count=0;
		List<Integer> list=new ArrayList<Integer>();
		Random random=new Random();
		int randomnumber;
		do
		{
			randomnumber=random.nextInt(number);
			count++;
			if(!list.contains(new Integer(randomnumber)))
			{
				list.add(randomnumber);
			}
		}
		while(list.size()!=number);
		System.out.println("Total random numbers needed ="+count);
		for(Integer num:list)
		{
			System.out.println(num);
		}
	}
	public static void gambler(int stake,int goal,int times)
	{
		int win=0,lose=0;
		int initialmoney=stake;
		for(int i=0;i<times;i++)
		{
			do
			{
				if(Math.random()>0.5)
				{
					initialmoney++;
				}
				else
				{
					initialmoney--;
				}
			}
			while(initialmoney>=0 && initialmoney<=goal);
			if(initialmoney>=goal)
			{
				win++;
			}
			else
			{
				lose++;
			}
			initialmoney=stake;
		}
		double winpercent=((double)win/(double)times)*100;
		double losepercent=100-winpercent;
		System.out.println("Wins="+win+"  Lose="+lose);
		System.out.println("WinPercentage="+winpercent+"%    LosePercentage"+losepercent+"%");
	}
	public static void primeFactors(int number)
	{
		if(number==1)
		{
			System.out.println(1);
		}
		for(int i=1;i<=number;i++)
		{
			for(int j=2;j<=number;j++)
			{
				if(number%j==0)
				{
					System.out.println(j);
					number=number/j;
					break;
				}
			}
		}
	}
	public static double harmonicNumber(int harmonicnumber)
	{
		double sum=0;
		double div=0;
		for(double i=1;i<=harmonicnumber;i++)
		{
			div=1/i;
			sum=sum+div;
		}
		return sum;
	}
	public static void powerValue(int power)
	{
		int mul=2;
		System.out.println(1);
		for(int i=1;i<=power;i++)
		{
			System.out.println(mul);
			mul=mul*2;	
		}
	}
	public static String helloUserName(String username)
	{
		return "Hello "+username+" ,How are you?";
	}
	public static double flipCoin(int fliptimes)
	{
		double head=0;
		double mathrandom=0;
		double div=0;
		for(int i=0;i<fliptimes;i++)
		{
			mathrandom=Math.random();
			if(mathrandom>0.5f)
			{
				head++;
			}
		}
		div=(head/fliptimes);
		return (div*100);
	}
	public static String leapyear(int year)
	{
		if((year%4)==0)
		{
			return "The year "+year+" is a Leap Year";
		}
		else
		{
			return "The year "+year+" is not a Leap Year";
		}
	}
}