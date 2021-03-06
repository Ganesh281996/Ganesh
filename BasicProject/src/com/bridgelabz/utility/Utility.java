package com.bridgelabz.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("unchecked")
public class Utility
{
	Scanner mScanner;
	
	/**
	 * Constructor to create scanner
	 */
	public Utility()
	{
		mScanner=new Scanner(System.in);
	}
	/**
	 * @return input for String
	 */
	public String next()
	{
		try
		{
			return mScanner.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}	
	/**
	 * @return input for String also takes space
	 */
	public String nextLine()
	{
		try
		{
			return mScanner.nextLine();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "";
	}	
	/**
	 * @return Input for Integer
	 */
	public int nextInt()
	{
		try
		{
			return mScanner.nextInt();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}	
	/**
	 * @return Input for Double
	 */
	public double nextDouble()
	{
		try
		{
			return mScanner.nextDouble();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}	
	/**
	 * @return Input for Boolean
	 */
	public boolean nextBoolean()
	{
		try
		{
			return mScanner.nextBoolean();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * @return Input for Long
	 */
	public long nextLong()
	{
		try
		{
			return mScanner.nextLong();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * purpose: convert the given number to its Binary representation
	 * @param number input from user to convert into binary form
	 * @return Binary string representation of giver number
	 */
	public static String toBinary(int number)
	{
		String ans="";
		int rem=0;
		do
		{
			rem=number%2;
			ans=rem+ans;
			number=number/2;
		}
		while(number>0);
		do
		{
			ans="0"+ans;
		}
		while(ans.length()<32);
		System.out.println();
		return ans;
	}
	/**
	 * purpose: finding day of given date
	 * @param day 
	 * @param month
	 * @param year
	 * @return day of given date
	 */
	public static int dayOfWeek(int day,int month,int year) 
	{
		int y=year-(14-month)/12;
		int x=y+(y/4)-(y/100)+(y/400);
		int m=month+12*((14-month)/12)-2;
		int d= (day+x+31*m/12)%7;
		return d;
	}
	/**
	 * purpose: take positive integer as input and find square root of it
	 * @param c input from user to find the square root
	 * @return square root of the given number
	 */
	public static double sqrt(double c)
	{
		double t=c;
		double epsilon=Math.pow(10, -15);
		double div;
		do
		{
			t=(t+(c/t))/2;
			div=t-(c/t);
		}
		while(Math.abs(div)>epsilon*t);
		return t;
	}
	/**
	 * purpose: merging the sub arrays to form original array
	 * @param array main array
	 * @param low starting index of array
	 * @param mid middle index of array
	 * @param high last index of array
	 */
	public static void mergeThem(String array[],int low,int mid,int high)
	{
		int subArraySize1=mid-low+1;
		int subArraySize2=high-mid;
		String subArray1[]=new String[subArraySize1];
		String subArray2[]=new String[subArraySize2];
		for(int i=0;i<subArraySize1;i++)
		{
			subArray1[i]=array[i+low];
		}
		for(int i=0;i<subArraySize2;i++)
		{
			subArray2[i]=array[i+mid+1];
		}
		int subArrayInitial1=0,subArrayInitial2=0;
		int mainArraySize=low;
		while(subArrayInitial1<subArraySize1 && subArrayInitial2<subArraySize2)
		{
			if(subArray1[subArrayInitial1].compareToIgnoreCase(subArray2[subArrayInitial2])<0)
			{
				array[mainArraySize]=subArray1[subArrayInitial1];
				subArrayInitial1++;
				mainArraySize++;
			}
			else
			{
				array[mainArraySize]=subArray2[subArrayInitial2];
				subArrayInitial2++;
				mainArraySize++;
			}
		}
		while(subArrayInitial1<subArraySize1)
		{
			array[mainArraySize]=subArray1[subArrayInitial1];
			subArrayInitial1++;
			mainArraySize++;
		}
		while(subArrayInitial2<subArraySize2)
		{
			array[mainArraySize]=subArray2[subArrayInitial2];
			subArrayInitial2++;
			mainArraySize++;
		}
	}
	/**
	 * purpose: dividing array into sub arrays
	 * @param array main array
	 * @param low starting index of array
	 * @param high last index of array
	 * @return sorted array using merge sort
	 */
	public static String[] mergeSortString(String array[],int low,int high)
	{
		int mid;
		if(array.length==0 ||array.length==1)
		{
			return array;
		}
		if(low<high)
		{
			mid=low+((high-low)/2);
			mergeSortString(array, low, mid);
			mergeSortString(array, mid+1, high);
			mergeThem(array, low, mid, high);
		}
		return array;
	}
	/** 
	 * purpose: finding monthly payment using given inputs
	 * @param p principle
	 * @param y year
	 * @param r rate of interest
	 * @return double value of monthly payment
	 */
	public static double monthlyPayment(double p,double y,double r)
	{
		double smallr=r/(12*100);
		double smalln=12*y;
		double payment=(p*smallr)/(1-Math.pow((1+smallr), -smalln));
		return payment;
	}
	/**
	 * purpose: computer will guess number that u selected using random number 
	 * @param bigN range of numbers to guess
	 * @param smallN number of guesses
	 * @param myNumber number to search
	 */
	public static void guessNumber(int bigN,int smallN,int myNumber)
	{
		Utility utility=new Utility();
		int array[]=new int[bigN];
		boolean flag=false;
		int i;
		for(i=0;i<bigN;i++)
		{
			array[i]=i;
		}
		Random random=new Random();
		int randomNumber=0;
		int first=0,last=bigN-1,mid=bigN;
		for(i=0;i<smallN;i++)
		{
			do
			{
				randomNumber=random.nextInt(mid);
			}
			while(randomNumber<=first || randomNumber>=last);
			if(randomNumber==myNumber)
			{
				System.out.println(randomNumber);
				System.out.println("Number was found.");
				break;
			}
			else
			{
				System.out.println(randomNumber);
				System.out.println("Enter true if the number is greater =");
				flag=utility.nextBoolean();
			}
			if(flag==true)
			{
				last=randomNumber-1;
			}
			else
			{
				first=randomNumber+1;
			}
			mid=(first+last)/2;
		}
		if(i>=smallN)
		{
			System.out.println("Number was not found.");
		}
	}
	/**
	 * purpose: convert celcius to fahrenheit
	 * @param celsius temperature in celcius
	 * @return temperature in fahrenheit
	 */
	public static double celsiusToFahrenheit(double celsius)
	{
		return ((celsius*9/5)+32);
	}
	/**
	 * purpose: convert fahrenheit to celcius
	 * @param fahrenheit temperature in Fahrenheit
	 * @return temperature in cencius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) 
	{
		return ((fahrenheit-32)*5/9);
	}
	/**
	 * purpose: Sorting String using Insertion sort
	 * @param array array to be sorted
	 * @return sorted array
	 */
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
	/**
	 * purpose: Sorting Integer array using Insertion sort
	 * @param array array to be sorted
	 * @return sorted array
	 */
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
	/**
	 * purpose: Search number in integer array using binary search
	 * @param array input array
	 * @param number value to be searched in array
	 * @return true if number is found else false
	 */
	public static boolean binarySearchInteger(int array[],int number)
	{
		array=bubbleSortInteger(array);
		int first=0,mid=array.length/2,last=array.length-1;
		int count=0;
		int originalLast=last;
		do
		{
			for(int i=0;i<originalLast;i++)
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
			if(count>originalLast)
			{
				return false;
			}
		}
		while(mid>0 && mid<originalLast-1);
		return false;
	}
	/**
	 * purpose: Search String in String array using binary search
	 * @param array input array
	 * @param string value to be searched in array
	 * @return true if string is found else false
	 */
	public static boolean binarySearchString(String array[],String string)
	{
		array=bubbleSortString(array);
		int first=0,mid=array.length/2,last=array.length-1;
		int count=0;
		int originalLast=last;
		do
		{
			for(int i=0;i<originalLast;i++)
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
			if(count>originalLast)
			{
				return false;
			}
		}
		while(mid>0 && mid<originalLast-1);
		return false;
	}
	/**
	 * purpose: sorting String array using bubble sort
	 * @param array input array
	 * @return sorted array
	 */
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
	/**
	 * purpose: sorting long array in descending order
	 * @param array input array
	 * @return sorted array
	 */
	public static long[] sortLongDesc(long[] array)
	{
		long temp=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length-1;j++)
			{
				if(array[j]<array[j+1])
				{
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
		}
		return array;
	}
	/**
	 * purpose: Sorting integer array using bubble sort
	 * @param array input array
	 * @return sorted array
	 */
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
	/**
	 * purpose: Finding if the given number is palindrome or not
	 * @param number input number
	 * @return returns true if number is palindrome else false
	 */
	public static boolean palindrome(int number)
	{
		int reverseNumber=0;
		int originalNumber=number;
		while(number!=0)
		{
			reverseNumber=(10*reverseNumber)+(number%10);
			number=number/10;
		}
		if(originalNumber==reverseNumber)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * purpose: Finding if the given number is prime or not
	 * @param number input number
	 * @return true if number is prime else false
	 */
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
	/**
	 * purpose: sorting character array
	 * @param charArray input character array
	 * @return sorted array
	 */
	public static char[] sortCharArray(char[] charArray)
	{
		char temp=0;
		for(int i=0;i<charArray.length;i++)
		{
			for(int j=0;j<charArray.length;j++)
			{
				if(charArray[i]>charArray[j])
				{
					temp=charArray[i];
					charArray[i]=charArray[j];
					charArray[j]=temp;
				}
			}
		}
		return charArray;
	}
	/**
	 * purpose: finding if the given strings are anagram or not
	 * @param string1 first string 
	 * @param string2 second string
	 * @return true if strings are anagram else false
	 */
	public static boolean findingAnagram(String string1,String string2)
	{
		int count=0;
		if(string1.length()!=string2.length())
		{
			return false;
		}
		char charArray1[]=string1.toCharArray();
		char charArray2[]=string2.toCharArray();
		charArray1=sortCharArray(charArray1);
		charArray2=sortCharArray(charArray2);
		for(int i=0;i<charArray1.length;i++)
		{
			if(charArray1[i]==charArray2[i])
			{
				count++;
			}
		}
		if(count==charArray1.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * purpose: calculating windchill using formula
	 * @param t temperature in fahrenheit
	 * @param v speed in miles per hour
	 * @return calculated windchill 
	 */
	public static double windChill(double t,double v)
	{
		double w=35.74+0.6215*t+(((0.4275*t)-35.75)*Math.pow(v, 0.16));
		return w;
	}
	/**
	 * purpose: finding roots of given equation
	 * @param a value used in formula
	 * @param b value used in formula
	 * @param c value used in formula
	 * @return roots of equation
	 */
	public static double[] quadratic(double a,double b,double c)
	{
		double rootArray[]=new double[2];
		double bSquare=b*b;
		double delta=bSquare-(4*a*c);
		if(delta>=0)
		{
			rootArray[0]=(-b+Math.sqrt(delta))%(2*a);
			rootArray[1]=(-b-Math.sqrt(delta))%(2*a);
			return rootArray;
		}
		return null;
	}
	/**
	 * purpose: Finding the result of tic tac toe game played by user and computer
	 * @param game value of game in twodarray form
	 * @return who won the game or is it draw
	 */
	public static String ticTacToeResult(char[][] game)
	{
		String userWon="Player 1 User has won.";
		String computerWon="Player 2 Computer has won.";
		String draw="It was a Draw.";
		for(int k=0;k<3;k++)
		{
			int j=0;
			for(int i=0;i<3;i++)
			{
				if(i==j && game[i][j]==game[i+1][j+1] && game[i+1][j+1]==game[i+2][j+2])
				{
					if(game[i][j]=='X')
					{
						return userWon;
					}
					else if(game[i][j]=='O')
					{
						return computerWon;
					}
				}
				if(game[0][2]==game[1][1] && game[1][1]==game[2][0])
				{
					if(game[0][2]=='X')
					{
						return userWon;
					}
					else if(game[0][2]=='O')
					{
						return computerWon;
					}
				}
				if(game[i][j]==game[i][j+1] && game[i][j+1]==game[i][j+2])
				{
					if(game[i][j]=='X')
					{
						return userWon;
					}
					else if(game[i][j]=='O')
					{
						return computerWon;
					}
				}
				if(game[j][i]==game[j+1][i] && game[j+1][i]==game[j+2][i])
				{
					if(game[i][j]=='X')
					{
						return userWon;
					}
					else if(game[i][j]=='O')
					{
						return computerWon;
					}
				}
			}
		}
		return draw;
	}
	/**
	 * purpose: playing tic tac toe game 
	 * @param game twodarray on which game will be played
	 * @return returns the game played
	 */
	public static char[][] ticTacToe(char[][] game)
	{
		Utility utility=new Utility();
		String userWon="Player 1 User has won.";
		String computerWon="Player 2 Computer has won.";
		System.out.println("Player 1 :User");
		System.out.println("Player 2 :Computer");
		System.out.println("User will start the game.");
		int rounds=0;
		int row,col;
		int computer=0;
		Random random=new Random();
		int randomRow,randomCol;
		do
		{
			do
			{
				System.out.println("Enter column and row to mark as X between 0 and 3");
				row=utility.nextInt();
				col=utility.nextInt();
			}
			while(game[row][col]=='X' || game[row][col]=='O');
			game[row][col]='X';
			rounds++;
			if(rounds==9)
			{
				break;
			}
			if(rounds>4)
			{
				if(Utility.ticTacToeResult(game)==userWon || Utility.ticTacToeResult(game)==computerWon)
				{
					return game;
				}
			}
			do
			{
				randomRow=random.nextInt(3);
				randomCol=random.nextInt(3);
				if(game[randomRow][randomCol]=='*')
				{
					game[randomRow][randomCol]='O';
					computer++;
					rounds++;
					if(rounds>4)
					{
						if(Utility.ticTacToeResult(game)==userWon || Utility.ticTacToeResult(game)==computerWon)
						{
							return game;
						}
					}
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
	/**
	 * purpose: Finding elapsed time between two inputs from user
	 * @return elapsed time
	 */
	public static double stopWatch()
	{
		Utility utility=new Utility();
		double stopTime=0;
		double startTime=System.currentTimeMillis();
		System.out.println("Enter number to stop the watch=");
		utility.nextInt();
		stopTime=System.currentTimeMillis();
		double elapsedTime=stopTime-startTime;
		return elapsedTime/1000;
	}
	/**
	 * purpose: finding all the combinations of given string
	 * @param string input String
	 */
	public static void permutationOfStringIterative(String string)
	{
		Set<String> set=new TreeSet<String>();
		int noOfPermutations=1,intNumber=0;
		for(int i=1;i<=string.length();i++)
		{
			noOfPermutations=noOfPermutations*i;
		}
		List<Integer> randomNumber=new ArrayList<Integer>();
		int number=0,count=0;
		String temp1="";
		Random random=new Random();
		do
		{
			do
			{
				number=random.nextInt(string.length());
				count++;
				if(!randomNumber.contains(number))
				{
					randomNumber.add(number);
				}
			}
			while(randomNumber.size()!=string.length());
			for(int k=0;k<string.length();k++)
			{
				temp1=temp1+string.charAt(randomNumber.get(k));
			}
			randomNumber.removeAll(randomNumber);
			set.add(temp1);
			temp1="";
		}
		while(set.size()!=noOfPermutations);
		System.out.println("No of Iterations="+count);
		System.out.println("No of Permutations="+noOfPermutations);
		for(String s:set)
		{
			intNumber++;
			if(intNumber==100)
			{
				intNumber=1;
				System.out.println();
			}
			System.out.print(s+" ");
		}
	}
	/**
	 * purpose: Finding distance using power function
	 * @param x value used in formula
	 * @param y value used in formula
	 * @return calculated distance
	 */
	public static double distance(int x,int y)
	{
		double xSquare=Math.pow(x, 2);
		double ySquare=Math.pow(y, 2);
		double sumOfSquares=xSquare+ySquare;
		double distance=Math.pow(sumOfSquares, 0.5);
		return distance;
	}
	/**
	 * purpose: finding distinct integer triplets whose sum=0
	 * @param array input array
	 */
	public static void integerTriplet(int array[])
	{
		int numOfTriplets=0;
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
							numOfTriplets++;
						}
					}
				}
			}
		}
		System.out.println("Number of Triplets="+numOfTriplets);
	}
	/**
	 * Purpose: Reading Generic 2Darray and printing it
	 * @param twodarray array of generic type
	 * @param row number of rows
	 * @param col number of columns
	 */
	public static <T> void generic2DArray(T[][] twodarray,int row,int col)
	{	
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				System.out.print("arr["+i+"]["+j+"]="+twodarray[i][j]+"  ");
			}
			System.out.println();
		}
	}
	/** 
	 * purpose: random numbers need to generate distinct coupon numbers
	 * @param number N distinct coupon number
	 */
	public static void couponNumber(int number)
	{
		int count=0;
		List<Integer> list=new ArrayList<Integer>();
		Random random=new Random();
		int randomNumber;
		do
		{
			randomNumber=random.nextInt(number);
			count++;
			if(!list.contains(new Integer(randomNumber)))
			{
				list.add(randomNumber);
			}
		}
		while(list.size()!=number);
		System.out.println("Total random numbers needed ="+count);
		for(Integer num:list)
		{
			System.out.println(num);
		}
	}
	/**
	 * purpose: gambler game. Start with stake and keep betting to win or lose
	 * @param stake initial money
	 * @param goal goal need to be reached in order to win
	 * @param times how times to play
	 */
	public static void gambler(int stake,int goal,int times)
	{
		int win=0,lose=0;
		int initialMoney=stake;
		for(int i=0;i<times;i++)
		{
			do
			{
				if(Math.random()>0.5)
				{
					initialMoney++;
				}
				else
				{
					initialMoney--;
				}
			}
			while(initialMoney>=0 && initialMoney<=goal);
			if(initialMoney>=goal)
			{
				win++;
			}
			else
			{
				lose++;
			}
			initialMoney=stake;
		}
		double winPercent=((double)win/(double)times)*100;
		double losePercent=100-winPercent;
		System.out.println("Wins="+win+"  Lose="+lose);
		System.out.println("WinPercentage="+winPercent+"%    LosePercentage"+losePercent+"%");
	}
	/**
	 * purpose: finding prime factors of given number
	 * @param number input number
	 */
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
	/**
	 * purpose: finding harmonic number using formula
	 * @param harmonicNumber input variable
	 * @return calculated harmonic number
	 */
	public static double harmonicNumber(int harmonicNumber)
	{
		double sum=0;
		double div=0;
		for(double i=1;i<=harmonicNumber;i++)
		{
			div=1/i;
			sum=sum+div;
		}
		return sum;
	}
	/**
	 * purpose: finding power of 2 which is less than given number
	 * @param power input number
	 */
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
	/**
	 * purpose: printing hello username
	 * @param userName input name
	 * @return string representing hello username
	 */
	public static String helloUserName(String userName)
	{
		return "Hello "+userName+" ,How are you?";
	}
	/**
	 * purpose: flip a coin many times and find percentage of heads and tails
	 * @param flipTimes number of times to flip coin
	 * @return percentage of head
	 */
	public static double flipCoin(int flipTimes)
	{
		double head=0;
		double mathRandom=0;
		double div=0;
		for(int i=0;i<flipTimes;i++)
		{
			mathRandom=Math.random();
			if(mathRandom>0.5f)
			{
				head++;
			}
		}
		div=(head/flipTimes);
		return (div*100);
	}
	/**
	 * purpose: finding if the given year is leap year or not
	 * @param year given year
	 * @return string stating if the year is leap year or not
	 */
	public static boolean leapYear(int year)
	{
		if(((year%4)==0 && (year%100)!=0) || (year%400)==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * purpose: swapping nibbles of a binary number
	 * @param number input number
	 * @return true if decimal value is power of 2 else false
	 */
	public static boolean swapNibble(int number)
	{
		String binary=toBinary(number);
		int size=binary.length()-1;
		String bit8="";
		String firstHalf="";
		String secondHalf="";
		double decimal;
		int num1=0,num2=4;
		do
		{
			bit8=binary.charAt(size)+bit8;
			size--;
		}
		while(bit8.length()!=8);
		do
		{
			firstHalf=firstHalf+bit8.charAt(num1);
			secondHalf=secondHalf+bit8.charAt(num2);
			num1++;num2++;
		}
		while(num1<4 && num2!=8);
		binary=secondHalf+firstHalf;System.out.println(binary);
		decimal=toDecimal(binary);
		System.out.println("The Decimal Number after swapping nibbles="+decimal);
		for(int i=0;i<decimal;i++)
		{
			if((i*2)==decimal)
			{
				return true;
			}
		}
		return false;
	}
	/**
	 * purpose: converts binary numbers to decimal
	 * @param binary input binary number
	 * @return decimal value of binary
	 */
	public static double toDecimal(String binary)
	{
		double decimal=0;
		int num=7;
		for(int i=0;i<binary.length()-1;i++)
		{
			if(binary.charAt(i)=='1')
			{
				decimal=decimal+Math.pow(2, num);
			}
			num--;
		}
		return decimal;
	}
	/**
	 * purpose: finding number of notes from given amount of money
	 * @param amount input money
	 * @return array of number of notes
	 */
	public static int[] noOfNotes(int amount)
	{
		int noOfNotes[]=new int[8];
		int notes[]={1000,500,100,10,5,2,1};
		int sizeOfNotes=0,sizeNotes=0;
		int number=0;
		do
		{
			number=amount/notes[sizeNotes];
			amount=amount%notes[sizeNotes];
			noOfNotes[sizeOfNotes]=number;
			sizeOfNotes++;
			sizeNotes++;
		}
		while(amount!=0);
		return noOfNotes;
	}
	/**
	 * purpose: finding numbers which are prime, palindrome and anagrams
	 * @param range range of numbers(0 to range)
	 */
	public static void primePalindromeAnagram(int range)
	{
		List<Integer> primeNumber=new ArrayList<Integer>();
		List<Integer> primePalindrome=new ArrayList<Integer>();
		Set<Integer> primeAnagram=new TreeSet<Integer>();
		List<Integer> primePalindromeAnagram=new ArrayList<Integer>();
		String string1="",string2="";
		for(int i=0;i<range;i++)
		{
			if(primeNumber(i)==true)
			{
				primeNumber.add(i);
			}
		}
		System.out.println("Prime numbers="+primeNumber);
		for(Integer i:primeNumber)
		{
			if(palindrome(i)==true)
			{
				primePalindrome.add(i);
			}
		}
		System.out.println("PrimePalindromes="+primePalindrome);
		for(Integer i:primeNumber)
		{
			for(Integer j:primeNumber)
			{
				if(!i.equals(j))
				{
					string1=string1+i;
					string2=string2+j;
					if(findingAnagram(string1, string2)==true)
					{
						primeAnagram.add(i);
						primeAnagram.add(j);
					}
					string1="";
					string2="";
				}
			}
		}
		System.out.println("PrimeAnagrams="+primeAnagram);
		for(Integer i:primePalindrome)
		{
			if(primeAnagram.contains(i))
			{
				primePalindromeAnagram.add(i);
			}
		}
		System.out.println("PrimePalindromeAnagram="+primePalindromeAnagram);
	}
	/**
	 * purpose: taking path as input and getting the contents present on the file
	 * @param path path of the file
	 * @return string array of contents present in file
	 */
	public static String[] getFileContents(String path)
	{
		InputStream file=null;
		String string="";
		String array[]=null;
		int content=0;
		try
		{
			file=new FileInputStream(path);
			while((content=file.read())!=-1)
			{
				string=string+(char)content;
			}
			array=string.split(" ");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return array;
	}
	/**
	 * Purpose: takes byte array and stores in file
	 * @param bytearray byte array input
	 * @param path path of file
	 */
	public static void bytesToFile(byte bytearray[],String path)
	{
		OutputStream list=null;
		InputStream file=null;
		int content=0;
		try
		{
			list=new FileOutputStream(path);
			list.write(bytearray);
			file=new FileInputStream(path);
			while((content=file.read())==-1)
			{
				System.out.print((char)content);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Purpose: Printing the calendar of given month and year
	 * @param year input year of calendar
	 * @param month input month of calendar
	 * @return 2D array of calendar
	 */
	public static String[][] calender(int year,int month)
	{
		String calender[][]=new String[7][7];
		int dayOfWeek,date=1;
		int temp=0;
		calender[0][0]="Sun";
		calender[0][1]="Mon";
		calender[0][2]="Tue";
		calender[0][3]="Wed";
		calender[0][4]="Thu";
		calender[0][5]="Fri";
		calender[0][6]="Sat";
		dayOfWeek=dayOfWeek(1, month, year);
		if(leapYear(year) && month==2)
		{
			for(int j=1;j<7;j++)
			{
				for(int k=dayOfWeek;k<7;k++)
				{
					calender[j][k]=""+date;
					date++;
					if(date==30)
					{
						break;
					}
				}	
				dayOfWeek=temp;
				temp++;
				if(date==30)
				{
					break;
				}
			}
		}
		else if((!leapYear(year)) && month==2)
		{
			for(int j=1;j<7;j++)
			{
				for(int k=dayOfWeek;k<7;k++)
				{
					calender[j][k]=""+date;
					date++;
					if(date==29)
					{
						break;
					}
				}	
				dayOfWeek=temp;
				temp++;
				if(date==29)
				{
					break;
				}
			}
		}
		else
		{
			if(month==4 || month==6 || month==9 || month==11)
			{
				for(int j=1;j<7;j++)
				{
					for(int k=dayOfWeek;k<7;k++)
					{
						calender[j][k]=""+date;
						date++;
						if(date==31)
						{
							break;
						}
					}	
					dayOfWeek=temp;
					temp++;
					if(date==31)
					{
						break;
					}
				}
			}
			else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
			{
				for(int j=1;j<7;j++)
				{
					for(int k=dayOfWeek;k<7;k++)
					{
						calender[j][k]=""+date;
						date++;
						if(date==32)
						{
							break;
						}
					}
					dayOfWeek=temp;
					temp++;
					if(date==32)
					{
						break;
					}
				}
			}
		}
		for(int i=1;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				if(calender[i][j]!=null)
				{
					do
					{
						calender[i][j]=calender[i][j]+" ";
					}
					while(calender[i][j].length()!=3);
				}
				if(calender[i][j]==null)
				{
					calender[i][j]="   ";
				}
			}
		}
		return calender;
	}
	/**
	 * Purpose: creates 2d array of range of prime numbers
	 * @param range max range of prime numbers
	 * @return 2d array of prime numbers
	 */
	public static String[][] twoDPrimeNumber(int range,int col)
	{
		String array[][]=new String[100][col];
		int a=100,b=-1,c=0;
		int temp=0;
		for(int i=0;i<col;i++)
		{
			array[0][i]=temp+"-"+(temp+100);
			temp=temp+100;
		}
		temp=2;
		for(int i=0;i<col;i++)
		{
			for(int j=1;j<100;j++)
			{
				for(int k=temp;k<a;k++)
				{
					if(primeNumber(k))
					{
						array[j][i]=""+k;
						temp=k+1;
						break;
					}
					if(k==range)
					{
						b=range;
						break;
					}
				}
			}
			c=c+100;
			temp=c;
			a=a+100;
			if(b==range)
			{
				break;
			}
		}
		return array;
	}
	/**
	 * Purpose: removing null values from 2d arrays
	 * @param array 2d array input
	 * @param col number of columns
	 * @return null free 2d array
	 */
	public static String[][] removeNull(String[][] array,int col)
	{
		for(int i=1;i<100;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(array[i][j]!=null)
				{
					do
					{
						array[i][j]=array[i][j]+" ";
					}
					while(array[i][j].length()<=6);
				}
				if(array[i][j]==null)
				{
					array[i][j]="";
				}
			}
		}
		return array;
	}
	/**
	 * Purpose: create 2D array of anagrams that are prime number
	 * @param range range of numbers
	 * @param col number of columns
	 * @return 2D array of anagrams that are prime number
	 */
	public static String[][] twoDPrimeAnagram(int range,int col)
	{
		int temp=0,temp1,temp2,temp3=1;
		String array[][]=twoDPrimeNumber(range, col);
		String arrayAnagram[][]=new String[100][col];
		for(int i=0;i<col;i++)
		{
			arrayAnagram[0][i]=temp+"-"+(temp+100);
			temp=temp+100;
		}
		for(int j=0;j<col;j++)
		{
			for(int i=1;i<100;i++)
			{
				if(array[i][j]!=null)
				{
					for(int k=i+1;k<100-i;k++)
					{
						if(array[k][j]!=null)
						{
							temp1=Integer.parseInt(array[i][j]);
							temp2=Integer.parseInt(array[k][j]);
							if(    (findingAnagram(array[i][j], array[k][j]))  && 
								   (primeNumber(temp1) && primeNumber(temp2))    )
							{
								arrayAnagram[temp3][j]=array[i][j];
								temp3++;
								arrayAnagram[temp3][j]=array[k][j];
								temp3++;
							}
						}
					}
				}
			}
			temp3=1;
		}
		return arrayAnagram;
	}
	/**
	 * Purpose: finding number of binary search tree for given test case
	 * @param test input test case
	 * @return number of binary search tree
	 */
	public static double binarySearchTreeTestCase(int test)
	{
		double twoNFactorial=1,nFactorial=1,n1Factorial=1;
		double no_of_tree;
		for(int j=1;j<=test;j++)
		{
			nFactorial=nFactorial*j;
		}
		for(int j=1;j<=2*test;j++)
		{
			twoNFactorial=twoNFactorial*j;
		}
		n1Factorial=nFactorial*(test+1);
		no_of_tree=twoNFactorial/((n1Factorial)*(nFactorial));
		return no_of_tree%(Math.pow(10, 8)+7);
	}
	/**
	 * Purpose: Creating calendar using Queue
	 * @param array 2d array of calendar
	 * @return calendar created using Queue
	 */
	public static Queue<String>[]  calendarQueue(String[][] array)
	{
		Queue<String> weekDays[]=new Queue[7];
		for(int i=0;i<7;i++)
		{
			weekDays[i]=new Queue<String>(7);
		}
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				weekDays[j].enQueue(array[i][j]);
			}
		}
		return weekDays;
	}
	/**
	 * Purpose: Creating calendar using Queue
	 * @param array 2d calendar
	 * @return calendar created using Stack
	 */
	public static Stack<String>[]  calendarStack(String[][] array)
	{
		Stack<String> weekdays[]=new Stack[7];
		for(int i=0;i<7;i++)
		{
			weekdays[i]=new Stack<String>(7);
		}
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				weekdays[j].push(array[i][j]);
			}
		}
		return weekdays;
	}
	/**
	 * Purpose : search number using hashing slot mechanism
	 * @param stringArray array of string
	 * @return array of linked list
	 */
	public static LinkedList<Integer>[] hashingSearchSlotNumber(String stringArray[])
	{
		Utility utility=new Utility();
		LinkedList<Integer> listArray[]=new LinkedList[11];
		Map<Integer, LinkedList<Integer>> map=new HashMap<Integer, LinkedList<Integer>>();
		int intArray[]=new int[stringArray.length];
		int temp=0;
		for(int i=0;i<intArray.length;i++)
		{
			intArray[i]=Integer.parseInt(stringArray[i]);
		}
		for(int i=0;i<11;i++)
		{
			listArray[i]=new LinkedList<Integer>();
		}
		for(int j=0;j<intArray.length;j++)
		{
			temp=intArray[j]%11;
			listArray[temp].add(intArray[j]);
		}
		for(int j=0;j<11;j++)
		{
			listArray[j].order();
		}
		for(int i=0;i<11;i++)
		{
			map.put(i, listArray[i]);
		}
		System.out.println(" Keys   Values");
		for(Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet())
		{
			System.out.println("  "+entry.getKey()+"    "+entry.getValue());
		}
		System.out.println("Enter Number to search=");
		int number=utility.nextInt();
		boolean flag=false;
		temp=number%11;
		for(Map.Entry<Integer, LinkedList<Integer>> entry: map.entrySet())
		{
			if(entry.getKey()==temp && entry.getValue().getFirstItem()!=null)
			{
				flag=entry.getValue().search(number);
			}
		}	
		if(flag==true)
		{
			System.out.println("Number was Found.");
			listArray[temp].remove(number);
			listArray[temp].order();
		}
		else
		{
			System.out.println("Number was not Found.");
			listArray[temp].add(number);
			listArray[temp].order();
		}
		return listArray;
	}
	/**
	 * @param path path of the file
	 */
	public static JSONObject ricePulseWheat(String path)
	{
		JSONParser parser=null;
		JSONObject jsonObject=null,rice=null,pulse=null,wheat=null;
		FileReader file=null;
		try
		{
			file=new FileReader(path);
			parser=new JSONParser();
			jsonObject=(JSONObject)parser.parse(file);
			
			rice=(JSONObject)jsonObject.get("Rice");
			System.out.println(rice);
			
			pulse=(JSONObject)jsonObject.get("Pulse");
			System.out.println(pulse);
			
			wheat=(JSONObject)jsonObject.get("Wheat");
			System.out.println(wheat);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * @param path path of the file
	 */
	public static void inventoryManagement(String path)
	{
		long total=0;
		JSONObject jsonObject=ricePulseWheat(path);
		
		JSONObject rice=(JSONObject)jsonObject.get("Rice");
		total=(Long)rice.get("Weight")*(Long)rice.get("Price");
		rice.put("Total", total);
		
		JSONObject pulse=(JSONObject)jsonObject.get("Pulse");
		total=(Long)pulse.get("Weight")*(Long)pulse.get("Price");
		pulse.put("Total", total);
		
		JSONObject wheat=(JSONObject)jsonObject.get("Wheat");
		total=(Long)wheat.get("Weight")*(Long)wheat.get("Price");
		wheat.put("Total", total);
		
		jsonObject=new JSONObject();
		jsonObject.put("Rice", rice);
		jsonObject.put("Pulse", pulse);
		jsonObject.put("Wheat", wheat);
		path="/home/bridgeit/Ganesh/BasicProject/Files/InventoryManagement";
		FileWriter file=null;
		try
		{
			file=new FileWriter(path);
//			System.out.println(jsonObject);
			file.write(jsonObject.toJSONString());
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(file!=null)
				{
					file.flush();
					file.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		ricePulseWheat(path);
	}
	/**
	 * @param noOfStocks total no of stocks
	 * @param path path of the file
	 */
	public static void stockReport(int noOfStocks,String path)
	{
		JSONObject stock=new JSONObject();
		JSONObject jsonObject=new JSONObject();
		Utility utility=new Utility();
		String stockName=null;
		long noOfShare=0,sharePrice=0,stockValue=0,totalValue=0;
		for(int i=0;i<noOfStocks;i++)
		{
			System.out.println("Enter Stock Name");
			stockName=utility.next();
			stock.put("Stock_Name", stockName);
			System.out.println("Enter Number of Shares=");
			noOfShare=utility.nextLong();
			stock.put("Number_Of_Shares", noOfShare);
			System.out.println("Enter Price of Each Share=");
			sharePrice=utility.nextLong();
			stock.put("Price", sharePrice);
			stockValue=noOfShare*sharePrice;
			totalValue=totalValue+stockValue;
			stock.put("Stock_Value", stockValue);
			jsonObject.put("Stock_"+(i+1), stock);
			stock=new JSONObject();
		}
		jsonObject.put("Total_Value", totalValue);
		System.out.println(jsonObject);
		FileWriter fileWriter=null;
		try
		{
			fileWriter=new FileWriter(path);
			fileWriter.write(jsonObject.toJSONString());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if(fileWriter!=null)
				{
					fileWriter.flush();
					fileWriter.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	/**
	 * @param nonShuffledCards 2D array containing ordered cards
	 * @param suit array of suits
	 * @param rank array of ranks
	 * @return 2D array stating which player got which cards
	 */
	public static String[][]  deckOfCards(String nonShuffledCards[][],String suit[],String rank[])
	{
		String shuffleCards[][]=new String[52][2];
		int row=0,column=0,countRow=0;
		List<Integer> list=new ArrayList<Integer>();
		Random random=new Random();
		do
		{
			row=random.nextInt(52);
			if(!list.contains(row))
			{
				list.add(row);
				shuffleCards[countRow][column]=nonShuffledCards[row][column];
				shuffleCards[countRow][column+1]=nonShuffledCards[row][column+1];
				countRow++;
			}
		}
		while(shuffleCards[51][1]==null);
		System.out.println("Shuffled Cards=");
		for(int i=0;i<52;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.print(shuffleCards[i][j]+"  ");
			}
			System.out.println();
		}
		String distributeCards[][]=new String[14][5];
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<5;j++)
			{
				distributeCards[i][j]="";
			}
		}
		for(int i=1;i<14;i++)
		{
			distributeCards[i][0]=rank[i-1];
		}
		for(int i=1;i<5;i++)
		{
			distributeCards[0][i]=suit[i-1];
		}
		int user=1;
		for(int k=0;k<36;k++)
		{
			for(int i=1;i<5;i++)
			{
				if(shuffleCards[k][0].equals(distributeCards[0][i]))
				{
					for(int j=0;j<13;j++)
					{
						if(shuffleCards[k][1].equals(distributeCards[j+1][0]))
						{
							distributeCards[j+1][i]=user+"";
							user++;
						}
					}
				}
			}
			if(user==5)
			{
				user=1;
			}
		}
		return distributeCards;
	}
	/**
	 * @param array 2D array to align space
	 * @return aligned 2Darray
	 */
	public static String[][] alignSpace(String array[][])
	{
		for(int i=0;i<14;i++)
		{
			for(int j=0;j<5;j++)
			{
				do
				{
					array[i][j]=array[i][j]+" ";
				}
				while(array[i][j].length()!=10);
			}
		}
		return array;
	}
	/**
	 * @param nonShuffledCards deck of cards not shuffled
	 * @param suit Diamond,Spade,Heart,Club
	 * @param rank 2 to 10,king,queen,jack,ace
	 */
	public static void queueDeckOfCards(String nonShuffledCards[][],String suit[],String rank[])
	{
		String shuffleCards[][]=new String[52][2];
		int row=0,column=0,count_row=0;
		List<Integer> list=new ArrayList<Integer>();
		Random random=new Random();
		do
		{
			row=random.nextInt(52);
			if(!list.contains(row))
			{
				list.add(row);
				shuffleCards[count_row][column]=nonShuffledCards[row][column];
				shuffleCards[count_row][column+1]=nonShuffledCards[row][column+1];
				count_row++;
			}
		}
		while(shuffleCards[51][1]==null);
		
		Queue<String> array[]=new Queue[4];
		int count=0;
		
		for(int i=0;i<4;i++)
		{
			array[i]=new Queue<String>(9);
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<9;j++)
			{
				array[i].enQueue(shuffleCards[count][1]+shuffleCards[count++][0]);
			}
		}
		
		for(int i=0;i<4;i++)
		{
			array[i].orderString();
		}
		count =1;
		Queue<String> sortedQueue[]=new Queue[4];
		for(int i=0;i<4;i++)
		{
			sortedQueue[i]=new Queue<String>(9);
		}
		String stringArray[]=null,temp1="",temp2="";
		for(int i=0;i<4;i++)
		{
			stringArray=array[i].retrieve();
			for(int j=0;j<9;j++)
			{
				temp1=stringArray[j];
				for(int k=1;k<temp1.length();k++)
				{
					temp2=temp2+temp1.charAt(k);
				}
				sortedQueue[i].enQueue(temp2);
				temp2="";
			}
		}
		count=1;
		for(int i=0;i<4;i++)
		{
			System.out.print("Player "+(count++)+"=");
			System.out.println("[ "+sortedQueue[i].toString()+"]");
		}
	}
	/**
	 * @param string input string
	 * @return output string
	 */
	public static String regularExpression(String string)
	{
		Utility utility=new Utility();
		
		Pattern pattern=Pattern.compile("[a-zA-Z]+$");
		Matcher matcher=null;
		String name,lastName,mobile,date;
		do
		{
			System.out.println("Enter First Name=");
			name=utility.next();
			matcher=pattern.matcher(name);
			if(!matcher.matches())
			{
				System.out.println("Please try again.");
			}
		}
		while(!matcher.matches());
		
		pattern=Pattern.compile("[a-zA-Z]+$");
		do
		{
			System.out.println("Enter Last Name=");
			lastName=utility.next();
			matcher=pattern.matcher(lastName);
			if(!matcher.matches())
			{
				System.out.println("Please try again.");
			}
		}
		while(!matcher.matches());
		
		pattern=Pattern.compile("[0-9]{10}+$");
		do
		{
			System.out.println("Enter Contact Name=");
			mobile=utility.next();
			matcher=pattern.matcher(mobile);
			if(!matcher.matches())
			{
				System.out.println("Please try again.");
			}
		}
		while(!matcher.matches());
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
		Date date_object=new Date();
		date=dateFormat.format(date_object);
		string=string.replaceAll("<<name>>", name);
		string=string.replaceAll("<<full name>>", name+" "+lastName);
		string=string.replaceAll("91­xxxxxxxxxx", mobile);
		string=string.replaceAll("01/01/2016", date);
		return string;
	}
	/**
	 * @param path path of the file
	 * @return jsonObject read from file
	 */
	public static JSONObject readJsonFile(String path)
	{
		FileReader file=null;
		JSONParser parser=null;
		JSONObject jsonObject=null;
		File checkingFile=null;
		try
		{
			checkingFile=new File(path);
			if(checkingFile.length()==0)
			{
				jsonObject=null;
			}
			else
			{
				file=new FileReader(path);
				parser=new JSONParser();
				jsonObject=(JSONObject)parser.parse(file);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(file!=null)
				{
					file.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return jsonObject;
	}
	/**
	 * @param path path of the file
	 * @param jsonObject jsonObject to write on the file 
	 */
	public static void writeJsonFile(String path,JSONObject jsonObject)
	{
		FileWriter file=null;
		try
		{
			file=new FileWriter(path);
			file.write(jsonObject.toJSONString());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(file!=null)
				{
					file.flush();
					file.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	/**
	 * @param path path of the file
	 * @return jsonArray read jsonArray from file
	 */
	public static JSONArray readJsonArrayFile(String path)
	{
		FileReader file=null;
		JSONParser parser=null;
		JSONArray jsonArray=null;
		File checkingFile=null;
		try
		{
			checkingFile=new File(path);
			if(checkingFile.length()==0)
			{
				jsonArray=null;
			}
			else
			{
				file=new FileReader(path);
				parser=new JSONParser();
				jsonArray=(JSONArray)parser.parse(file);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(file!=null)
				{
					file.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return jsonArray;
	}
	/**
	 * @param path path of the file
	 * @param jsonArray jsonArray to write on the file 
	 */
	public static void writeJsonArrayFile(String path,JSONArray jsonArray)
	{
		FileWriter file=null;
		try
		{
			file=new FileWriter(path);
			file.write(jsonArray.toJSONString());
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(file!=null)
				{
					file.flush();
					file.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}