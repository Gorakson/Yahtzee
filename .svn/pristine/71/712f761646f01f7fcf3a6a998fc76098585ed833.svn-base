/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.controller.rules;

import java.util.HashMap;
import java.util.Map;

import edu.hm.cs.kniffel.model.ReadonlyDiceCup;

/**
 * 4 of a kind rule.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-30
 */
public class RuleFourOfAKind extends BaseRule {

    /** The rules name. */
    private static final String NAME = "Four of a kind";
    /** Minimum number of dices with the same value. */
    private static final int MIN_COUNT = 4;

    /**
     * Ctor.
     */
    public RuleFourOfAKind() {
        super(NAME);
    }


    @Override
    public boolean check(ReadonlyDiceCup diceCup) {
        final Map<Integer, Integer> counts = new HashMap<>();

        diceCup.getValues().forEach(value -> {
            if (counts.containsKey(value)) {
                counts.put(value, counts.get(value) + 1);
            } else {
                counts.put(value, 1);
            }
        });

        return counts.values().stream().anyMatch(value -> value >= MIN_COUNT);
    }

    @Override
    public int numPoints(ReadonlyDiceCup diceCup) {
        final int result;

        if (check(diceCup)) {
            int sum = 0;

            for (int diceValue : diceCup.getValues()) {
                sum += diceValue;
            }

            result = sum;
        } else {
            result = 0;
        }

        return result;
    }

}
