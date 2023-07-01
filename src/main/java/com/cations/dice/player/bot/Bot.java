package com.cations.dice.player.bot;

import java.util.List;
import com.cations.dice.player.Player;
import com.cations.dice.util.RandomInt;

public class Bot extends Player {
	private final List<String> responses; // On losing

	public Bot(String name, List<String> responses) {
		super(name);
		// TODO: check if responses's size is greater then 0
		this.responses = responses;
	}

	public void response() {
		System.out.println(getName() + ": " + responses.get(RandomInt.get(responses.size())) + ".");
	}
}
