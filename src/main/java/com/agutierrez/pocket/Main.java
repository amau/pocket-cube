
package com.agutierrez.pocket;

public class Main 
{
	/**
	 * Main entry point of the game, creates the engine object and starts the
	 * game loop.
	 */
	public static void main(String args[]) 
	{
		PocketCube p = new PocketCube();

		//p.gameLoop();

		/**
		int setSize = 4;
		int count = 0;

		for(int i = 0; i < PocketCube.factorial(setSize); i++)
		{
			Main.print(PocketCube.getNthPermutation(i, setSize));
			count++;
		}
		
		System.out.println(count);
		
		**/
		p.scramble();
		System.out.println(p.toString());
		System.out.println(p.getTarget());
		
		int index;
		
		for(int i = 0; i < PocketCubeConstants.FINAL_ORDER.length; i++)
		{
			index = p.getCubieIndex(PocketCubeConstants.FINAL_ORDER[i]);
			System.out.println("Index: " + index);
		}
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
