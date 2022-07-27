package war_game2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	List<Card> cards = new ArrayList<Card>();
	
	Deck() {	
		String[] rank = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
		String[] suit = {"diamonds", "clubs", "hearts", "spades"};
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				cards.add(new Card(j, rank[j - 2] + " of " + suit[i]));
			}
		}
	}
	
	// removes and returns the top card of the Cards field
	public Card draw() {	
		// do I need to plan for a thrown exception? like when there are no more cards?
		// or maybe that will be handled by the loop that draws cards only a number of times
		Card drawnCard = cards.get(0);
		cards.remove(0);
		return drawnCard;
	}
	
	// randomizes the order of the cards
	public void shuffle() {
		Collections.shuffle(cards);
	}

}
