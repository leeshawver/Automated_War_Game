package war_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> cards = new ArrayList<Card>();
	
	Deck() {	
		String[] rank = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
		String[] suit = {"\u2666", "\u2663", "\u2665", "\u2663"};
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				cards.add(new Card(j, rank[j - 2] + " of " + suit[i]));
			}
		}
	}
	
	// removes and returns the top card of the Cards field
	public Card draw() {	
		Card drawnCard = cards.get(0);
		cards.remove(0);
		return drawnCard;
	}
	
	// randomizes the order of the cards
	public void shuffle() {
		Collections.shuffle(cards);
	}

}
