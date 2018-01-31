/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

import edu.hm.cs.kniffel.controller.GameLogic;
import edu.hm.cs.kniffel.logic.command.Command;
import edu.hm.cs.kniffel.logic.command.CommandRollDiceCup;
import edu.hm.cs.kniffel.model.ReadonlyDice;
import edu.hm.cs.kniffel.model.ReadonlyGame;

/**
 * Panel to manage all dice in the game.
 * @author Hammerschall
 * @version 1.0
 */
public class SwingDicePanel extends JPanel implements Observer {

    /**
     * serial number.
     */
    private static final long serialVersionUID = 1L;
    
    /** Button which will roll the dicecup. */
    private final JButton rollButton;
    /** Command for rolling the dicecup. */
    private Command rollCommand;
    /** The games logic. */
    private GameLogic logic;
    /** The game. */
    private ReadonlyGame game;

    /**
     * Creates a new panel with five dice.
     * @param game containing all game data.
     * @param logic object to control the game flow
     */
    public SwingDicePanel(GameLogic logic, ReadonlyGame game) {
        
        setLayout(new BorderLayout());
        this.logic = logic;
        this.game = game;
        game.addObserver(this);

        final Collection<ReadonlyDice> dices = game.getDiceCup().getDices();
        final JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, dices.size(), 0, 0));
        
        for (ReadonlyDice dice : dices) {
        	final JPanel dicePanel = new JPanel();
        	dicePanel.setLayout(new BorderLayout());
        	final SwingDice swingDice = new SwingDice(logic, game, dice, dicePanel);
            
            // mouse listener to react on button clicks.
            swingDice.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    swingDice.activate();
                }
            });
            
            dicePanel.add(swingDice, BorderLayout.CENTER);
            panel.add(dicePanel);
        }       
        add(panel);
        rollCommand = new CommandRollDiceCup();

        // panel with roll button
        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        rollButton = new JButton("Würfeln");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                logic.executeCommand(rollCommand, game.getCurrentPlayer());
            }
        });
        buttonPanel.add(rollButton);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(buttonPanel, BorderLayout.SOUTH);
    }

	@Override
	public void update(Observable o, Object arg) {
		rollButton.setEnabled(logic.testCommand(rollCommand, game.getCurrentPlayer()).getResult());
	}
}
