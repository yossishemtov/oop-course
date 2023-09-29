package cards;

public class Deck {
	private Card[] deck;
	private int numcard = 0;

	/* The constructor(int num) will create a new deck of cards */
	public Deck(int num) {
		int k = 0;
		deck = new Card[num * 4];
		for (int i = 0; i < num * 4; i = i + 4) {
			deck[i] = new Card(k, 0);
			deck[i + 1] = new Card(k, 1);
			deck[i + 2] = new Card(k, 2);
			deck[i + 3] = new Card(k, 3);
			k++;
		}
		numcard = num * 4;
	}

	/*
	 * Creates deck of cards by taking card after card from the deck "from"
	 * Takes maximum cards as the size of the deck "from"
	 */
	public Deck(Deck from, int num) {
		int count = 0;
		if (num > from.numcard) {
			count = from.numcard;
		} else {
			count = num;
		}
		deck = new Card[count];
		for (int i = 0; i < count; i++) {
			deck[this.numcard] = from.takeOne();
			this.numcard++;

		}

	}

	/*
	 * the constructor get 2 Deck of cards. it will create new deck from those two
	 * given decks.
	 */
	public Deck(Deck first, Deck second) {
		int numofcard = 0;

		numofcard = first.numcard + second.numcard;
		deck = new Card[numofcard];
		int max = 0;
		if (first.numcard > second.numcard)
			max = first.numcard;
		else
			max = second.numcard;
		for (int i = 0; i < max; i++) {
			if (first.getNumCards() != 0) {
				deck[this.numcard] = first.deck[first.numcard - 1];
				this.numcard++;
				first.numcard--;
			}
			if (second.getNumCards() != 0) {
				deck[this.numcard] = second.deck[second.numcard - 1];
				this.numcard++;
				second.numcard--;
			}
		}
	}

	// getNumCards will return the current cards number in the deck
	public int getNumCards() {
		return numcard;
	}

	/*
	 * takeOne method will takes one card from the end of the deck, remove it and then
	 * return's it to the deck.
	 */
	public Card takeOne() {
		if (numcard != 0) {
			numcard--;
			return deck[numcard];
		} else {
			return null;
		}
	}

	//Return's a string with numbers of cards and their kind.
	public String toString() {
		String returnDeck = "";
		if (numcard != 0) {
			returnDeck = "[";
			for (int i = 0; i < numcard - 1; i++)
				returnDeck += deck[i] + ", ";
			returnDeck += deck[numcard - 1] + "]";
			return returnDeck;
		} else
			return String.format("[]");
	}

	//Sorting the deck in increasing order.

	public void sort() {
		int n = deck.length;

		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (deck[j].compareTo(deck[j + 1]) > 0) {
					Card temp = deck[j];
					deck[j] = deck[j + 1];
					deck[j + 1] = temp;
				}
	}
}
