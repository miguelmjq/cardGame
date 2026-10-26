package com.cardGame;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Blackjack {
	ArrayList<Stack<Card>> columns;
	Stack<Card> deck;

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

	public void hit(int player) {
		if (deck.isEmpty()){
			System.out.println("no cards");
		}
		if (player == 1) {
			dealval += deck.pop().value;

		} else if (player == 0) {
			playval += deck.pop().value;
		}
		if (playval > 21) {
			System.out.println(stand());
		}

	}

	public int stand() {
		if (dealval == playval) {
			System.out.println("tie");
			return 2;
		}
		if (dealval == 21) {
			System.out.println("dw");
			return 1;
		}
		if (playval > 21) {
			System.out.println("pb");
			return 1;
		}

		if (dealval > 21) {
			System.out.println("db");
			return 0;
		}

		while (dealval < 17) {
			hit(1);
			if (dealval == 21) {
				System.out.println("dw");
				return 1;
			}
			if (dealval > 21) {
				System.out.println("db");
				return 0;
			}
		}

		if (playval == 21) {
			System.out.println("pw");
			return 0;
		}

		if (dealval > playval) {
			System.out.println("dw");
			return 1;
		}

		if (playval > dealval){
			System.out.println("pw");
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
