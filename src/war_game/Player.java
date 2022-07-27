package war_game;

import java.util.List;

public class Player {
	
	// fields
	List<Card> hand;
	int score;
	String name;
	
	//constructors
	Player(List<Card> hand, int score, String name) {
		this.hand = hand;
		this.score = score;
		this.name = name;
		score = 0;
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
		hand.remove(0);
		return flippedCard;
	}
	
	// takes a Deck as an argument and calls the draw method on the deck, adding the returned Card to the hand field
	public void draw(Deck deck) {
		Card returnedCard = deck.draw();
		hand.add(returnedCard);
	}
	
	// adds 1 to the Player’s score field
	public void incrementScore() {
		score ++;
	}

	// getters and setters
	public List<Card> getHand() { // don't think I need this
		return hand;
	}

	public void setHand(List<Card> hand) { // don't think I need this
		this.hand = hand;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) { // do I need this since I'm setting the score in the constructor?
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) { // do I need this since I'm setting the name in the constructor?
		this.name = name;
	}
	
}
