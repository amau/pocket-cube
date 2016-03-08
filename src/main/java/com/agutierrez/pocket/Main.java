
package com.agutierrez.pocket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main 
{
	/**
	 * Main entry point of the game, creates the engine object and starts the
	 * game loop.
	 */
	public static void main(String args[]) throws IOException
	{
		PocketCube p = new PocketCube();

		
		int test = p.mapToInt(5040,729);
		
		System.out.println(Integer.valueOf("F", 34));
		System.out.println(Integer.toString(35, 36));
		System.out.println("Test: " + test);
		System.out.println("Test >> 11: " + (test>>11));
		System.out.println("Test && 11: " + (test & (2048-1)));
		//p.gameLoop();

		//write2(p);
		System.out.println("End");
		/**
		
		int setSize = 7;
		int count = 0;

		for(int i = 0; i < Util.factorial(setSize); i++)
		{
			Main.print(Util.getNthPermutation(i, setSize));
			count++;
		}
		
		System.out.println(count);
		**/
		
		
		/**
		p.scramble();
		System.out.println(p.toString());
		System.out.println(p.getTarget());
		
		int index;
		
		for(int i = 0; i < PocketCubeConstants.FINAL_ORDER.length; i++)
		{
			index = p.getCubieIndex(PocketCubeConstants.FINAL_ORDER[i]);
			System.out.println("Index: " + index);
		}
		**/
		/**
		int total = 3;
		
		for(int i = 0; i < total; i++)
		{
		int example = i;
		
		int fact = Util.toTernary(example);
		
		int result = Util.fromTernary(fact);
		
		System.out.println(example + " -> " + fact + " -> " + result);
		}
		int example = (1<<11) - 1;
		System.out.println(example);
		**/
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
	
	public static void write(PocketCube p) throws IOException
	{
		File file = new File("numbers.txt");
		
		int test;
		
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0; i < 5040; i++) 
        {
        	for(int j = 0; j < 729; j++) 
        	{
        		bw.write(p.mapToInt(i, j));
        		bw.newLine();
        	}
        }
        bw.flush();
        bw.close();
	}
	
	public static void write2(PocketCube p) throws IOException
	{		
		FileOutputStream out = new FileOutputStream("bytes.txt");
        
		
		for(int i = 0; i < 5040; i++) 
        {
        	for(int j = 0; j < 729; j++) 
        	{
        		out.write(p.mapToByteArray(i, j));
        	}
        }
        
        out.close();

	}
}
