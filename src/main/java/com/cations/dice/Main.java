package com.cations.dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.cations.dice.player.Human;
import com.cations.dice.player.Player;
import com.cations.dice.player.bot.Bot;
import com.cations.dice.util.RandomInt;

public class Main {
	private final static int N_PLAYERS = 4;
	private static Scanner scanner = new Scanner(System.in);
	private final List<Dice> dices = Arrays.asList(
		new Dice(1),
		new Dice(2),
		new Dice(3),
		new Dice(4)
	);
	private List<Player> players = new ArrayList<>();
	private Iterator<Player> current;

	public Main(int nHumans) {
		if (nHumans >= N_PLAYERS) {
			System.out.println("[Warn]: clamping players count to " + N_PLAYERS);
			nHumans = N_PLAYERS;
		} else if (nHumans < 0) {
			System.out.println("[Warn]: clamping players count to 0");
			nHumans = 0;
		}

		for (int i = 0; i < nHumans; ++i) {
			System.out.print("Enter player " + (i + 1) + "'s name: ");
			players.add(new Human(scanner));
		}
		players.addAll(Bot.getBots(N_PLAYERS - nHumans));

		current = players.iterator();
	}

	private Player nextPlayer() {
		if (!current.hasNext())
			current = players.iterator();
		return current.next();
	}

	public void run() {
		while (true) {
			var player = nextPlayer();
			System.out.println("\nIt's " + player.getName() + "'s turn.");
			var dots = dices.get(RandomInt.get(dices.size())).getFace();
			if (player.addScore(dots)) {
				System.out.println("\n" + player.getName() + " won!");
				break;
			}
		}
		for (int i = 0; i < N_PLAYERS - 1; ++i) {
			var player = nextPlayer();
			if (player instanceof Bot) {
				var bot = (Bot)player;
				bot.response();
			}
		}
	}

	public static void main(String[] args) {
		System.out.print("Number of human players: ");
		int nHumans = scanner.nextInt();
		scanner.nextLine(); // Clear newline

		var game = new Main(nHumans);
		game.run();

		scanner.close();
	}
}
