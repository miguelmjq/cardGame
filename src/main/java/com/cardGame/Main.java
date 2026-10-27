package com.cardGame;

public class Main {

	public static void main(String[] args) {
		Blackjack game = new Blackjack();
		GUI gui = new GUI(game);
		int dealerwins = 0;
		int playerwins = 0;

		for (int ib = 0; ib < 3; ib++) {
			for (int i = 1; i <= 10; i++) {
				System.out.println("test " + i);
				game.hit(0);
				game.hit(0);
				if (game.stand() == 1) {
					dealerwins++;
				} else {
					playerwins++;
				}
				System.out.println("end");
			}
			System.out.println("dw:" + dealerwins + " pw:" + playerwins);
		}
	}
}