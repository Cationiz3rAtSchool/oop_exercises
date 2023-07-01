package com.cations.dice;

import java.util.Random;

public class Dice {
	private static Random random = new Random();
	private int faceHigh; // 20% for this face

	public Dice() {
		this.faceHigh = random.nextInt(6) + 1;
	}
	public Dice(int faceHigh) {
		this.faceHigh = faceHigh;
	}

	public int getFace() {
		var chance = random.nextInt(100);
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
}
