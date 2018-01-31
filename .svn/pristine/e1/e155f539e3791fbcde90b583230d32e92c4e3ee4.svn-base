package edu.hm.cs.kniffel;
/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import edu.hm.cs.kniffel.controller.GameLogic;
import edu.hm.cs.kniffel.controller.rules.Ruleset;
import edu.hm.cs.kniffel.gui.MainGUI;
import edu.hm.cs.kniffel.model.GameState;
import edu.hm.cs.kniffel.model.full.Game;
import edu.hm.cs.kniffel.model.full.WriteableGame;

/**
 * Starts a game of Yahtzee.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class Yahtzee {
    /**
     * Launch the application.
     * 
     * @param args number of players
     */
    public static void main(String[] args) {
        final int numPlayers = getNumPlayers();
        final Ruleset rules = new Ruleset();
        final WriteableGame game = new Game(numPlayers, Ruleset.NUM_DICE,
                rules.getRuleNames());
        final GameLogic logic = new GameLogic(game);
        game.setState(GameState.Running);
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                final MainGUI frame = new MainGUI(logic, game, rules);
                frame.setVisible(true);
            }
        });
    }
    
    /**
     * Displays a dialog asking the user how many players will play the game.
     * @return number of players
     */
    private static int getNumPlayers() {
        String errorMessage = "";
        int numPlayers = 0;
        
        do {
            final String userInput = JOptionPane.showInputDialog(errorMessage + "How many players will play?");
            
            try {
                numPlayers = Integer.parseInt(userInput);
                
                if (numPlayers < Ruleset.MIN_NUM_PLAYERS || numPlayers > Ruleset.MAX_NUM_PLAYERS) {
                    errorMessage = "Please enter a number between 1 and 6.\n";
                } else {
                    errorMessage = "";
                }
            } 
            catch (NumberFormatException exception) {
                errorMessage = "Please enter a number.\n";
            }
        } while(!errorMessage.isEmpty());
        
        return numPlayers;
    }
}
