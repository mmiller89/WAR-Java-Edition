package Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	
	//Initiate a new cards list.
	List<Card> cards = new ArrayList<Card>();
	
	
	public Deck() {
		
		//Assign suite (determines the suite assigned to each Card).
		//Assign valueAssign (this will make sure the card value does not go over 13, which is the highest).
		int suite = 0;
		int valueAssign = 1;
		
		
		//For loop to fill the array with cards.
		for(int i=0; i <= 51; i++) {
			if (suite < 13) {
				cards.add(i, new Card(valueAssign, " of Spades"));
				
			}
			else if (suite < 26) {
				cards.add(i, new Card(valueAssign, " of Hearts"));	
			}
			else if (suite < 39) {
				cards.add(i, new Card(valueAssign, " of Spades"));
			}
			else {
				cards.add(i, new Card(valueAssign, " of Diamonds"));
			}
			
			valueAssign++;
			suite++;
			
			if (valueAssign > 13) {
				valueAssign = 1;
			}
			
		}
	}

	//Display the deck of cards on command. Delete this later once tested.
	public void getCards() {
		for(Card card: this.cards) {
			System.out.println(card.describe());
		}
	}
	
	//Use the collections shuffle method to randomize the deck of cards.
	public List<Card> shuffleDeck(){
		Collections.shuffle(cards);
		return cards;
	}
	
	//Draw the first card in the deck and remove it.
	public Card draw() {
		Card drawnCard = cards.get(0);
		cards.remove(0);
		return drawnCard;
	}
}
