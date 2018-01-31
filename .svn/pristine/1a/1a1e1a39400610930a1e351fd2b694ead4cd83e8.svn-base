/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import edu.hm.cs.kniffel.controller.rules.Ruleset;
import edu.hm.cs.kniffel.model.Player;
import edu.hm.cs.kniffel.model.ReadonlyGame;
import edu.hm.cs.kniffel.model.ScoreboardSection;

/**
 * The table model of a scoreboard.
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class ScoreBoardTableModel implements TableModel {

    /** The sign to show that a player filled in a zero for a rule. */
    private static final String FILLED_IN_ZERO_MARK = "x";
    /** Column name of the rule column. */
    private static final String RULE_COLUMN_NAME = "Rule";
    /** Cell name of the first sum field. */
    private static final String SUM_UPPER_NAME = "Sum Part 1";
    /** Cell name of the second sum field. */
    private static final String SUM_LOWER_NAME = "Sum Part 2";
    /** Cell name of the total field. */
    private static final String TOTAL_NAME = "Total";

    /** The game this TableModel represents. */
    private final ReadonlyGame game;
    /** The table rows of this table. */
    private final List<TableRow> rows;

    /**
     * Ctor with game and ruleset.
     * @param game The game this TableModel represents.
     * @param rules The ruleset. 
     */
    public ScoreBoardTableModel(ReadonlyGame game, Ruleset rules) {
        this.game = game;
        rows = new ArrayList<>();

        rules.getRuleNames(ScoreboardSection.Upper).stream().forEach(rule -> 
        rows.add(new TableRow(rule, player -> getScoreCellText(player, rule)))
                );

        rows.add(new TableRow(SUM_UPPER_NAME, player -> player.getProtocol().sum(rules.getRuleNames(ScoreboardSection.Upper))));

        rules.getRuleNames(ScoreboardSection.Lower).stream().forEach(rule -> 
        rows.add(new TableRow(rule, player -> getScoreCellText(player, rule)))
                );

        rows.add(new TableRow(SUM_LOWER_NAME, player -> player.getProtocol().sum(rules.getRuleNames(ScoreboardSection.Lower))));
        rows.add(new TableRow(TOTAL_NAME, player -> {
            return Integer.toString(player.getProtocol().sum());
        }));
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {

    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return game.getNumPlayers() + 1; // +1 bc Rule column
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return RULE_COLUMN_NAME;
        } else {
            return game.getPlayers().get(column - 1).getName();
        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        final String result;

        if (col == 0) {
            result = rows.get(row).getRowName();
        } else {
            final Player player = game.getPlayers().get(col - 1);
            result = rows.get(row).getValue(player);
        }

        return result;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {

    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {

    }

    /**
     * Provides the points a player scored for a rule. 
     * @param player The player in question
     * @param ruleName The name of the rule in question
     * @return number of points
     */
    private String getScoreCellText(Player player, String ruleName) {
        final String result;

        if (player.getProtocol().isScored(ruleName)) {
            final int points = player.getProtocol().getPoints(ruleName);

            if (points == 0) {
                result = FILLED_IN_ZERO_MARK;
            } else {
                result = Integer.toString(points);
            }
        } else {
            result = "";
        }

        return result;
    }
}
