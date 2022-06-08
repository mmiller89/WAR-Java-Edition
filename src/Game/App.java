package Game;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		//Initialize new deck and player classes.
		Deck deck = new Deck();
		Player p1 = new Player("", 0);
		Player p2 = new Player("", 0);
		
		//Setup scanner and introduction.
		Scanner input = new Scanner(System.in);
		
		System.out.println("********************");
		System.out.println("***Welcome to WAR***");
		System.out.println("********************");
		System.out.println();
		
		
		//Boolean is setup to allow for a while loop.
		boolean canContinue = false;
		
		
		//While loop continues until canContinue is true. This happens when player inputs a valid name (not blank).
		while (!canContinue) {
			System.out.print("Please enter the name of Player 1: ");
			String p1Name = input.nextLine();
			if (p1Name != "") {
				p1.setName(p1Name);
				canContinue = true;
			}
		}
			
		//Repeat process above for player 2.
			canContinue = false;
			
			while (!canContinue) {
			System.out.print("Please enter the name of Player 2: ");
			String p2Name = input.nextLine();
			if (p2Name != "") {
				p2.setName(p2Name);
				canContinue = true;
			} 
		}
			
		//Shuffle the deck.
			deck.shuffleDeck();
			
			
		//Split the deck between two players.
			splitDeck(p1,p2,deck);
			
			
		//Initialize options for player.
			System.out.println();
			System.out.println("It's time for " + p1.getName() + " to battle against " + p2.getName() + "!" );
			System.out.println();
			System.out.println("********************");
			System.out.println("***Select option***");
			System.out.println("********************");
			System.out.println();
			System.out.println("1 - See player 1's details");
			System.out.println("2 - See player 2's details");
			System.out.println("3 - Play one hand");
			System.out.println("4 - Finish the game (plays all remaining hands)");
			System.out.println();
		
			
		//Reusing boolean canContinue, set up scanner input for player to control the game.
			canContinue = false;
			
			while (!canContinue) {
				System.out.print("Enter number: ");
				String playerChoice = input.nextLine();
				
				if (playerChoice.equals("1")) {
					p1.describePlayer();
				} else if (playerChoice.equals("2")) {
					p2.describePlayer();
				} else if (playerChoice.equals("3")) {
					playRound(p1, p2);
					System.out.println();
					
		//If the player 1's hand has no cards, the game must be over.
					if (p1.playerHandLength() == 0) {
						
		//Sets variables to the final scores of both players and breaks out of loop.
						tallyScore(p1, p2);
						canContinue = true;
					}
				} else if (playerChoice.equals("4")) {
					
		//Pressing 4 plays the remainder of the rounds. Iterate once for each card left in player 1's deck.
					int totalPlaysRemaining = p1.playerHandLength() - 1;
					for (int i=0; i <= totalPlaysRemaining; i++) {
						playRound(p1, p2);
					}
		//Sets variables to the final scores of both players and breaks out of loop.
					tallyScore(p1,p2);
					canContinue = true;
				}
				else {
					System.out.println("Please select a valid option (1, 2, 3, or 4)");
					System.out.println();
				}
		}
		
		
		
		


//		
	
		
		
		
	}
		
		//Accepts two player classes and a deck class. Splits the deck evenly between two players.
		public static void splitDeck(Player p1, Player p2, Deck deck) {
			
			//Initialize length, this allows the deck size to be dynamic and re-usable.
			int deckSize = deck.cards.size() - 1;
			
			for(int i=0; i <= deckSize; i++) {
				Card curCard = deck.draw();
				if (i % 2 == 0) {
					p1.addToHand(curCard);
				} else {
					p2.addToHand(curCard);
				}
			}
		}
		
		
		//Accepts two players, p1 and p2. Plays a game of war between them. *Must run splitDeck() prior calling*.
		public static void playRound(Player p1, Player p2) {
			
		//This pulls the hand on top of the deck of each player. It is a Card object.
			Card cardP1 = p1.flip();
			Card cardP2 = p2.flip();
			
		//Print description of each card.
			System.out.println("------");
			System.out.println(p1.getName() + " - " + cardP1.describe());
			System.out.println(p2.getName() + " - " + cardP2.describe());
			
		//Comparison of the values of each card.
			if (cardP1.getValue() > cardP2.getValue()) {
				p1.incrementScore();
				System.out.println(p1.getName() + " " + "wins this round!");
			} else if (cardP1.getValue() < cardP2.getValue()) {
				p2.incrementScore();
				System.out.println(p2.getName() + " " + "wins this round!");
			} else {
				System.out.println("It's a draw!");
			}
		
	}
		
		
	
		//Accepts two players, p1 and p2. Tallies score for both players and announces winner.
		public static void tallyScore(Player p1, Player p2) {
			int playerOneFinal = p1.getScore();
			int playerTwoFinal = p2.getScore();
			
			System.out.println("------");
			System.out.println("Final Score");
			System.out.println(p1.getName() + "'s final score: " +  + playerOneFinal);
			System.out.println(p2.getName() + "'s final score:  " +  + playerTwoFinal);
			
			
		//This code determines who to display as the winner.
			if (playerOneFinal > playerTwoFinal) {
				System.out.println();
				System.out.println("^O^ " + p1.getName() + " IS THE WINNER! " + "^O^");
			} else if (playerTwoFinal > playerOneFinal) {
				System.out.println();
				System.out.println("^O^ " + p2.getName() + " IS THE WINNER! " + "^O^");
			} else {
				System.out.println();
				System.out.println("DRAW!");
			}
		}
		
		
		

}
