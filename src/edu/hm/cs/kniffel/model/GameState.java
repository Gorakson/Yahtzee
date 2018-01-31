/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model;

/**
 * The current game state.
 * @author Thomas Pfaffinger
 * @version 1.0
 */
public enum GameState {
    
    /** The game is currently running. The players can roll dice and score. */
	Running,
	/** The turn ended. */
	TurnEnd,
	/** There is a winner and the game is over. */
	GameOver
}
