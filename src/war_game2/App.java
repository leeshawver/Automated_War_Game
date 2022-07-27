package war_game2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	static List<Card> p1Hand = new ArrayList<Card>(); // can I instantiate these instead when they are passed as parameters?
	static List<Card> p2Hand = new ArrayList<Card>();
	static List<Card> pile = new ArrayList<Card>();
	static Player p1 = new Player(p1Hand, pile, 0 , "Jason");
	static Player p2 = new Player(p2Hand, pile, 0, "Hillary");
	
	public static void main(String[] args) {		
		String winner = "";
		int winnerScore = 0;
		int loserScore = 0;
		
		Deck deck = new Deck();
		deck.shuffle();

		// populates each player's hand
		for (int i = 0; i < 26; i++) {
			p1Hand.add(deck.draw());
			p2Hand.add(deck.draw());
		}
		
		// main game play
		while (p1Hand.size() > 0 && p2Hand.size() > 0) {
			System.out.println("Score: " + p1.getScore() + " : " + p2.getScore());
			Card p1Flip = p1.flip();
			Card p2Flip = p2.flip();
			if (p1Flip.getValue() > p2Flip.getValue()) {
				p1.incrementScore();
				p1Hand.add(pile.get(0));
				p1Hand.add(pile.get(1));
				pile.clear();
			} else if (p2Flip.getValue() > p1Flip.getValue()) {
				p2.incrementScore();
				p2Hand.add(pile.get(0));
				p2Hand.add(pile.get(1));
				pile.clear();
			} 
			
			// maybe add turn method
			else if (p1Flip.getValue() == p2Flip.getValue()) { // this is war
				if ((p1Hand.size() > 3 && p2Hand.size() > 3)){
					List<Card> warPile = new ArrayList<Card>();
					// remove last 3 cards from each hand and add to pile
					for (int i = 0; i < 3; i++) {
						warPile.add(p1Hand.get(0));
						p1Hand.remove(p1Hand.get(0));
						warPile.add(p2Hand.get(0));
						p2Hand.remove(p2Hand.get(0));
					}
					if (p1Hand.get(0).getValue() > p2Hand.get(0).getValue()) {
						p1.incrementScore();
						p1Hand.add(p1Hand.get(0));
						p1Hand.add(p2Hand.get(0));
						for (int j = 0; j < warPile.size() - 1; j++) {
							p1Hand.add(warPile.get(j));
						}
					} else if (p2Hand.get(0).getValue() > p1Hand.get(0).getValue()) {
						p2.incrementScore();
						p2Hand.add(p1Hand.get(0));
						p2Hand.add(p2Hand.get(0));
						for (int j = 0; j < warPile.size() - 1; j++) {
							p2Hand.add(warPile.get(j));
						}
					}
				}
			}
			
			// this shuffles each hand if either score is a product of 100, thus preventing an endless game
			if (p1.getScore() % 100 == 0 || p2.getScore() % 100 == 0) {
				Collections.shuffle(p1Hand);
				Collections.shuffle(p2Hand);
			}
		}
		
		// comparing final scores and declaring winner
		if (p1.score > p2.score) {
			winner = p1.getName();
			winnerScore = p1.getScore();
			loserScore = p2.getScore();
		} else if (p2.score > p1.score) {
			winner = p2.getName();
			winnerScore = p2.getScore();
			loserScore = p1.getScore();
		} else winner = "NO ONE";
		
		System.out.println("The winner is " + winner + " with a score of " + winnerScore + ":" + loserScore);		
	}
}
