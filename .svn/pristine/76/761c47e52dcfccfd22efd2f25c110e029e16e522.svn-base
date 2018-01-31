/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model.full;

import edu.hm.cs.kniffel.controller.rules.Ruleset;

/**
 * A dice which has a value that can be randomized. 
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0 *
 */
public class Dice implements RollableDice {
	
    /** The ID that will be given to the dice which will be created next. */
	private static long nextId = 1;
	/** The ID of this dice. */
	private final long id;
	/** The current value of this dice. */
	private int value;
	
	/**
	 * Ctor.
	 */
	public Dice() {
		this.id = nextId++;
	}
	
	@Override
	public int getValue() {
		return value;
	}
	
	@Override
	public void roll() {
        value = (int) (Math.random() * Ruleset.MAX_DICE_VALUE + Ruleset.MIN_DICE_VALUE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Dice other = (Dice) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public void reset() {
		value = 0;
	}
}
