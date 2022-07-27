package war_game;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {		
		String winner = "";
		int winnerScore = 0;
		int loserScore = 0;

		Deck deck = new Deck();
		deck.shuffle();
		List<Card> p1Hand = new ArrayList<Card>();
		List<Card> p2Hand = new ArrayList<Card>();

		Player p1 = new Player(p1Hand, 0 , "Jason");
		Player p2 = new Player(p2Hand, 0, "Hillary");
		
		// populates each player's hand
		for (int i = 0; i < 26; i++) {
			p1Hand.add(deck.draw());
			p2Hand.add(deck.draw());
		}
		
		// main game play
		for (int j = 0; j < 26; j++) {
			Card p1Flip = p1.flip();
			Card p2Flip = p2.flip();
			System.out.println("Round " + j);
			System.out.print(p1.getName() + ": " + p1Flip.getName() + " vs ");
			System.out.println(p2.getName() + ": " + p2Flip.getName());
			if (p1Flip.getValue() > p2Flip.getValue()) {
				p1.incrementScore();
			} else if (p2Flip.getValue() > p1Flip.getValue()) {
				p2.incrementScore();
			}
			// print result of flip
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
		
		String endGame = "The winner is " + winner + " with a score of " + winnerScore + ":" + loserScore;
		String dash = "=";
		System.out.println(dash.repeat(endGame.length()));
		System.out.println(endGame);		
	}

}
