
package com.agutierrez.pocket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
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
		fixOrientation();
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


	public boolean isSolved()
	{
		String[] SOLVED = { "446611332255446611332255",
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

		for (int i = 0; i < SOLVED.length; i++)
		{
			if (toString().equals(SOLVED[i]))
			{
				return true;
			}
		}
		return false;
	}


	public void scramble()
	{
		Random random = new Random();
		String aux;

		int numMoves = random.nextInt(10) + 10;

		for (int i = 0; i < numMoves; i++)
		{
			aux = MOVES[random.nextInt(MOVES.length)];
			// System.out.print(aux);
			this.parseToken(aux);
		}
		// System.out.println("");
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


	public static String[] getValidMoves(String lastMoves)
	{
		String[] res = null;

		if (lastMoves.endsWith("R") ||
			lastMoves.endsWith("R'") ||
			lastMoves.endsWith("R2"))
		{
			res = PocketCube.LAST_MOVE_R;
		}
		else if (lastMoves.endsWith("D") ||
			lastMoves.endsWith("D'") ||
			lastMoves.endsWith("D2"))
		{
			res = PocketCube.LAST_MOVE_D;
		}
		else if (lastMoves.endsWith("F") ||
			lastMoves.endsWith("F'") ||
			lastMoves.endsWith("F2"))
		{
			res = PocketCube.LAST_MOVE_F;
		}
		else
		{
			res = PocketCube.MOVES_GENERATOR_CORNER_UBL_FIXED;
		}

		return res;
	}


	public static String solve(PocketCube rubik)
	{
		Map<String, String> positions = new HashMap<String, String>();
		Queue<String> queue = new LinkedList<String>();
		String pos;
		String newPos;
		String algorithm;
		String[] validMoves;

		rubik.fixOrientation();
		PocketCube copy = new PocketCube();

		copy.setPosition(rubik.toString());

		queue.offer(copy.toString());
		positions.put(copy.toString(),
			"");

		while ((pos = queue.poll()) != null)
		{

			algorithm = positions.get(pos);
			validMoves = getValidMoves(algorithm);
			for (String move : validMoves)
			{
				copy = new PocketCube();
				copy.setPosition(pos);
				copy.fixOrientation();
				copy.applySequence(move);
				newPos = copy.toString();
				algorithm = positions.get(pos) + move;
				if (!positions.keySet().contains(newPos))
				{
					positions.put(newPos,
						positions.get(pos) + move);
					queue.offer(newPos);

					if (copy.isSolved())
					{
						return positions.get(newPos);
					}
				}
			}
		}
		return null;
	}


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


	public void printMap()
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


	public void applySequence(String sequence)
	{
		applySequence(PocketCube.RUBIK_PATTERN,
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


	public String formatColor(int color)
	{
		String result = "";
		switch (color)
		{
			case 1:
				result = ANSI_YELLOW + "  " + ANSI_RESET;
				break;
			case 2:
				result = ANSI_WHITE + "  " + ANSI_RESET;
				break;
			case 3:
				result = ANSI_BLUE + "  " + ANSI_RESET;
				break;
			case 4:
				result = ANSI_RED + "  " + ANSI_RESET;
				break;
			case 5:
				result = ANSI_GREEN + "  " + ANSI_RESET;
				break;
			case 6:
				result = ANSI_ORANGE + "  " + ANSI_RESET;
				break;
		}

		return result;
	}


	public void fixOrientation()
	{
		orientOne = rubik[0];
		orientTwo = rubik[4];
		orientThree = rubik[11];
	}


	public boolean validMoveWithOrientation()
	{
		return (orientOne == rubik[0]) &&
			(orientTwo == rubik[4]) &&
			(orientThree == rubik[11]);
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

				String solution = PocketCube.solve(this);

				Pattern pattern = Pattern.compile(RUBIK_PATTERN);
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


	public static void main(String args[])
	{
		PocketCube p = new PocketCube();

		p.gameLoop();
	}

	/**
	 * Regular expression that accepts valid moves for the Pocket Cube
	 */
	public static final String RUBIK_PATTERN = "[DULRFB][2']?";

	public static final String[] MOVES = { "F",
		"F'",
		"F2",
		"B",
		"B'",
		"B2",
		"L",
		"L'",
		"L2",
		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2",
		"U",
		"U'",
		"U2"
	};

	public static final String[] MOVES_GENERATOR_CORNER_UBL_FIXED = {
		"F",
		"F'",
		"F2",
		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2"
	};

	public static final String[] LAST_MOVE_R = {
		"F",
		"F'",
		"F2",
		"D",
		"D'",
		"D2"
	};

	public static final String[] LAST_MOVE_F = {

		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2"
	};

	public static final String[] LAST_MOVE_D = {
		"F",
		"F'",
		"F2",
		"R",
		"R'",
		"R2"
	};

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_RED = "\u001B[48;5;160m";

	public static final String ANSI_GREEN = "\u001B[48;5;35m";

	public static final String ANSI_YELLOW = "\u001B[48;5;226m";

	public static final String ANSI_BLUE = "\u001B[48;5;26m";

	public static final String ANSI_WHITE = "\u001B[48;5;255m";

	public static final String ANSI_ORANGE = "\u001B[48;5;208m";

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

	protected int orientOne;

	protected int orientTwo;

	protected int orientThree;

	protected int[] rubik;
}