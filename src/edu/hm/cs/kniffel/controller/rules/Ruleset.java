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
import java.util.stream.Collectors;

import edu.hm.cs.kniffel.model.ScoreboardSection;

/**
 * A ruleset for a game. It contains constants that a relevant for the game and
 * all the rules of the scoreboard.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-30
 */
public class Ruleset {
    /** The minimum number of players for a game. */
    public static final int MIN_NUM_PLAYERS = 1;
    /** The maximum number of players for a game. */
    public static final int MAX_NUM_PLAYERS = 6;
    /** The maximum number of rolling the dice cup. */
    public static final int MAX_ROLL_COUNT = 3;
    /** Maximum value a dice can have. */
    public static final int MAX_DICE_VALUE = 6;
    /** Minimum value a dice can have. */
    public static final int MIN_DICE_VALUE = 1;
    /** 
     * The minimum number of points a player must have scored in the upper section
     * in order to apply for the bonus.
     */
    public static final int MIN_POINTS_BONUS = 63;
    /** Number of dices for a game. */
    public static final int NUM_DICE = 5;
    
    /** A list containing all rules. */
    private final List<Rule> rules;

    /**
     * Creates a new Ruleset.
     */
    public Ruleset() {
        rules = new ArrayList<>();

        for (int counter = MIN_DICE_VALUE; counter <= MAX_DICE_VALUE; counter++) {
            rules.add(new RuleNumber(counter));
        }

        rules.add(new RuleBonus());
        rules.add(new RuleThreeOfAKind());
        rules.add(new RuleFourOfAKind());
        rules.add(new RuleFullHouse());
        rules.add(new RuleSmallStraight());
        rules.add(new RuleLargeStraight());
        rules.add(new RuleYahtzee());
        rules.add(new RuleChance());
    }

    /**
     * Provides all rules.
     * 
     * @return all rules which must be scored for ending the game.
     */
    public List<Rule> getRules() {
        return Collections.unmodifiableList(rules);
    }

    /**
     * Provides all rules of a specific section.
     * @param section The section of the scoreboard
     * @return All rules of that section
     */
    public List<Rule> getRules(ScoreboardSection section) {
        return Collections.unmodifiableList(rules.stream().filter(rule -> rule.getSection() == section)
                .collect(Collectors.toList()));
    }

    /**
     * Provides the names of all rules.
     * 
     * @return List of String containing all rulenames
     */
    public List<String> getRuleNames() {
        return getRules().stream().map(rule -> rule.getName() ).collect(Collectors.toList());
    }

    /**
     * Provides the names of all rules in a specific section.
     * @param section The section of the scoreboard
     * @return All rulenames of that section
     */
    public List<String> getRuleNames(ScoreboardSection section) {
        return getRules(section).stream().map(rule -> rule.getName() ).collect(Collectors.toList());
    }
}
