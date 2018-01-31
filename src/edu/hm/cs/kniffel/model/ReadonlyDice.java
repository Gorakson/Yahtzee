/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model;

/**
 * A readonly view of a dice. Only shows its current value. 
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-30
 */
public interface ReadonlyDice {
    /** 
     * The dices current value.
     * @return the dices current Value.
     */
	int getValue();
}