/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.logic.command;

import edu.hm.cs.kniffel.controller.rules.Rule;
import edu.hm.cs.kniffel.controller.rules.RuleBonus;
import edu.hm.cs.kniffel.controller.rules.Ruleset;
import edu.hm.cs.kniffel.model.GameState;
import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.ScoreboardSection;
import edu.hm.cs.kniffel.model.full.WriteableGame;

/**
 * A command which will handle the end of the turn.
 * That means it will either proceed the game with the next player or
 * will determine a winner and set the games state to GameOver.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class CommandWriteScore implements Command {

    /** The rule which will be scored. */
	private final Rule rule;

	/**
	 * Ctor with rule.
	 * @param rule the rule which will be scored. 
	 */
	public CommandWriteScore(Rule rule) {
		if (rule == null) {
			throw new NullPointerException();
		}
		
		this.rule = rule;
	}
	
	@Override
	public CommandResult test(WriteableGame game, Player player) {
		final CommandResult result;
		
		if (game.getState() != GameState.Running) {
			result = new CommandResult(false, "Game is not running.");
		} else if (!game.getCurrentPlayer().equals(player)) {
			result = new CommandResult(false, "Player with ID: " + player.getId() + " is not the current player.");
		} else if (game.getDiceCup().getRollsCount() < 1) {
			result = new CommandResult(false, "Player with ID: " + player.getId() + " must roll first.");
		} else if (game.getDiceCup().getRollsCount() < Ruleset.MAX_ROLL_COUNT && !rule.check(game.getDiceCup())) {
			result = new CommandResult(false, "You must first roll " + Ruleset.MAX_ROLL_COUNT + " times before filling in zero.");
		} else if (player.getProtocol().isScored(rule.getName())) {
			result = new CommandResult(false, "The box " + rule.toString() + " is already filled in.");
		} else {
			result = new CommandResult();
		}
			
		return result;
	}

	@Override
	public CommandResult execute(WriteableGame game, Player player) {
		final CommandResult result = test(game, player);
		
		if (result.getResult()) {
			player.getProtocol().setPoints(rule.getName(), rule.numPoints(game.getDiceCup()));
			
			// Check for Bonus
			if (rule.getSection() == ScoreboardSection.Upper) {
				if (player.getProtocol().sum() >= Ruleset.MIN_POINTS_BONUS) {
					final Rule bonus = new RuleBonus();
					player.getProtocol().setPoints(bonus.getName(), bonus.numPoints(game.getDiceCup()));
				}
			}
			
			game.setState(GameState.TurnEnd);
		} else {
			throw new IllegalStateException(result.getDescription());
		}
		
		return result;
	}

}
