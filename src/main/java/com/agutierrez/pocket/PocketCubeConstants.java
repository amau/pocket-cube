//
// Tom Sawyer Software
// Copyright 1992 - 2015
// All rights reserved.
//
// www.tomsawyer.com
//

package com.agutierrez.pocket;

public class PocketCubeConstants
{
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

}

