//
// Tom Sawyer Software
// Copyright 1992 - 2015
// All rights reserved.
//
// www.tomsawyer.com
//

package com.agutierrez.pocket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SolutionsGenerator
{
	public static String[] getValidMoves(String lastMoves)
	{
		String[] res = null;

		if (lastMoves.endsWith("R") ||
			lastMoves.endsWith("R'") ||
			lastMoves.endsWith("R2"))
		{
			res = SolutionsGenerator.LAST_MOVE_R;
		}
		else if (lastMoves.endsWith("D") ||
			lastMoves.endsWith("D'") ||
			lastMoves.endsWith("D2"))
		{
			res = SolutionsGenerator.LAST_MOVE_D;
		}
		else if (lastMoves.endsWith("F") ||
			lastMoves.endsWith("F'") ||
			lastMoves.endsWith("F2"))
		{
			res = SolutionsGenerator.LAST_MOVE_F;
		}
		else
		{
			res = SolutionsGenerator.MOVES;
		}

		return res;
	}


	public static void main(String args[])
	{
		Map<String, String> positions = new HashMap<String, String>();
		Queue<String> queue = new LinkedList<String>();
		String pos;
		String newPos;
		PocketCube copy = new PocketCube();
		String algorithm;

		queue.offer(copy.toString());
		positions.put(copy.toString(),
			"");
		int cont = 1;

		int posi = 1;
		int i = 0;
		String lastMoves;
		String[] validMoves;

		long time = System.currentTimeMillis();

		while ((pos = queue.poll()) != null)
		{

			lastMoves = positions.get(pos);
			validMoves = SolutionsGenerator.getValidMoves(lastMoves);
			for (String move : validMoves)
			{
				copy = new PocketCube();
				copy.setPosition(pos);
				copy.applySequence(move);
				newPos = copy.toString();
				algorithm = positions.get(pos) + move;
				cont++;
				if (!positions.keySet().contains(newPos))
				{

					positions.put(newPos,
						algorithm);
					queue.offer(newPos);
					posi++;

				}
			}

		}

		time = System.currentTimeMillis() - time;
		System.out.println("Number of loops: " + cont);
		System.out.println("Number of positions: " + posi);
		System.out.println("Milliseconds elapsed: " + time);
		// try
		// {
		// File file = new File("full.txt");
		// BufferedWriter output = new BufferedWriter(new
		// FileWriter(file));
		//
		// for (String position : positions.keySet())
		// {
		//
		// output.write(position + "," + positions.get(position));
		// output.newLine();
		// }
		//
		// output.close();
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		//
		// try
		// {
		// File file = new File("positionsonly.txt");
		// BufferedWriter output = new BufferedWriter(new
		// FileWriter(file));
		//
		// for (String position : positions.keySet())
		// {
		//
		// output.write(position + ",");
		//
		// }
		//
		// output.close();
		// }
		// catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		//
		// for (String position : positions.keySet())
		// {
		// System.out.println(position + "," + positions.get(position));
		// }

	}

	public static final String[] MOVES = { "F",
		"F'",
		"F2",
		// "B",
		// "B'",
		// "B2",
		// "L",
		// "L'",
		// "L2",
		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2",
		// "U",
		// "U'",
		// "U2"
	};

	public static final String[] LAST_MOVE_R = { "F",
		"F'",
		"F2",
		// "B",
		// "B'",
		// "B2",
		// "L",
		// "L'",
		// "L2",
		// "R",
		// "R'",
		// "R2",
		"D",
		"D'",
		"D2",
		// "U",
		// "U'",
		// "U2"
	};

	public static final String[] LAST_MOVE_F = {
		// "F",
		// "F'",
		// "F2",
		// "B",
		// "B'",
		// "B2",
		// "L",
		// "L'",
		// "L2",
		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2",
		// "U",
		// "U'",
		// "U2"
	};

	public static final String[] LAST_MOVE_D = {
		"F",
		"F'",
		"F2",
		// "B",
		// "B'",
		// "B2",
		// "L",
		// "L'",
		// "L2",
		"R",
		"R'",
		"R2",
		// "D",
		// "D'",
		// "D2",
		// "U",
		// "U'",
		// "U2"
	};

	public static int DEEPNESS = 4;
}
