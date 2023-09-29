package cards;

public class Card { 

	private int num;
	private int suit;

	public Card(int num, int suit) {
		this.num = num;
		this.suit = suit;
	}

	public int getNum() {
		return num;
	}

	public int getSuit() {
		return suit;
	}

	/*
	 toString - will return the card with his number and his kind.
	 for example 5 heart will be 5H
	 */

	public String toString() {
		String s = null;
		switch (this.suit) {
		case 0:
			s = "C";
			break;
		case 1:
			s = "D";
			break;
		case 2:
			s = "H";
			break;
		case 3:
			s = "S";
			break;
		}

		return String.format("%d%s", num, s);
	}

	/*
	 * the method will compare two cards.
	 * if the cards equals it will return 0
	 * if the first bigger than the other it will return positive num, else negative num
	 */
	public int compareTo(Card other) {
		if (num > other.getNum())
			return 1;
		else if (num == other.getNum() && suit > other.getSuit())
			return 1;
		else if (num < other.getNum())
			return -1;
		else if (num == other.getNum() && suit < other.getSuit())
			return -1;
		else
			return 0;
	}

}
