
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
	 * @throws Exception 
	 */
	public static void main(String args[]) throws Exception
	{
		PocketCube p = new PocketCube();

		
		int test = p.mapToInt();
		
		
		
		
		
		
		System.out.println(Character.digit("9".charAt(0), 9));
		System.out.println(Util.fromFactoradic(2210));
		System.out.println(Util.toString(17,8));
		System.out.println(Util.parseFactorial("2210"));
		System.out.println(Integer.toString(35, 36));
		System.out.println("Test: " + test);
		System.out.println("Test >> 11: " + (test>>11));
		System.out.println("Test && 11: " + (test & (2048-1)));
		//p.gameLoop();

		//write2(p);
		System.out.println("End: " +  Integer.toBinaryString(8387584));
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
		
		//write3(p);
		
		
		
		p.scramble();
		String before = p.toString();
		System.out.println(before);
		
		System.out.println(p.mapToInt());
		
		String after = p.mapFromInt(p.mapToInt(), p.getTarget());
		System.out.println(after);
		
		System.out.println(after.compareTo(before));
		
		/**
		int total = 5040;
		
		for(int i = 0; i < total; i++)
		{
		int example = i;
		
		String fact = Util.toString(example, 15);
		
		int result = Util.parseFactorial("" + fact);
		
		System.out.println(example + " -> " + fact + " -> " + result);
		}
		**/
	}
	
	public static int getremainingOrientation(String orientation, int radix)
	{
		int count = 0;
		for(int i = 0; i < orientation.length(); i++)
		{
			int digit = Character.digit(orientation.charAt(i), 10);
			count += digit;
		}
		return (radix - count % radix) % radix;
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
        		bw.write(p.mapToInt());
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
	
	public static void write3(PocketCube p) throws Exception
	{		
		FileOutputStream out = new FileOutputStream("bytes.txt");
        
		
		for(int i = 0; i < 5040; i++) 
        {
        	for(int j = 0; j < 729; j++) 
        	{
        		int integer = p.mapToInt();
        		//p.mapFromInt(integer, "");
        	}
        }
        
        out.close();

	}
}
