
package com.agutierrez.pocket;

public class Main 
{
	/**
	 * Main entry point of the game, creates the engine object and starts the
	 * game loop.
	 */
	public static void main(String args[]) 
	{
		PocketCube p = new PocketCube();

		p.gameLoop();
	}
}
