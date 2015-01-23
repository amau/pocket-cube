
package com.agutierrez.pocket;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solver
{
	public static String[] getValidMoves(String lastMoves)
	{
		String[] res = null;

		if (lastMoves.endsWith("R") ||
			lastMoves.endsWith("R'") ||
			lastMoves.endsWith("R2"))
		{
			res = PocketCubeConstants.HALF_TURN_GENERATOR_UBL_LAST_MOVE_R;
		}
		else if (lastMoves.endsWith("D") ||
			lastMoves.endsWith("D'") ||
			lastMoves.endsWith("D2"))
		{
			res = PocketCubeConstants.HALF_TURN_GENERATOR_UBL_LAST_MOVE_D;
		}
		else if (lastMoves.endsWith("F") ||
			lastMoves.endsWith("F'") ||
			lastMoves.endsWith("F2"))
		{
			res = PocketCubeConstants.HALF_TURN_GENERATOR_UBL_LAST_MOVE_F;
		}
		else
		{
			res = PocketCubeConstants.HALF_TURN_GENERATOR_CORNER_UBL_FIXED;
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
}

