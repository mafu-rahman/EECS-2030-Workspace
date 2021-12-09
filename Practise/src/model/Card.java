package model;

public class Card {
	public static int MAX_VALUE = 13;
	public static int MAX_SUITE = 4;
	
	int faceValue;
	int suit;
	
	public String[] cards;
	
	public Card(int suit, int faceValue) {
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
	public String toString() {
		String s = suit + " " + faceValue;
		return s;
	}

}