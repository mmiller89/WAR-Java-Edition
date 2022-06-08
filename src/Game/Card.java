package Game;

public class Card {
	
	//Initial values are created first. They are private to keep them within the function themself.
		private int value;
		private String name;

		//Next, create the constructor for the value and name of the card.
		public Card(int value, String name) {
			this.value = value;
			this.name = name;
			
			//Reassign the ace to highest value for comparison later. I needed to do this because in the deck, Aces are considered the "1".
			if (this.value == 1) {
				this.value = 14;
			}
		}

		
		//Create getters and setters for the cards.
		public int getValue() {
			return value;
		}
		
		public void setValue(int value) {
			this.value = value;
		
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		//This is a describe method if called upon by the player. It says the name of the card.
		public String describe() {
			
			//These lines are to convert numbers  > 10 to their proper card name.
			if (this.value == 11) {
				return "Jack" + name;
			}
			else if (this.value == 12) {
				return "Queen" + name;		
			}
			else if (this.value == 13) {
				return "King" + name;
				
			} 
			else if (this.value == 14) {
				return "Ace" + name;
			}
			else {
				return this.value + "" + name;
			}
			
			
			
		}

}
