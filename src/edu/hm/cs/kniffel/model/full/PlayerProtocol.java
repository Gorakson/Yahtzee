/**
 * Hochschule M�nchen, Fakult�t 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * L�sung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */


package edu.hm.cs.kniffel.model.full;

import java.util.List;
import java.util.Map;

import edu.hm.cs.kniffel.interfaces.Changeable;

import java.util.HashMap;

/**
 * A protocol that keeps track of the points a player scored.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 *
 */
public class PlayerProtocol {
    /** The owner of this protocol. */
    private final Changeable owner;

    /**
     * A entry in the protocol. 
     * @author Thomas Pfaffinger
     * @version 1.0
     */
    private static class ProtocolEntry {
        /** The number of points scored. */
        private int score; 
        /** true if the player scored, false otherwise. */
        private boolean scored;

        private int getScore() {
            return score;
        }

        /**
         * Sets the score for this entry and marks the entry as scored.
         * Can only be used once.
         * @param score the score
         */
        private void setScore(int score) {
            if (scored) {
                throw new IllegalStateException();
            }

            this.score = score;
            scored = true;
        }

        private boolean isScored() {
            return scored;
        }
    }

    /**
     * Rulenames and their respective ProtocolEntries.
     */
    private final Map<String, ProtocolEntry> protocol;

    /**
     * Ctor. 
     * @param owner The object that will be notified when this protocol changes.
     * @param rules The names of the rules this protocol will keep track of.
     */
    public PlayerProtocol(Changeable owner, List<String> rules) {
        if (rules == null) {
            throw new NullPointerException();
        } else if (rules.size() == 0) {
            throw new IllegalArgumentException();
        } else if (owner == null) {
            throw new NullPointerException();
        }

        this.owner = owner;

        protocol = new HashMap<>();
        rules.stream().forEach(rule -> protocol.put(rule, new ProtocolEntry()));
    }

    /**
     * Yields the number of points scored for a rule.
     * 
     * @param ruleName name of the rule
     * @return number of points
     */
    public int getPoints(String ruleName) {

        if (!protocol.containsKey(ruleName)) {
            throw new IllegalArgumentException();
        } 

        return protocol.get(ruleName).getScore();
    }

    /**
     * Sets the points for a rule.
     * @param ruleName name of the rule
     * @param points number of points
     */
    public void setPoints(String ruleName, int points) {

        if (!protocol.containsKey(ruleName)) {
            throw new IllegalArgumentException();
        } else if (points < 0) {
            throw new IllegalArgumentException();
        }

        protocol.get(ruleName).setScore(points);
        owner.notifyChange();
    }

    /**
     * Tells weather a rule has been scored.
     * @param ruleName name of the rule
     * @return true if rule has been scored
     */
    public boolean isScored(String ruleName) {

        if (!protocol.containsKey(ruleName)) {
            throw new IllegalArgumentException();
        } 

        return protocol.get(ruleName).isScored();
    }

    /**
     * Yields the sum of all points.
     * @return sum of all points
     */
    public int sum() {
        int sum = 0;

        for (ProtocolEntry entry : protocol.values()) {
            sum += entry.getScore();
        }

        return sum;
    }
    
    /**
     * Gets the sum of points for the specified rules.
     * @param rules The rules in question
     * @return sum of points
     */
    public String sum(List<String> rules) {
        int sum = 0;

        for (String rule : rules) {
            sum += getPoints(rule);
        }

        return Integer.toString(sum);
    }

    /**
     * Tells weather there is any rule that has not been scored yet.
     * @return true if there is no such rule, false otherwise
     */
    public boolean allScored() {
        return protocol.values().stream().allMatch(entry -> entry.isScored() );
    }   
}
