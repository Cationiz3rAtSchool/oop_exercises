package com.cations.dice.player;

public abstract class Player {
	private final String name;
	private final int WIN_SCORE = 21;
	private int score = 0;

	public Player(String name) { this.name = name; }

	public String getName() { return name; }
	public boolean addScore(int dots) {
		// Returns true if player wins
		score += dots;
		if (score == WIN_SCORE)
			return true;
		else if (score > WIN_SCORE)
			score = 0;

		return false;
	}
}
