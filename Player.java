package finalProject;
import java.util.*;
public class Player 
{
//instance variables of an array list to hold cards, and integer for the value of the hand, number of
//cards and a string for the name
private ArrayList<Card> hand = new ArrayList<Card>();
private int handValue;
private String name;
private int handCount;
//creates a player object with a name n
public Player(String n)
{
name = n;	
handValue = 0;
handCount = 0;
}
//this method is used to draw a card for the player and add 1 to the hand count
public void getCard(Card c)
{
	hand.add(c);
	handCount ++;
}
//calculates the numerical value of the players hand
public void calcHandValue()
{
	int sum = 0;
	for(int i = 0; i < hand.size(); i++)
	{
		sum += hand.get(i).getValue();
	}
	handValue = sum;
	
}
//returns the value of the players hand
public int getHandValue()
{
	return handValue;
}
//gets rid of the cards in the players hand for a new round
public void clearHand()
{
	while(hand.size()>0)
	{
		hand.remove(0);
		handCount --;
	}
}
//this method prints the info for the crads that are face up
public void printHandInfo()
{
	System.out.println( name + "'s cards Showing: ");
	for(int i = 0; i < hand.size(); i++)
	{
		if(hand.get(i).getFaceUp())
		{
			System.out.print(hand.get(i).getType() + " of " + hand.get(i).getSuit() + ", ");
		}
	}
	System.out.println("");
}
//this method makes the first card in your hand face down
public void flipFirstCard()
{
	hand.get(0).flipCard();
}
//this method prints the info of all cards in your hand
public void printAllHandInfo()
{
	System.out.println("Cards in " + name + "'s hand:");
	for(int i = 0; i < hand.size()-1; i++)
	{
		System.out.print(hand.get(i).getType() + " of " + hand.get(i).getSuit() + ", ");
	}
	System.out.println( "and "+ hand.get(hand.size()-1).getType() + " of " + hand.get(hand.size()-1).getSuit());
}
//this method checks if the player has an ace and prompts the player to chose the value of the 
//ace to be 1 or 11
public void checkAceAndSet()
{
	Scanner input = new Scanner(System.in);
	for(int i = 0; i < hand.size(); i++)
	{
		if(hand.get(i).getType().equals("Ace"))
		{
			System.out.println("do you want this ace to be 1 or 11?");
			hand.get(i).changeAce(input.nextInt());
			printHandValue();
		}
	}
	
}
//returns player name
public String getName()
{
	return name;
}
//prints the numerical value of the players hand
public void printHandValue()
{
	calcHandValue();
	System.out.println(name + "'s hand value: " + handValue);
}
//returns number of cards in the players hand
public int getCardCount()
{
	return handCount;
}
//returns the numerical value of the face up cards in the players hand. used in the dealer to 
//determine if the dealer will take another card
public int getShowingValue()
{
	int val = 0;
	for(int i = 0; i < hand.size(); i++)
	{
		if(hand.get(i).getFaceUp())
		{
		val +=hand.get(i).getValue();	
		}
	}
	return val;
}
//returns the array list of cards that is the players hand. used in the dealer class to access 
//it's own cards.
public ArrayList<Card> getHand()
{
	return hand;
}
}
