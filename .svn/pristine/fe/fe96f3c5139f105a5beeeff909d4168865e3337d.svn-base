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
 * Chance.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-30
 */
public final class RuleChance extends BaseRule {

    /** The rules name. */
    private static final String NAME = "Chance";

    /**
     * Ctor.
     */
    public RuleChance() {
        super(NAME);
    }

    @Override
    public boolean check(ReadonlyDiceCup diceCup) {
        return true;
    }

    @Override
    public int numPoints(ReadonlyDiceCup diceCup) {
        int sum = 0;

        for (int diceValue : diceCup.getValues()) {
            sum += diceValue;
        }

        return sum;
    }
}
