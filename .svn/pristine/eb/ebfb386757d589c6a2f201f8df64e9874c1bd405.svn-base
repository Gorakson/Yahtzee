/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.logic.command;

import edu.hm.cs.kniffel.controller.rules.Ruleset;
import edu.hm.cs.kniffel.model.GameState;
import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.full.WriteableGame;

/**
 * A command for rolling the DiceCup.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 2016-05-30 *
 */
public class CommandRollDiceCup implements Command {
    
	@Override
	public CommandResult execute(WriteableGame game, Player player) {
		final CommandResult result = test(game, player);
		
		if (result.getResult()) {
			game.getDiceCup().roll();
		} else {
			throw new IllegalStateException(result.getDescription());
		}
		
		return result;
	}

	@Override
	public CommandResult test(WriteableGame game, Player player) {
		final CommandResult result;
		
		if (game.getState() != GameState.Running) {
			result = new CommandResult(false, "Game is not running.");
		} else if (!game.getCurrentPlayer().equals(player)) {
			result = new CommandResult(false, "Player with ID: " + player.getId() + " is not the current player.");
		} else if (game.getDiceCup().getRollsCount() >= Ruleset.MAX_ROLL_COUNT) {
			result = new CommandResult(false, "Player with ID: " + player.getId() + " has already rolled " + Ruleset.MAX_ROLL_COUNT + " times");
		} else if (!game.getDiceCup().anyActive()) {
			result = new CommandResult(false, "There are no dices to roll.");
		} else {
			result = new CommandResult();
		}
		
		return result;
	}

}
