/**
 * Hochschule München, Fakultät 07. 
 * Softwareentwicklung II Praktikum, IF2A, SS2016
 * Lösung der 2. Aufgabe
 * Oracle Java SE 8u77
 * OS Win7 64, RAM 8GB, CPU 4x2.5GHz x64
 */

package edu.hm.cs.kniffel.model;

import edu.hm.cs.kniffel.model.full.PlayerProtocol;

/**
 * A player.
 * 
 * @author Thomas Pfaffinger, thomas.pfaffinger@hm.edu
 * @version 1.0
 *
 */
public class Player {
	/** Prefix for a Players name. A name is build from this prefix and the players ID. */
	private static final  String PLAYER_NAME_PREFIX = "Player";
    /** The ID that will be given to the player who is created next. */
    private static int nextId = 1;
	/** The unique ID of this player. */
	private final int id;
	/** The name of this player. */
	private final String name;
	/** The playerprotocol of this player. */
	private final PlayerProtocol protocol;
	
	/**
	 * Creates a new player with a protocol.
	 * @param playerProtocol the protocol containing all rules and points.
	 */
	public Player(PlayerProtocol playerProtocol) {
		id = nextId++;
		name = PLAYER_NAME_PREFIX + " " + id;
		this.protocol = playerProtocol;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public PlayerProtocol getProtocol() {
		return protocol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Player other = (Player) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
