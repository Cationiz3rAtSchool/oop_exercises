package com.cations.dice.player.bot;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import com.cations.dice.player.Player;
import com.cations.dice.util.RandomInt;

enum BotEnum {
	Clover,
	Kale,
	Mallow,
	Shallot,
};

public class Bot extends Player {
	private final List<String> responses; // On losing

	public Bot(String name, List<String> responses) {
		super(name);
		// TODO: check if responses's size is greater then 0
		this.responses = responses;
	}

	private static Bot enumToPlayer(BotEnum bot) {
		switch (bot) {
			default:
			case Clover:
				return new Clover();
			case Kale:
				return new Kale();
			case Mallow:
				return new Mallow();
			case Shallot:
				return new Shallot();
		}
	}
	public static List<Bot> getBots(int count) {
		List<BotEnum> bots = Arrays.asList(BotEnum.values());
		Collections.shuffle(bots);
		return bots
			.subList(0, count)
			.stream()
			.map(Bot::enumToPlayer)
			.collect(Collectors.toList());
	}

	public void response() {
		System.out.println(getName() + ": " + responses.get(RandomInt.get(responses.size())) + ".");
	}
}
