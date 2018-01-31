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
import java.util.List;
import java.util.Optional;

import edu.hm.cs.kniffel.interfaces.Changeable;
import edu.hm.cs.kniffel.model.GameState;
import edu.hm.cs.kniffel.model.Player;

/** 
 * A game that contains all the relevant data for a game.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 *
 */
public class Game extends WriteableGame implements Changeable {
    /** The DiceCup used for this game. */
    private final ReadwriteDiceCup diceCup;
    /** The players playing this game. */
    private final List<Player> players;
    /** The active player. */
    private int currentPlayer;
    /** The current GameState. */
    private GameState gameState;
    /** The winner of this game. Is null, if this game is not over yet. */
    private Player winner;

    /**
     * Ctor.
     * @param numPlayers The number of player playing this game
     * @param numDice The number of dices used for play
     * @param ruleNames The names of all rules
     */
    public Game(int numPlayers, int numDice, List<String> ruleNames) {
        if (numPlayers < 1) {
            throw new IllegalArgumentException();
        } else if (ruleNames == null) {
            throw new NullPointerException();
        } else if (ruleNames.size() == 0) {
            throw new IllegalArgumentException();
        } else if (numDice == 0) {
            throw new IllegalArgumentException();
        }

        diceCup = new DiceCup(this, numDice);
        players = new ArrayList<>();

        for (int counter = 0; counter < numPlayers; counter++) {
            players.add(new Player(new PlayerProtocol(this, ruleNames)));
        }

        currentPlayer = (int) (Math.random() * players.size());
    }

    @Override
    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    @Override
    public GameState getState() {
        return gameState;
    }

    @Override
    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.size();
        notifyChange();
    }

    @Override
    public void setState(GameState state) {
        this.gameState = state;
        notifyChange();
    }

    @Override
    public ReadwriteDiceCup getDiceCup() {
        return diceCup;
    }

    @Override
    public void notifyChange() {
        setChanged();
        notifyObservers();
    }

    @Override
    public int getNumPlayers() {
        return players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public void setWinner(Player player) {
        winner = player;
        notifyChange();
    }

    @Override
    public Optional<Player> getWinner() {
        return Optional.ofNullable(winner);
    }
}