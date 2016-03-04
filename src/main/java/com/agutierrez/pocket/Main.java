
package com.agutierrez.pocket;

public class Main 
{
	/**
	 * Main entry point of the game, creates the engine object and starts the
	 * game loop.
	 */
	public static void main(String args[]) 
	{
		//PocketCube p = new PocketCube();

		//p.gameLoop();

		int setSize = 5;
		int count = 0;

		for(int i = 1; i < PocketCube.factorial(setSize); i++)
		{
			Main.print(PocketCube.getNthPermutation(i));
			count++;
		}
		
		System.out.println(count);
	}
		
	public static void print(int[] result)
	{
		System.out.print("(");
		for(int i = 0; i < result.length - 1; i++)
		{
			System.out.print(result[i] + ",");
		}
		System.out.println(result[result.length - 1] + ")");
	}
}
