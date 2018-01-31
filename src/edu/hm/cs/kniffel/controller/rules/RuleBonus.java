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
 * The bonus rule.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class RuleBonus extends BaseRule {
	
    /** The rules name. */
	private static final String NAME = "Bonus";
	/** The fixed points this rule will yield when scored. */
	private static final int SCORE = 35;
	
	/**
	 * Ctor.
	 */
	public RuleBonus() {
		super(NAME);
	}

	@Override
	public boolean check(ReadonlyDiceCup diceCup) {
		return false;
	}

	@Override
	public int numPoints(ReadonlyDiceCup diceCup) {
		return SCORE;
	}

	@Override
	public ScoreboardSection getSection() {
		return ScoreboardSection.Upper;
	}
}
