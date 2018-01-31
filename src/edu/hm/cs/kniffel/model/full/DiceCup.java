/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model.full;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import edu.hm.cs.kniffel.interfaces.Changeable;
import edu.hm.cs.kniffel.model.ReadonlyDice;

/**
 * A container for dices.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-30
 */
public class DiceCup implements ReadwriteDiceCup {
    /** The owner of this DiceCup. */
    private final Changeable owner;
    /** All dices. */
    private final List<RollableDice> dices;
    /** The inactive dices. */
    private final Set<ReadonlyDice> inactiveDices;
    /** The number of rolls since the last reset. */
    private int rollsCount;

    /**
     * Ctor.
     * @param owner the owner of this DiceCup
     * @param size the number of dices in this DiceCup
     */
    public DiceCup(Changeable owner, int size) {
        if (owner == null) {
            throw new NullPointerException();
        } else if (size < 1) {
            throw new IllegalArgumentException();
        }

        this.owner = owner;
        rollsCount = 0;
        dices = new ArrayList<>();

        for (int index = 0; index < size; index++) {
            dices.add(new Dice());
        }

        inactiveDices = new HashSet<>();
    }

    @Override
    public void roll() {		
        dices.forEach(dice -> {
            if (!inactiveDices.contains(dice)) {
                dice.roll();
            }
        });

        rollsCount++;
        owner.notifyChange();
    }

    @Override
    public List<Integer> getValues() {
        return Collections.unmodifiableList(dices.stream().map(dice -> dice.getValue()).collect(Collectors.toList()));
    }

    @Override
    public int getRollsCount() {
        return rollsCount;
    }

    @Override
    public void reset() {
        rollsCount = 0;		
        inactiveDices.clear();

        dices.stream().forEach(dice -> dice.reset() );
    }

    @Override
    public List<ReadonlyDice> getDices() {
        return Collections.unmodifiableList(dices);
    }

    @Override
    public boolean isInactive(ReadonlyDice dice) {
        return inactiveDices.contains(dice);
    }

    @Override
    public void setActive(ReadonlyDice dice, boolean isActive) {
        if (isActive && inactiveDices.contains(dice)) {
            inactiveDices.remove(dice);
        } else if (!(isActive || inactiveDices.contains(dice))) {
            inactiveDices.add(dice);
        } else {
            throw new IllegalArgumentException();
        }

        owner.notifyChange();
    }

    @Override
    public boolean anyActive() {
        return !inactiveDices.containsAll(dices);
    }
}
