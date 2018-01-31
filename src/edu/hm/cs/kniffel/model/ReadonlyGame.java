/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model;

import java.util.List;
import java.util.Observable;
import java.util.Optional;

import edu.hm.cs.kniffel.model.full.ReadwriteDiceCup;

/**
 * Readonly view on a games data.
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 *
 */
public abstract class ReadonlyGame extends Observable {
    /** 
     * Tells which player is currently active.
     * @return the active player
     */
    public abstract Player getCurrentPlayer();
    /**
     * Yields the number of players.
     * @return number of players
     */
    public abstract int getNumPlayers();
    /**
     * The games current state.
     * @return the games current state
     */
    public abstract GameState getState();
    /**
     * The DiceCup used for this game.
     * @return the DiceCup
     */
    public abstract ReadwriteDiceCup getDiceCup();
    /**
     * Yields a list of all players.
     * @return a list of all players
     */
    public abstract List<Player> getPlayers();
    /**
     * Yields the winner of this game, if there is one.
     * @return Optional where a value will be present if there is a winner
     *         and the game is over.
     */
    public abstract Optional<Player> getWinner();
}