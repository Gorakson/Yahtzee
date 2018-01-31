/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model;

import java.util.List;

/**
 * A readonly view of a dicecup.
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public interface ReadonlyDiceCup {
    /** 
     * Provides the dices current values. 
     * @return The current values of all dices
     */
	List<Integer> getValues();
	/**
	 * Provides the dices.
	 * @return all dices in this DiceCup
	 */
	List<ReadonlyDice> getDices();
	/**
	 * Provides the number of rolls of the currently active player.
	 * @return number of rolls
	 */
	int getRollsCount();
	/**
	 * Tells weather or not a dice is currently active.
	 * @param dice The dice in question
	 * @return true if dice is active, false otherwise
	 */
	boolean isInactive(ReadonlyDice dice);
	/**
	 * Tells weather or not there is any active dice.
	 * @return true if there is any active dice, false otherwise
	 */
	boolean anyActive();

}