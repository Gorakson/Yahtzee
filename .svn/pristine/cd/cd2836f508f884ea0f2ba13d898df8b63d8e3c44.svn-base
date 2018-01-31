/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.controller.rules;

import edu.hm.cs.kniffel.model.ScoreboardSection;

/**
 * ABC class for Commands.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-29
 */
abstract class BaseRule implements Rule {
    /** The name of this Rule. */
	private final String name;
	
	/**
	 * Creates a new Rule.
	 * 
	 * @param name the name of this Rule
	 */
	BaseRule(String name) {
		this.name = name;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public ScoreboardSection getSection() {
		return ScoreboardSection.Lower;
	}
}
