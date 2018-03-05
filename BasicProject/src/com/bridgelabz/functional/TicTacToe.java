package com.bridgelabz.functional;

import com.bridgelabz.utility.Utility;

/*
 * purpose: User and Computer plays tic tac toe game
 * @author Ganesh
 * @since 28 Feb 2018
*/
public class TicTacToe
{
	public static void main(String[] args) 
	{
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
				System.out.print(game[i][j]+"  ");;
			}
			System.out.println();
		}
		String result=Utility.ticTacToeResult(game);
		System.out.println(result);
	}
}