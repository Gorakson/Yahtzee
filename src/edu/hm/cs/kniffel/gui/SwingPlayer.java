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
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.ReadonlyGame;

/**
 * Represents player in the game. Player objects contain player data (model) and
 * wrap a JLabel as its visual representation (view).
 * @author U. Hammerschall
 * @version 1.0
 */
public class SwingPlayer extends JLabel {

    /**
     * serial number.
     */
    private static final long serialVersionUID = 1L;
    
    /** Background color of the currently active player. */
    private static final Color ACTIVE_COLOR = Color.green;
    
    /**
     * defines default image size for each player.
     */
    private static final int IMAGE_SIZE = 80;
    
    /**
     * panel to allow background color changes.
     */
    private final JPanel panel;
    /** The player this view represents. */
    private final Player player;
    /** The game containing all game data. */
    private final ReadonlyGame game;

    /**
     * Initiates a new player object with identifying number and panel.
     * @param game game containing all game data.
     * @param player the player this view represents.
     * @param panel of the player
     */
    public SwingPlayer(ReadonlyGame game, Player player, JPanel panel) {
        this.panel = panel;
        this.player = player;
        this.game = game;
    }

    @Override
    public void paint(Graphics g) {

        BufferedImage image = null;
        try {
            image = ImageIO.read(SwingDice.class.getResource("./img/p" + player.getId() + ".png"));
            final int resized = (int) (image.getWidth() * ((double) IMAGE_SIZE / image.getHeight()));

            g.drawImage(image, (this.getWidth() - resized) / 2, (this.getHeight() - IMAGE_SIZE) / 2, resized,
                    IMAGE_SIZE, null, null);
            
            panel.setBackground(player.equals(game.getCurrentPlayer()) ? ACTIVE_COLOR : null);
        } 
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
