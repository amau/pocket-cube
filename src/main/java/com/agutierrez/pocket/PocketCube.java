package com.agutierrez.pocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
		rubik = INITIAL;
	}


	public String toString()
	{

		String result = "";
		for (int i = 0; i < rubik.length; i++)
		{
			result = result + rubik[i];
		}

		return result;
	}


	public int[] toArray(String rubik)
	{
		int[] array = new int[rubik.length()];

		for (int i = 0; i < array.length; i++)
		{
			String number = rubik.substring(i,
				i + 1);
			array[i] = Integer.parseInt(number);
		}
		return array;
	}

	/**
	 * Convenience method that determines if the Pocket Cube state that this
	 * instance represents is in its solved state. The array contains all the
	 * solved positions when the cube orientation is not taken into account.
	 */
	public boolean isSolved()
	{
		for (int i = 0; i < SOLVED.length; i++)
		{
			if (toString().equals(SOLVED[i]))
			{
				return true;
			}
		}
		return false;
	}
	
	public int getCubieIndex(int [] arr)
	{
		return getCubieIndex(arr, this.rubik, this.getTarget());
	}
	
	
	public int getCubieIndex(int [] arr, int[] current, String target)
	{
		int[] targetArray = new int[arr.length];
		int[] currentArray = new int[arr.length];
		
		
		for(int j = 0; j < currentArray.length; j++)
		{
			targetArray[j] = Integer.parseInt("" + target.charAt(arr[j]));
		}
		
		
	    int[] cubieArray;
		for(int i = 0; i < PocketCubeConstants.FINAL_ORDER.length; i++)
		{
			cubieArray = PocketCubeConstants.FINAL_ORDER[i];
			
			for(int j = 0; j < currentArray.length; j++)
			{
				currentArray[j] = current[cubieArray[j]];
			}

			if(this.getOrientation(currentArray, targetArray) > -1)
			{
				System.out.println("Orientation: " + this.getOrientation(currentArray, targetArray));
				return i;
			}
		
		}
		return -1;
	}
	
	public int getOrientation(int[] current, int[] target)
	{
		for(int j = 0; j < current.length; j++)
		{
			if(current[0] == target[(0 + j) % 3] &&
			   current[1] == target[(1 + j) % 3] &&
			   current[2] == target[(2 + j) % 3])
			{
				return j;
			}
		}
		
		return -1;
	}
	
	public String getTarget()
	{
		return getTarget(PocketCubeConstants.UBL_INDEXES, this.toString());
	}

	public String getTarget(int[] arr, String current)
	{	
		for (int i = 0; i < SOLVED.length; i++)
		{
			String target = "";
			String currentString = "";
			for(int j = 0; j < arr.length; j++)
			{
				target = target + SOLVED[i].charAt(arr[j]);
				currentString = currentString + current.charAt(arr[j]);
			}
			if(target.compareTo(currentString) == 0)
			{
				return SOLVED[i];
			}
		}
		return "";
	}
	/**
	 * Applies a random number (between 10 inclusive and 20 exclusive) of random
	 * moves to the cube to get to a scrambled state.
	 */
	public void scramble()
	{
		Random random = new Random();
		String aux;

		int numMoves = random.nextInt(10) + 10;

		for (int i = 0; i < numMoves; i++)
		{
			aux = PocketCubeConstants.HALF_TURN_METRIC_MOVES[random.nextInt(PocketCubeConstants.HALF_TURN_METRIC_MOVES.length)];
			this.parseToken(aux);
		}
	}


	/*
	 * ***UP*******DOWN*******LEFT*******FRONT*****RIGHT******BACK | 0|
	 * | 0| 1| | 2|| 3| | 4|| 5| | 6|| 7| | 8|| 9| |10||11| |12||13|
	 * |14||15| |16||17| |18||19| |20||21| |22||23|
	 */

	public void setPosition(String string)
	{
		rubik = this.toArray(string);
	}
	
	/**
	 * Mapping of a clockwise turn of the left face of the Pocket Cube
	 * represented by this instancee.
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
		rubik[17] = rubik[5];
		rubik[5] = aux;
	}

	/**
	 * Mapping of a counterclockwise turn of the left face of the Pocket Cube
	 * represented by this instancee.
	 */
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
		rubik[16] = rubik[4];
		rubik[4] = aux;
	}

	/**
	 * Mapping of a clockwise turn of the right face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveRight()
	{
		int up = rubik[7];
		int down = rubik[19];

		rubik[7] = rubik[3];
		rubik[19] = rubik[15];

		rubik[3] = rubik[22];
		rubik[15] = rubik[10];

		rubik[22] = rubik[1];
		rubik[10] = rubik[13];

		rubik[1] = up;
		rubik[13] = down;

		int aux = rubik[20];
		rubik[20] = rubik[21];
		rubik[21] = rubik[9];
		rubik[9] = rubik[8];
		rubik[8] = aux;
	}

	/**
	 * Mapping of a counterclockwise turn of the right face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveCounterRight()
	{
		int up = rubik[1];
		int down = rubik[13];

		rubik[1] = rubik[22];
		rubik[13] = rubik[10];

		rubik[22] = rubik[3];
		rubik[10] = rubik[15];

		rubik[3] = rubik[7];
		rubik[15] = rubik[19];

		rubik[7] = up;
		rubik[19] = down;

		int aux = rubik[8];
		rubik[8] = rubik[9];
		rubik[9] = rubik[21];
		rubik[21] = rubik[20];
		rubik[20] = aux;
	}

	/**
	 * Mapping of a clockwise turn of the back face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveBack()
	{
		int up = rubik[0];
		int down = rubik[1];

		rubik[0] = rubik[9];
		rubik[1] = rubik[21];

		rubik[9] = rubik[15];
		rubik[21] = rubik[14];

		rubik[15] = rubik[16];
		rubik[14] = rubik[4];

		rubik[16] = up;
		rubik[4] = down;

		int aux = rubik[10];
		rubik[10] = rubik[22];
		rubik[22] = rubik[23];
		rubik[23] = rubik[11];
		rubik[11] = aux;

	}

	/**
	 * Mapping of a counterclockwise turn of the back face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveCounterBack()
	{
		int up = rubik[16];
		int down = rubik[4];

		rubik[16] = rubik[15];
		rubik[4] = rubik[14];

		rubik[15] = rubik[9];
		rubik[14] = rubik[21];

		rubik[9] = rubik[0];
		rubik[21] = rubik[1];

		rubik[0] = up;
		rubik[1] = down;

		int aux = rubik[11];
		rubik[11] = rubik[23];
		rubik[23] = rubik[22];
		rubik[22] = rubik[10];
		rubik[10] = aux;
	}

	/**
	 * Mapping of a clockwise turn of the front face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveFront()
	{
		int up = rubik[12];
		int down = rubik[13];

		rubik[12] = rubik[17];
		rubik[13] = rubik[5];

		rubik[5] = rubik[2];
		rubik[17] = rubik[3];

		rubik[2] = rubik[20];
		rubik[3] = rubik[8];

		rubik[20] = down;
		rubik[8] = up;

		int aux = rubik[6];
		rubik[6] = rubik[18];
		rubik[18] = rubik[19];
		rubik[19] = rubik[7];
		rubik[7] = aux;
	}

	/**
	 * Mapping of a counterclockwise turn of the front face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveCounterFront()
	{
		int up = rubik[8];
		int down = rubik[20];

		rubik[20] = rubik[2];
		rubik[8] = rubik[3];

		rubik[2] = rubik[5];
		rubik[3] = rubik[17];

		rubik[5] = rubik[13];
		rubik[17] = rubik[12];

		rubik[12] = up;
		rubik[13] = down;

		int aux = rubik[7];
		rubik[7] = rubik[19];
		rubik[19] = rubik[18];
		rubik[18] = rubik[6];
		rubik[6] = aux;
	}

	/**
	 * Mapping of a clockwise turn of the top face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveUp()
	{
		int left = rubik[4];
		int right = rubik[5];

		rubik[4] = rubik[6];
		rubik[5] = rubik[7];

		rubik[6] = rubik[8];
		rubik[7] = rubik[9];

		rubik[8] = rubik[10];
		rubik[9] = rubik[11];

		rubik[10] = left;
		rubik[11] = right;

		int aux = rubik[0];
		rubik[0] = rubik[12];
		rubik[12] = rubik[13];
		rubik[13] = rubik[1];
		rubik[1] = aux;
	}

	/**
	 * Mapping of a counterclockwise turn of the top face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveCounterUp()
	{
		int left = rubik[10];
		int right = rubik[11];

		rubik[10] = rubik[8];
		rubik[11] = rubik[9];

		rubik[8] = rubik[6];
		rubik[9] = rubik[7];

		rubik[6] = rubik[4];
		rubik[7] = rubik[5];

		rubik[4] = left;
		rubik[5] = right;

		int aux = rubik[1];
		rubik[1] = rubik[13];
		rubik[13] = rubik[12];
		rubik[12] = rubik[0];
		rubik[0] = aux;
	}

	/**
	 * Mapping of a clockwise turn of the bottom face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveDown()
	{
		int left = rubik[16];
		int right = rubik[17];

		rubik[16] = rubik[22];
		rubik[17] = rubik[23];

		rubik[22] = rubik[20];
		rubik[23] = rubik[21];

		rubik[20] = rubik[18];
		rubik[21] = rubik[19];

		rubik[18] = left;
		rubik[19] = right;

		int aux = rubik[2];
		rubik[2] = rubik[14];
		rubik[14] = rubik[15];
		rubik[15] = rubik[3];
		rubik[3] = aux;
	}

	/**
	 * Mapping of a counterclockwise turn of the bottom face of the Pocket Cube
	 * represented by this instancee.
	 */
	public void moveCounterDown()
	{
		int left = rubik[18];
		int right = rubik[19];

		rubik[18] = rubik[20];
		rubik[19] = rubik[21];

		rubik[20] = rubik[22];
		rubik[21] = rubik[23];

		rubik[22] = rubik[16];
		rubik[23] = rubik[17];

		rubik[16] = left;
		rubik[17] = right;

		int aux = rubik[3];
		rubik[3] = rubik[15];
		rubik[15] = rubik[14];
		rubik[14] = rubik[2];
		rubik[2] = aux;
	}

	/**
	 * Parses a token into the set of moves that it represents. It then calls
	 * the move represented.
	 */
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

	/**
	 * Convenience method that returns the token that would cancel a given move.
	 * Concatenating both moves would result in the identity move algebraically
	 * speaking.
	 */
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

	/**
	 * Prints a pretty representation of the pocket cube to the terminal.
	 */
	public void printPocket()
	{
		System.out.print("    ");
		System.out.println(formatColor(rubik[0]) + formatColor(rubik[1]));
		System.out.print("    ");
		System.out.println(formatColor(rubik[12]) + formatColor(rubik[13]));
		System.out.print(formatColor(rubik[4]) + formatColor(rubik[5]));
		System.out.print(formatColor(rubik[6]) + formatColor(rubik[7]));
		System.out.print(formatColor(rubik[8]) + formatColor(rubik[9]));
		System.out.println(formatColor(rubik[10]) + formatColor(rubik[11]));
		System.out.print(formatColor(rubik[16]) + formatColor(rubik[17]));
		System.out.print(formatColor(rubik[18]) + formatColor(rubik[19]));
		System.out.print(formatColor(rubik[20]) + formatColor(rubik[21]));
		System.out.println(formatColor(rubik[22]) + formatColor(rubik[23]));
		System.out.print("    ");
		System.out.println(formatColor(rubik[2]) + formatColor(rubik[3]));
		System.out.print("    ");
		System.out.println(formatColor(rubik[14]) + formatColor(rubik[15]));
	}

	/**
	 * Prints a String representation of the pocket cube.
	 */
	public static void printMap()
	{
		System.out.print("       ");
		System.out.println("| 0| 1|");
		System.out.print("       ");
		System.out.println("|12|13|");
		System.out.print("| 4| 5|");
		System.out.print("| 6| 7|");
		System.out.print("| 8| 9|");
		System.out.println("|10|11|");
		System.out.print("|16|17|");
		System.out.print("|18|19|");
		System.out.print("|20|21|");
		System.out.println("|22|23|");
		System.out.print("       ");
		System.out.println("| 2| 3|");
		System.out.print("       ");
		System.out.println("|14|15|");
	}

	/**
	 * Method overload to make calls simpler when we want to solve the Pocket
	 * Cube to the theoretical solved state.
	 */
	public void applySequence(String sequence)
	{
		applySequence(PocketCubeConstants.RUBIK_PATTERN,
			sequence);
	}

	/**
	 * Using regular expresions, this method consumes a string calling the move
	 * that each token represents one by one.
	 */
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

	/**
	 * This method creates a String containing space the given color as
	 * background.
	 * 
	 * @param color
	 *            The color of the output space.
	 * @return String Space with the given color as background.
	 */
	public String formatColor(int color)
	{
		String result = "";
		switch (color)
		{
			case 1:
				result = PocketCubeConstants.ANSI_YELLOW + "  " + PocketCubeConstants.ANSI_RESET;
				break;
			case 2:
				result = PocketCubeConstants.ANSI_WHITE + "  " + PocketCubeConstants.ANSI_RESET;
				break;
			case 3:
				result = PocketCubeConstants.ANSI_BLUE + "  " + PocketCubeConstants.ANSI_RESET;
				break;
			case 4:
				result = PocketCubeConstants.ANSI_RED + "  " + PocketCubeConstants.ANSI_RESET;
				break;
			case 5:
				result = PocketCubeConstants.ANSI_GREEN + "  " + PocketCubeConstants.ANSI_RESET;
				break;
			case 6:
				result = PocketCubeConstants.ANSI_ORANGE + "  " + PocketCubeConstants.ANSI_RESET;
				break;
		}

		return result;
	}

	public void reset()
	{

	}


	public void gameLoop()
	{
		printPocket();

		Scanner in = new Scanner(System.in);

		String incoming = in.next();
		while (!incoming.equals("QUIT"))
		{
			if (incoming.equals("RESET"))
			{
				rubik = INITIAL;
				printPocket();
			}
			else if (incoming.equals("SCRAMBLE"))
			{
				scramble();
				printPocket();
			}
			else if (incoming.equals("SOLVE"))
			{

				String solution = Solver.solve(this);

				Pattern pattern = Pattern.compile(PocketCubeConstants.RUBIK_PATTERN);
				Matcher matcher = pattern.matcher(solution);
				while (matcher.find())
				{
					String move = matcher.group();
					parseToken(move);
					System.out.println(move);
					printPocket();
				}

			}
			else
			{
				applySequence(incoming);
				printPocket();
				if (isSolved())
				{
					System.out.println("SOLVED!");
				}
			}
			incoming = in.next();
		}
		System.out.println("END!");
		in.close();
	}

	protected static final int[] INITIAL = { 1,
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
	protected int[] rubik;
	
	protected String[] SOLVED = { "446611332255446611332255",
			"446655113322446655113322",
			"446622551133446622551133",
			"446633225511446633225511",
			"221144336655221144336655",
			"221155443366221155443366",
			"221166554433221166554433",
			"221133665544221133665544",
			"664422331155664422331155",
			"664455223311664455223311",
			"664411552233664411552233",
			"664433115522664433115522",
			"112266334455112266334455",
			"112255663344112255663344",
			"112244556633112244556633",
			"112233445566112233445566",
			"553366114422553366114422",
			"553322661144553322661144",
			"553344226611553344226611",
			"553311442266553311442266",
			"335566224411335566224411",
			"335511662244335511662244",
			"335544116622335544116622",
			"335522441166335522441166"
		};
}