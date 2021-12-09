package model;

import java.util.Random;

public class DeckOfCards {
	
	public Card[][] cards;	//array of 2D cards to store SUIT and FACEVALUE
	public int numOfCards;	//number of total cards in deck
	
	
	public DeckOfCards() {	
		numOfCards = 52;
		cards = new Card[4][13];	// initialising cards deck with 4 suit values and 13 facevalues
		for(int i=0; i<4; i++) {	//looping through suit values	0=clubs 1=diamonds 2=hearts and 3=spades
			for(int j=0; j<13; j++) {	//looping through facevalues	0=A, 10=J, 11=Q, 12=K 
				cards[i][j] = new Card(i,j); 
			}
		}
	}
	
	public Card deal() {
		Random rand = new Random();	//initialising random class to generate random numbers
		int faceValue = rand.nextInt(13);	//using random object to generate random numbers
		int suit = rand.nextInt(4);		//using random object to generate random numbers
		
		Card removedCard = new Card(faceValue, suit);	// creating object to store removed card
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; i++) {
				if(faceValue == j  &&  suit == i) {
					this.cards[i][j] = null;
				}
			}
		}
		numOfCards--;
		return removedCard;
	}
	
	public void display() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				System.out.println(this.cards[i][j]);
			}
		}
		System.out.println("DONE");
	}
	
	public void shuffle() {
		Random rand = new Random();
			int faceValue1, suit1, faceValue2, suit2, indexF1=0, indexF2=0, indexS1=0, indexS2=0;	// variables to store random facevalues and suits and their indexes
			Card temp;	// to store a temporary card while swapping
		
		if(numOfCards == 52) {
			for(int a=0; a<20; a++) {	// shuffling 20 times
				faceValue1 = rand.nextInt(13);
				faceValue2 = rand.nextInt(13);
				
				suit1 = rand.nextInt(4);
				suit2 = rand.nextInt(4);
				
				for(int i=0; i<4; i++) {
					for(int j=0; j<13; i++) {
						if(faceValue1 == j  &&  suit1 == i) {	//storing indexes of first random card
							indexF1 = j;
							indexS1 = i;
						}
						else if(faceValue2 == j && suit2 == i) {	//storing indexes of first random card
							indexF2 = j;
							indexS2 = i;
						}
					}
				}
				
				temp = this.cards[indexF1][indexS1];	// holding first card temporarily
				this.cards[indexF1][indexS1] = this.cards[indexF2][indexS2];	// swapping card
				this.cards[indexF2][indexS2] = temp;	// swapping card with the temporary card
			}
		}
	}
}
