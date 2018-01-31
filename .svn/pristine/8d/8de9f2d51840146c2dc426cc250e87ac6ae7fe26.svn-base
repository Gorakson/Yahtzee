/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model.full;

import edu.hm.cs.kniffel.model.GameState;
import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.ReadonlyGame;

/**
 * A view for a game with full access. 
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 *
 */
public abstract class WriteableGame extends ReadonlyGame {
    /** Determines and sets the next active player. */
	public abstract void nextPlayer();
	/** 
	 * Changes the games state.
	 * @param gameState the new state
	 */
	public abstract void setState(GameState gameState);
	/**
	 * Sets the winner.
	 * @param player the winner
	 */
	public abstract void setWinner(Player player);
}