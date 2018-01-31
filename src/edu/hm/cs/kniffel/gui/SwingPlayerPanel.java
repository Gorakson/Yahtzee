/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

import edu.hm.cs.kniffel.controller.GameLogic;
import edu.hm.cs.kniffel.model.ReadonlyGame;

/**
 * panel to manage players in the game.
 * 
 * @author Hammerschall
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class SwingPlayerPanel extends JPanel {

    /** 
     * serial number. 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Initiates a new panel with players. Each player is set on an 
     * additional panel.
     * @param logic object to control the game flow
     * @param game object which contains all game data.
     */
    public SwingPlayerPanel(GameLogic logic, ReadonlyGame game) {
        
        setLayout(new GridLayout(0, game.getNumPlayers(), 0, 0));
        
        // create players and player panels
        for (int i = 0; i < game.getNumPlayers(); i++) {
            final JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            final SwingPlayer player = new SwingPlayer(game, game.getPlayers().get(i), panel);
            panel.add(player, BorderLayout.CENTER);
            add(panel);
        }
    }
}
