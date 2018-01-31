/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model.full;

import edu.hm.cs.kniffel.model.ReadonlyDice;

/**
 * A view for a dice with full access.
 * 
 * @author Thomas Pfaffinger, thomas.paffinger@hm.edu
 * @version 1.0
 */
public interface RollableDice extends ReadonlyDice {
    /** rolls the dice. */
	void roll();
	/** resets the dice. */
	void reset();
}