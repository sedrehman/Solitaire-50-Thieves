package FiftyThieves.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Class that represents the homecell pile for forty thieves.
 * 
 * @author Syed Rehman
 */
public class Homecell extends Pile {

	public Homecell(Deck deck, Point p, int rank, String suit) {
		super(p);
		initialSetup(deck, rank, suit);
	}

	/**
	 * takes out the specific card and adds it to the pile. In this case The ACE
	 * cards.
	 * 
	 * @param d
	 * @param rank
	 * @param suit
	 */
	public void initialSetup(Deck d, int rank, String suit) {
		Card c = d.getSpecificCard(rank, suit);
		c.setPile("h");
		c.getImg().setLocation(getBaseLocation());
		this.getPile().add(c);
	}

	public boolean MoveCheck() {
		return false;
	}

	public void MoveAction() {

	}

	/**
	 * if Card c has an identical suite as the topCard and Card c has a rank one
	 * above that of the topCard then it can be added. Otherwise return false
	 * 
	 * @param c
	 * @return true if legally added false if not
	 */
	public boolean AddCheck(Card c) {
		if (getPile().isEmpty()) {
			c.setPile("h");
			getPile().add(c);
			return true;
		} else if (c.getSuit().equals(getTopCard().getSuit()) && (c.getRank() - 1) == getTopCard().getRank()) {
			c.setPile("h");
			getPile().add(c);
			return true;
		} else {
			return false;
		}
	}

	public boolean RemoveCheck() {
		return false;
	}

	public void RemoveAction() {

	}

}
