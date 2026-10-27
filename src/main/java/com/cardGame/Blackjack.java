package com.cardGame;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Blackjack {
	ArrayList<Stack<Card>> columns;
	Stack<Card> deck;
	Queue<Card> discard;

	// the part of your program that's in charge of game rules goes here.
	public int dealval, playval = 0;

	public Blackjack() {
		deck = new Stack<>();
		for (int s = 0; s < 4; s++) {
			for (int v = 1; v <= 13; v++) {
				deck.push(new Card(v, Card.Suit.values()[s]));
			}
		}
	}

	public void shiffle() {
		
	}
	public void reset() {
		dealval = 0;
		playval = 0;
	}

	public void hit(int player) {
		Card c = deck.pop();
		if (deck.isEmpty()) {
			deck = new Stack<>();
			for (int s = 0; s < 4; s++) {
				for (int v = 1; v <= 13; v++) {
					deck.push(new Card(v, Card.Suit.values()[s]));
				}
			}
			System.out.println("no cards");
		}
		if (player == 1) {

			dealval += c.value;
			System.out.println("deal: " + dealval);
			System.out.println(c.value + " of " + c.suit);

		} else if (player == 0) {
			playval += c.value;
			System.out.println("play: " + playval);
			System.out.println(c.value + " of " + c.suit);
		}
		if (playval > 21) {
			System.out.println(stand());
		}

	}

	public int stand() {
		if (dealval == playval) {
			System.out.println("tie");
			reset();
			return 2;
		}
		if (dealval == 21) {
			System.out.println("dw");
			reset();
			dealval = 0;
			return 1;
		}
		if (playval > 21) {
			System.out.println("pb");
			reset();
			return 1;
		}

		if (dealval > 21) {
			System.out.println("db");
			reset();
			return 0;
		}

		while (dealval < 17) {
			hit(1);
			if (dealval == 21) {
				System.out.println("dw");
				reset();
				return 1;
			}
			if (dealval > 21) {
				System.out.println("db");
				reset();
				return 0;
			}
		}

		if (playval == 21) {
			System.out.println("pw");
			reset();
			return 0;
		}

		if (dealval > playval) {
			System.out.println("dw");
			reset();
			return 1;
		}

		if (playval > dealval) {
			System.out.println("pw");
			reset();
			return 0;
		}

		return 2;
	}

	public int getDealVal() {
		return dealval;
	}

	public int getPlayVal() {
		return playval;
	}
}
