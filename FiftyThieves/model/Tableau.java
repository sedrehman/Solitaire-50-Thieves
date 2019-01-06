package FiftyThieves.model;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Tableau Pile extends Pile
 * 
 * @author Syed Rehman
 * 
 */
public class Tableau extends Pile {

	/**
	 * Constructor for tableau pile. Here it takes in the deck instance and takes
	 * out 3 cards and adds them to the tableau pile
	 * 
	 * @param d
	 * @param baseLocation
	 */
	public Tableau(Deck d, Point baseLocation) {
		super(baseLocation);
		initialSetup(d, baseLocation);

	}

	/**
	 * mostly empty constructor.. Used for testing only..
	 * 
	 * @param baseLocation
	 */
	public Tableau(Point baseLocation) {
		super(baseLocation);

	}

	/**
	 * sets up the tableau pile
	 * 
	 * @param d
	 * @param baseLocation
	 */
	private void initialSetup(Deck d, Point baseLocation) {
		int x = baseLocation.x;
		int y = baseLocation.y;
		for (int i = 0; i < 3; i++) {
			// initially 3 cards are allowed.
			Card c = d.delt();
			c.getImg().setLocation(x, y);
			y += 15;
			c.setPile("t");
			this.getPile().add(c);
		}
	}

	/**
	 * -check adding rules -once passed > set Card's piles name -set the card's
	 * position (topcards's position + 15 in y direction) -move all the cards down
	 * in layers..
	 * 
	 * @param c
	 * @return
	 */
	public boolean add(Card c) {
		if (getPile().isEmpty()) {
			c.setPile("t");
			getPile().add(c);
			return true;
		} else if ((c.getSuit().equals(getTopCard().getSuit()) && (c.getRank() + 1) == getTopCard().getRank())) {
			c.setPile("t");
			getPile().add(c);
			return true;
		}
		return false;
	}

	/**
	 * removes the top card from the pile
	 * 
	 * @return c
	 */
	public Card remove() {
		Card c = getPile().remove(getPile().size() - 1);
//		updateTopCardLocation();
		return c;
	}

}
