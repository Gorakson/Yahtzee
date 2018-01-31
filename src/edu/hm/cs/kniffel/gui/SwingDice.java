/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import edu.hm.cs.kniffel.controller.GameLogic;
import edu.hm.cs.kniffel.logic.command.Command;
import edu.hm.cs.kniffel.logic.command.CommandToggleDiceActive;
import edu.hm.cs.kniffel.model.ReadonlyDice;
import edu.hm.cs.kniffel.model.ReadonlyGame;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Represents dice in the game. Dice objects contain dice data (model) and
 * wrap a JLabel as its visual representation (view).
 * @author U. Hammerschall
 * @author Thomas Pfaffinge, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class SwingDice extends JLabel {

    /**
     * Serial number.
     */
    private static final long serialVersionUID = 1L;
    
    /** The Dice this view represents. */
    private final ReadonlyDice dice;
    /** A panel for background. */
    private final JPanel panel;
    /** The games logic. */
    private final GameLogic logic;
    /** The game. */
    private final ReadonlyGame game;
    /** Changes the state of the dice from being active to inactive. */
    private final Command toggleDiceActive;
    /** The background color for inactive dices. */
    private final Color color = Color.lightGray;

    /**
     * Ctor.
     * @param logic The games logic.
     * @param game The game.
     * @param dice A dice.
     * @param panel The panel for background color.
     */
    public SwingDice(GameLogic logic, ReadonlyGame game, ReadonlyDice dice, JPanel panel) {
        this.dice = dice;
        this.panel = panel;
        this.logic = logic;
        this.game = game;
        toggleDiceActive = new CommandToggleDiceActive(dice);
    }
    
    @Override
    public void paint(Graphics g) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(SwingDice.class.getResource("./img/" + dice.getValue() + ".png"));
            final int width = image.getWidth() + image.getWidth() / 3;
            final int height = image.getHeight() + image.getHeight() / 3;
            g.drawImage(image, (this.getWidth() - width) / 2, 
                    (this.getHeight() - width) / 2, width,
                    height, null, null);
            panel.setBackground(game.getDiceCup().isInactive(dice) ? color : null);
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Realizes color changes of the player panel based on the status.
     */
    public void activate() {
    	if (logic.testCommand(toggleDiceActive, game.getCurrentPlayer()).getResult()) {  		
    		 logic.executeCommand(toggleDiceActive, game.getCurrentPlayer());
    	}
    }
    
    ReadonlyDice getDice() {
    	return dice;
    }
}
