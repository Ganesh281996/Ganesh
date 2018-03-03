package com.bridgelabz.functional;

import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class TicTacToe14 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		char game[][]=new  char[3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				game[i][j]='*';
			}
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(game[i][j]+"  ");
			}
			System.out.println();
		}
		game=Utility.ticTacToe(game);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if((i==j || i+j==2) && game[i][j]==game[j][i])
				{
					if(game[j][j]=='X')
					{
						System.out.println("Player 1 User has Won.");
						System.exit(0);
					}
					else
					{
						System.out.println("Player 2 Computer has Won.");
						System.exit(0);
					}
				}
				
			}
		}
		scanner.close();
	}
}