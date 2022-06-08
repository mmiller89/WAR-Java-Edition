package Game;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	
	//Initialization of the class.
	private String name;
	private int score;
	private List<Card> hand = new ArrayList<Card>();

	public Player(String name, int score) {
		this.name = name;
		this.score = score;
		
	}
	
	//This method returns the Card object from index 0 of the player's hand, and then removes it.
	public Card flip() {
		Card drawnCard = this.hand.get(0);
		this.hand.remove(0);
		return drawnCard;
	}
	
	//Used to increase a player's score by 1.
	public void incrementScore() {
		this.score += 1;
	}
	
	//Used when constructing the player's initial hands. Adds a Card object to their hand.
	public void addToHand(Card curCard) {
		this.hand.add(curCard);
	}
	
	
	//Describes player's name and their current hand.
	public void describePlayer() {
		System.out.println();
		System.out.println("Player Name: " + this.name);
		System.out.println("--CURRENT HAND--");
		for (Card card: this.hand) {
			System.out.println(card.describe());
			
		}
		System.out.println();
		System.out.println("Cards remaining: " + this.playerHandLength());
		System.out.println();
		System.out.println();
	}
	
	
	//Returns the size of the hand remaining for the player.
	public int playerHandLength() {
		return hand.size();
	}
	
	
	//Getters and setters for the class.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}