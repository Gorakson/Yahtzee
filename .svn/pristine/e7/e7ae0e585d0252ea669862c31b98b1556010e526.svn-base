/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.logic.command;

/**
 * The result of a commands execution or test for execution.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 *
 */
public class CommandResult {
    /** true if (test for) execution was successfull. */
    private boolean result;
    /** description of the result. */
    private String description;

    /**
     * Ctor.
     * Creates a new successfull CommandResult with an empty description.
     */
    public CommandResult() {
        this(true, "");
    }

    /**
     * Ctor.
     * @param result indicates weather the (test for) execution was successfull
     * @param description of the result
     */
    public CommandResult(boolean result, String description) {
        this.result = result;
        this.description = description;
    }

    public boolean getResult() {
        return result;
    }

    public String getDescription() {
        return description;
    }
}
