package com.agutierrez.pocket;

public class PocketCubeConstants
{
	/**
	 * Regular expression that accepts valid moves for the Pocket Cube
	 */
	public static final String RUBIK_PATTERN = "[DULRFB][2']?";

	/**
	 * Valid moves in the half turn metric in which 90º and 180º turns
	 * are counted as single moves.
	 */
	public static final String[] HALF_TURN_METRIC_MOVES = { "F",
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

	/**
	 * Valid moves in the quarter turn metric in which only 90º turns
	 * are counted as single moves.
	 */
	public static final String[] QUARTER_TURN_METRIC_MOVES = { "F",
		"F'",
		"B",
		"B'",
		"L",
		"L'",
		"R",
		"R'",
		"D",
		"D'",
		"U",
		"U'"
	};

	/**
	 * Set of generator moves used to fix the upper back left corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_UBL_FIXED = {
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

	/**
	 * Set of generator moves used to fix the upper back right corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_UBR_FIXED = {
		"F",
		"F'",
		"F2",
		"L",
		"L'",
		"L2",
		"D",
		"D'",
		"D2"
	};
	/**
	 * Set of generator moves used to fix the upper front right corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_UFR_FIXED = {
		"B",
		"B'",
		"B2",
		"L",
		"L'",
		"L2",
		"D",
		"D'",
		"D2"
	};
	
	/**
	 * Set of generator moves used to fix the upper front left corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_UFL_FIXED = {
		"B",
		"B'",
		"B2",
		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2"
	};

	/**
	 * Set of generator moves used to fix the down front left corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_DFL_FIXED = {
		"B",
		"B'",
		"B2",
		"R",
		"R'",
		"R2",
		"U",
		"U'",
		"U2"
	};

	/**
	 * Set of generator moves used to fix the down front right corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_DFR_FIXED = {
		"B",
		"B'",
		"B2",
		"L",
		"L'",
		"L2",
		"U",
		"U'",
		"U2"
	};

	/**
	 * Set of generator moves used to fix the down back left corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_DBL_FIXED = {
		"F",
		"F'",
		"F2",
		"R",
		"R'",
		"R2",
		"U",
		"U'",
		"U2"
	};
	
	/**
	 * Set of generator moves used to fix the down back right corner.
	 */
	public static final String[] HALF_TURN_GENERATOR_CORNER_DBR_FIXED = {
		"F",
		"F'",
		"F2",
		"L",
		"L'",
		"L2",
		"U",
		"U'",
		"U2"
	};

	/**
	 * Set of valid moves when last face moved was the right one. Upper back left corner is fixed.
	 */
	public static final String[] HALF_TURN_GENERATOR_UBL_LAST_MOVE_R = {
		"F",
		"F'",
		"F2",
		"D",
		"D'",
		"D2"
	};

	/**
	 * Set of valid moves when last face moved was the front one. Upper back left corner is fixed.
	 */
	public static final String[] HALF_TURN_GENERATOR_UBL_LAST_MOVE_F = {

		"R",
		"R'",
		"R2",
		"D",
		"D'",
		"D2"
	};

	/**
	 * Set of valid moves when last face moved was the down one. Upper back left corner is fixed.
	 */
	public static final String[] HALF_TURN_GENERATOR_UBL_LAST_MOVE_D = {
		"F",
		"F'",
		"F2",
		"R",
		"R'",
		"R2"
	};
	
	/**
	 * Up Front Right corner.
	 */
	public static final int[] UFR_INDEXES = {
		13,
		7,
		8
	}
	
	/**
	 * Up Right Back corner.
	 */
	public static final int[] URB_INDEXES = {
		1,
		9,
		10
	}
	
	/**
	 * Up Back Left corner.
	 */
	public static final int[] UBL_INDEXES = {
		0,
		11,
		4
	}
	
	/**
	 * Up Left Front corner.
	 */
	public static final int[] ULF_INDEXES = {
		12,
		5,
		6
	}
	
	/**
	 * Down Right Front corner.
	 */
	public static final int[] DRF_INDEXES = {
		3,
		20,
		19
	}
	
	/**
	 * Down Front Left corner.
	 */
	public static final int[] DFL_INDEXES = {
		2,
		18,
		17
	}
	
	/**
	 * Down Left Back corner.
	 */
	public static final int[] DLB_INDEXES = {
		14,
		16,
		23
	}
	
	/**
	 * Down Back Right corner.
	 */
	public static final int[] DBR_INDEXES = {
		15,
		22,
		21
	}

	/**
	 * Up Front Right corner offset.
	 */
	public static final int[] UFR = 0;

	/**
	 * Up Right Back corner offset.
	 */
	public static final int[] URB = 5;

	/**
	 * Up Back Left corner offset.
	 */
	public static final int[] UBL = 10;

	/**
	 * Up Left Front corner offset.
	 */
	public static final int[] ULF = 15;

	/**
	 * Down Right Front corner offset.
	 */
	public static final int[] DRF = 20;	

	/**
	 * Down Front Left corner offset.
	 */
	public static final int[] DFL = 25;

	/**
	 * Down Left Back corner offset.
	 */
	public static final int[] DLB = 30;
	
	/**
	 * Down Back Right corner offset.
	 */
	public static final int[] DBR = 35;	
	
	/**
	 * Up Front Right corner bit mask.
	 */
	public static final int[] UFR = 0;

	/**
	 * Up Right Back corner bit mask.
	 */
	public static final int[] URB = 1;

	/**
	 * Up Back Left corner bit mask.
	 */
	public static final int[] UBL = 3;

	/**
	 * Up Left Front corner bit mask.
	 */
	public static final int[] ULF = 2;

	/**
	 * Down Right Front corner bit mask.
	 */
	public static final int[] DRF = 4;	

	/**
	 * Down Front Left corner bit mask.
	 */
	public static final int[] DFL = 6;

	/**
	 * Down Left Back corner bit mask.
	 */
	public static final int[] DLB = 7;
	
	/**
	 * Down Back Right corner bit mask.
	 */
	public static final int[] DBR = 5;
	
	/**
	 * Correct orientation.
	 */
	public static final int NEEDS_ZERO_CLOCKWISE = 0;
	
	/**
	 * Correct orientation.
	 */
	public static final int NEEDS_ONE_CLOCKWISE = 1;
	
	/**
	 * Correct orientation.
	 */
	public static final int NEEDS_TWO_CLOCKWISE = 2;
	
	/**
	 * ASNI code to get color back to default.
	 */
	public static final String ANSI_RESET = "\u001B[0m";

	/**
	 * ASNI code to set background color to red.
	 */
	public static final String ANSI_RED = "\u001B[48;5;160m";

	/**
	 * ASNI code to set background color to green.
	 */
	public static final String ANSI_GREEN = "\u001B[48;5;35m";

	/**
	 * ASNI code to set background color to yellow.
	 */
	public static final String ANSI_YELLOW = "\u001B[48;5;226m";

	/**
	 * ASNI code to set background color to blue.
	 */
	public static final String ANSI_BLUE = "\u001B[48;5;26m";

	/**
	 * ASNI code to set background color to white.
	 */
	public static final String ANSI_WHITE = "\u001B[48;5;255m";

	/**
	 * ASNI code to set background color to orange.
	 */
	public static final String ANSI_ORANGE = "\u001B[48;5;208m";

}
