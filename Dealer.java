package finalProject;
import java.util.*;
/*
 * the dealer class extends the player class because a dealer is just a player with some extra rules which
 * are outlined in this class, and because it isn't a real person controlling it there is strategy coded
 * into the dealer
 */
public class Dealer extends Player
{
	//instance variables to hold the minimum hand value the dealer must have, and the player object 
	//because the dealer needs to access some information in the player. 
private int min;
private Player p1;

//creates a dealer object with a minimum value of 16
public Dealer(String n, Player p)
{
	super(n);
	min = 16;
	p1 = p;
}
//determines if the dealer must take another card if their hand value is under the minimum. 
public boolean mustHit()
{
	super.calcHandValue();
	return super.getHandValue() <= min;
}
//this method is hard wired strategy that will make the dealer take another card if it's hand value is
//less than 19 and the dealer's hand value is less than 10 plus the cards showing in the players hand
public boolean willHit()
{
	boolean strategy = false; 
	if(super.getHandValue()<19)
	{
	if(p1.getShowingValue() < 10 && super.getHandValue() < p1.getShowingValue()+10)
	{
		strategy = true;
	}
	}
	return strategy;
	
}
//because an ace can have a value of 1 or 11 this method changes an ace to the value passed.
//this is only meant to change the first ace in the dealers hand 
public void changeAce(int v)
{
	for(int i = 0; i < super.getHand().size(); i++ )
	{
	if(super.getHand().get(i).getType().equals("Ace"))
	{
		super.getHand().get(i).changeAce(v);
		break;
	}
	}
	
}
//this method checks if the dealer has a hidden black jack and sets the ace to 11 
public void checkBlackJack()
{
	if(hasAce() && (getNotAceVal() == 10))
	{
		changeAce(11);
	}
}
//this method returns the value of non ace cards in the dealers hand
public int getNotAceVal()
{
	int sum = 0;
	for(int i = 0; i<super.getHand().size();i++)
	{
		if(!(super.getHand().get(i).getType().equals("Ace")))
		{
			sum += super.getHand().get(i).getValue();
		}
	}
	return sum;
}
//this method checks and returns true if there is an ace in the dealers hand
public boolean hasAce()
{
	boolean ace = false;
	for(int i = 0; i < super.getHand().size(); i++)
	{
		if(super.getHand().get(i).getType().equals("Ace"))
		{
			ace = true;
		}
	}
	return ace;
}
}
