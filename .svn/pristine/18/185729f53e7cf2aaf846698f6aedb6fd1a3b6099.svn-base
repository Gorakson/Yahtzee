/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.controller.rules;

import edu.hm.cs.kniffel.model.ReadonlyDiceCup;
import edu.hm.cs.kniffel.model.ScoreboardSection;

/**
 * A named rule which calculates the points a player gets if 
 * he chooses to score.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public interface Rule {
    /**
     * The name of this Rule.
     * @return the name of this Rule
     */
	String getName();
	
	/**
	 * Checks weather scoring this rule would yield any points.
	 * @param diceCup The DiceCup with all currently active dices
	 * @return true if the rule would yield any points, false otherwise
	 */
	boolean check(ReadonlyDiceCup diceCup);
	
	/**
	 * The number of points this rule yields in the current context.
	 * Will be 0 if check returns false.
	 * 
	 * @param diceCup The DiceCup with all currently active dices
	 * @return Number of points
	 */
	int numPoints(ReadonlyDiceCup diceCup);
	
	/**
	 * This rules section, meaning its position on the Scoreboard.
	 * @return this rules section
	 */
	ScoreboardSection getSection();
}
