
package com.agutierrez.pocket;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PocketCube
{
	/**
	 * Basic constructor.
	 */
	public PocketCube()
	{
		int[] r = { 1,
			1,
			2,
			2,
			3,
			3,
			4,
			4,
			5,
			5,
			6,
			6,
			1,
			1,
			2,
			2,
			3,
			3,
			4,
			4,
			5,
			5,
			6,
			6
		};
		rubik = r;
	}


	/*
	 * ***UP*******DOWN*******LEFT*******FRONT*****RIGHT******BACK | 0|
	 * | 0| 1|  | 2|| 3|    | 4|| 5|   | 6|| 7|   | 8|| 9|   |10||11| 
	 * |12||13| |14||15|    |16||17|   |18||19|   |20||21|   |22||23|
	 */

	public void moveLeft()
	{
		int up = rubik[0];
		int down = rubik[12];

		rubik[0] = rubik[23];
		rubik[12] = rubik[11];

		rubik[23] = rubik[2];
		rubik[11] = rubik[14];

		rubik[2] = rubik[6];
		rubik[14] = rubik[18];

		rubik[6] = up;
		rubik[18] = down;

		int aux = rubik[4];
		rubik[4] = rubik[16];
		rubik[16] = rubik[17];
		rubik[5] = aux;
	}


	public void moveCounterLeft()
	{

		int up = rubik[6];
		int down = rubik[18];

		rubik[6] = rubik[2];
		rubik[18] = rubik[14];

		rubik[2] = rubik[23];
		rubik[14] = rubik[11];
		
		rubik[23] = rubik[0];
		rubik[11] = rubik[12];
		
		rubik[0] = up; 
		rubik[12] = down;

		int aux = rubik[5];
		rubik[5] = rubik[17];
		rubik[17] = rubik[16];
		rubik[4] = aux;
	}


	public void moveRight()
	{

	}


	public void moveCounterRight()
	{

	}


	public void moveBack()
	{

	}


	public void moveCounterBack()
	{

	}


	public void moveFront()
	{
	}


	public void moveCounterFront()
	{

	}


	public void moveUp()
	{

	}


	public void moveCounterUp()
	{

	}


	public void moveDown()
	{

	}


	public void moveCounterDown()
	{

	}


	public void parseToken(String token)
	{
		if (token.equals("D"))
		{

			moveDown();
		}
		else if (token.equals("U"))
		{

			moveUp();
		}
		else if (token.equals("L"))
		{

			moveLeft();
		}
		else if (token.equals("R"))
		{

			moveRight();

		}
		else if (token.equals("F"))
		{

			moveFront();
		}
		else if (token.equals("B"))
		{

			moveBack();
		}
		if (token.equals("D'"))
		{

			moveCounterDown();
		}
		else if (token.equals("U'"))
		{

			moveCounterUp();
		}
		else if (token.equals("L'"))
		{

			moveCounterLeft();
		}
		else if (token.equals("R'"))
		{

			moveCounterRight();
		}
		else if (token.equals("F'"))
		{

			moveCounterFront();
		}
		else if (token.equals("B'"))
		{

			moveCounterBack();
		}
		if (token.equals("D2"))
		{

			moveDown();
			moveDown();
		}
		else if (token.equals("U2"))
		{

			moveUp();
			moveUp();
		}
		else if (token.equals("L2"))
		{

			moveLeft();
			moveLeft();
		}
		else if (token.equals("R2"))
		{
			moveRight();
			moveRight();
		}
		else if (token.equals("F2"))
		{
			moveFront();
			moveFront();
		}
		else if (token.equals("B2"))
		{

			moveBack();
			moveBack();
		}
	}


	public String getOposite(String token)
	{
		String result = "";
		if (token.equals("D"))
		{
			result = "D'";
		}
		else if (token.equals("U"))
		{
			result = "U'";
		}
		else if (token.equals("L"))
		{
			result = "L'";
		}
		else if (token.equals("R"))
		{
			result = "R'";

		}
		else if (token.equals("F"))
		{
			result = "F'";
		}
		else if (token.equals("B"))
		{
			result = "B'";
		}
		if (token.equals("D'"))
		{
			result = "D";
		}
		else if (token.equals("U'"))
		{
			result = "U";
		}
		else if (token.equals("L'"))
		{
			result = "L";
		}
		else if (token.equals("R'"))
		{
			result = "R";
		}
		else if (token.equals("F'"))
		{
			result = "F";
		}
		else if (token.equals("B'"))
		{
			result = "B";
		}
		if (token.equals("D2"))
		{
			return token;
		}
		else if (token.equals("U2"))
		{
			return token;
		}
		else if (token.equals("L2"))
		{
			return token;
		}
		else if (token.equals("R2"))
		{
			return token;
		}
		else if (token.equals("F2"))
		{
			return token;
		}
		else if (token.equals("B2"))
		{
			return token;
		}
		return result;
	}


	public void printPocket()
	{
		System.out.print("       ");
		System.out.println("| " + rubik[0] + "| " + rubik[1] + "|");
		System.out.print("       ");
		System.out.println("| " + rubik[12] + "| " + rubik[13] + "|");
		System.out.print("| " + rubik[4] + "| " + rubik[5] + "|");
		System.out.print("| " + rubik[6] + "| " + rubik[7] + "|");
		System.out.print("| " + rubik[8] + "| " + rubik[9] + "|");
		System.out.println("| " + rubik[10] + "| " + rubik[11] + "|");
		System.out.print("| " + rubik[16] + "| " + rubik[17] + "|");
		System.out.print("| " + rubik[18] + "| " + rubik[19] + "|");
		System.out.print("| " + rubik[20] + "| " + rubik[21] + "|");
		System.out.println("| " + rubik[22] + "| " + rubik[23] + "|");
		System.out.print("       ");
		System.out.println("| " + rubik[2] + "| " + rubik[3] + "|");
		System.out.print("       ");
		System.out.println("| " + rubik[14] + "| " + rubik[15] + "|");
	}


	public void applySequence(String sequence)
	{
		applySequence(this.rubikPattern,
			sequence);
	}


	protected void applySequence(String stringPattern,
		String sequence)
	{
		Pattern pattern = Pattern.compile(stringPattern);
		Matcher matcher = pattern.matcher(sequence);
		while (matcher.find())
		{
			parseToken(matcher.group());
		}
	}


	public String reverseSequence(String stringPattern,
		String sequence)
	{
		String result = "";
		Pattern pattern = Pattern.compile(stringPattern);

		Matcher matcher = pattern.matcher(sequence);

		while (matcher.find())
		{
			result = getOposite(matcher.group()) + result;
		}

		return result;
	}


	public static void main(String args[])
	{
		System.out.println("Hello World of Pocket Cube!");

		PocketCube p = new PocketCube();

		p.printPocket();
		
		Scanner in = new Scanner(System.in);

		String incoming = in.next();
		while(!incoming.equals("Q"))
		{
			p.applySequence(incoming);
			p.printPocket();
			incoming = in.next();
		}
		
		System.out.println("End!");
		in.close();
		
	
	}

	/**
	 * Regular expression that accepts valid moves for the Pocket Cube
	 */
	protected final String rubikPattern = "[DULRFB][2']?";

	protected int[] rubik;
}