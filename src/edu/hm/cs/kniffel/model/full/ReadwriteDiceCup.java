/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model.full;

import edu.hm.cs.kniffel.model.ReadonlyDice;
import edu.hm.cs.kniffel.model.ReadonlyDiceCup;

/**
 * A view for a DiceCup with full access.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu 
 * @version 2016-05-30
 */
public interface ReadwriteDiceCup extends ReadonlyDiceCup {
    /** Rolls the dices. */
	void roll();
	/** Resets all dices and the roll count. */
	void reset();
	/**
	 * Sets a dices state to active/inactive, depending on its current state.
	 * @param dice the dice whose change should change
	 * @param isActive true, if the dice should be active, false otherwise
	 */
	void setActive(ReadonlyDice dice, boolean isActive);
}