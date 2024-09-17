package finalProject;
import java.util.*;
public class Card 
/*
 * this class is used to act as a single card for the game and holds variables for the number 
 * value of the card, a string for the type and suit, and a boolean that represents if the card
 *  is face up on the table
 */
{
private int value;
private String type;
private String suit;
private boolean faceUp;

//creates a card object with the specified parameters, and all cards are set to be face up
public Card(int v, String t, String s)
{
	value = v;
	type = t;
	suit = s;
	faceUp = true;
}
//returns number value of card
public int getValue()
{
	return value;
}
//method to change number value of a card. only used to change an ace to 1 or 11
public void changeAce(int i)
{
	value = i;
}
//getters to get info about card
public String getType()
{
	return type;
}
public String getSuit()
{
	return suit;
}
public boolean getFaceUp()
{
	return faceUp;
}
//flips card to be face down. only used to flip first card
public void flipCard()
{
	faceUp = false;
}
}
