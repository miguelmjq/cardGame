package com.cardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class Blackjack {
	ArrayList<Stack<Card>> columns;
	public Stack<Card> deck;
	public Stack<Card> discard;

	public ArrayList<Card> playerhand = new ArrayList<Card>();
	public ArrayList<Card> dealerhand = new ArrayList<Card>();

	// the part of your program that's in charge of game rules goes here.

	public Blackjack() {
		deck = new Stack<>();
		discard = new Stack<>();
		for (int s = 0; s < 4; s++) {
			for (int v = 1; v <= 13; v++) {
				deck.push(new Card(v, Card.Suit.values()[s]));
			}
		}
		shuffle();
	}

public void shuffle() {
    ArrayList<Card> cards = new ArrayList<>(deck);
    cards.addAll(discard);

    Collections.shuffle(cards);

    deck.clear();
    deck.addAll(cards);
    discard.clear();
}

	public boolean isempt() {
		return deck.isEmpty();
	}
	public int gethandval(int player) {
		ArrayList<Card> bb = playerhand;
		if (player == 0) {
			bb = dealerhand;
		}
		int val = 0;
		for (Card c : bb) {
			val += c.value;
		}
		return val;
	}

	public void reset() {
		//TODO: add hands to discard instead
		for (Card disc: playerhand) {
			System.out.println("nee"+disc.value);
			discard.push(disc);
		}
		playerhand.clear();
		for (Card disc: dealerhand) {
			System.out.println("kou"+disc.value);
			discard.push(disc);
		}
		dealerhand.clear();
		shuffle();
		System.out.println("reset");
	}

	public Card hit(int player) {
		if(deck.empty()) {
			shuffle();
			System.out.print("shuffled");
		}
		Card c = deck.pop();
		boolean p = player==1;
		if (c.value==1) {
			if (p&&gethandval(1)<=10) {
				c.value = 11;
			}
			else if (!p&&gethandval(0)<=10) {
				c.value = 11;
			}
		}
		System.out.println(c.value+" of "+c.suit+ " added to "+p);
		if (p) {
			playerhand.add(c);
			System.out.println("playerval: "+gethandval(1));
		}
		else {
			dealerhand.add(c);
			System.out.println("dealerval: "+gethandval(0));
		}
		

		return c;
	}

	public int stand() {
		if (gethandval(0) == gethandval(1)) {
			System.out.println("tie");
			reset();
			return 2;
		}
		if (gethandval(0) == 21) {
			System.out.println("dw");
			reset();
			return 1;
		}
		if (gethandval(1) > 21) {
			System.out.println("pb");
			reset();
			return 1;
		}

		if (gethandval(0) > 21) {
			System.out.println("db");
			reset();
			return 0;
		}

		while (gethandval(0) < 17) {
			hit(0);
			if (gethandval(0) == 21) {
				System.out.println("dw");
				reset();
				return 1;
			}
			if (gethandval(0) > 21) {
				System.out.println("db");
				reset();
				return 0;
			}
		}

		if (gethandval(1) == 21) {
			System.out.println("pw");
			reset();
			return 0;
		}

		if (gethandval(0) > gethandval(1)) {
			System.out.println("dw");
			reset();
			return 1;
		}

		if (gethandval(1) > gethandval(0)) {
			System.out.println("pw");
			reset();
			return 0;
		}

		return 2;
	}

	public int getDealVal() {
		return gethandval(0);
	}

	public int getPlayVal() {
		return gethandval(1);
	}
}
