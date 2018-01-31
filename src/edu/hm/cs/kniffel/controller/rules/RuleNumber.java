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
 * A rule for numbers.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public final class RuleNumber extends BaseRule {

    /** The dice value for this rule. */
    private final int number;

    /**
     * Ctor with number.
     * @param number dice value for this rule
     */
    public RuleNumber(int number) {
        super(number + "s");
        this.number = number;
    }


    @Override
    public boolean check(ReadonlyDiceCup diceCup) {
        return diceCup.getValues().stream().filter(num -> num == number).count() >= 1;
    }

    @Override
    public int numPoints(ReadonlyDiceCup diceCup) {
        final int result;

        if (check(diceCup)) {
            result = (int) (diceCup.getValues().stream().filter(num -> num == number).count() * number);
        } else {
            result = 0;
        }

        return result;
    }

    @Override
    public ScoreboardSection getSection() {
        return ScoreboardSection.Upper;
    }
}
