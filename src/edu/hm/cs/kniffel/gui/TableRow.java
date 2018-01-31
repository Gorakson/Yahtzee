/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.gui;

import java.util.function.Function;

import edu.hm.cs.kniffel.model.Player;

/**
 * A row of the ScoreBoard table.
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 */
public class TableRow {
    /** The name of this row. */
	private final String rowName;
	/** Defines how this row retrieves its data. */
	private final Function<Player, String> rowFunction;
	
	/**
	 * Ctor.
	 * @param rowName The name of this row
	 * @param rowFunction Defines how this row retrieves its data
	 */
	public TableRow(String rowName, Function<Player, String> rowFunction) {
		this.rowName = rowName;
		this.rowFunction = rowFunction;
	}
	
	/**
	 * provides the row name.
	 * @return the row name
	 */
	public String getRowName() {
		return rowName;
	}
	
	/** 
	 * Provides the value in this row for a Player.
	 * 
	 * @param player the player in question
	 * @return score in this row.
	 */
	public String getValue(Player player) {
		return rowFunction.apply(player);
	}
}
