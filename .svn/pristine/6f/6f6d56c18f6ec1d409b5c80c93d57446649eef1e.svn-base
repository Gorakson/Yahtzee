/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.controller.rules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.hm.cs.kniffel.model.ReadonlyDiceCup;

/**
 * Large Straight. 
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class RuleLargeStraight extends BaseRule {

    /** The rules name. */
    private static final String NAME = "Large Straight";
    /** The fixed points this rule will yield when scored. */
    private static final int NUM_POINTS = 40;
    /** The minimum number of dices in consecutive order for this straight. */
    private static final int MIN_STRAIGHT_SIZE = 5;

    /** 
     * Ctor.
     */
    public RuleLargeStraight() {
        super(NAME);
    }

    @Override
    public boolean check(ReadonlyDiceCup diceCup) {
        final List<Integer> diceValues = new ArrayList<>(diceCup.getValues());
        Collections.sort(diceValues);

        int straightSize = 1;

        for (int index = 1; index < diceValues.size() && straightSize < MIN_STRAIGHT_SIZE; index++) {
            if (diceValues.get(index) - diceValues.get(index - 1) == 1) {
                straightSize++;
            } else {
                straightSize = 1;
            }
        }

        return straightSize >= MIN_STRAIGHT_SIZE;
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

}
