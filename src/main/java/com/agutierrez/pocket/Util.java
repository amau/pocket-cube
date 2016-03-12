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
	 * Turns the String representation of a factoradic number into its int
	 * value.
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static int parseFactorial(String s) throws Exception
	{
        if (s == null) {
            throw new NumberFormatException("null");
        }

        int result = 0;
        int i = 0, len = s.length();
        int digit;

        if (len > 0) {
            char lastChar = s.charAt(len - 1);
            if (lastChar != '0') { 
            	throw new NumberFormatException("All factoradic numbers must end in 0.");
            }
            
            while (i < len - 1) {
                digit = Character.digit(s.charAt(i++), 10);
                if (digit < 0) {
                	throw new NumberFormatException("Not valid character.");
                } 
                result += digit;
                result *= (len - i);
            }
        } else {
        	throw new NumberFormatException("Empty String.");
        }
        return result;
	}
	
	/**
	 * Converts the given decimal number into its factoradic representation. The
	 * factoradic number system is used to induce a natural order to the
	 * permutations of a given set. The resulting number is represented in a
	 * string.
	 * 
	 * @param i
	 *            Number to be converted.
	 * @return The factoradic string representation of the given number.
	 */
	public static String toString(int i) {
        int radix = 1;


        char buf[] = new char[32];
        int charPos = 31;


        while (i >= radix) {
            buf[charPos--] = digits[(i % radix)];
            i = i / radix;
            radix++;
        }
        buf[charPos] = digits[i];

        return new String(buf, charPos, (32 - charPos));
    }
	
	/**
	 * Converts the given decimal number into its factoradic representation. The
	 * factoradic number system is used to induce a natural order to the
	 * permutations of a given set. The resulting number is represented in a
	 * string. If the resulting string lenght is less than the given size
	 * parameter, zeros are padded to the left to match the required size. Note
	 * that zeros to the left wont affect a hypothetical conversion back to an
	 * integer.
	 * 
	 * @param i
	 *            Number to be converted.
	 * @return The factoradic string representation of the given number.
	 */
	public static String toString(int i, int size) {
		return padLeftZeros(toString(i), size);
	}
	
	/**
	 * Adds zeros to the left of the given string until its size matches the
	 * required one.
	 * 
	 * @param s
	 *            The string to be added with zeros.
	 * @param size
	 *            The desired size of the resulting string.
	 * @return The given string with zeros padded to the left.
	 */
	public static String padLeftZeros(String s, int size)
	{
		return padLeft(s, size, '0');
	}
	
	/**
	 * Adds the given character to the left of the given string until its size
	 * matches the required one.
	 * 
	 * @param s
	 *            The string to be added with zeros.
	 * @param size
	 *            The desired size of the resulting string.
	 * @param pad
	 *            The char that will be added to the left.
	 * @return The given string with the given character padded to the left.
	 */
	public static String padLeft(String s, int size, char pad) {
		
		if(s.length() > size)
		{
			return s;
		}
		
		StringBuilder str = new StringBuilder("");
		for(int j = 0; j < size; j++)
		{
			str.append(pad);
		}
		return str.toString().substring(s.length()) + s;
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
	
	/**
	 * Given an index, and the number of elements in the set (from 0 to n) it
	 * returns a String representing the nth permutation.
	 * 
	 * @param index
	 * @param size
	 * @return
	 */
	public static String getNthPermutationString(int index, int size)
	{
		int factoradic = toFactoradic(index);
		int [] arr = new int[size];
		String result = "";
		List<Integer> numbers = new ArrayList<Integer>();

		// 0 is already taken, this way we ensure that we don't repeat 0.
		for(int i = 1; i < size + 1; i++)
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
			result = result + numbers.remove(arr[i]);
		}		
		return result;
	}

	/**
	 * Given an array containing a permutation of numbers, it returns the index
	 * of the permutation given by the Lehmer code.
	 * 
	 * @param permutation
	 *            Array containing a permutation of numbers from 1-n.
	 * @return The index of the given permutation in the Lehmer code.
	 */
	public static int getPermutationIndex(int[] permutation)
	{
		int[] aux = new int[permutation.length];
		
		String x = "";
		for(int i = permutation.length -1; i > -1; i--)
		{
			int j = 0;
			int auxInt = permutation[i];
			int counter = 0;
			
			while(j < auxInt)
			{
				if(aux[j] > 0)
				{
					counter++;
				}
				j++;
			}
			aux[j] = auxInt;
			
			x = counter + x;
			
		}
		int res = 0;
		try
		{
			res = parseFactorial(x);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return res;
	}

	/**
	 * Determines the orientation of a given string that represents a number in
	 * the given radix base. The sum of all orientations should always be 0
	 * modulus the radix number.
	 * 
	 * @param orientation
	 *            String representing orientation of n-1 elements.
	 * @param radix
	 *            The desired base.
	 * @return The orientation of the nth element in order to keep the zero sum.
	 */
	public static String getremainingOrientation(String orientation, int radix)
	{
		int count = 0;
		for(int i = 0; i < orientation.length(); i++)
		{
			int digit = Character.digit(orientation.charAt(i), 10);
			count += digit;
		}
		return new String(digits, (radix - count % radix) % radix, 1);
	}
	
    /**
     * All possible chars for representing a number as a String
     */
    final static char[] digits = {
        '0' , '1' , '2' , '3' , '4' , '5' ,
        '6' , '7' , '8' , '9'
    };
}
