package edu.hm.cs.kniffel.logic.command;

import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.full.WriteableGame;

/**
 * A command which executes a specific task.
 * The task will manipulate the current gamestate in some way.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public interface Command {
    /**
     * Checks if the command can be executed in the current state.
     * 
     * @param game The game this command manipulates
     * @param player The requesting player
     * @return CommandResult with data on whether this command can be executed or not.
     */
    CommandResult test(WriteableGame game, Player player);

    /**
     * Executes the command.
     * 
     * @param game The game this command manipulates
     * @param player The requesting player
     * @return CommandResult with data on whether this command can be executed or not.
     */
    CommandResult execute(WriteableGame game, Player player);
}
