package finalProject;
import java.util.*;
public class Deck 
{
	/**
	 * this class is to act like a virtual deck to draw cards from.
	 */
	
//instance variables of an array list to hold the cards and the number of cards and how many 52 card
//decks will be included in the deck
private ArrayList<Card> cards = new ArrayList<Card>();
private int numCards;
private int numDecks;

//creates a deck object with no cards 
public Deck(int num)
{
numDecks = num;
numCards = 0;
}
//fills the array list with the appropriate amount of cards and utilizes arrays and for loops to 
//give cards the appropriate information, and keeps track of how many cards are in the list
public void fillDeck()
{
	int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	String[] types = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	for(int i = 0; i < numDecks; i++)
	{
		for(int j = 0; j < suits.length; j++)
		{
			for(int k = 0; k < values.length; k++)
			{
				cards.add(new Card(values[k],types[k],suits[j]));
				numCards ++;
			}
		}
	}
}
//this method draws a card from the deck in a random position because the deck is filled in numerical 
//order, so taking the first card won't work for a black jack game. if the deck is emptied it will refill
//the deck and then draw a card

public Card drawCard()
{
	if(numCards > 0)
	{
	Card c = cards.remove((int)(Math.random() * cards.size()));
	numCards --;
	return c;
	}
	else
	{
		fillDeck();
		Card c = cards.remove((int)(Math.random() * cards.size()));
		numCards --;
		return c;
	}
}
}
