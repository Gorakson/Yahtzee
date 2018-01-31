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
 * Full House rule.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class RuleFullHouse extends BaseRule {

    /** The rules name. */
    private static final String NAME = "Full House";
    /** The fixed points this rule will yield when scored. */
    private static final int NUM_POINTS = 25;
    /** Number of different dice values in a full house. */
    private static final int NUM_DIFFERENT_VALUES = 2;
    /** The size of a pair. */
    private static final int SIZE_PAIR = 2;

    /**
     * Ctor.
     */
    public RuleFullHouse() {
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

        return counts.size() == NUM_DIFFERENT_VALUES && counts.values().contains(SIZE_PAIR);
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
