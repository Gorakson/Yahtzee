/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.controller.rules;

import edu.hm.cs.kniffel.model.ReadonlyDiceCup;

/**
 * Three of a kind rule.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public final class RuleYahtzee extends BaseRule {

    /** Minimum number of dices with the same value. */
    private static final int MIN_COUNT = 5;
    /** The fixed points this rule will yield when scored. */
    private static final int NUM_POINTS = 50;
    /** The name of this rule. */
    private static final String NAME = "Yahtzee";

    /**
     * Ctor.
     */
    public RuleYahtzee() {
        super(NAME);
    }

    @Override
    public boolean check(ReadonlyDiceCup diceCup) {

        final int number = diceCup.getValues().get(0);
        return diceCup.getValues().stream().filter(num -> num == number).count() >= MIN_COUNT;
    }

    @Override
    public int numPoints(ReadonlyDiceCup diceCup) {
        final int result;

        if (check(diceCup)) {
            result = NUM_POINTS;
        } else {
            result = 0;
        }

        return result;
    }

    @Override
    public String toString() {
        return "Yahtzee";
    }
}
