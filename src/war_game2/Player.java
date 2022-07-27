package war_game2;

import java.util.List;

public class Player {
	
	// fields
	List<Card> hand;
	List<Card> pile;
	int score;
	String name;
	
	//constructors
	Player(List<Card> hand, List<Card> pile, int score, String name) {
		this.hand = hand;
		this.pile = pile;
		this.score = score;
		this.name = name;
		score = 0; // i am asked to set score to zero in constructor.  Why?  Why can't I just do it when I instantiate a player?
	}
	
	// public methods

	// prints out information about the player and calls the describe method for each card in the Hand List
	public void describe() {
		System.out.println("PLAYER INFO:");
		System.out.println("    Name: " + name + ", " + "Score: " + score);
		System.out.println("    Cards in hand:");

		for (int i = 0; i < hand.size(); i++) {
			hand.get(i).describe();
		}		
	}
	
	// removes and returns the top card of the Hand
	public Card flip() {
		Card flippedCard = hand.get(0);
		pile.add(flippedCard);
		hand.remove(0);
		return flippedCard;
	}
	
	// takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field
	public  void draw(Deck deck) {
		Card returnedCard = deck.draw();
		hand.add(returnedCard);
	}
	
	// adds 1 to the Player’s score field
	public void incrementScore() {
		score ++;
	}

	// getters and setters
	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
