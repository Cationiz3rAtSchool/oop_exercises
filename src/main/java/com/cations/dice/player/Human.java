package com.cations.dice.player;

import java.util.Scanner;

public class Human extends Player {
	public Human(Scanner scanner) {
		super(scanner.nextLine().strip());
	}
}
