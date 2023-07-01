package com.cations.dice;

import java.util.List;
import com.cations.dice.util.RandomInt;

public class Dice {
	private int faceHigh; // 20% for this face

	public Dice() {
		this.faceHigh = RandomInt.get(6) + 1;
	}
	public Dice(int faceHigh) {
		this.faceHigh = faceHigh;
	}

	public int getFace() {
		var chance = RandomInt.get(100);
		var dots = 0;
		while (chance >= 0) {
			dots++;
			if (dots == this.faceHigh)
				chance -= 20;
			else
				chance -= 16;
		}

		return dots;
	}

	public static int getFaces(List<Dice> dices) {
		return dices
			.stream()
			.map(Dice::getFace)
			.reduce(0, Integer::sum);
	}
}
