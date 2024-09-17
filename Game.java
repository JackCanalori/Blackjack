package finalProject;
import java.util.*;
/*
 * this class will operate the game and determine winners
 */
public class Game
{
	//instance variables of a deck to be used, and a player and dealer
	private Deck gameDeck;
	private Player p1;
	private Dealer house;
	//creates game with parameters and fills the game deck with cards
	public Game(Deck d, Player p, Dealer de)
	{
		gameDeck = d;
		p1 = p;
		house = de;
		gameDeck.fillDeck();
	}
	//this method plays a round and utilizes other methods that break the game up into [hases
	public void round()
	{
		
		start();
		playerTurn();
		dealerTurn();
		printEndResult();
		
	}
	//this gives both players two cards and flips the first card of each player. prints info
	//needed for next turn, and checks if there is an ace in the players hand and what they want it to be
	public void start()
	{
		p1.getCard(gameDeck.drawCard());
		p1.flipFirstCard();
		p1.getCard(gameDeck.drawCard());
		house.getCard(gameDeck.drawCard());
		house.flipFirstCard();
		house.getCard(gameDeck.drawCard());
		house.printHandInfo();
		p1.printAllHandInfo();
		p1.calcHandValue();
		p1.printHandValue();
		p1.printHandInfo();
		p1.checkAceAndSet();
	}
	//this method performs the players turn and prompts it to take however many cards they want unless
	//their hand is a bust. checks for an ace after each card the player takes
	public void playerTurn()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("do you want another card? type 1 for yes, or 0 for no");
		
		while(p1.getHandValue()<=21 && input.nextInt() == 1)
		{
			p1.getCard(gameDeck.drawCard());
			p1.printAllHandInfo();
			p1.calcHandValue();
			p1.printHandValue();
			p1.printHandInfo();
			p1.checkAceAndSet();
			house.printHandInfo();
			if(p1.getHandValue()<=21)
			{
			System.out.println("do you want another card? type 1 for yes, or 0 for no");
			}
		}
	}
	//this method does the dealer's turn, checks if they have a black jack because it can't set an ace
	//so the computer does it when appropriate. this utilizes the strategy methods in the dealer class
	//to determine if it will take another card
	public void dealerTurn()
	{
		house.checkBlackJack();
		while(house.mustHit()||house.willHit())
		{
			house.getCard(gameDeck.drawCard());
			house.checkBlackJack();
		}
	}
	//this method uses the results to determine the winner and print the winner message
	public void printWinner()
	{
		if(p1.getHandValue() > house.getHandValue() && p1.getHandValue() <= 21)
		{
			System.out.println( p1.getName()+ " wins");
		}
		else if( p1.getHandValue() <= 21 && house.getHandValue()>21)
		{
			System.out.println( p1.getName()+ " wins");
		}
		else if(p1.getCardCount()>4 && p1.getHandValue()<=21)
		{
			
		}
		else if (house.getHandValue() <= 21)
		{
			System.out.println("The Dealer wins");
		}
		else
		{
			System.out.println("Draw");
		}
	}
	//prints the final result of the round including hand info and winner
	public void printEndResult()
	{
		printWinner();
		p1.printAllHandInfo();
		p1.calcHandValue();
		p1.printHandValue();
		house.printAllHandInfo();
		house.calcHandValue();
		house.printHandValue();
	}
}
