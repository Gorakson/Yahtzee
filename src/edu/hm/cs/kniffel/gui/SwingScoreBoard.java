/**
 * Hochschule M�nchen, Fakult�t 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * L�sung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;

import edu.hm.cs.kniffel.controller.GameLogic;
import edu.hm.cs.kniffel.controller.rules.Rule;
import edu.hm.cs.kniffel.controller.rules.Ruleset;
import edu.hm.cs.kniffel.logic.command.Command;
import edu.hm.cs.kniffel.logic.command.CommandSave;
import edu.hm.cs.kniffel.logic.command.CommandTurnEnd;
import edu.hm.cs.kniffel.logic.command.CommandWriteScore;
import edu.hm.cs.kniffel.model.ReadonlyGame;
import edu.hm.cs.kniffel.model.ScoreboardSection;

/**
 * The view for a scoreboard.
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class SwingScoreBoard extends JPanel implements Observer {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -5476474324722090006L;
    /** Button which initiates a writescore command. */
    private final JButton writeButton;
    /** The rules this view represents. */
    private final List<Rule> rules;
    /** The logic controlling the game flow. */
    private final GameLogic logic;
    /** The game containing all game data. */
    private final ReadonlyGame game;
    /** The table for displaying the scoreboard. */
    private final JTable table;
    /** The table model for managing the scoreboard data. */
    private final TableModel model;
    /** A command to score the currently selected rule. */
    private Command writeScore;

    /**
     * Ctor.
     * @param game object containing all game data
     * @param logic object for controlling the game flow
     * @param rules The rules this view represents
     */
    public SwingScoreBoard(ReadonlyGame game, GameLogic logic, Ruleset rules) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.logic = logic;
        this.game = game;
        game.addObserver(this);
        this.rules = new LinkedList<>(rules.getRules(ScoreboardSection.Upper));
        this.rules.addAll(rules.getRules(ScoreboardSection.Lower));

        model = new ScoreBoardTableModel(game, rules);
        table = new JTable(model);

        writeButton = new JButton("Write");


        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(e -> onRowSelectionChange(e));

        add(new JScrollPane(table), BorderLayout.NORTH);

        writeButton.addActionListener(al -> onWriteButtonClick(al));
        writeButton.setEnabled(false);
        writeButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        writeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(writeButton, BorderLayout.CENTER);
    }

    /**
     * An EventListener for reacting to row selection changes.
     * @param e ListSelectionEvent
     */
    private void onRowSelectionChange(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {

            final Object columnValue = table.getValueAt(table.getSelectedRow(), 0);

            final Optional<Rule> optRule = rules.stream().filter(rule -> rule.getName().equals(columnValue)).findAny();

            if (optRule.isPresent()) {            	
                writeScore = new CommandWriteScore(optRule.get());
                writeButton.setEnabled(logic.testCommand(writeScore, game.getCurrentPlayer()).getResult());
            } else {
                writeButton.setEnabled(false);
            }
        }
    }

    /**
     * An EventListener for reacting to button click. 
     * @param ignored not used
     */
    private void onWriteButtonClick(ActionEvent ignored) {
        try {
            logic.executeCommand(writeScore, game.getCurrentPlayer());
            logic.executeCommand(new CommandTurnEnd(), game.getCurrentPlayer());
        } catch (IllegalStateException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
        
    }

    @Override
    public void update(Observable o, Object arg) {
        if (writeScore == null) {
            writeButton.setEnabled(false);
        } else {
            writeButton.setEnabled(logic.testCommand(writeScore, game.getCurrentPlayer()).getResult());		
        }
    }
    
    /**
     * Saves the scoreboard as a .txt-file at the specified path. The name given will be a timestamp.
     * @param path The path of the output file
     */
    public void save(String path) {
        final TabelModelSaver saver = new TabelModelSaver(model);
        final Command saveCommand = new CommandSave(saver, path);
        
        try {
            logic.executeCommand(saveCommand, game.getCurrentPlayer());
        } catch (IllegalStateException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }
}
