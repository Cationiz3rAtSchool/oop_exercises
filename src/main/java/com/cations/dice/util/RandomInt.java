package com.cations.dice.util;

import java.util.Random;

public class RandomInt {
	private static Random random = new Random();

	public static int get(int bound) {
		return random.nextInt(bound);
	}
}
