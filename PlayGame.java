package finalProject;
import java.util.*;
public class PlayGame 
{
	/**
	 * This PlayGame class is meant to test and play my black jack game. the user can input their name 
	 * and how many decks they would like to be included in the game. they will be able to play as many 
	 * games as they want to. 
	 */

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");
		Player p1 = new Player(input.nextLine());
		Dealer house = new Dealer("House",p1);
		System.out.println("How many decks would you like to play with?");
		Deck d = new Deck(input.nextInt());
		Game g1 = new Game(d,p1,house);
		System.out.println("Type 1 to start");
		while (input.nextInt() == 1)
		{
			p1.clearHand();
			house.clearHand();
			g1.round();
			System.out.println("Do you want to play another round? type 1 for yes or 0 for no");
		}

	}

}
