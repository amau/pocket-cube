package com.agutierrez.pocket;

import java.util.ArrayList;
import java.util.List;

public class Util {
	/**
	 * Converts a decimal number to ternary.
	 * 
	 * @param decimal
	 *            The number to be converted.
	 * @return The ternary representation of the given number.
	 */
	public static int toTernary(int decimal)
	{
		return toBaseN(decimal, 3);
	}

	/**
	 * Converts a ternary number to decimal.
	 * 
	 * @param ternary
	 *            The number to be converted.
	 * @return The decimal representation of the given number.
	 */
	public static int fromTernary(int ternary)
	{
		return fromBaseN(ternary, 3);
	}

	/**
	 * Converts a decimal number to binary.
	 * 
	 * @param decimal
	 *            The number to be converted.
	 * @return The binary representation of the given number
	 */
	public static int toBinary(int decimal)
	{
		return toBaseN(decimal, 2);
	}
	
	/**
	 * Converts a binary number to decimal.
	 * 
	 * @param binary
	 *            The number to be converted.
	 * @return The decimal representation of the given number.
	 */
	public static int fromBinary(int binary)
	{
		return fromBaseN(binary, 2);
	}

	/**
	 * Converts the given decimal number into a representation in the given
	 * base.
	 * 
	 * @param decimal
	 *            The number to be converted.
	 * @param base
	 *            The target base.
	 * @return The representation of the given decimal number in the given base.
	 */
	public static int toBaseN(int decimal, int base)
	{
		int remainder = 0;
		int quotient = decimal;
		int i = 0;
		int result = 0;
		while(quotient > 0)
		{
			remainder = quotient % base;
			quotient = quotient / base;
			result = result + pow(10, i) * remainder;
			i++;
		}
		return result;
	}
	
	/**
	 * Converts the given decimal number into a representation in the given
	 * base.
	 * 
	 * @param decimal
	 *            The number to be converted.
	 * @param base
	 *            The original base.
	 * @return The representation of the given decimal number in the given base.
	 */
	public static int fromBaseN(int decimal, int base)
	{
		int remainder = 0;
		int quotient = decimal;
		int i = 0;
		int result = 0;
		while(quotient > 0)
		{
			remainder = quotient % 10;
			quotient = quotient / 10;
			result = result + pow(base, i) * remainder;
			i++;
		}
		return result;
	}
	

	/**
	 * Converts the given decimal number into its factoradic representation. The
	 * factoradic number system is used to induce a natural order to the
	 * permutations of a given set.
	 * 
	 * @param decimal Number to be converted.
	 * @return The factoradic representation of the given number.
	 */
	public static int toFactoradic(int decimal)
	{
		int remainder = 0;
		int quotient = decimal;
		int i = 0;
		int result = 0;
		while(quotient > 0)
		{
			remainder = quotient % (i + 1);
			quotient = quotient / (i + 1);
			result = result + pow(10, i) * remainder;
			i++;
		}
		return result;
	}
	
	/**
	 * Converts the given factoradic number into its decimal representation.
	 * 
	 * @param factoradic number to be converted.
	 * @return The decimal representation of the given number.
	 */
	public static int fromFactoradic(int factoradic)
	{
		int remainder = 0;
		int quotient = factoradic;
		int i = 0;
		int result = 0;
		while(quotient > 0)
		{
			remainder = quotient % 10;
			quotient = quotient / 10;
			result = result + factorial(i) * remainder;
			i++;
		}
		return result;
	}
	
	/**
	 * Convenient method to calculate powers of integer numbers..
	 * @param a Base number to be elevated to given power.
	 * @param b Exponent
	 * @return a^b
	 */
	public static int pow(int a, int b)
	{
		int result = 1;
		for (int i = 0; i < b; i++) 
		{
		   result *= a;
		}
		return result;
	}

	/**
	 * Recursively calculates the factorial of the given number.
	 * @param n
	 * @return n!
	 */
	public static int factorial(int n)
	{
		if(n == 0)
		{
			return 1;
		}
		else if(n == 1)
		{
			return 1;
		}
		else
		{
			return factorial(n -1) * n;
		}
	}
	
	/**
	 * This method returns the nth permutation using the Lehmer code. The size
	 * reflects the number of elements that the set has, the index is the nth
	 * permutation.
	 * 
	 * @param index nth permutation
	 * @param size Number of objects in the set.
	 * @return An array containing the desired order of the elements.
	 */
	public static int[] getNthPermutation(int index, int size)
	{
		int factoradic = toFactoradic(index);
		int [] arr = new int[size];
		int [] result = new int[size];
		List<Integer> numbers = new ArrayList<Integer>();

		for(int i = 0; i < size; i++)
		{
			numbers.add(i);
		}	
		
		for(int i = arr.length - 1; factoradic > 0; factoradic = factoradic / 10)
		{
			arr[i] = factoradic % 10;
			i--;
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			result[i] = numbers.remove(arr[i]).intValue();
		}		
		return result;
	}
}
